create database Edimon;
use Edimon;
drop table if exists loginRecord;
create table loginRecord (id int not null,username varchar(64),password varchar(64),primary key(id));
drop table if exists privateRecord;
create table privateRecord (id int not null, image varchar(64),
email varchar(64) ,levelDefinition varchar(64),studentYear varchar(64),religion varchar(64),
studentCourse varchar(64),likeChurch varchar(64),reasonforAttend varchar(128),primary key(id)) ;
 drop table if exists relationshipRecord;
create table relationshipRecord(id int not null, been varchar(64),
importance varchar(64),yes varchar(64),currentStatus varchar(64)
,futureStatus varchar(64),
relationshipView varchar(64),primary key(id));