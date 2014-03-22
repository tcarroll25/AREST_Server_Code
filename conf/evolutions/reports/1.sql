# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table report (
  id                        bigint not null,
  label                     varchar(255),
  constraint pk_report primary key (id))
;

create sequence report_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists report;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists report_seq;

