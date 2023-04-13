package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductApproval;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-13
 */
public interface IPmsProductApprovalService {

    void update(PmsProductApproval pmsProductApproval);

    Page<PmsProductApproval> findByPage(Map<String,Object> params, Integer page, Integer size);

    List<PmsProductApproval> findAll();

    void approvalProduct(PmsProductApproval pmsProductApproval);
}
