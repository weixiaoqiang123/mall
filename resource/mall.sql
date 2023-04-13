
drop database if exists mall;
create database mall character set utf8 collate utf8_general_ci;
use mall;

DROP TABLE IF EXISTS ums_admin;
CREATE TABLE ums_admin(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `username` VARCHAR(100)    COMMENT '用户名' ,
    `password` VARCHAR(32)    COMMENT '密码' ,
    `nickname` VARCHAR(100)    COMMENT '用户昵称' ,
    `head_img` VARCHAR(100)    COMMENT '用户头像' ,
    `register_method` VARCHAR(20)    COMMENT '注册方式: mobile/qq' ,
    `phone` VARCHAR(11)    COMMENT '手机号' ,
    `email` VARCHAR(50)    COMMENT '邮箱' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `status` INT(1)    COMMENT '用户状态: 0 未启用 1 启用' ,
    `login_time` DATE    COMMENT '最后登录时间' ,
    PRIMARY KEY (id)
)  COMMENT = '管理员用户表';

DROP TABLE IF EXISTS ums_admin_login_log;
CREATE TABLE ums_admin_login_log(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '' ,
    `username` VARCHAR(100)    COMMENT '用户名' ,
    `ip` VARCHAR(20)    COMMENT '登录IP' ,
    `create_time` DATE    COMMENT '创建时间' ,
    PRIMARY KEY (id)
)  COMMENT = '后台用户登录日志';

DROP TABLE IF EXISTS ums_member;
CREATE TABLE ums_member(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `username` VARCHAR(20) NOT NULL   COMMENT '用户名' ,
    `password` VARCHAR(32) NOT NULL   COMMENT '密码' ,
    `nickname` VARCHAR(50) NOT NULL   COMMENT '昵称' ,
    `head_img` VARCHAR(100) NOT NULL   COMMENT '用户头像' ,
    `register_method` VARCHAR(10) NOT NULL   COMMENT '注册方式: mobile/qq/chat' ,
    `phone` VARCHAR(11)    COMMENT '手机号' ,
    `email` VARCHAR(30)    COMMENT '邮箱' ,
    `status` INT NOT NULL   COMMENT '状态: 0 未启用 1 启用' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `login_time` DATE    COMMENT '最后一次登录时间' ,
    PRIMARY KEY (id)
)  COMMENT = '会员表';

DROP TABLE IF EXISTS ums_member_address;
CREATE TABLE ums_member_address(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `member_id` VARCHAR(255)    COMMENT '会员关联ID' ,
    `receive_name` VARCHAR(10) NOT NULL   COMMENT '收件人姓名' ,
    `receive_phone` VARCHAR(11) NOT NULL   COMMENT '收件人电话' ,
    `province_id` VARCHAR(10)    COMMENT '省编码' ,
    `city_id` VARCHAR(10)    COMMENT '市' ,
    `region_id` VARCHAR(10)    COMMENT '区/县' ,
    `detail_address` VARCHAR(200)    COMMENT '详细地址' ,
    PRIMARY KEY (id)
)  COMMENT = '会员收获地址表';

DROP TABLE IF EXISTS ums_business;
CREATE TABLE ums_business(
     `id` INT NOT NULL   COMMENT '主键' ,
     `username` VARCHAR(100)    COMMENT '用户名' ,
     `business_code` VARCHAR(32)    COMMENT '商家编码' ,
     `business_name` VARCHAR(100)    COMMENT '商家名称' ,
     `province_id` VARCHAR(10)    COMMENT '省' ,
     `city_id` VARCHAR(10)    COMMENT '市' ,
     `region_id` VARCHAR(10)    COMMENT '区/县' ,
     `detail_address` VARCHAR(100)    COMMENT '商家详细地址(街道)' ,
     `create_time` DATETIME    COMMENT '创建时间' ,
     PRIMARY KEY (id)
)  COMMENT = '商家表';

