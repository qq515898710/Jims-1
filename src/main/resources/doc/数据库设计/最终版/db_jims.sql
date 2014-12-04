/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : db_jims

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2014-12-04 22:53:52
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
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uk_customer_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_customer_info
-- ----------------------------
INSERT INTO `tb_customer_info` VALUES ('c14175948294840000', '阿里巴巴', '阿巴', '中国杭州市余杭区文一西路969号 (311100)', '523000', '13800138000', '0571-88157872', '马云', '0571-88157872', 'alababa@mayun.com', '无', '无', '2014-12-03 16:20:29');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840001', '阿里妈妈', '阿妈', '浙江省杭州市下城区海华广场', '310000 ', '13596721568', '093-76269992', '当麻', '093-76269992', 'alimama@dm.com', '无', '无', '2014-12-03 16:27:52');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840002', '腾讯帝国', '企鹅', '中国深圳', '518000', '13583765566', '093-73933024', '麻花疼', '093-73933024', 'mahua@qq.com', '无', '无', '2014-12-03 16:31:50');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840003', 'google', '谷歌', '美国加利福尼亚州圣克拉拉县山景市', '590015 ', '13612388791', '093-78835352', '拉里·佩奇', '093-78835352', 'google@play.com', '无', '无', '2014-12-03 16:35:30');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840004', '百度', 'baidu', '中国北京', '100028', '18956752155', '010-65196110', '李生', '010-65196110', 'baidu@qq.com', '无', '无', '2014-12-03 16:38:33');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840005', '北京市邮政总局', '北邮政', '北京西城区二龙路', '100000', '15675513274', '093-72661169', '政府机关', '093-72661169', 'byz@government.com', '无', '无', '2014-12-03 16:41:39');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840006', '京东商城', 'JD', '中国北京市朝阳区北辰西路8号北辰世纪中心A座', '100000', '13888105500', '0527-88105500', '刘强东', '0527-88105500', 'JD@js.com', '无', '无', '2014-12-03 16:44:45');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840007', '易迅', 'yx', '上海易迅电子商务发展有限公司', '200000', '13008288788', '093-78839565', '卜广齐', '093-78839565', 'pgq@yixun.com', '无', '无', '2014-12-03 16:48:31');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840008', '新蛋', 'negg', '美国南加州', '300000', '18818832145', '021-67072999', '蛋总', '021-67072999', 'newegg@service.com', '无', '无', '2014-12-03 16:51:24');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840009', '亚马逊', 'Amazon', '西雅图', '400000', '13881056661', '093-72688963', '杰夫·贝佐斯', '093-72688963', 'Amazon@Business.com', '无', '无', '2014-12-03 16:54:18');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840010', '阿里旺旺', '淘宝', '浙江杭州', '310000', '13588158198', '093-76713310', '马云', '093-76713310', 'awangwang@tb.com', '无', '无', '2014-12-03 16:56:58');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840011', '八达华利五金机电市场', '八达华五金', '虎门镇人民南路78号旺角中心', '523000', '18922501788', '093-78832536', '东莞山庄', '093-78832536', 'bdah@dg.com', '无', '无', '2014-12-03 16:59:58');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840012', '美宜佳', '无', '广东省东莞市糖酒集团控股的连锁商业流通企业', '523000', '13541234875', '093-75917702', '叶志坚', '093-75917702', 'myijia@dg.com', '无', '无', '2014-12-03 17:01:47');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840013', '沃尔玛百货有限公司', '沃尔玛', '美国阿肯色州的本顿维尔', '231500', '13421512288', '093-78932838', '董明伦', '093-78932838', 'WalMart@Stores.com', '无', '无', '2014-12-03 17:04:56');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840014', '百佳超级市场', '百佳', '香港', '999077', '13907700852', '093-72630012', '李嘉诚', '093-72630012', 'ljchen@parknshop.com', '无', '无', '2014-12-03 17:09:02');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840015', '711便利店', '7-Eleven', '美国德州达拉斯', '999077', '18907700852', '093-78821123', 'Mr.Jim Keyes', '093-78821123', '7Eleven@711.com', '无', '无', '2014-12-03 17:12:26');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840016', '1号店', '无', '上海益实多电子商务有限公司', '200000', '18000711111', '093-72688299', '于刚', '093-72688299', 'No.1@store.com', '无', '无', '2014-12-03 17:15:18');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840017', '优衣库', 'UNIQLO', '中国香港地区', '523000', '13465432137', '093-72681986', '柳井正', '093-72681986', 'UNIQLO@jp.com', '无', '无', '2014-12-03 17:18:29');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840018', '耐克', 'NIKE', '美国俄勒冈州波特兰市', '999699', '13908208861', '093-78851188', 'Mark Parker', '093-78851188', 'naike@NIke.com', '无', '无', '2014-12-03 17:20:29');
INSERT INTO `tb_customer_info` VALUES ('c14175948294840019', '阿迪王', '无', '福建泉州', '5233331', '13546135761', '093-76712011', '春', '093-76712011', 'chun@adw.com', '无', '无', '2014-12-03 17:22:26');

