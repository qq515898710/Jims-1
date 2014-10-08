/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/9/24 星期三 18:54:22                       */
/*==============================================================*/


drop table if exists tb_customer_info;

drop table if exists tb_good_info;

drop table if exists tb_inventory_info;

drop table if exists tb_provider_info;

drop table if exists tb_sell;

drop table if exists tb_sell_return;

drop table if exists tb_stock;

drop table if exists tb_stock_return;

drop table if exists tb_user;

drop table if exists tb_user_log;

drop table if exists tb_user_permission;

drop table if exists tb_user_role;

/*==============================================================*/
/* Table: tb_customer_info                                      */
/*==============================================================*/
create table tb_customer_info
(
   id                   varchar(50) not null comment '客户的ID编号，以字符串"c"为编号的前缀,加上4位数字做编号的后缀',
   cname                varchar(50) not null comment '客户名称',
   abbreviation         varchar(50) comment '简称',
   address              varchar(100) comment '地址',
   postal_code          varchar(50) comment '邮政编号',
   phone                varchar(50) comment '电话',
   fax                  varchar(50) comment '传真',
   contacts             varchar(50) comment '联系人',
   telephone            varchar(50) comment '联系人电话',
   email                varchar(50) comment '电子邮箱',
   deposit_bank         varchar(60) comment '开户行',
   account_bank         varchar(60) comment '帐号',
   primary key (id)
);

alter table tb_customer_info comment '客户信息';

/*==============================================================*/
/* Table: tb_good_info                                          */
/*==============================================================*/
create table tb_good_info
(
   id                   varchar(50) not null comment '商品编号是商品的唯一标识，它是商品信息表的主键，用于区分不同的商品，前缀使用“g”字符串',
   gname                varchar(50) not null comment '商品名字',
   abbreviation         varchar(50) comment '简称',
   origin               varchar(50) comment '产品',
   units                varchar(50) comment '单位',
   pack                 varchar(50) comment '包装',
   approval_num         varchar(50) comment '批准文号',
   batch_num            varchar(50) comment '批号',
   memo                 varchar(90) comment '备忘录(简介)',
   pid                  varchar(50),
   primary key (id)
);

alter table tb_good_info comment '商品信息';

/*==============================================================*/
/* Table: tb_inventory_info                                     */
/*==============================================================*/
create table tb_inventory_info
(
   id                   varchar(30) not null comment '编号',
   name                 varchar(50) not null comment '商品名称',
   abbreviation         varchar(50) comment '商品简称',
   origin               varchar(50) comment '产地',
   specification        varchar(50) comment '规格',
   pack                 varchar(50) comment '包装',
   units                varchar(10) comment '单位',
   unit_cost            float comment '单价',
   amount               int comment '库存数量',
   primary key (id)
);

alter table tb_inventory_info comment '库存信息';

/*==============================================================*/
/* Table: tb_provider_info                                      */
/*==============================================================*/
create table tb_provider_info
(
   id                   varchar(50) not null comment '以"p"作为前缀,加上4位数做编号的后缀',
   pname                varchar(60) not null comment '供应商名称',
   abbreviation         varchar(50) comment '简称',
   address              varchar(100) comment '地址',
   postal_code          varchar(50) comment '邮政编码',
   phone                varchar(50) comment '电话',
   fax                  varchar(50) comment '传真',
   contacts             varchar(50) comment '联系人',
   telephone            varchar(50) comment '联系人电话',
   deposit_bank         varchar(50) comment '开户行',
   email                varchar(50) comment '电子邮箱',
   primary key (id)
);

alter table tb_provider_info comment '供应商信息';

/*==============================================================*/
/* Table: tb_sell                                               */
/*==============================================================*/
create table tb_sell
(
   id                   varchar(50) not null comment '前缀"s",后缀1000格式',
   gid                  varchar(50) comment '商品id',
   cid                  varchar(50) comment '客户id',
   uid                  varchar(50) comment '操作员id',
   unit_cost            float comment '销售单价',
   amount               int comment '数量',
   sum                  float comment '金额',
   time                 datetime comment '销售时间',
   clearing_form        varchar(50) comment '结算方式',
   headler              varchar(50),
   primary key (id)
);

alter table tb_sell comment '销售信息';

/*==============================================================*/
/* Table: tb_sell_return                                        */
/*==============================================================*/
create table tb_sell_return
(
   id                   varchar(50) not null,
   gid                  varchar(50),
   cid                  varchar(50),
   uid                  varchar(50),
   unit_cost            float,
   amount               int,
   sum                  float,
   time                 datetime,
   clearing_form        varchar(50),
   handler              varchar(50),
   primary key (id)
);

alter table tb_sell_return comment '销售退货信息';

/*==============================================================*/
/* Table: tb_stock                                              */
/*==============================================================*/
create table tb_stock
(
   id                   varchar(30) not null comment '入库编号,以"rk"字符串为前缀,加上商品的入库日期,再以3位数字作为后缀',
   pid                  varchar(50) comment '供应商',
   uid                  varchar(50) comment '对应用户name字段',
   gid                  varchar(50),
   variety_amount       int comment '品种数量',
   unit_cost            float comment '单价',
   amount               int comment '数量',
   sum                  float comment '合计金额',
   "check"              varchar(50) comment '验收结论',
   time                 datetime comment '入货时间',
   clearing_form        varchar(50) comment '结算方式',
   handler              varchar(50) comment '经手人',
   primary key (id)
);

