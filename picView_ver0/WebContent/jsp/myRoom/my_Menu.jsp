<%@page import="picView.member.model.Member"%>
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
<link href="css/my_Menu.css" rel="stylesheet">


<%
	Member member = (Member)request.getAttribute("member");
%>
</head>
<body>
	<div id="myMenu">
		<div id="profileBack">
			<div class="coverPhoto">
				<div class="coverPhoto-content fluid-centered">
					<div class="cover-photo-edit" title="표지 사진 편집">
						<a href="#"><span class="glyphicon glyphicon-pencil">
						
						</span></a>
					</div>
					<div class="avatar no-menu person large"
						style="background-image: url(../../upload/<%= member.getMem_pic() %>);">
						<div class="edit">
							<a href="#"><span
								class="glyphicon glyphicon-pencil edit-icon"></span></a>
						</div>
					</div>
					<div class="title-block-content">
						<div class="title">
							<h1 class="truncate"><%= member.getMem_name() %></h1>
						</div>
						<p class="subtitle trucnate"><%= member.getMem_id() %></p>
					</div>
					<div class="metadata-content">
						<p class="photo-count">사진 <%= member.getPic_count() %>개</p>
						<p class="truncate"><%= member.getMem_sex()%></p>
						<p><fmt:formatDate value="<%= member.getMem_date() %>" pattern="yyyy-MM-dd"/> 가입</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>