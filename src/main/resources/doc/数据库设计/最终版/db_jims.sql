/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : db_jims

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2014-11-18 22:01:07
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
  `time` datetime default NULL COMMENT '录入时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_customer_info
-- ----------------------------
INSERT INTO `tb_customer_info` VALUES ('c14143285715680002', 'a', '城院i', '广东东莞', '523525', '13580889535', '0769-81234567', '莫梓奇', '0769-81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-10 21:32:23');
INSERT INTO `tb_customer_info` VALUES ('c14143285715680003', '东莞理工学院城市学院8', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-01 21:32:27');
INSERT INTO `tb_customer_info` VALUES ('c14143285715680004', '东莞理工学院城市学院9', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-10-14 21:32:32');
INSERT INTO `tb_customer_info` VALUES ('c14143285715680006', '东莞理工学院城市学院11', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-11 21:32:38');
INSERT INTO `tb_customer_info` VALUES ('c14143285715680007', '东莞理工学院城市学院12', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-07 21:32:42');
INSERT INTO `tb_customer_info` VALUES ('c14143285715680008', '东莞理工学院城市学院13', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-07 21:32:46');
INSERT INTO `tb_customer_info` VALUES ('c14143285715680009', '东莞理工学院城市学院14', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-07 21:32:50');
INSERT INTO `tb_customer_info` VALUES ('c14143285721620000', '东莞理工学院城市学院15', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-10-06 21:32:53');
INSERT INTO `tb_customer_info` VALUES ('c14143285721620001', '东莞理工学院城市学院16', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-05 21:32:58');
INSERT INTO `tb_customer_info` VALUES ('c14143285721620002', '东莞理工学院城市学院17', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-04 21:33:01');
INSERT INTO `tb_customer_info` VALUES ('c14143285721620003', '东莞理工学院城市学院18', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-10-20 21:33:06');
INSERT INTO `tb_customer_info` VALUES ('c14143285721620004', '东莞理工学院城市学院19', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-09 21:33:11');
INSERT INTO `tb_customer_info` VALUES ('c14143285721620005', '东莞理工学院城市学院20', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-01 21:33:15');
INSERT INTO `tb_customer_info` VALUES ('c14143285721620006', '东莞理工学院城市学院21', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-03 21:33:21');
INSERT INTO `tb_customer_info` VALUES ('c14143285721620007', '东莞理工学院城市学院22', '城院i', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-10 21:33:25');
INSERT INTO `tb_customer_info` VALUES ('c14159504955130000', '东莞理工学院城市学院1', '城院9', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-14 15:34:55');
INSERT INTO `tb_customer_info` VALUES ('c14159504955130001', '东莞理工学院城市学院2', '城院9', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-14 15:34:55');
INSERT INTO `tb_customer_info` VALUES ('c14159504955130002', '东莞理工学院城市学院3', '城院9', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-14 15:34:56');
INSERT INTO `tb_customer_info` VALUES ('c14159504955130003', '东莞理工学院城市学院4', '城院9', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-14 15:34:56');
INSERT INTO `tb_customer_info` VALUES ('c14159504955130004', '东莞理工学院城市学院5', '城院9', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-14 15:34:56');
INSERT INTO `tb_customer_info` VALUES ('c14159504955130005', '东莞理工学院城市学院6', '城院9', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-14 15:34:56');
INSERT INTO `tb_customer_info` VALUES ('c14159504955130006', '东莞理工学院城市学院7', '城院9', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-14 15:34:56');
INSERT INTO `tb_customer_info` VALUES ('c14159504955130007', '东莞理工学院城市学院8', '城院9', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-14 15:34:56');
INSERT INTO `tb_customer_info` VALUES ('c14159504955130008', '东莞理工学院城市学院9', '城院9', '广东东莞', '523525', '13580889535', null, '莫梓奇', '81234567', 'mo@163.com', '东莞银行', '5345 3453 3453 6565', '2014-11-14 15:34:56');

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
  `time` datetime default NULL COMMENT '录入时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_good_info
-- ----------------------------
INSERT INTO `tb_good_info` VALUES ('g1', '杜蕾斯避孕套', '避孕套', '未知', '元', '包', '', null, null, '2014-11-18 19:25:32');

-- ----------------------------
-- Table structure for tb_inventory_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_inventory_info`;
CREATE TABLE `tb_inventory_info` (
  `id` varchar(30) NOT NULL COMMENT '编号',
  `good_id` varchar(50) NOT NULL COMMENT '商品id',
  `user_id` varchar(50) NOT NULL,
  `specification` varchar(50) default NULL COMMENT '规格',
  `unit_cost` float default NULL COMMENT '单价',
  `amount` int(11) default NULL COMMENT '库存数量',
  `time` datetime default NULL COMMENT '入库时间',
  PRIMARY KEY  (`id`),
  KEY `tb_inventory_info_ibfk_1` (`good_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tb_inventory_info_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_inventory_info_ibfk_1` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_inventory_info
-- ----------------------------
INSERT INTO `tb_inventory_info` VALUES ('i1', 'g1', 'moziqi', '未知', '35', '990', '2014-11-18 21:58:29');

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `name` varchar(50) default NULL COMMENT '名字',
  `description` varchar(255) default NULL COMMENT '描述,访问的链接',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES ('1', 'admin_add', 'addAdmin');
INSERT INTO `tb_permission` VALUES ('2', 'admin_list', 'getListAdmin');
INSERT INTO `tb_permission` VALUES ('3', 'admin_update', 'updateAdmin');
INSERT INTO `tb_permission` VALUES ('4', 'admin_delete', 'deleteAdmin');
INSERT INTO `tb_permission` VALUES ('5', '游客', '未授权的用户');
INSERT INTO `tb_permission` VALUES ('6', '游客2', '未授权的用户');

-- ----------------------------
-- Table structure for tb_provider_good
-- ----------------------------
DROP TABLE IF EXISTS `tb_provider_good`;
CREATE TABLE `tb_provider_good` (
  `provider_id` varchar(50) default NULL,
  `good_id` varchar(50) default NULL,
  KEY `tb_provider_good_ibfk_1` (`provider_id`),
  KEY `tb_provider_good_ibfk_2` (`good_id`),
  CONSTRAINT `tb_provider_good_ibfk_2` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `tb_provider_good_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `tb_provider_info` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION
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
  `time` datetime default NULL COMMENT '录入时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_provider_info
-- ----------------------------
INSERT INTO `tb_provider_info` VALUES ('p1', 'c', null, null, null, null, null, null, null, null, null, null);

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
INSERT INTO `tb_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `tb_role` VALUES ('2', 'user', '操作员');

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
INSERT INTO `tb_role_permission` VALUES ('1', '1');
INSERT INTO `tb_role_permission` VALUES ('2', '2');
INSERT INTO `tb_role_permission` VALUES ('2', '3');
INSERT INTO `tb_role_permission` VALUES ('2', '4');

-- ----------------------------
-- Table structure for tb_sell
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell`;
CREATE TABLE `tb_sell` (
  `id` varchar(50) NOT NULL COMMENT '前缀"s",后缀1000格式',
  `customer_id` varchar(50) NOT NULL COMMENT '客户id',
  `user_id` varchar(50) NOT NULL COMMENT '操作员id',
  `good_id` varchar(50) NOT NULL COMMENT '商品id',
  `unit_cost` float default NULL COMMENT '销售单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '金额',
  `time` datetime default NULL COMMENT '销售时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `handler` varchar(50) default NULL COMMENT '负责人',
  `state` char(1) default NULL COMMENT '审批状态',
  PRIMARY KEY  (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `user_id` (`user_id`),
  KEY `tb_sell_ibfk_5` (`good_id`),
  CONSTRAINT `tb_sell_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_sell_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_sell_ibfk_5` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 4096 kB; (`good_id`) REFER `db_jims/tb_good_inf';

-- ----------------------------
-- Records of tb_sell
-- ----------------------------
INSERT INTO `tb_sell` VALUES ('1', 'c14143285715680002', 'name1', 'g1', '35', '1', '35', '2014-11-12 15:35:52', '支付宝', '董建华', '1');
INSERT INTO `tb_sell` VALUES ('2', 'c14143285715680003', 'name12', 'g1', '36', '10', '360', '2014-11-10 17:00:52', '现金', '欧阳震华', '0');
INSERT INTO `tb_sell` VALUES ('3', 'c14143285715680007', 'name13', 'g1', '34', '9', '306', '2014-11-19 17:04:10', '支付宝', '小明', '0');

-- ----------------------------
-- Table structure for tb_sell_return
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_return`;
CREATE TABLE `tb_sell_return` (
  `id` varchar(50) NOT NULL COMMENT '前缀"sell_r",后缀1000格式',
  `customer_id` varchar(50) NOT NULL COMMENT '客户id',
  `user_id` varchar(50) NOT NULL COMMENT '操作员id',
  `good_id` varchar(50) NOT NULL COMMENT '商品id',
  `unit_cost` float default NULL COMMENT '销售单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '金额',
  `time` datetime default NULL COMMENT '销售退回时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `handler` varchar(50) default NULL COMMENT '负责人',
  `state` char(1) default NULL COMMENT '审批状态',
  PRIMARY KEY  (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `user_id` (`user_id`),
  KEY `good_id` (`good_id`),
  CONSTRAINT `tb_sell_return_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_sell_return_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_sell_return_ibfk_5` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `provider_id` varchar(50) NOT NULL COMMENT '供应商id',
  `user_id` varchar(50) NOT NULL COMMENT '对应用户id',
  `good_id` varchar(50) NOT NULL COMMENT '商品id',
  `variety_amount` int(11) default NULL COMMENT '品种数量',
  `unit_cost` float default NULL COMMENT '单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '合计金额',
  `check_conclusion` varchar(50) default NULL COMMENT '验收结论',
  `time` datetime default NULL COMMENT '入货时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `handler` varchar(50) default NULL COMMENT '经手人',
  `state` char(1) default NULL COMMENT '审批状态',
  PRIMARY KEY  (`id`),
  KEY `provider_id` (`provider_id`),
  KEY `user_id` (`user_id`),
  KEY `good_id` (`good_id`),
  CONSTRAINT `tb_stock_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `tb_provider_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_stock_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_stock_ibfk_3` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 4096 kB; (`inventory_id`) REFER `db_jims/tb_goo';

-- ----------------------------
-- Records of tb_stock
-- ----------------------------
INSERT INTO `tb_stock` VALUES ('stock1', 'p1', 'moziqi', 'g1', '100', '100', '100', '100', '22', '2014-11-09 21:28:06', '2121', '毛泽东', '');

-- ----------------------------
-- Table structure for tb_stock_return
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock_return`;
CREATE TABLE `tb_stock_return` (
  `id` varchar(30) NOT NULL default '' COMMENT '入库退货编号,以"stock_r"字符串为前缀',
  `provider_id` varchar(50) NOT NULL COMMENT '供应商id',
  `user_id` varchar(50) NOT NULL COMMENT '对应用户id',
  `good_id` varchar(50) NOT NULL COMMENT '货物id',
  `variety_amount` int(11) default NULL COMMENT '品种数量',
  `unit_cost` float default NULL COMMENT '单价',
  `amount` int(11) default NULL COMMENT '数量',
  `sum` float default NULL COMMENT '合计金额',
  `check_conclusion` varchar(50) default NULL COMMENT '验收结论',
  `time` datetime default NULL COMMENT '入货退货时间',
  `clearing_form` varchar(50) default NULL COMMENT '结算方式',
  `handler` varchar(50) default NULL COMMENT '经手人',
  `state` char(1) default NULL COMMENT '审批状态',
  PRIMARY KEY  (`id`),
  KEY `provider_id` (`provider_id`),
  KEY `user_id` (`user_id`),
  KEY `good_id` (`good_id`),
  CONSTRAINT `tb_stock_return_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `tb_provider_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_stock_return_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_stock_return_ibfk_3` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
INSERT INTO `tb_user` VALUES ('moziqi', '莫梓奇', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-22 15:53:55', '2014-11-09 21:26:36');
INSERT INTO `tb_user` VALUES ('name1', '莫梓奇2', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:51', '2014-11-09 21:26:39');
INSERT INTO `tb_user` VALUES ('name10', 'uname10', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:51', '2014-11-04 23:29:19');
INSERT INTO `tb_user` VALUES ('name11', 'uname11', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:51', '2014-11-04 23:29:20');
INSERT INTO `tb_user` VALUES ('name12', 'uname12', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:51', '2014-11-04 23:29:21');
INSERT INTO `tb_user` VALUES ('name13', 'uname13', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:51', '2014-11-04 23:29:23');
INSERT INTO `tb_user` VALUES ('name14', 'uname14', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:51', '2014-11-04 23:29:24');
INSERT INTO `tb_user` VALUES ('name15', 'uname15', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:27');
INSERT INTO `tb_user` VALUES ('name16', 'uname16', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:29');
INSERT INTO `tb_user` VALUES ('name17', 'uname17', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:30');
INSERT INTO `tb_user` VALUES ('name18', 'uname18', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:31');
INSERT INTO `tb_user` VALUES ('name19', 'uname19', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:34');
INSERT INTO `tb_user` VALUES ('name2', 'uname2', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:51', '2014-11-04 23:29:36');
INSERT INTO `tb_user` VALUES ('name20', 'uname20', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:38');
INSERT INTO `tb_user` VALUES ('name21', 'uname21', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:40');
INSERT INTO `tb_user` VALUES ('name22', 'uname22', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:42');
INSERT INTO `tb_user` VALUES ('name23', 'uname23', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:44');
INSERT INTO `tb_user` VALUES ('name24', 'uname24', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:47');
INSERT INTO `tb_user` VALUES ('name25', 'uname25', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:48');
INSERT INTO `tb_user` VALUES ('name26', 'uname26', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:49');
INSERT INTO `tb_user` VALUES ('name27', 'uname27', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-15 13:10:52', '2014-11-04 23:29:51');
INSERT INTO `tb_user` VALUES ('name28', 'uname28', '123465', '2014-10-15 13:10:52', null);
INSERT INTO `tb_user` VALUES ('name29', 'uname29', '123465', '2014-10-15 13:10:52', null);
INSERT INTO `tb_user` VALUES ('name3', 'uname3', '123465', '2014-10-15 13:10:51', null);
INSERT INTO `tb_user` VALUES ('name4', 'uname4', '123465', '2014-10-15 13:10:51', null);
INSERT INTO `tb_user` VALUES ('name5', 'uname5', '123465', '2014-10-15 13:10:51', null);
INSERT INTO `tb_user` VALUES ('name6', 'uname6', '123465', '2014-10-15 13:10:51', null);
INSERT INTO `tb_user` VALUES ('name7', 'uname7', '123465', '2014-10-15 13:10:51', null);
INSERT INTO `tb_user` VALUES ('name8', 'uname8', '123465', '2014-10-15 13:10:51', null);
INSERT INTO `tb_user` VALUES ('name9', 'uname9', '123465', '2014-10-15 13:10:51', null);

-- ----------------------------
-- Table structure for tb_user_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_log`;
CREATE TABLE `tb_user_log` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `user_account` varchar(50) NOT NULL COMMENT '对应用户表的account',
  `login_time` datetime default NULL COMMENT '登录时间',
  PRIMARY KEY  (`id`),
  KEY `user_account` (`user_account`),
  CONSTRAINT `tb_user_log_ibfk_1` FOREIGN KEY (`user_account`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_log
-- ----------------------------
INSERT INTO `tb_user_log` VALUES ('1', 'name1', '2014-10-22 15:19:54');
INSERT INTO `tb_user_log` VALUES ('2', 'name2', '2014-10-22 15:20:05');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `user_id` varchar(50) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `tb_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('moziqi', '1');
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_sell_insert`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_sell_insert` AFTER INSERT ON `tb_sell` FOR EACH ROW  
   begin
     update tb_inventory_info set amount=amount - new.amount 
     where good_id = new.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_sell_update`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_sell_update` AFTER UPDATE ON `tb_sell` FOR EACH ROW  
   begin
     update tb_inventory_info set amount=amount - new.amount 
     where good_id = old.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_sell_return_insert`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_sell_return_insert` AFTER INSERT ON `tb_sell_return` FOR EACH ROW  
   begin
     update tb_inventory_info set amount=amount + new.amount 
     where good_id = new.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_sell_return_update`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_sell_return_update` AFTER UPDATE ON `tb_sell_return` FOR EACH ROW  
   begin
     update tb_inventory_info set amount=amount + new.amount 
     where good_id = old.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_stock_insert`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_stock_insert` AFTER INSERT ON `tb_stock` FOR EACH ROW  
   begin
     update tb_inventory_info set amount=amount + new.amount 
     where good_id = new.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_stock_update`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_stock_update` AFTER UPDATE ON `tb_stock` FOR EACH ROW  
   begin
     update tb_inventory_info set amount = amount + new.amount 
     where good_id = old.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_stock_return_insert`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_stock_return_insert` AFTER INSERT ON `tb_stock_return` FOR EACH ROW  
   begin
     update tb_inventory_info set amount=amount - new.amount 
     where good_id = new.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_stock_return_update`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_stock_return_update` AFTER UPDATE ON `tb_stock_return` FOR EACH ROW  
   begin
     update tb_inventory_info set amount=amount - new.amount 
     where good_id = old.good_id and new.state = '0';
   end
;;
DELIMITER ;
