package com.wxq.mall.service;

import com.wxq.mall.model.CmsAdminNotifyMessage;

import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-13
 */
public interface ICmsAdminNotifyMessageService {

    void saveMessageBatch(List<CmsAdminNotifyMessage> messages);

    void markMessageRead(Integer messageId);

    List<CmsAdminNotifyMessage> findUnReadMessageByUserName(String username);
}
