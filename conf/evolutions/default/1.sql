# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table abuser (
  relationship_to_victim    varchar(255),
  social                    varchar(255),
  dob                       varchar(255))
;

create table guardian (
  relationship_to_victim    varchar(255))
;

create table person_info (
  first_name                varchar(255),
  last_name                 varchar(255),
  address                   varchar(255),
  phone_number              varchar(255))
;

create table report (
  id                        bigint not null,
  type_of_abuse             varchar(255),
  description               varchar(255),
  constraint pk_report primary key (id))
;

create table reporter (
  mandated_bool             varchar(255),
  relationship_to_victim    varchar(255))
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
  sex                       varchar(255),
  dob                       varchar(255),
  age                       varchar(255),
  marital_status            varchar(255),
  disability                varchar(255),
  communication_needs       varchar(255),
  currently_served_by       varchar(255),
  type_of_service           varchar(255),
  ethnicity                 varchar(255),
  awareness_of_report       varchar(255))
;

create sequence report_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists abuser;

drop table if exists guardian;

drop table if exists person_info;

drop table if exists report;

drop table if exists reporter;

drop table if exists user;

drop table if exists victim;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists report_seq;

drop sequence if exists user_seq;

