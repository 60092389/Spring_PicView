
<%@page import="picView.follow.model.FollowDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="picView.follow.model.Follow"%>
<%@page import="java.util.List"%>
<%@page import="picView.member.model.AuthInfo"%>
<%@page import="picView.member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
	int mem_no = authInfo.getMem_no();
	int fri_no = member.getMem_no();
	
	String fol_check = (String)request.getAttribute("fol_check");
	
	if(mem_no == member.getMem_no()){
		fol_check = "4";//나자신일때
	}
	
%>
</head>
<body>
	<div id="myMenu">
		<div id="profileBack">
			<div class="coverPhoto">
				<div class="coverPhoto-content fluid-centered">
					<div class="cover-photo-edit" title="표지 사진 편집">
						<a href="#"><span class="glyphicon glyphicon-pencil"> </span></a>
					</div>
					<div class="avatar no-menu person large"
						style="background-image: url(../../upload/<%= member.getMem_pic() %>);">
						<div class="edit">
							<span><a href="#">
								<span class="glyphicon glyphicon-pencil edit-icon" aria-hidden="true"/></a></span>
						</div>
					</div>
					<div class="title-block-content">
						<div class="title">
							<h1 class="truncate"><%= member.getMem_name() %></h1>
							<div class="menu-follow-btn">
								<%if(fol_check == "0"){ %>
									<div class='view follow-view default_follow'>
										<form action='addNewFollow' method='post'>
						 					<textarea rows='5' cols='5' name='mem_nos' style='display:none;'><%=mem_no %>,<%=fri_no %></textarea>
						 					<input class='btn btn-lg btn-primary in_black' type='submit' value='+팔로우' />
						 				</form>
						 			</div>
								<%} %>
								
								<%if(fol_check == "1"){ %>
									<div class='view follow-view only_follow only_follow2'>
										<form action='cancelFollow' method='post'>
						 					<textarea rows='5' cols='5' name='mem_nos' style='display:none;'><%=mem_no %>,<%=fri_no %></textarea>
						 					<input class='btn btn-lg btn-danger in_black' type='submit' value='팔로우 취소' />
						 				</form>
						 			</div>
								<%} %>
								<%if(fol_check == "2"){ %>
									<div class='view follow-view only_follower only_follower2'>
										<form action='addFollow' method='post'>
						 					<textarea rows='5' cols='5' name='mem_nos' style='display:none;'><%=mem_no %>,<%=fri_no %></textarea>
						 					<input class='btn btn-lg btn-success in_black' type='submit' value='+맞팔로우' />
						 				</form>
						 			</div>
								<%} %>
								<%if(fol_check == "3"){ %>
									<div class='view follow-view each_follow each_follow2'>
										<form action='cancelEachFollow' method='post'>
						 					<textarea rows='5' cols='5' name='mem_nos' style='display:none;'><%=mem_no %>,<%=fri_no %></textarea>
						 					<input class='btn btn-lg btn-warning in_black' type='submit' value='맞팔 취소' />
						 				</form>
						 			</div>
								<%} %>
								<%if(fol_check == "4"){ %>
									
								<%} %>
								
							</div>
						</div>
						<p class="subtitle trucnate"><%= member.getMem_id() %></p>
					</div>
					<div class="metadata-content">
						<p class="photo-count">
							사진
							<%= member.getPic_count() %>개
						</p>
						<p class="truncate"><%= member.getMem_sex()%></p>
						<p>
							<fmt:formatDate value="<%= member.getMem_date() %>"
								pattern="yyyy-MM-dd" />
							가입
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	
	
</body>
</html>