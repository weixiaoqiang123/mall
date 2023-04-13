package com.wxq.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.wxq.mall.exception.BaseException;
import com.wxq.mall.model.CmsAdminNotifyMessage;
import com.wxq.mall.service.ICmsAdminNotifyMessageService;
import com.wxq.mall.system.MessageWrapper;
import com.wxq.mall.system.cache.ProductApprovalUserCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 *
 * todo 前端需要控制拥有审核角色用户和商家进入 减少对象缓存数量
 * todo 展示管理员和商家活跃数量
 *
 * 如果用户状态未离线 一段时间后上线 消息通知与直接从数据库查询消息并展示无差异
 * 如果用户在线 某个商品审核通过 无法确定什么时刻去获取用户最新的消息 因此采用WebSocket主动推送 + 数据库记录消息方式
 **/
@Slf4j
@Component
@ServerEndpoint("/message-deliver/{userId}")
public class MessageDeliver implements InitializingBean {

    private static ProductApprovalUserCache approvalUserCache;

    // 包含所有管理员与商家
    private static ConcurrentHashMap<String, MessageDeliver> webSocketMap = new ConcurrentHashMap<>();

    private Session session;

    private String userId;

    @Resource
    private ApplicationContext context;

    @Resource
    private ICmsAdminNotifyMessageService notifyMessageService;

    @Override
    public void afterPropertiesSet() throws Exception {
        approvalUserCache = context.getBean(ProductApprovalUserCache.class);
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId){
        this.session = session;
        this.userId = userId;
        webSocketMap.put(userId, this);

        List<CmsAdminNotifyMessage> messages = notifyMessageService.findUnReadMessageByUserName(userId);
        // 用户上线后 主动推送未读消息
        List<MessageWrapper> messageWrapperList = convertMessageWrapper(messages);
        if(!messageWrapperList.isEmpty()) {
            sendMessageBatchCaptureException(session, messageWrapperList);
        }
    }

    @OnMessage
    public void onMessage(String message) throws IOException {

    }

    @OnError
    public void onError(Session session, Throwable error){
        log.error("[{}]: connection failed, reason: {}",  this.userId, error.getMessage());
    }

    @OnClose
    public void onClose() {
        webSocketMap.remove(userId);
        log.info("[{}]: connection closed", userId);
    }

    // 向指定角色用户广播商品上架审批消息
    public void broadcastMessage(MessageWrapper messageWrapper){
        // 过滤拥有审核角色管理员
        Iterator<String> iterator = webSocketMap.keySet().stream()
                .filter(userId -> approvalUserCache.getUserIds().contains(userId))
                .iterator();

        try{
            List<CmsAdminNotifyMessage> messages = new ArrayList<>();
            while (iterator.hasNext()) {
                String userId = iterator.next();
                MessageDeliver messageDeliver = webSocketMap.get(userId);
                sendMessageCaptureException(messageDeliver.session, messageWrapper);
                messages.add(createNotifyMessage(userId, messageWrapper));
            }
            notifyMessageService.saveMessageBatch(messages);
        }catch (BaseException e){
            throw e;
        }
    }

    // 向指定商家发送审批结果消息
    public void sendMessage(String userId, MessageWrapper messageWrapper) throws BaseException {
        MessageDeliver messageDeliver = webSocketMap.get(userId);
        if(messageDeliver == null) {
            throw new BaseException("Invalid user");
        } else {
            CmsAdminNotifyMessage message = createNotifyMessage(messageDeliver.userId, messageWrapper);
            notifyMessageService.saveMessageBatch(Arrays.asList(message));
            sendMessageCaptureException(messageDeliver.session, messageWrapper);
        }
    }

    private static void sendMessageCaptureException(Session session, MessageWrapper messageWrapper) {
        try {
            session.getBasicRemote().sendText(JSONObject.toJSONString(messageWrapper));
        } catch (IOException e) {
            log.error("send message error, reason: {}", e);
            throw new BaseException("发送消息失败");
        }
    }

    private static void sendMessageBatchCaptureException(Session session, List<MessageWrapper> messageWrappers) {
        try {
            session.getBasicRemote().sendText(JSONObject.toJSONString(messageWrappers));
        } catch (IOException e) {
            log.error("send message error, reason: {}", e);
            throw new BaseException("发送消息失败");
        }
    }

    private static CmsAdminNotifyMessage createNotifyMessage(String userId, MessageWrapper messageWrapper) {
        CmsAdminNotifyMessage notifyMessage = new CmsAdminNotifyMessage();
        notifyMessage.setUsername(userId);
        notifyMessage.setMessage(messageWrapper.getMessage());
        notifyMessage.setRead(messageWrapper.isRead() ? 1 : 0);
        return notifyMessage;
    }

    public static List<MessageWrapper> convertMessageWrapper(List<CmsAdminNotifyMessage> messages) {
        List<MessageWrapper> messageWrapperList = new ArrayList<>(messages.size());
        for (CmsAdminNotifyMessage message : messages) {
            messageWrapperList.add(convert(message));
        }
        return messageWrapperList;
    }

    public static MessageWrapper convert(CmsAdminNotifyMessage message) {
        return new MessageWrapper(message.getMessage(), message.isRead() == 1 ? true : false);
    }
}
