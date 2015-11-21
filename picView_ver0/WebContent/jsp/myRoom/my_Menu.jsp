<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="css/my_Menu.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>

<%
	Date date;
	String mem_name = "";
	String mem_id = "";
	String pic_count = "0";
	Timestamp mem_date = new Timestamp(2015);
	if(session.getAttribute("mem_name")!=null){
		mem_name = (String)session.getAttribute("mem_name");
		mem_id = (String)session.getAttribute("mem_id");
		pic_count = (String)session.getAttribute("pic_count");
		mem_date = (Timestamp)session.getAttribute("mem_date");
	}
%>
</head>
<body>
	<div id="myMenu">
		<div id="profileBack">
			<div class="coverPhoto">
				<div class="coverPhoto-content fluid-centered">
					<div class="cover-photo-edit" title="표지 사진 편집">
						<a href="#"><span class="glyphicon glyphicon-pencil"></span></a>
					</div>
					<div class="avatar no-menu person large"
						style="background-image: url(//c1.staticflickr.com/1/724/buddyicons/136454064@N06_r.jpg?1443072667#136454064@N06);">
						<div class="edit">
							<a href="#"><span
								class="glyphicon glyphicon-pencil edit-icon"></span></a>
						</div>
					</div>
					<div class="title-block-content">
						<div class="title">
							<h1 class="truncate"><%=mem_name %></h1>
						</div>
						<p class="subtitle trucnate"><%=mem_id %></p>
						<p class="followers truncate">
							<a href="#">팔로어 7명</a> <em>·</em> <a href="#">7명 팔로우</a>
						</p>
					</div>
					<div class="metadata-content">
						<p class="photo-count">사진 <%=pic_count %>개</p>
						<p class="truncate">서울, 한국</p>
						<p><fmt:formatDate value="<%=mem_date %>" pattern="yyyy-MM-dd"/> 가입</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>