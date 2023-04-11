package com.wxq.mall.service.impl;

import javax.annotation.Resource;
import com.wxq.mall.model.UmsMemberAddress;
import com.wxq.mall.mapper.UmsMemberAddressMapper;
import com.wxq.mall.service.IUmsMemberAddressService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class UmsMemberAddressServiceImpl implements IUmsMemberAddressService {

    @Resource
    private UmsMemberAddressMapper umsMemberAddressMapper;

    @Override
    public void add(UmsMemberAddress umsMemberAddress) {
        umsMemberAddressMapper.insert(umsMemberAddress);
    }

    @Override
    public void update(UmsMemberAddress umsMemberAddress) {
        umsMemberAddressMapper.updateById(umsMemberAddress);
    }

    @Override
    public void delete(String id) {
        umsMemberAddressMapper.deleteById(id);
    }

    @Override
    public UmsMemberAddress get(String id) {
        return umsMemberAddressMapper.selectById(id);
    }

    @Override
    public Page<UmsMemberAddress> findByPage(Map<String, Object> params, Integer page, Integer size) {
        return umsMemberAddressMapper.findByPage(new Page<>(page, size), params);
    }

    @Override
    public List<UmsMemberAddress> findAll() {
        return umsMemberAddressMapper.selectList(null);
    }
}
