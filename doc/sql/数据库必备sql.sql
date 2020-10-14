## 数据库建用户
    drop user basetest cascade;
    create user basetest identified by basetest default tablespace TBS_LLM_DATA temporary tablespace TBS_LLM_TEMP;
    grant connect,resource to basetest;
    grant dba to basetest;
    alter user  basetest default role DBA;
## 数据库建表
-- Create table
create table BASE_TEST
(
  id          VARCHAR2(64) not null,
  create_by   VARCHAR2(64),
  create_date TIMESTAMP(6),
  update_by   VARCHAR2(64),
  update_date TIMESTAMP(6),
  del_flag    CHAR(1) default 0 not null,
  remarks     VARCHAR2(2000),
  name        VARCHAR2(64),
  age         VARCHAR2(64)
)
tablespace TBS_LLM_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table BASE_TEST
  is '基础框架测试表';
-- Add comments to the columns
comment on column BASE_TEST.id
  is '主键';
comment on column BASE_TEST.create_by
  is '创建人';
comment on column BASE_TEST.create_date
  is '创建时间';
comment on column BASE_TEST.update_by
  is '更新人';
comment on column BASE_TEST.update_date
  is '更新时间';
comment on column BASE_TEST.del_flag
  is '删除标记';
comment on column BASE_TEST.remarks
  is '备注';
comment on column BASE_TEST.name
  is '名字';
comment on column BASE_TEST.age
  is '年龄';
-- Create/Recreate primary, unique and foreign key constraints
alter table BASE_TEST
  add primary key (ID)
  using index
  tablespace TBS_LLM_DATA
  pctfree 10
  initrans 2
  maxtrans 255;