-- ----------------------------
-- Table structure for tb_good_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_good_info`;
CREATE TABLE `tb_good_info` (
  `id` varchar(50) NOT NULL COMMENT '商品编号是商品的唯一标识,前缀使用“g”字符串',
  `provider_id` varchar(50) NOT NULL COMMENT '供应商id',
  `name` varchar(50) NOT NULL COMMENT '商品名字',
  `abbreviation` varchar(50) default NULL COMMENT '简称',
  `origin` varchar(50) default NULL COMMENT '产地',
  `unit_cost` float default NULL COMMENT '单价',
  `pack` varchar(50) default NULL COMMENT '包装',
  `approval_num` varchar(50) default NULL COMMENT '批准文号',
  `batch_num` varchar(50) default NULL COMMENT '批号',
  `memo` varchar(90) default NULL COMMENT '备忘录(简介)',
  `time` datetime default NULL COMMENT '录入时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uk_good_name` (`name`),
  KEY `provider_id` (`provider_id`),
  CONSTRAINT `tb_good_info_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `tb_provider_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_good_info
-- ----------------------------
INSERT INTO `tb_good_info` VALUES ('g14176971400180022', 'p14176971400180001', '卡西欧 EX-MR1', 'EX-MR1', '日本', '100000', '彩包', 'H33022048', 'F-01', '', '2014-12-04 21:58:17');
INSERT INTO `tb_good_info` VALUES ('g14176971400180023', 'p14176971400180017', '充气娃娃半实体三交', '充气娃娃', '广东广州 荔湾区', '235', '非全新', '无', '无', '', '2014-12-04 22:02:30');
INSERT INTO `tb_good_info` VALUES ('g14176971400180024', 'p14176971400180014', '香奈儿山茶花补水美白', '香奈儿', '美国', '308', '三包', 'F20080018 ', 'GB/T 16451-1996 ', '', '2014-12-04 22:05:15');
INSERT INTO `tb_good_info` VALUES ('g14176971400180025', 'p14176971400180012', '妤舒颜安抚卸妆乳', '安婕', '中国', '87', '彩包', 'F20080014', 'GB/T 13736-92 ', '', '2014-12-04 22:06:35');
INSERT INTO `tb_good_info` VALUES ('g14176971400180026', 'p14176971400180018', '韩国鸡蛋面膜too cool for school', 'egg保', '韩国', '65', '简包', 'F20050008', 'GB 1986-89', '', '2014-12-04 22:07:40');
INSERT INTO `tb_good_info` VALUES ('g14176971400180027', 'p14176971400180006', '外星人 ALW17D-2728', 'M17X', '深圳', '13278', '全包', '无', '无', '', '2014-12-04 22:08:55');
INSERT INTO `tb_good_info` VALUES ('g14176971400180028', 'p14176971400180008', '苹果iphone4/4s背夹电池', '充电宝', '深圳', '68', '简包', '无', '无', '', '2014-12-04 22:10:09');
INSERT INTO `tb_good_info` VALUES ('g14176971400180029', 'p14176971400180001', '一次成像LOMO胶卷', '拍立得', '深圳', '355', '简包', '无', '无', '', '2014-12-04 22:11:30');
INSERT INTO `tb_good_info` VALUES ('g14176971400180030', 'p14176971400180010', 'Iphone 6', '苹果绿', '杭州', '5287', '彩包', '无', '无', '', '2014-12-04 22:12:56');
INSERT INTO `tb_good_info` VALUES ('g14176971400180031', 'p14176971400180004', '瑞士天梭TISSOT手表力洛克', '天梭', '瑞士', '2870', '三包', '无', '无', '', '2014-12-04 22:14:36');
INSERT INTO `tb_good_info` VALUES ('g14176971400180032', 'p14176971400180021', '多芬沐浴露丰盈宠肤沐浴乳', '沐浴乳', '大陆', '32.9', '无', '无', '无', '', '2014-12-04 22:15:54');
INSERT INTO `tb_good_info` VALUES ('g14176971400180033', 'p14176971400180012', '旺旺吸吸冰 ', '冰', '广州', '3.8', '盒装', '无', '无', '', '2014-12-04 22:17:09');
INSERT INTO `tb_good_info` VALUES ('g14176971400180034', 'p14176971400180014', '巴拿米蔓越莓西饼', '西饼', '巴西', '11.9', '箱装', '无', '无', '', '2014-12-04 22:18:17');
INSERT INTO `tb_good_info` VALUES ('g14176971400180035', 'p14176971400180016', '鲁花5S压榨一级花生油', '花生油', '山东', '85.9', '桶装', '无', '无', '', '2014-12-04 22:19:03');
INSERT INTO `tb_good_info` VALUES ('g14176971400180036', 'p14176971400180009', '小米平板 ', '米板', '北京', '1299', '简包', '无', '无', '', '2014-12-04 22:20:42');
INSERT INTO `tb_good_info` VALUES ('g14176971400180037', 'p14176971400180005', '三星 SM-N9150 GALAXY Note Edge', '盾牌', '韩国', '6699', '彩包', '无', '无', '', '2014-12-04 22:21:26');
INSERT INTO `tb_good_info` VALUES ('g14176971400180038', 'p14176971400180003', '飞利浦净水器', '净水', '荷兰', '169', '桶装', '无', '无', '', '2014-12-04 22:22:48');
INSERT INTO `tb_good_info` VALUES ('g14176971400180039', 'p14176971400180015', '福库G1067SR电饭煲', '电饭煲', '辽宁沈阳', '2950', '三包', '无', '无', '', '2014-12-04 22:30:24');
INSERT INTO `tb_good_info` VALUES ('g14176971400180041', 'p14176971400180020', 'Iphone20', '次世代', '五次元', '999999', '无', '无', '无', '', '2014-12-04 22:33:45');
INSERT INTO `tb_good_info` VALUES ('g14176971400180042', 'p14176971400180011', '广州樱花抽油烟机', '无', '广州', '999', '箱装', '无', '无', '', '2014-12-04 22:35:04');

