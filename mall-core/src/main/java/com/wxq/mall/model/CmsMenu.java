package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import com.wxq.core.Tree;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("cms_menu")
@ApiModel(value = "CmsMenu对象", description = "菜单表")
public class CmsMenu implements Serializable, Tree {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableField("id")
    private Integer id;

    @ApiModelProperty("菜单编码 8位UUID")
    @TableId("menu_code")
    private String menuCode;

    @ApiModelProperty("菜单名称")
    @TableField("menu_name")
    private String menuName;

    @ApiModelProperty("父级菜单编码")
    @TableField("parent_menu_code")
    private String parentMenuCode;

    @ApiModelProperty("菜单级别")
    @TableField("menu_level")
    private Integer menuLevel;

    @ApiModelProperty("菜单顺序")
    @TableField("menu_order")
    private Integer menuOrder;

    @ApiModelProperty("是否是叶子菜单: 0 目录 1 页面")
    @TableField("is_leaf")
    private Integer isLeaf;

    @ApiModelProperty("菜单地址 仅叶子菜单有")
    @TableField("url")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentMenuCode() {
        return parentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        this.parentMenuCode = parentMenuCode;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "CmsMenu{" +
            "id=" + id +
            ", menuCode=" + menuCode +
            ", menuName=" + menuName +
            ", parentMenuCode=" + parentMenuCode +
            ", menuLevel=" + menuLevel +
            ", menuOrder=" + menuOrder +
            ", isLeaf=" + isLeaf +
            ", url=" + url +
        "}";
    }

    @Override
    public String getCurrentNodeId() {
        return menuCode;
    }

    @Override
    public String getParentNodeId() {
        return parentMenuCode;
    }
}
