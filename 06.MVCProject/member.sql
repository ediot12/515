create table member(
	id		varchar2(15)	primary key,
	password 	varchar2(10),
	name	 varchar2(20),
	age	 	number,
	gender	char(1),
	addr	varchar2(100),
	regdate		date		default sysdate
	)
	
	

	insert into member(id,password,name,age,gender,addr) values('test',123,'�׽�Ʈ',20,1,'������')
	
	select * from member