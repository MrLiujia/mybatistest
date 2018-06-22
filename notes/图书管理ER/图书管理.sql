create table BOOKS(
  ID identity,
  TITLE varchar(512) not null,
  DESCRIPTION varchar(1024),
  PUBLISHER_ID bigint not null
);

create table AUTHORS(
  ID identity,
  NAME varchar(512) not null,
  GENDER varchar(8) not null,
  DESCRIPTION varchar(1024)
);

create table BOOK_AUTHORS(
  BOOK_ID bigint not null,
  AUTHOR_ID bigint not null,
  constraint BOOK_AUTHORS_PK primary key (BOOK_ID, AUTHOR_ID)
);

create table PUBLISHERS(
  ID identity,
  NAME varchar(512) not null,
  DESCRIPTION varchar(1024)
);

create table BOOK_COMMENTS(
  ID identity,
  BOOK_ID bigint not null,
  COMMENT varchar(1024) not null
);

alter table BOOKS add constraint BOOKS_FK_PUBLISHER_ID_PUBLISHERS 
  foreign key (PUBLISHER_ID) references PUBLISHERS (ID);
  
alter table BOOK_AUTHORS add constraint BOOK_AUTHORS_FK_BOOK_ID_BOOKS
  foreign key (BOOK_ID) references BOOKS (ID);
  
alter table BOOK_AUTHORS add constraint BOOK_AUTHORS_FK_AUTHOR_ID_AUTHORS
  foreign key (AUTHOR_ID) references AUTHORS (ID);  
  
alter table BOOK_COMMENTS add constraint BOOK_COMMENTS_FK_BOOK_ID_BOOKS
  foreign key (BOOK_ID) references BOOKS (ID);
  
-----------------------------------------------------

-- 红楼梦    曹雪芹、高鹗      北京联合出版社
-- 西游记    吴承恩            人民文学出版社
-- 水浒传    施耐庵，罗贯中    人民文学出版社

insert into PUBLISHERS(NAME) values 
  ('北京联合出版社'),
  ('人民文学出版社');
  
insert into AUTHORS(NAME, GENDER) values
  ('曹雪芹', 'Male'),
  ('高鹗', 'Male'),
  ('吴承恩', 'Male'),
  ('施耐庵', 'Male'),
  ('罗贯中', 'Male');
  
insert into BOOKS(TITLE, PUBLISHER_ID) values
  ('红楼梦', 1),
  ('西游记 ', 2),
  ('水浒传', 2);
  
insert into BOOK_AUTHORS(BOOK_ID, AUTHOR_ID) values
  (1, 1),
  (1, 2),
  (2, 3),
  (3, 4),
  (3, 5);
  
insert into BOOK_COMMENTS(BOOK_ID, COMMENT) values (1, 'COOL');
  