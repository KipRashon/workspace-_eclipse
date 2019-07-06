
use ToDo;
drop table if exists users;
create table users (userid int not null auto_increment,firstname varchar(50) not null,lastname varchar(50) not null,username varchar(50) not null
,password varchar(50) not null,location varchar(50) not null,primary key(userid));
describe users;