alter table tb_stock comment '入库信息主要内容';

/*==============================================================*/
/* Table: tb_stock_return                                       */
/*==============================================================*/
create table tb_stock_return
(
   id                   varchar(30) not null comment '入库编号,以"rk"字符串为前缀,加上商品的入库日期,再以3位数字作为后缀',
   pid                  varchar(50) comment '供应商',
   gid                  varchar(50),
   uid                  varchar(50) comment '对应用户name字段',
   variety_amount       int comment '品种数量',
   unit_cost            float comment '单价',
   amount               int comment '数量',
   sum                  float comment '合计金额',
   "check"              varchar(50) comment '验收结论',
   time                 datetime comment '退货时间',
   clearing_form        varchar(50) comment '结算方式',
   handler              varchar(50) comment '经手人',
   primary key (id)
);

alter table tb_stock_return comment '进货退货信息';

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   name                 varchar(50) not null comment '帐号',
   username             varchar(50) not null comment '用户名',
   password             varchar(50) not null comment '密码',
   primary key (name)
);

alter table tb_user comment '操作员信息';

/*==============================================================*/
/* Table: tb_user_log                                           */
/*==============================================================*/
create table tb_user_log
(
   id                   int not null auto_increment comment '编号',
   name                 varchar(50) comment '对应用户表的name',
   time                 datetime comment '登录时间',
   primary key (id)
);

alter table tb_user_log comment '登录日志信息';

/*==============================================================*/
/* Table: tb_user_permission                                    */
/*==============================================================*/
create table tb_user_permission
(
   id                   int not null comment '编号',
   rid                  int comment '对应角色表的id',
   KeHuGuanLi           int comment '客户信息管理 ',
   ShangPinGuanLi       int comment '商品信息管理 ',
   GongYingShangGuanLi  int comment '供应商信息管理 ',
   JinHuoDan            int comment '进货单 ',
   JinHuoTuiHuo         int comment '进货退货 ',
   XiaoShouDan          int comment ' 销售单 ',
   XiaoShouTuiHuo       int comment ' 销售退货 ',
   KeHuChaXun           int comment ' 客户查询 ',
   ShangPinChaXun       int comment ' 商品查询 ',
   GongYingShangChaXun  int comment ' 供应商查询 ',
   XiaoShouChaXun       int comment '销售查询 ',
   XiaoShouTuiHuoChaXun int comment '销售退货查询',
   RuKuChaXun           int comment '入货查询',
   RuKuTuiHuoChaXun     int comment '入库退货查询',
   XiaoShouPaiHang      int comment '销售排行',
   KuCunPanDian         int comment '库存盘点',
   JiaGeTiaoZheng       int comment '价格调整',
   CaoZuoYuanGuanLi     int comment '操作员管理',
   GengGaiMiMa          int comment '更改密码',
   QuanXianGuanLi       int comment '权限管理',
   primary key (id)
);

alter table tb_user_permission comment '权限';

/*==============================================================*/
/* Table: tb_user_role                                          */
/*==============================================================*/
create table tb_user_role
(
   id                   int not null auto_increment comment '编号',
   name                 varchar(50) comment '对应用户表的name',
   type                 int comment '角色类型',
   primary key (id)
);

alter table tb_user_role comment '角色';

alter table tb_good_info add constraint FK_Reference_5 foreign key (pid)
      references tb_provider_info (id) on delete restrict on update restrict;

alter table tb_sell add constraint FK_Reference_6 foreign key (gid)
      references tb_good_info (id) on delete restrict on update restrict;

alter table tb_sell add constraint FK_Reference_7 foreign key (cid)
      references tb_customer_info (id) on delete restrict on update restrict;

alter table tb_sell add constraint FK_Reference_8 foreign key (uid)
      references tb_user (name) on delete restrict on update restrict;

alter table tb_sell_return add constraint FK_Reference_10 foreign key (gid)
      references tb_good_info (id) on delete restrict on update restrict;

alter table tb_sell_return add constraint FK_Reference_11 foreign key (cid)
      references tb_customer_info (id) on delete restrict on update restrict;

alter table tb_sell_return add constraint FK_Reference_12 foreign key (uid)
      references tb_user (name) on delete restrict on update restrict;

alter table tb_stock add constraint FK_Reference_13 foreign key (uid)
      references tb_user (name) on delete restrict on update restrict;

alter table tb_stock add constraint FK_Reference_16 foreign key (gid)
      references tb_good_info (id) on delete restrict on update restrict;

alter table tb_stock add constraint FK_Reference_9 foreign key (pid)
      references tb_provider_info (id) on delete restrict on update restrict;

alter table tb_stock_return add constraint FK_Reference_14 foreign key (pid)
      references tb_provider_info (id) on delete restrict on update restrict;

alter table tb_stock_return add constraint FK_Reference_15 foreign key (uid)
      references tb_user (name) on delete restrict on update restrict;

alter table tb_stock_return add constraint FK_Reference_17 foreign key (gid)
      references tb_good_info (id) on delete restrict on update restrict;

alter table tb_user_log add constraint FK_Reference_1 foreign key (name)
      references tb_user (name) on delete restrict on update restrict;

alter table tb_user_permission add constraint FK_Reference_3 foreign key (rid)
      references tb_user_role (id) on delete restrict on update restrict;

alter table tb_user_role add constraint FK_Reference_2 foreign key (name)
      references tb_user (name) on delete restrict on update restrict;

