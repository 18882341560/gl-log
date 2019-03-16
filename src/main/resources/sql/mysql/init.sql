
drop table if exists action_log;

/*==============================================================*/
/* Table: action_log                                            */
/*==============================================================*/

create table action_log (

   id               int(20) not null auto_increment comment 'id',
   type             varchar(191) default '' comment '接口类型',
   identify         varchar(191) default '' comment '用户身份',
   description      varchar(255) default '' comment '接口描述',
   url              varchar(191) default '' comment '接口地址',
   params           text comment '请求参数JSON字符串',
   duration         int(20) default 0 comment '接口处理时长',
   ip                   VARCHAR(191) default '' comment '请求IP',
   visit_time           TIMESTAMP default CURRENT_TIMESTAMP comment '请求时间',
   create_time          TIMESTAMP default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
)ENGINE = InnoDB
 CHARSET = utf8
 COLLATE utf8_general_ci;

alter table action_log comment '操作日志表';





/*==============================================================*/
/* Table: exception_log                                         */
/*==============================================================*/

drop table if exists exception_log;

create table exception_log
(
  id                   INT(20) not null auto_increment comment 'id',
  identify             VARCHAR(191) default 'null' comment '身份（如用户名，手机号，用户id等）',
  ip                   VARCHAR(255) default '' comment '请求者IP',
  uri                  VARCHAR(191) default '' comment '接口地址',
  params                TEXT comment '请求参数JSON字符串',
  class_name           VARCHAR(255) default '' comment '异常类名',
  message              VARCHAR(255) default '' comment '异常信息',
  stack_trace          TEXT comment '异常堆栈信息',
  create_time          TIMESTAMP default CURRENT_TIMESTAMP comment '创建时间',
  primary key (id)
)ENGINE = InnoDB
 CHARSET = utf8
 COLLATE utf8_general_ci;

alter table exception_log comment '异常日志表';




/*==============================================================*/
/* Table: api_log                                               */
/*==============================================================*/

drop table if exists api_log;

create table api_log
(
  id                   INT(20) not null auto_increment comment 'ID',
  url                  VARCHAR(191) comment 'API地址',
  method               VARCHAR(191) comment '请求方式',
  params               TEXT comment '请求参数',
  create_time          TIMESTAMP default CURRENT_TIMESTAMP comment '创建时间',
  response             TEXT comment '响应内容',
  description          VARCHAR(191) comment 'API描述',
  primary key (id)
);

alter table api_log comment '远程访问日志表';