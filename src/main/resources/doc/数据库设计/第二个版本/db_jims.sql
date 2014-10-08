/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : db_jims

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2014-09-25 13:13:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_customer_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer_info`;
CREATE TABLE `tb_customer_info` (
  `id` varchar(50) NOT NULL COMMENT '客户的ID编号，以字符串"c"为编号的前缀,加上4位数字做编号的后缀',
  `cname` varchar(50) NOT NULL COMMENT '客户名称',
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
  `id` varchar(50) NOT NULL COMMENT '商品编号是商品的唯一标识，它是商品信息表的主键，用于区分不同的商品，前缀使用“g”字符串',
  `gname` varchar(50) NOT NULL COMMENT '商品名字',
  `abbreviation` varchar(50) default NULL COMMENT '简称',
  `origin` varchar(50) default NULL COMMENT '产品',
  `units` varchar(50) default NULL COMMENT '单位',
  `pack` varchar(50) default NULL COMMENT '包装',
  `approval_num` varchar(50) default NULL COMMENT '批准文号',
  `batch_num` varchar(50) default NULL COMMENT '批号',
  `memo` varchar(90) default NULL COMMENT '备忘录(简介)',
  `pid` varchar(50) default NULL,
  PRIMARY KEY  (`id`),
  KEY `pid` (`pid`),
  CONSTRAINT `tb_good_info_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `tb_provider_info` (`id`)
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
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_inventory_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_provider_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_provider_info`;
CREATE TABLE `tb_provider_info` (
  `id` varchar(50) NOT NULL COMMENT '以"p"作为前缀,加上4位数做编号的后缀',
  `pname` varchar(60) NOT NULL COMMENT '供应商名称',
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
-- Table structure for tb_sell
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell`;
CREATE TABLE `tb_sell` (
  `id` varchar(50) NOT NULL COMMENT '前缀"s",后缀1000格式',
  `gid` varchar(50) default NULL COMMENT '商品id',
  `cid` varchar(50) default NULL COMMENT '客户id',
  `uid` varchar(50) default NULL COMMENT '操作员id',
  `unit_cost` float default NULL COMMENT '销售单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '金额',
  `time` datetime default NULL COMMENT '销售时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `headler` varchar(50) default NULL,
  PRIMARY KEY  (`id`),
  KEY `gid` (`gid`),
  KEY `cid` (`cid`),
  KEY `uid` (`uid`),
  CONSTRAINT `tb_sell_ibfk_3` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`name`),
  CONSTRAINT `tb_sell_ibfk_1` FOREIGN KEY (`gid`) REFERENCES `tb_good_info` (`id`),
  CONSTRAINT `tb_sell_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `tb_customer_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sell
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sell_return
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_return`;
CREATE TABLE `tb_sell_return` (
  `id` varchar(50) NOT NULL,
  `gid` varchar(50) default NULL,
  `cid` varchar(50) default NULL,
  `uid` varchar(50) default NULL,
  `unit_cost` float default NULL,
  `amount` int(11) default NULL,
  `sum` float default NULL,
  `time` datetime default NULL,
  `clearing_form` varchar(50) default NULL,
  `handler` varchar(50) default NULL,
  PRIMARY KEY  (`id`),
  KEY `gid` (`gid`),
  KEY `cid` (`cid`),
  KEY `uid` (`uid`),
  CONSTRAINT `tb_sell_return_ibfk_3` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`name`),
  CONSTRAINT `tb_sell_return_ibfk_1` FOREIGN KEY (`gid`) REFERENCES `tb_good_info` (`id`),
  CONSTRAINT `tb_sell_return_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `tb_customer_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sell_return
-- ----------------------------

-- ----------------------------
-- Table structure for tb_stock
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock`;
CREATE TABLE `tb_stock` (
  `id` varchar(30) NOT NULL COMMENT '入库编号,以"rk"字符串为前缀,加上商品的入库日期,再以3位数字作为后缀',
  `pid` varchar(50) default NULL COMMENT '供应商',
  `uid` varchar(50) default NULL COMMENT '对应用户name字段',
  `gid` varchar(50) default NULL,
  `variety_amount` int(11) default NULL COMMENT '品种数量',
  `unit_cost` float default NULL COMMENT '单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '合计金额',
  `check_conclusion` varchar(50) default NULL COMMENT '验收结论',
  `time` datetime default NULL COMMENT '入货时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `handler` varchar(50) default NULL COMMENT '经手人',
  PRIMARY KEY  (`id`),
  KEY `pid` (`pid`),
  KEY `uid` (`uid`),
  KEY `gid` (`gid`),
  CONSTRAINT `tb_stock_ibfk_3` FOREIGN KEY (`gid`) REFERENCES `tb_good_info` (`id`),
  CONSTRAINT `tb_stock_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `tb_provider_info` (`id`),
  CONSTRAINT `tb_stock_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stock
-- ----------------------------

-- ----------------------------
-- Table structure for tb_stock_return
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock_return`;
CREATE TABLE `tb_stock_return` (
  `id` varchar(30) NOT NULL COMMENT '入库编号,以"rk"字符串为前缀,加上商品的入库日期,再以3位数字作为后缀',
  `pid` varchar(50) default NULL COMMENT '供应商',
  `gid` varchar(50) default NULL,
  `uid` varchar(50) default NULL COMMENT '对应用户name字段',
  `variety_amount` int(11) default NULL COMMENT '品种数量',
  `unit_cost` float default NULL COMMENT '单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '合计金额',
  `check_conclusion` varchar(50) default NULL COMMENT '验收结论',
  `time` datetime default NULL COMMENT '退货时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `handler` varchar(50) default NULL COMMENT '经手人',
  PRIMARY KEY  (`id`),
  KEY `pid` (`pid`),
  KEY `gid` (`gid`),
  KEY `uid` (`uid`),
  CONSTRAINT `tb_stock_return_ibfk_3` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`name`),
  CONSTRAINT `tb_stock_return_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `tb_provider_info` (`id`),
  CONSTRAINT `tb_stock_return_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `tb_good_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stock_return
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `name` varchar(50) NOT NULL COMMENT '帐号',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `rid` int(11) default NULL,
  PRIMARY KEY  (`name`),
  KEY `rid` (`rid`),
  CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `tb_user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('moziqi', '莫梓奇', '123465', '1');

-- ----------------------------
-- Table structure for tb_user_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_log`;
CREATE TABLE `tb_user_log` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `name` varchar(50) default NULL COMMENT '对应用户表的name',
  `time` datetime default NULL COMMENT '登录时间',
  PRIMARY KEY  (`id`),
  KEY `name` (`name`),
  CONSTRAINT `tb_user_log_ibfk_1` FOREIGN KEY (`name`) REFERENCES `tb_user` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_log
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_permission`;
CREATE TABLE `tb_user_permission` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `rid` int(11) default NULL COMMENT '对应角色表的id',
  `KeHuGuanLi` int(11) default NULL COMMENT '客户信息管理 ',
  `ShangPinGuanLi` int(11) default NULL COMMENT '商品信息管理 ',
  `GongYingShangGuanLi` int(11) default NULL COMMENT '供应商信息管理 ',
  `JinHuoDan` int(11) default NULL COMMENT '进货单 ',
  `JinHuoTuiHuo` int(11) default NULL COMMENT '进货退货 ',
  `XiaoShouDan` int(11) default NULL COMMENT ' 销售单 ',
  `XiaoShouTuiHuo` int(11) default NULL COMMENT ' 销售退货 ',
  `KeHuChaXun` int(11) default NULL COMMENT ' 客户查询 ',
  `ShangPinChaXun` int(11) default NULL COMMENT ' 商品查询 ',
  `GongYingShangChaXun` int(11) default NULL COMMENT ' 供应商查询 ',
  `XiaoShouChaXun` int(11) default NULL COMMENT '销售查询 ',
  `XiaoShouTuiHuoChaXun` int(11) default NULL COMMENT '销售退货查询',
  `RuKuChaXun` int(11) default NULL COMMENT '入货查询',
  `RuKuTuiHuoChaXun` int(11) default NULL COMMENT '入库退货查询',
  `XiaoShouPaiHang` int(11) default NULL COMMENT '销售排行',
  `KuCunPanDian` int(11) default NULL COMMENT '库存盘点',
  `JiaGeTiaoZheng` int(11) default NULL COMMENT '价格调整',
  `CaoZuoYuanGuanLi` int(11) default NULL COMMENT '操作员管理',
  `GengGaiMiMa` int(11) default NULL COMMENT '更改密码',
  `QuanXianGuanLi` int(11) default NULL COMMENT '权限管理',
  PRIMARY KEY  (`id`),
  KEY `rid` (`rid`),
  CONSTRAINT `tb_user_permission_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `tb_user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_permission
-- ----------------------------
INSERT INTO `tb_user_permission` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `tb_user_permission` VALUES ('2', '2', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `type` int(11) default NULL COMMENT '角色类型(0表示管理员,1表示操作员)',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1', '0');
INSERT INTO `tb_user_role` VALUES ('2', '1');
