package com.wxq.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author weixiaoqiang
 * @date 2023-04-11
 */
@TableName("cms_menu_button_dic")
@ApiModel(value = "CmsMenuButtonDic对象", description = "菜单按钮字典")
public class CmsMenuButtonDic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("叶子菜单ID")
    @TableField("menu_id")
    private String menuId;

    @ApiModelProperty("按钮ID 当前菜单无法重复")
    @TableField("button_id")
    private String buttonId;

    @ApiModelProperty("菜单名称")
    @TableField("button_name")
    private String buttonName;

    @ApiModelProperty("菜单类型: add|update|delete|view")
    @TableField("button_type")
    private String buttonType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }


    @Override
    public String toString() {
        return "CmsMenuButtonDic{" +
            "id=" + id +
            ", menuId=" + menuId +
            ", buttonId=" + buttonId +
            ", buttonName=" + buttonName +
            ", buttonType=" + buttonType +
        "}";
    }
}
