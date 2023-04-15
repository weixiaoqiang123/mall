package com.wxq.mall.service;

import com.wxq.mall.model.PmsProductImages;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface IPmsProductImagesService {

    void add(PmsProductImages pmsProductImages);

    void delete(String id);

    List<PmsProductImages> findPictureByProductId(String productId);
}