DROP TABLE IF EXISTS cms_area;
CREATE TABLE cms_area(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `area_code` VARCHAR(10) NOT NULL   COMMENT '地区编码' ,
    `area_name` VARCHAR(50) NOT NULL   COMMENT '地区名称' ,
    `parent_area_code` VARCHAR(10) NOT NULL   COMMENT '父级地区编码' ,
    `area_level` VARCHAR(255)    COMMENT '地区级别' ,
    PRIMARY KEY (id)
)  COMMENT = '地区表';

DROP TABLE IF EXISTS pms_product;
CREATE TABLE pms_product(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `product_id` VARCHAR(32) NOT NULL   COMMENT '商品编码,32位UUID' ,
    `business_code` VARCHAR(32)    COMMENT '商家编码' ,
    `business_name` VARCHAR(50)    COMMENT '商家名称' ,
    `product_name` VARCHAR(200)    COMMENT '商品名称' ,
    `product_desc` VARCHAR(1000)    COMMENT '商品描述' ,
    `cate_code` VARCHAR(32)    COMMENT '商品分类编码' ,
    `status` INT    COMMENT '0 编辑 1 发布 2 下线' ,
    `sale_num` INT    COMMENT '销售数量' ,
    `new_status` INT    COMMENT '是否为新品: 0 否 1 是' ,
    `recommend_status` INT    COMMENT '是否推荐: 0 否 1 是' ,
    `verify_status` INT    COMMENT '审核状态: 0 审核中 1 审核通过 2 审核不通过' ,
    `sale_price` decimal(8, 2)   COMMENT '商品售价' ,
    `stock` INT    COMMENT '商品库存' ,
    `low_stock` INT    COMMENT '预警库存' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_time` DATE    COMMENT '修改时间' ,
    `publish_time` DATE    COMMENT '发布时间' ,
    `offline_time` DATE    COMMENT '下线时间' ,
    PRIMARY KEY (id)
)  COMMENT = '商品表';

DROP TABLE IF EXISTS pms_product_stock;
CREATE TABLE pms_product_stock(
    `id` INT    COMMENT '主键' ,
    `image` VARCHAR(100)    COMMENT '库存图片' ,
    `product_id` VARCHAR(32)    COMMENT '商品ID' ,
    `sku_code` VARCHAR(32)    COMMENT '商品库存编码' ,
    `price` DECIMAL(8,2)    COMMENT '原价' ,
    `promotion_price` DECIMAL(8,2)    COMMENT '促销价格' ,
    `sale_num` INT    COMMENT '销售数量' 
)  COMMENT = '商品库存表';

DROP TABLE IF EXISTS pms_product_images;
CREATE TABLE pms_product_images(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `product_id` VARCHAR(32) NOT NULL   COMMENT '商品编码' ,
    `url` VARCHAR(100) NOT NULL   COMMENT '图片地址(最多十张图片)' ,
    PRIMARY KEY (id)
)  COMMENT = '商品图片表';

DROP TABLE IF EXISTS pms_product_detail;
CREATE TABLE pms_product_detail(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `product_id` VARCHAR(32) NOT NULL   COMMENT '商品编码' ,
    `detail` MEDIUMTEXT NOT NULL   COMMENT '商品详情' ,
    PRIMARY KEY (id)
)  COMMENT = '商品详情表';

DROP TABLE IF EXISTS pms_product_attribute;
CREATE TABLE pms_product_attribute(
    `id` INT(255) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `product_id` VARCHAR(32)    COMMENT '商品编码' ,
    `attr_id` VARCHAR(8)    COMMENT '属性ID' ,
    `attr_name` VARCHAR(50)    COMMENT '属性名称' ,
    PRIMARY KEY (id)
)  COMMENT = '商品属性表';

DROP TABLE IF EXISTS pms_product_attribute_value;
CREATE TABLE pms_product_attribute_value(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `product_id` VARCHAR(32)    COMMENT '商品编码' ,
    `attribute_id` VARCHAR(8)    COMMENT '属性ID' ,
    `attr_value_name` VARCHAR(50)    COMMENT '属性值' ,
    PRIMARY KEY (id)
)  COMMENT = '商品属性值表';

DROP TABLE IF EXISTS pms_banner;
CREATE TABLE pms_banner(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `name` VARCHAR(100)    COMMENT '图片名称' ,
    `url` VARCHAR(100)    COMMENT '图片地址' ,
    `status` INT    COMMENT '图片状态: 0 不生效 1 生效' ,
    `order` INT   DEFAULT 0 COMMENT '图片顺序' ,
    PRIMARY KEY (id)
)  COMMENT = '首页轮播图表';

DROP TABLE IF EXISTS pms_cart;
CREATE TABLE pms_cart(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `account` VARCHAR(50) NOT NULL   COMMENT '用户账号' ,
    `product_id` VARCHAR(32) NOT NULL   COMMENT '商品ID' ,
    `product_name` VARCHAR(100) NOT NULL   COMMENT '商品名称' ,
    `sku_code` VARCHAR(32) NOT NULL   COMMENT '商品库存编码' ,
    `product_attr` VARCHAR(1000) NOT NULL   COMMENT '商品属性(json)' ,
    `price` DECIMAL(8,2) NOT NULL   COMMENT '商品原价' ,
    `quantity` INT NOT NULL   COMMENT '商品数量' ,
    `picture` VARCHAR(100) NOT NULL   COMMENT '商品主图' ,
    `business_code` VARCHAR(32)    COMMENT '商家编码' ,
    `business_name` VARCHAR(100)    COMMENT '商家名称' ,
    `create_time` DATE    COMMENT '创建时间' ,
    `update_time` DATE    COMMENT '修改时间' ,
    PRIMARY KEY (id)
)  COMMENT = '购物车';

DROP TABLE IF EXISTS oms_order;
CREATE TABLE oms_order(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `account` VARCHAR(100)    COMMENT '用户账号' ,
    `order_code` VARCHAR(32)    COMMENT '订单编码' ,
    `total_amount` DECIMAL(8,2)    COMMENT '订单总金额' ,
    `pay_amount` DECIMAL(8,2)    COMMENT '实际支付金额' ,
    `pay_type` INT    COMMENT '支付类型: 0 未支付 1 支付宝 2 微信' ,
    `souce_type` INT    COMMENT '订单来源: 1 pc 2手机' ,
    `stauts` INT    COMMENT '订单状态: 0 未付款 1 待发货 2 已发货 3 已收货' ,
    `order_type` INT    COMMENT '订单类型: 0 正常订单 1 秒杀订单' ,
    `confirm_status` INT    COMMENT '收货状态: 0 未确认 1 已确认' ,
    `create_time` DATE    COMMENT '订单创建时间' ,
    PRIMARY KEY (id)
)  COMMENT = '订单表';

DROP TABLE IF EXISTS oms_order_detail;
CREATE TABLE oms_order_detail(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `oder_code` VARCHAR(32)    COMMENT '订单编码' ,
    `product_id` VARCHAR(32)    COMMENT '商品编码' ,
    `product_name` VARCHAR(100)    COMMENT '商品名称' ,
    `sku_code` VARCHAR(32)    COMMENT '商品库存编码' ,
    `buy_num` INT    COMMENT '购买数量' ,
    `product_attr` VARCHAR(1000)    COMMENT '商品属性' ,
    `create_time` DATE    COMMENT '订单创建时间' ,
    `original_price` DECIMAL(8,2)    COMMENT '原价' ,
    `sale_price` DECIMAL(8,2)    COMMENT '售价' ,
    `business_code` VARCHAR(32)    COMMENT '商家编码' ,
    `business_name` VARCHAR(100)    COMMENT '商家名称' ,
    PRIMARY KEY (id)
)  COMMENT = '订单详情表';

DROP TABLE IF EXISTS pms_product_approval;
CREATE TABLE pms_product_approval(
     `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
     `username` VARCHAR(20)    COMMENT '用户名' ,
     `business_name` VARCHAR(100)    COMMENT '商家名称' ,
     `product_id` VARCHAR(255)    COMMENT '商品ID' ,
     `product_name` VARCHAR(100)    COMMENT '商品名称' ,
     `status` INT    COMMENT '审核状态: 0 审核中 1 审核通过 2 审核不通过' ,
     `not_pass_message` VARCHAR(200)    COMMENT '审核不通过原因' ,
     `create_time` DATETIME    COMMENT '审核记录创建时间' ,
     `verify_time` DATETIME    COMMENT '审核时间' ,
     `verify_name` VARCHAR(10)    COMMENT '审核人名称' ,
     PRIMARY KEY (id)
)  COMMENT = '商品上架审核表';


