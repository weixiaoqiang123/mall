package com.wxq.mall.service.impl;

import com.wxq.mall.mapper.CmsAdminNotifyMessageMapper;
import com.wxq.mall.model.CmsAdminNotifyMessage;
import com.wxq.mall.service.ICmsAdminNotifyMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-13
 */
@Service
public class CmsAdminNotifyMessageServiceImpl implements ICmsAdminNotifyMessageService {

    @Resource
    private CmsAdminNotifyMessageMapper notifyMessageMapper;

    @Override
    public void markMessageRead(Integer messageId) {
        CmsAdminNotifyMessage notifyMessage = notifyMessageMapper.selectById(messageId);
        notifyMessage.setRead(1);
        notifyMessageMapper.updateById(notifyMessage);
    }

    @Override
    public List<CmsAdminNotifyMessage> findUnReadMessageByUserName(String username) {
        return notifyMessageMapper.findUnReadMessageByUserName(username);
    }

    @Override
    @Transactional
    public void saveMessageBatch(List<CmsAdminNotifyMessage> messages) {
        for (CmsAdminNotifyMessage message : messages) {
            notifyMessageMapper.insert(message);
        }
    }
}
