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
  
-- 查询指定作者所有的图书
select * from BOOK_AUTHORS ba 
  inner join AUTHORS a on ba.AUTHOR_ID =  a.ID 
  left join BOOKS b on ba.BOOK_ID = b.ID 
  where ba.AUTHOR_ID = 1;

-- 查询某本图书的信息（出版社、有哪些作者）
select * from BOOKS b 
  inner join PUBLISHERS p on b.PUBLISHER_ID = p.ID 
  left join BOOK_AUTHORS ba on ba.BOOK_ID = b.ID 
  inner join AUTHORS a on ba.AUTHOR_ID = a.ID 
  where b.ID = 1  
  