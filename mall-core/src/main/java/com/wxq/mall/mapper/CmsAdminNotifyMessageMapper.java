package com.wxq.mall.mapper;

import com.wxq.mall.model.CmsAdminNotifyMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-13
 */
@Mapper
public interface CmsAdminNotifyMessageMapper extends BaseMapper<CmsAdminNotifyMessage> {

    Page<CmsAdminNotifyMessage> findByPage(Page<CmsAdminNotifyMessage> page, @Param("params") Map<String, Object> params);

    List<CmsAdminNotifyMessage> findAll();

    List<CmsAdminNotifyMessage> findUnReadMessageByUserName(String username);
}
