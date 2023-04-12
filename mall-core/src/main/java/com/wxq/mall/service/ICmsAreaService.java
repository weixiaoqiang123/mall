package com.wxq.mall.service;

import com.wxq.modeltree.core.TreeNode;
import java.util.List;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
public interface ICmsAreaService {

    List<TreeNode> findAreasByParentCode(String parentCode);

    List<TreeNode> provinces();
}
