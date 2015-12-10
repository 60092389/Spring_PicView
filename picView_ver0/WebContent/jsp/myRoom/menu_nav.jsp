<%@page import="picView.member.model.Member"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%
	Member member = (Member)request.getAttribute("member");
	String level = (String)request.getAttribute("level");

%>

</head>
<body>
	<%if(level.equals("1")){ %>
		<ul class="nav nav-pills">
			<li class="menu"><a href="manageForm">사진 관리</a></li>
			<li class="menu"><a href="myShowForm${member.mem_no }">보여 주기</a></li>
			<li class="menu"><a href="my_album${member.mem_no }">사진첩</a></li>
			<li class="menu"><a href="my_Follow${member.mem_no }">친구 목록</a></li>
			<li class="menu"><a href="my_Analysis">유입분석</a></li>
			<li class="menu"><a href="#">프로필</a>
		</ul>
	<%} %>
	
	<%if(!level.equals("1")){ %>
		<ul class="nav nav-pills">
			<li class="menu"><a href="myShowForm${member.mem_no }">보여 주기</a></li>
			<li class="menu"><a href="my_album${member.mem_no }">사진첩</a></li>
			<li class="menu"><a href="my_Follow${member.mem_no }">친구 목록</a></li>
		</ul>
	<%} %>

</body>
</html>