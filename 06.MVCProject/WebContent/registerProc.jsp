<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="exam.dao.*" %>    
<%@ page import="exam.dto.*" %>
    
<%

	String id = request.getParameter("id");
	String pass = request.getParameter("pwd");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String addr = request.getParameter("addr");
	
	
	//1.JDBC 드라이버로드
	//2.데이터베이스 연결
	MemberDAO dao = new MemberDAO();
	//jsp에서 객체를 생성함으로써 DAO class를 웹에서 접근할수 있게 만듬
	//객체 만들면 자동으로 생성자 호출

	Member member = new Member();
	
	member.setId(id);
	member.setAge(Integer.parseInt(age));
	member.setPass(pass);
	member.setName(name);
	member.setGender(gender);
	member.setAddr(addr);
	
	//3.SQL문 실행
	dao.insertMember(member);
	

	
%>   
 

<!DOCTYPE html>
    
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    
    </body>
    </html>