package com.wxq.mall.service.impl;

import javax.annotation.Resource;

import com.wxq.mall.mapper.PmsProductImagesMapper;
import com.wxq.mall.model.PmsProductImages;
import com.wxq.mall.service.IPmsProductImagesService;
import com.wxq.mall.utils.FileUploadUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
public class PmsProductImagesServiceImpl implements IPmsProductImagesService {

    @Resource
    private PmsProductImagesMapper productImagesMapper;

    @Override
    public void add(PmsProductImages pmsProductImages) {
        productImagesMapper.insert(pmsProductImages);
    }

    @Override
    @Transactional
    public void delete(String id) {
        PmsProductImages image = productImagesMapper.selectById(id);
        productImagesMapper.deleteById(id);
        // 删除图片服务器文件
        FileUploadUtil.delete(image.getUrl());
    }

    @Override
    public List<PmsProductImages> findPictureByProductId(String productId) {
        return productImagesMapper.findPictureByProductId(productId);
    }
}
