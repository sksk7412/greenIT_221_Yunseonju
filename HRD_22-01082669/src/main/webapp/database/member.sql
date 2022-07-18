CREATE TABLE member_tbl_02(
   custno number(6) not null,
   custname varchar2(20),
   phone varchar2(13),
   address varchar2(4),
   joindate date,
   grade char(1),
   city char(2)	
);

 CREATE TABLE money_tbl_02(
   custno number(6) not null,
   salenol number(8) not null,
   pcost number(8),
   amount number(4),
   price number(8),
   pcode varchar2(4),
   sdate date	
);
