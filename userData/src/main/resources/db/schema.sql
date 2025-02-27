
drop table if exists demo;

CREATE TABLE IF NOT EXISTS demo  (
  id BIGINT(20) NOT NULL auto_increment ,
  name varchar(30) default NULL,
  birthday date default NULL ,
  email varchar(50) default NULL ,
  content varchar(1000) default NULL ,
  PRIMARY KEY  (id)
);
