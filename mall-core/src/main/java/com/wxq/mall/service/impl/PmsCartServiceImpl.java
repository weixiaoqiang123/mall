package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.PmsCart;
import com.wxq.mall.mapper.PmsCartMapper;
import com.wxq.mall.service.IPmsCartService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsCartServiceImpl implements IPmsCartService {

    @Resource
    private PmsCartMapper pmsCartMapper;

    @Override
    public void add(PmsCart pmsCart) {
        pmsCartMapper.insert(pmsCart);
    }

    @Override
    public void update(PmsCart pmsCart) {
        pmsCartMapper.updateById(pmsCart);
    }

    @Override
    public void delete(String id) {
        pmsCartMapper.deleteById(id);
    }

    @Override
    public PmsCart get(String id) {
        return pmsCartMapper.selectById(id);
    }

    @Override
    public Page<PmsCart> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return pmsCartMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<PmsCart> findAll() {
        return pmsCartMapper.selectList(null);
    }
}
