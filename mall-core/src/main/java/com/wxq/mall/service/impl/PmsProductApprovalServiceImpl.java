package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.controller.MessageDeliver;
import com.wxq.mall.model.PmsProductApproval;
import com.wxq.mall.mapper.PmsProductApprovalMapper;
import com.wxq.mall.service.IPmsProductApprovalService;
import com.wxq.mall.system.MessageWrapper;
import com.wxq.mall.type.product.ProductApproveStatus;
import com.wxq.mall.utils.ProductApprovalUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-13
 */
@Service
public class PmsProductApprovalServiceImpl implements IPmsProductApprovalService {

    @Resource
    private PmsProductApprovalMapper pmsProductApprovalMapper;

    @Resource
    private MessageDeliver messageDeliver;

    @Override
    public void update(PmsProductApproval pmsProductApproval) {
        pmsProductApprovalMapper.updateById(pmsProductApproval);
    }

    @Override
    public Page<PmsProductApproval> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return pmsProductApprovalMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsProductApproval> findAll() {
        return pmsProductApprovalMapper.selectList(null);
    }

    @Override
    public void approvalProduct(PmsProductApproval pmsProductApproval) {
        update(pmsProductApproval);
        boolean approvalPass = pmsProductApproval.getStatus().equals(ProductApproveStatus.APPROVE_PASS.getStatus());
        String message = ProductApprovalUtil.buildApprovalResult(pmsProductApproval.getProductName(), approvalPass);
        // 发送消息通知用户审核结果
        messageDeliver.sendMessage(pmsProductApproval.getUsername(), new MessageWrapper(message));
    }
}
