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

alter table BOOKS add constraint BOOKS_FK_PUBLISHER_ID_PUBLISHERS 
  foreign key (PUBLISHER_ID) references PUBLISHERS (ID);
  
alter table BOOK_AUTHORS add constraint BOOK_AUTHORS_FK_BOOK_ID_BOOKS
  foreign key (BOOK_ID) references BOOKS (ID);
  
alter table BOOK_AUTHORS add constraint BOOK_AUTHORS_FK_AUTHOR_ID_AUTHORS
  foreign key (AUTHOR_ID) references AUTHORS (ID);  
  