DROP TABLE IF EXISTS cms_menu_button_dic;
CREATE TABLE cms_menu_button_dic(
    `id` INT(8) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `menu_id` VARCHAR(8) NOT NULL   COMMENT '叶子菜单ID' ,
    `button_id` VARCHAR(30) NOT NULL   COMMENT '按钮ID 当前菜单无法重复' ,
    `button_name` VARCHAR(20) NOT NULL   COMMENT '菜单名称' ,
    `button_type` VARCHAR(10) NOT NULL   COMMENT '菜单类型: add|update|delete|view' ,
    PRIMARY KEY (id)
)  COMMENT = '菜单按钮字典';

DROP TABLE IF EXISTS cms_menu;
CREATE TABLE cms_menu(
     `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
     `menu_code` VARCHAR(8)    COMMENT '菜单编码 8位UUID' ,
     `menu_name` VARCHAR(20)    COMMENT '菜单名称' ,
     `parent_menu_code` VARCHAR(8)    COMMENT '父级菜单编码' ,
     `menu_level` INT(255)    COMMENT '菜单级别' ,
     `menu_order` INT(255)   DEFAULT 0 COMMENT '菜单顺序' ,
     `is_leaf` INT    COMMENT '是否是叶子菜单: 0 目录 1 页面' ,
     `url` VARCHAR(100)    COMMENT '菜单地址 仅叶子菜单有' ,
     PRIMARY KEY (id)
)  COMMENT = '菜单表';



DROP TABLE IF EXISTS cms_role;
CREATE TABLE cms_role(
     `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
     `role_id` VARCHAR(8)    COMMENT '角色ID' ,
     `role_name` VARCHAR(20)    COMMENT '角色名称' ,
     `role_desc` VARCHAR(100)    COMMENT '角色描述' ,
     PRIMARY KEY (id)
)  COMMENT = '角色表';