-- ----------------------------
-- Table structure for tb_inventory_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_inventory_info`;
CREATE TABLE `tb_inventory_info` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `good_id` varchar(50) NOT NULL COMMENT '商品id',
  `unit_cost` float default NULL COMMENT '单价',
  `amount` int(11) default '0' COMMENT '库存数量',
  `time` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP COMMENT '入库时间',
  PRIMARY KEY  (`id`),
  KEY `tb_inventory_info_ibfk_1` (`good_id`),
  CONSTRAINT `tb_inventory_info_ibfk_1` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_inventory_info
-- ----------------------------
INSERT INTO `tb_inventory_info` VALUES ('1', 'g14176971400180022', '100000', '0', '2014-12-04 21:58:18');
INSERT INTO `tb_inventory_info` VALUES ('2', 'g14176971400180023', '235', '0', '2014-12-04 22:02:30');
INSERT INTO `tb_inventory_info` VALUES ('3', 'g14176971400180024', '308', '0', '2014-12-04 22:05:15');
INSERT INTO `tb_inventory_info` VALUES ('4', 'g14176971400180025', '87', '0', '2014-12-04 22:06:35');
INSERT INTO `tb_inventory_info` VALUES ('5', 'g14176971400180026', '65', '0', '2014-12-04 22:07:41');
INSERT INTO `tb_inventory_info` VALUES ('6', 'g14176971400180027', '13278', '0', '2014-12-04 22:08:55');
INSERT INTO `tb_inventory_info` VALUES ('7', 'g14176971400180028', '68', '0', '2014-12-04 22:10:09');
INSERT INTO `tb_inventory_info` VALUES ('8', 'g14176971400180029', '355', '0', '2014-12-04 22:11:30');
INSERT INTO `tb_inventory_info` VALUES ('9', 'g14176971400180030', '5287', '0', '2014-12-04 22:12:56');
INSERT INTO `tb_inventory_info` VALUES ('10', 'g14176971400180031', '2870', '0', '2014-12-04 22:14:36');
INSERT INTO `tb_inventory_info` VALUES ('11', 'g14176971400180032', '32.9', '0', '2014-12-04 22:15:54');
INSERT INTO `tb_inventory_info` VALUES ('12', 'g14176971400180033', '3.8', '0', '2014-12-04 22:17:09');
INSERT INTO `tb_inventory_info` VALUES ('13', 'g14176971400180034', '11.9', '0', '2014-12-04 22:18:17');
INSERT INTO `tb_inventory_info` VALUES ('14', 'g14176971400180035', '85.9', '0', '2014-12-04 22:19:03');
INSERT INTO `tb_inventory_info` VALUES ('15', 'g14176971400180036', '1299', '0', '2014-12-04 22:20:42');
INSERT INTO `tb_inventory_info` VALUES ('16', 'g14176971400180037', '6699', '0', '2014-12-04 22:21:26');
INSERT INTO `tb_inventory_info` VALUES ('17', 'g14176971400180038', '169', '0', '2014-12-04 22:22:48');
INSERT INTO `tb_inventory_info` VALUES ('18', 'g14176971400180039', '2950', '0', '2014-12-04 22:30:24');
INSERT INTO `tb_inventory_info` VALUES ('19', 'g14176971400180041', '999999', '0', '2014-12-04 22:33:45');
INSERT INTO `tb_inventory_info` VALUES ('20', 'g14176971400180042', '999', '0', '2014-12-04 22:35:04');

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `name` varchar(50) default NULL COMMENT '名字',
  `description` varchar(255) default NULL COMMENT '描述,访问的链接',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uk_permission_name` (`name`)
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
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uk_provider_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_provider_info
-- ----------------------------
INSERT INTO `tb_provider_info` VALUES ('p14176971400180001', '富士康科技集团', '跳楼康', '中国深圳', '518000', '15128129588', '055-28129588', '郭台铭', '055-28129588', '无', 'Foxconn@sz.com', '2014-12-04 20:49:18');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180002', '微星科技公司', '军规星', '台湾台北县中和市', '200222', '1348288588', '828-85881111', '徐祥', '828-85881111', '无', 'MSI@taiwan.com', '2014-12-04 20:52:41');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180003', '华硕电脑股份有限公司', '华硕', '台湾台北市北投区立德路15号', '2011221', '13400007555', '400-6006655', '童子贤', '400-6006655', '无', 'ASUS@asus.com', '2014-12-04 20:55:02');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180004', 'EVGA Corporation', 'evga', '美国', '315005', '1800282868', '800-2828681', '欧巴马', '800-2828681', '无', 'evga@migo.com', '2014-12-04 20:57:48');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180005', '技嘉科技（GIGABYTE）', '技嘉', '台湾', '2210512', '13216341018', '021-63410189', '一群满怀理想抱负的年轻工程师', '021-63410189', '无', 'GIGABYTE@tw.com', '2014-12-04 21:00:32');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180006', '七彩虹科技发展有限公司', '七彩虹', '深圳', '315000', '13506792011', '400-6792011', '艾崴', '400-6792011', '无', 'Colorful@sz.com', '2014-12-04 21:03:20');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180007', '华擎科技股份有限公司', '华擎', '台湾台北', '455451', '13021071063', '021-60710630', '徐世昌', '021-60710630', '无', 'ASROCK@tw.com', '2014-12-04 21:05:58');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180008', '磐正科技', '磐正', '台湾', '7545412', '13295105809', '052-95105809', '威盛', '052-95105809', '无', 'SUPoX@EPOX.com', '2014-12-04 21:07:54');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180009', '映泰集团', '映泰', '中国台北', '5261400', '15295105530', '055-95105530', '一群志同道合的人', '055-95105530', '无', 'BIOSTAR@gd.com', '2014-12-04 21:10:44');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180010', '昂达电子', '昂达', '中国境内', '5131415', '13120876363', '020-87636363', '达哥', '020-87636363', '无', 'ong@sz.com', '2014-12-04 21:16:34');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180011', '长白山土特产公司', '土特产', '苌苩屾池丠', '522005', '13233578817', '0433-5788173', '韓', '0433-5788173', '无', '1056811055@qq.com', '2014-12-04 21:26:45');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180012', '仙桃航盛饲料有限公司', '无', '仙桃市干河高新技术产业园', '541322', '13035355908', '0728-3269867', '黄先生', '0728-3269867', '无', 'hbxths@123.com', '2014-12-04 21:28:21');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180013', '山东琦源牧业牛羊养殖基地', '无', '山东省济宁市', '524634', '13563729498', '053-76787498', '张传来', '053-76787498', '无', 'sdbulefly@126.com', '2014-12-04 21:30:12');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180014', '宜昌金利粮油食品有限公司', '有限责任公司', '湖北宜昌市西陵区云集路33号云集大厦', '0717-3461078', '13307200862', '0717-3461078', '张仁勇', '0717-3461078', '无', 'www@sxss.cn ', '2014-12-04 21:33:28');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180015', '虎林市石青峰天然保健品有限公司', '大保健', '黑龙江虎林市石青峰', '9551510', '13684608477', '0451-89589101', '谢艳双', '0451-89589101', '无', '123@dg.com', '2014-12-04 21:35:27');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180016', '抚松县岳桦林人参林产品有限公司', '人参', '吉林省白山市抚松县灵芝路40号', '5524242', '13043989601', '0439-6227118', '岳桦林', '0439-6227118', '无', '123456@qq.com', '2014-12-04 21:37:16');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180017', '蓬莱金创果蔬保鲜有限公司', '蓬莱果', '吉林省白山市抚松县灵芝路40号', '04398960118', '18043989601', '043-98960118', '岳桦林', '043-98960118', '无', 'plgg@yx.com', '2014-12-04 21:39:33');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180018', '贺州市永盛特产经销公司', '永盛', '广西贺州市', '5230001', '13197534800', '0774-5220157', '何维坚', '0774-5220157', '9559981539762938013 ', 'ngfwy@126.com', '2014-12-04 21:43:13');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180020', '云南烈铭科技开发有限公司', '云生源特产', '云南省昆明市西山区安康路162号新滇元商厦3楼', '0871-4179629 ', '13095311682', '0871-4179629', '祁程', '0871-4179629', '无', 'huidayn4@126.com', '2014-12-04 21:49:48');
INSERT INTO `tb_provider_info` VALUES ('p14176971400180021', '恩惠环保手工艺品厂', '工艺', '广东广州市徳中路２３５－２４３号德进批发市场D7档', '134-34187409', '13434187409', '134-34187409', '余正彦', '134-34187409', '４０５５１２１５７１５０２０５０３', 'eh88511211@com.cn', '2014-12-04 21:53:57');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `name` varchar(50) default NULL COMMENT '名字',
  `description` varchar(255) default NULL COMMENT '描述',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uk_role_name` (`name`)
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
  KEY `tb_role_permission_ibfk_2` (`permission_id`),
  CONSTRAINT `tb_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `tb_permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  CONSTRAINT `tb_sell_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_sell_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_sell_ibfk_5` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 4096 kB; (`good_id`) REFER `db_jims/tb_good_inf';

