<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>보여주기</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="js/my_Show.js"></script>

<link href="css/my_Show5.css" rel="stylesheet">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="../../jsp/myRoom/css/my_Menu.css" rel="stylesheet">
<link href="../../jsp/myRoom/css/my_Popular_Good.css" rel="stylesheet">
</head>

<body>

	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>

	<div class="my_Menu">
		<jsp:include page="../myRoom/my_Menu.jsp"></jsp:include>
	</div>

	<div id="myMenu_navi">
		<ul class="nav nav-pills">
			<li class="menu"><a href="my_Manage.html">사진 관리</a></li>
			<li class="menu active"><a href="my_Show.html">보여 주기</a></li>
			<li class="menu"><a href="#">사진첩</a></li>
			<li class="menu"><a href="#">관심 사진</a></li>
			<li class="menu"><a href="follow.jsp">친구 목록</a></li>
			<li id="other" class="dropdown"><a href=""
				data-toggle="dropdown"> 그 외 <span class="caret"></span>
			</a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="my_Tag.jsp">태그별</a>
					<li><a href="my_Popular_Hit.jsp">인기별</a>
					<li><a href="#">다운로드 기록</a>
					<li><a href="#">프로필</a>
				</ul></li>
		</ul>
	</div>


	<div class="contents">
		<div id="show_btn" class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				공개보기 <span class="caret"> </span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#">비공개 보기</a></li>
				<li><a href="#">친구 보기</a></li>
			</ul>
		</div>

		<!-- 공개 보기 -->
		<div class="open_pic">
		<div id="picture_area">
				<c:forEach var="s" items="${listShow}">
					<div class="picture_list" style="background-image: url('../../upload/${s.pic_add}');" id="${s.pic_add}">
						<input type="hidden" value="${s.pic_no}">
						<div class="info_bar" id="${s.pic_add}">
							<a class="pic_title" href="#">${s.pic_title}</a>
							<a class="pic_date" href="#"><fmt:formatDate value="${s.pic_date}" pattern="yyyy-MM-dd"/></a>
						</div>
					</div>
					
				</c:forEach>
			</div>

		</div>


		<!-- 비공개 보기 -->

		<div class="close_pic"></div>

		<!-- 친구 보기 -->
		<div class="friend_pic"></div>

		<!-- 공개 사진이 없을때 
	<div class="no_picture">

		<h3>공개 사진이 없습니다.</h3>
		<p>
			여러분의 포토스트림은 공개 포트폴리오입니다.<br>포토스트림을 채우려면 카메라 롤을 사용하여 사진을 공개로
			설정하세요.
		</p>
	</div>
	<div class="button">
			<input id="login" class="btn btn-primary" type="button"
				value="사진 관리로 이동">
		</div>
	-->


	</div>

	<div class="footer">
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>