DROP TABLE IF EXISTS cms_menu_role_map;
CREATE TABLE cms_menu_role_map(
  `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
  `menu_id` VARCHAR(8) NOT NULL   COMMENT '菜单ID' ,
  `role_id` VARCHAR(8) NOT NULL   COMMENT '角色ID' ,
  PRIMARY KEY (id)
)  COMMENT = '菜单角色关系表';

DROP TABLE IF EXISTS cms_admin_role_map;
CREATE TABLE cms_admin_role_map(
   `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
   `user_id` INT(255)    COMMENT '用户表主键' ,
   `role_id` VARCHAR(8)    COMMENT '角色ID' ,
   PRIMARY KEY (id)
)  COMMENT = '用户角色关系表';

DROP TABLE IF EXISTS cms_role_button_dic_map;
CREATE TABLE cms_role_button_dic_map(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '' ,
    `role_id` VARCHAR(8)    COMMENT '' ,
    `button_dic_id` INT    COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '角色按钮关系表';

DROP TABLE IF EXISTS cms_admin_notify_message;
CREATE TABLE cms_admin_notify_message(
     `id` INT NOT NULL   COMMENT '主键名称' ,
     `username` VARCHAR(20)    COMMENT '用户名' ,
     `message` VARCHAR(200)    COMMENT '消息内容' ,
     `is_read` INT    COMMENT '0 未读 1 已读' ,
     PRIMARY KEY (id)
)  COMMENT = '用户消息通知表';

