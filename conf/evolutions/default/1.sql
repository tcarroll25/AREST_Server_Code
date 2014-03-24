# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table abuser (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  address                   varchar(255),
  phone_number              varchar(255),
  relationship_to_victim    varchar(255),
  social                    varchar(255),
  dob                       varchar(255),
  constraint pk_abuser primary key (id))
;

create table guardian (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  address                   varchar(255),
  phone_number              varchar(255),
  relationship_to_victim    varchar(255),
  constraint pk_guardian primary key (id))
;

create table report (
  id                        bigint not null,
  reporter_id               bigint,
  victim_id                 bigint,
  abuser_id                 bigint,
  guardian_id               bigint,
  type_of_abuse             varchar(255),
  description               varchar(255),
  constraint pk_report primary key (id))
;

create table reporter (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  address                   varchar(255),
  phone_number              varchar(255),
  mandated_bool             varchar(255),
  relationship_to_victim    varchar(255),
  constraint pk_reporter primary key (id))
;

create table user (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  password                  bigint,
  salt                      integer,
  constraint pk_user primary key (id))
;

create table victim (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  address                   varchar(255),
  phone_number              varchar(255),
  sex                       varchar(255),
  dob                       varchar(255),
  age                       varchar(255),
  marital_status            varchar(255),
  disability                varchar(255),
  communication_needs       varchar(255),
  currently_served_by       varchar(255),
  type_of_service           varchar(255),
  ethnicity                 varchar(255),
  awareness_of_report       varchar(255),
  constraint pk_victim primary key (id))
;

create sequence abuser_seq;

create sequence guardian_seq;

create sequence report_seq;

create sequence reporter_seq;

create sequence user_seq;

create sequence victim_seq;

alter table report add constraint fk_report_reporter_1 foreign key (reporter_id) references reporter (id) on delete restrict on update restrict;
create index ix_report_reporter_1 on report (reporter_id);
alter table report add constraint fk_report_victim_2 foreign key (victim_id) references victim (id) on delete restrict on update restrict;
create index ix_report_victim_2 on report (victim_id);
alter table report add constraint fk_report_abuser_3 foreign key (abuser_id) references abuser (id) on delete restrict on update restrict;
create index ix_report_abuser_3 on report (abuser_id);
alter table report add constraint fk_report_guardian_4 foreign key (guardian_id) references guardian (id) on delete restrict on update restrict;
create index ix_report_guardian_4 on report (guardian_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists abuser;

drop table if exists guardian;

drop table if exists report;

drop table if exists reporter;

drop table if exists user;

drop table if exists victim;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists abuser_seq;

drop sequence if exists guardian_seq;

drop sequence if exists report_seq;

drop sequence if exists reporter_seq;

drop sequence if exists user_seq;

drop sequence if exists victim_seq;

