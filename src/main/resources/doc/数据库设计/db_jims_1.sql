/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : db_jims

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2014-10-06 16:31:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_customer_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer_info`;
CREATE TABLE `tb_customer_info` (
  `id` varchar(50) NOT NULL COMMENT '客户的ID编号，以字符串"c"为编号的前缀',
  `name` varchar(50) NOT NULL COMMENT '客户名称',
  `abbreviation` varchar(50) default NULL COMMENT '简称',
  `address` varchar(100) default NULL COMMENT '地址',
  `postal_code` varchar(50) default NULL COMMENT '邮政编号',
  `phone` varchar(50) default NULL COMMENT '电话',
  `fax` varchar(50) default NULL COMMENT '传真',
  `contacts` varchar(50) default NULL COMMENT '联系人',
  `telephone` varchar(50) default NULL COMMENT '联系人电话',
  `email` varchar(50) default NULL COMMENT '电子邮箱',
  `deposit_bank` varchar(60) default NULL COMMENT '开户行',
  `account_bank` varchar(60) default NULL COMMENT '帐号',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_customer_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_good_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_good_info`;
CREATE TABLE `tb_good_info` (
  `id` varchar(50) NOT NULL COMMENT '商品编号是商品的唯一标识,前缀使用“g”字符串',
  `name` varchar(50) NOT NULL COMMENT '商品名字',
  `abbreviation` varchar(50) default NULL COMMENT '简称',
  `origin` varchar(50) default NULL COMMENT '产品',
  `units` varchar(50) default NULL COMMENT '单位',
  `pack` varchar(50) default NULL COMMENT '包装',
  `approval_num` varchar(50) default NULL COMMENT '批准文号',
  `batch_num` varchar(50) default NULL COMMENT '批号',
  `memo` varchar(90) default NULL COMMENT '备忘录(简介)',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_good_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_inventory_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_inventory_info`;
CREATE TABLE `tb_inventory_info` (
  `id` varchar(30) NOT NULL COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '商品名称',
  `abbreviation` varchar(50) default NULL COMMENT '商品简称',
  `origin` varchar(50) default NULL COMMENT '产地',
  `specification` varchar(50) default NULL COMMENT '规格',
  `pack` varchar(50) default NULL COMMENT '包装',
  `units` varchar(10) default NULL COMMENT '单位',
  `unit_cost` float default NULL COMMENT '单价',
  `amount` int(11) default NULL COMMENT '库存数量',
  `user_id` varchar(50) default NULL,
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tb_inventory_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_inventory_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `name` varchar(50) default NULL COMMENT '名字',
  `description` varchar(50) default NULL COMMENT '描述',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------

-- ----------------------------
-- Table structure for tb_provider_good
-- ----------------------------
DROP TABLE IF EXISTS `tb_provider_good`;
CREATE TABLE `tb_provider_good` (
  `provider_id` varchar(50) default NULL,
  `good_id` varchar(50) default NULL,
  KEY `provider_id` (`provider_id`),
  KEY `good_id` (`good_id`),
  CONSTRAINT `tb_provider_good_ibfk_2` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `tb_provider_good_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `tb_provider_info` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_provider_good
-- ----------------------------

-- ----------------------------
-- Table structure for tb_provider_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_provider_info`;
CREATE TABLE `tb_provider_info` (
  `id` varchar(50) NOT NULL COMMENT '以"p"作为前缀',
  `name` varchar(60) NOT NULL COMMENT '供应商名称',
  `abbreviation` varchar(50) default NULL COMMENT '简称',
  `address` varchar(100) default NULL COMMENT '地址',
  `postal_code` varchar(50) default NULL COMMENT '邮政编码',
  `phone` varchar(50) default NULL COMMENT '电话',
  `fax` varchar(50) default NULL COMMENT '传真',
  `contacts` varchar(50) default NULL COMMENT '联系人',
  `telephone` varchar(50) default NULL COMMENT '联系人电话',
  `deposit_bank` varchar(50) default NULL COMMENT '开户行',
  `email` varchar(50) default NULL COMMENT '电子邮箱',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_provider_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `name` varchar(50) default NULL COMMENT '名字',
  `description` varchar(255) default NULL COMMENT '描述',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  KEY `tb_role_permission_ibfk_1` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `tb_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `tb_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `tb_permission` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sell
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell`;
CREATE TABLE `tb_sell` (
  `id` varchar(50) NOT NULL COMMENT '前缀"s",后缀1000格式',
  `good_id` varchar(50) default NULL COMMENT '商品id',
  `customer_id` varchar(50) default NULL COMMENT '客户id',
  `user_id` varchar(50) default NULL COMMENT '操作员id',
  `unit_cost` float default NULL COMMENT '销售单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '金额',
  `time` datetime default NULL COMMENT '销售时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `headler` varchar(50) default NULL COMMENT '负责人',
  PRIMARY KEY  (`id`),
  KEY `good_id` (`good_id`),
  KEY `customer_id` (`customer_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tb_sell_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_sell_ibfk_1` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_sell_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sell
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sell_return
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_return`;
CREATE TABLE `tb_sell_return` (
  `id` varchar(50) NOT NULL COMMENT '前缀"sell_r",后缀1000格式',
  `good_id` varchar(50) default NULL COMMENT '商品id',
  `customer_id` varchar(50) default NULL COMMENT '客户id',
  `user_id` varchar(50) default NULL COMMENT '操作员id',
  `unit_cost` float default NULL COMMENT '销售单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '金额',
  `time` datetime default NULL COMMENT '销售退回时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `handler` varchar(50) default NULL COMMENT '负责人',
  PRIMARY KEY  (`id`),
  KEY `good_id` (`good_id`),
  KEY `customer_id` (`customer_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tb_sell_return_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_sell_return_ibfk_1` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_sell_return_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sell_return
-- ----------------------------

-- ----------------------------
-- Table structure for tb_stock
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock`;
CREATE TABLE `tb_stock` (
  `id` varchar(30) NOT NULL COMMENT '入库编号,以"stock"字符串为前缀',
  `provider_id` varchar(50) default NULL COMMENT '供应商id',
  `user_id` varchar(50) default NULL COMMENT '对应用户id',
  `good_id` varchar(50) default NULL COMMENT '货物id',
  `variety_amount` int(11) default NULL COMMENT '品种数量',
  `unit_cost` float default NULL COMMENT '单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '合计金额',
  `check_conclusion` varchar(50) default NULL COMMENT '验收结论',
  `time` datetime default NULL COMMENT '入货时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `handler` varchar(50) default NULL COMMENT '经手人',
  PRIMARY KEY  (`id`),
  KEY `provider_id` (`provider_id`),
  KEY `user_id` (`user_id`),
  KEY `good_id` (`good_id`),
  CONSTRAINT `tb_stock_ibfk_3` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_stock_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `tb_provider_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_stock_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stock
-- ----------------------------

-- ----------------------------
-- Table structure for tb_stock_return
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock_return`;
CREATE TABLE `tb_stock_return` (
  `id` varchar(30) NOT NULL COMMENT '入库退货编号,以"stock_r"字符串为前缀',
  `provider_id` varchar(50) default NULL COMMENT '供应商id',
  `user_id` varchar(50) default NULL COMMENT '对应用户id',
  `good_id` varchar(50) default NULL COMMENT '货物id',
  `variety_amount` int(11) default NULL COMMENT '品种数量',
  `unit_cost` float default NULL COMMENT '单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '合计金额',
  `check_conclusion` varchar(50) default NULL COMMENT '验收结论',
  `time` datetime default NULL COMMENT '入货退货时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `handler` varchar(50) default NULL COMMENT '经手人',
  PRIMARY KEY  (`id`),
  KEY `provider_id` (`provider_id`),
  KEY `user_id` (`user_id`),
  KEY `good_id` (`good_id`),
  CONSTRAINT `tb_stock_return_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `tb_provider_info` (`id`),
  CONSTRAINT `tb_stock_return_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`),
  CONSTRAINT `tb_stock_return_ibfk_3` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stock_return
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `account` varchar(50) NOT NULL COMMENT '帐号',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `create_date` datetime default NULL COMMENT '创建时间',
  `latest_date` datetime default NULL COMMENT '最后登录时间',
  PRIMARY KEY  (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_log`;
CREATE TABLE `tb_user_log` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `user_account` varchar(50) default NULL COMMENT '对应用户表的account',
  `time` datetime default NULL COMMENT '登录时间',
  PRIMARY KEY  (`id`),
  KEY `user_account` (`user_account`),
  CONSTRAINT `tb_user_log_ibfk_1` FOREIGN KEY (`user_account`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_log
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `user_id` varchar(50) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `tb_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
