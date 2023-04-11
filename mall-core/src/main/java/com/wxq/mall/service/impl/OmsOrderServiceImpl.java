package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.OmsOrder;
import com.wxq.mall.mapper.OmsOrderMapper;
import com.wxq.mall.service.IOmsOrderService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class OmsOrderServiceImpl implements IOmsOrderService {

    @Resource
    private OmsOrderMapper omsOrderMapper;

    @Override
    public void add(OmsOrder omsOrder) {
        omsOrderMapper.insert(omsOrder);
    }

    @Override
    public void update(OmsOrder omsOrder) {
        omsOrderMapper.updateById(omsOrder);
    }

    @Override
    public void delete(String id) {
        omsOrderMapper.deleteById(id);
    }

    @Override
    public OmsOrder get(String id) {
        return omsOrderMapper.selectById(id);
    }

    @Override
    public Page<OmsOrder> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return omsOrderMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<OmsOrder> findAll() {
        return omsOrderMapper.selectList(null);
    }
}
