<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../../js/jquery.min.js"></script>
<link href="./css/loginMain.css" rel="stylesheet">
<link href="./css/pic_slider.css" rel="stylesheet">
<link href="./css/tab.css" rel="stylesheet">
<script type="text/javascript" src="./js/loginMain.js"></script>
<style type="text/css">
	body{
		background-color: #f3f5f6;
	}
</style>
</head>

<body style="background-color:#f3f5f6 ">
	<!-- <script src="../../js/bootstrap.min.js"></script> -->
	<div id="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
 		
 	<!-- contents 시작 -->
	<div id="contents">
	    <input type="hidden" name="requestPage" id="requestPage">
	    <input type="hidden" name="totalCount" id="totalCount" value="">
	    <!-- main 시작 -->
		<div id="main" class="clearfix" role="main">
			<div id="sidebar" style="position: absolute; top: 0px; bottom: auto; left: auto;">
				<!-- 친구목록시작 -->
				<div id="sihp-friendfinder" class="sihp-sidebar-module">
					<h2>
						<a href="/import/people">친구목록</a>
					</h2>
					<ul class="peopleYouMayKnow clearfix">
						
					</ul>
				</div>
				<!-- 친구목록끝 -->	
			</div>
			<div id="activityFeed"><!--뉴스피드 시작  -->
				<input type="hidden" name="mem_no" id="mem_no" value="${authInfo.mem_no }">
				 
					 
			</div>
		</div>
		<!-- main 끝 -->
	</div>
	<!-- contents 끝 -->
</body>
</html>