-- ----------------------------
-- Records of tb_sell
-- ----------------------------
INSERT INTO `tb_sell` VALUES ('sell14176971400180046', 'c14175948294840016', 'moziqi', 'g14176971400180031', '2888', '2', '5776', '2014-12-04 22:45:02', '分期付款', 'llx', '1');
INSERT INTO `tb_sell` VALUES ('sell14176971400180047', 'c14175948294840006', 'moziqi', 'g14176971400180027', '13888', '2', '27776', '2014-12-04 22:45:02', '分期付款', 'llx', '1');
INSERT INTO `tb_sell` VALUES ('sell14176971400180048', 'c14175948294840015', 'moziqi', 'g14176971400180023', '300', '5', '1500', '2014-12-04 22:45:02', '银行卡', 'llx', '1');
INSERT INTO `tb_sell` VALUES ('sell14176971400180049', 'c14175948294840012', 'moziqi', 'g14176971400180041', '99', '50', '4950', '2014-12-04 22:45:02', '活动赠送', 'llx', '1');
INSERT INTO `tb_sell` VALUES ('sell14176971400180050', 'c14175948294840003', 'moziqi', 'g14176971400180032', '35', '100', '3500', '2014-12-04 22:45:02', '赊账', 'llx', '1');

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
  KEY `tb_sell_return_ibfk_5` (`good_id`),
  CONSTRAINT `tb_sell_return_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_sell_return_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_sell_return_ibfk_5` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  CONSTRAINT `tb_stock_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `tb_provider_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_stock_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_stock_ibfk_3` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 4096 kB; (`inventory_id`) REFER `db_jims/tb_goo';

