package com.wxq.mall.controller;

import com.wxq.common.model.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.wxq.mall.service.ICmsAdminNotifyMessageService;
import org.springframework.stereotype.Controller;

/**
 * @author weixiaoqiang
 * @date 2023-04-13
 */
@Controller
@RequestMapping("/cms-admin-notify-message")
@Api(tags = "通知消息管理")
public class CmsAdminNotifyMessageController {

    @Resource
    private ICmsAdminNotifyMessageService notifyMessageService;

    @GetMapping("/mark-message-read/{messageId}")
    @ResponseBody
    @ApiOperation("标记消息已读")
    public Object markMessageRead(@PathVariable Integer messageId) {
        notifyMessageService.markMessageRead(messageId);
        return ResultBody.success();
    }
}
