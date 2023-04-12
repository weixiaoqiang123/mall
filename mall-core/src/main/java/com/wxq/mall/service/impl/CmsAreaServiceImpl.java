package com.wxq.mall.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import com.wxq.mall.mapper.CmsAreaMapper;
import com.wxq.mall.model.CmsArea;
import com.wxq.mall.service.ICmsAreaService;
import com.wxq.mall.utils.Constants;
import com.wxq.modeltree.core.TreeNode;
import com.wxq.modeltree.utils.TreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@Service
@Slf4j
public class CmsAreaServiceImpl implements ICmsAreaService {

    private List<TreeNode> provincesCache = new ArrayList<>();

    @Resource
    private CmsAreaMapper areaMapper;

    @PostConstruct
    public void init(){
        List<TreeNode> provinces = findAreasByParentCode(Constants.AREA_ROOT_CODE);
        provincesCache.addAll(provinces);
    }

    @Override
    public List<TreeNode> findAreasByParentCode(String parentCode) {
        List<CmsArea> areas = areaMapper.findAreasByParentCode(parentCode);
        return TreeUtils.buildTree(areas, parentCode).getChildren();
    }

    @Override
    public List<TreeNode> provinces() {
        if(!provincesCache.isEmpty()){
            return provincesCache;
        }
        return findAreasByParentCode(Constants.AREA_ROOT_CODE);
    }
}