-- ----------------------------
-- Records of tb_stock
-- ----------------------------
INSERT INTO `tb_stock` VALUES ('stock14176971400180043', 'p14176971400180018', 'moziqi', 'g14176971400180026', '55', '16', '880', '无', '2014-12-04 22:37:50', '现金', 'llx', '1');
INSERT INTO `tb_stock` VALUES ('stock14176971400180044', 'p14176971400180011', 'moziqi', 'g14176971400180042', '999', '20', '19980', '无', '2014-12-04 22:37:51', '转账', 'llx', '1');
INSERT INTO `tb_stock` VALUES ('stock14176971400180045', 'p14176971400180003', 'moziqi', 'g14176971400180038', '119', '60', '7140', '补仓', '2014-12-04 22:37:51', '转账', 'mzq', '1');

-- ----------------------------
-- Table structure for tb_stock_return
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock_return`;
CREATE TABLE `tb_stock_return` (
  `id` varchar(30) NOT NULL default '' COMMENT '入库退货编号,以"stock_r"字符串为前缀',
  `provider_id` varchar(50) NOT NULL COMMENT '供应商id',
  `user_id` varchar(50) NOT NULL COMMENT '对应用户id',
  `good_id` varchar(50) NOT NULL COMMENT '货物id',
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
  CONSTRAINT `tb_stock_return_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `tb_provider_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_stock_return_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_stock_return_ibfk_3` FOREIGN KEY (`good_id`) REFERENCES `tb_good_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  PRIMARY KEY  (`account`),
  UNIQUE KEY `uk_user_name` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('moziqi', '莫梓奇', 'f1764bc7363ece6170ebf1334f2e6e6f', '2014-10-22 15:53:55', '2014-11-09 21:26:36');
INSERT INTO `tb_user` VALUES ('u14176971400180051', 'LLX', 'ef3e7c30c5ff8f6b3ce0155ca7a9a17f', '2014-12-04 22:46:14', '2014-12-04 22:46:14');

-- ----------------------------
-- Table structure for tb_user_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_log`;
CREATE TABLE `tb_user_log` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `user_account` varchar(50) NOT NULL COMMENT '对应用户表的account',
  `login_time` datetime default NULL COMMENT '登录时间',
  PRIMARY KEY  (`id`),
  KEY `tb_user_log_ibfk_1` (`user_account`),
  CONSTRAINT `tb_user_log_ibfk_1` FOREIGN KEY (`user_account`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
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
  KEY `tb_user_role_ibfk_1` (`user_id`),
  KEY `tb_user_role_ibfk_2` (`role_id`),
  CONSTRAINT `tb_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 3072 kB; (`user_id`) REFER `db_jims/tb_user`(`a';

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('moziqi', '1');
INSERT INTO `tb_user_role` VALUES ('moziqi', '2');
INSERT INTO `tb_user_role` VALUES ('u14176971400180051', '2');
DROP TRIGGER IF EXISTS `trigger_insert_tb_inventory_after`;
DELIMITER ;;
CREATE TRIGGER `trigger_insert_tb_inventory_after` AFTER INSERT ON `tb_good_info` FOR EACH ROW  begin
     insert into tb_inventory_info(good_id,unit_cost,time) value(new.id,new.unit_cost,now());
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_sell_insert`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_sell_insert` AFTER INSERT ON `tb_sell` FOR EACH ROW  begin
     update tb_inventory_info set amount=amount - new.amount 
     where good_id = new.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_sell_update`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_sell_update` AFTER UPDATE ON `tb_sell` FOR EACH ROW  begin
     update tb_inventory_info set amount=amount - new.amount 
     where good_id = old.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_sell_return_insert`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_sell_return_insert` AFTER INSERT ON `tb_sell_return` FOR EACH ROW  begin
     update tb_inventory_info set amount=amount + new.amount 
     where good_id = new.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_sell_return_update`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_sell_return_update` AFTER UPDATE ON `tb_sell_return` FOR EACH ROW  begin
     update tb_inventory_info set amount=amount + new.amount 
     where good_id = old.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_stock_insert`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_stock_insert` AFTER INSERT ON `tb_stock` FOR EACH ROW  begin
     update tb_inventory_info set amount=amount + new.amount ,unit_cost = (new.unit_cost * 0.2 + new.unit_cost)
     where good_id = new.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_stock_update`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_stock_update` AFTER UPDATE ON `tb_stock` FOR EACH ROW  begin
     update tb_inventory_info set amount = amount + new.amount, unit_cost = (new.unit_cost * 0.2 + new.unit_cost)
     where good_id = old.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_stock_return_insert`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_stock_return_insert` AFTER INSERT ON `tb_stock_return` FOR EACH ROW  begin
     update tb_inventory_info set amount=amount - new.amount 
     where good_id = new.good_id and new.state = '0';
   end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trigger_reduce_inventory_stock_return_update`;
DELIMITER ;;
CREATE TRIGGER `trigger_reduce_inventory_stock_return_update` AFTER UPDATE ON `tb_stock_return` FOR EACH ROW  begin
     update tb_inventory_info set amount=amount - new.amount 
     where good_id = old.good_id and new.state = '0';
   end
;;
DELIMITER ;
