package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.OmsOrderDetail;
import com.wxq.mall.mapper.OmsOrderDetailMapper;
import com.wxq.mall.service.IOmsOrderDetailService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class OmsOrderDetailServiceImpl implements IOmsOrderDetailService {

    @Resource
    private OmsOrderDetailMapper omsOrderDetailMapper;

    @Override
    public void add(OmsOrderDetail omsOrderDetail) {
        omsOrderDetailMapper.insert(omsOrderDetail);
    }

    @Override
    public void update(OmsOrderDetail omsOrderDetail) {
        omsOrderDetailMapper.updateById(omsOrderDetail);
    }

    @Override
    public void delete(String id) {
        omsOrderDetailMapper.deleteById(id);
    }

    @Override
    public OmsOrderDetail get(String id) {
        return omsOrderDetailMapper.selectById(id);
    }

    @Override
    public Page<OmsOrderDetail> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return omsOrderDetailMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<OmsOrderDetail> findAll() {
        return omsOrderDetailMapper.selectList(null);
    }
}
