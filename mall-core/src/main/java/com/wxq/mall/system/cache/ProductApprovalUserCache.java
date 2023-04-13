package com.wxq.mall.system.cache;

import com.wxq.mall.mapper.UmsAdminMapper;
import com.wxq.mall.model.UmsAdmin;
import com.wxq.mall.utils.Constants;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weixiaoqiang
 * @date 2023/4/13
 **/
public class ProductApprovalUserCache {

    private static final List<UmsAdmin> APPROVAL_USERS = new ArrayList<>();

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @PostConstruct
    private void refresh(){
        List<UmsAdmin> approvalUsers = umsAdminMapper.findByRoleId(Constants.APPROVAL_ROLE_ID);
        APPROVAL_USERS.addAll(approvalUsers);
    }

    public List<String> getUserIds(){
        return APPROVAL_USERS.stream().map(user -> user.getUsername()).collect(Collectors.toList());
    }
}
