<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>그 외(태그별)</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>

<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="../../jsp/myRoom/css/my_Menu.css" rel="stylesheet">
<link href="../../jsp/myRoom/css/my_Tag.css" rel="stylesheet">
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
			<li class="menu"><a href="my_Show.html">보여 주기</a></li>
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
	
	<!-- 태그 테이블 -->
	<div id="contents">
		<div id="tag">
			<h3>태그</h3>
		</div>
		
		<div id="tag_table">
			<table class="table table-hover responsive">
				<tr>
					<th id="tag_name">태그</th>
					<th id="tag_num">태그수</th>
					<th id="up_del"></th>
				</tr>
				<tr>
					<td>연식짱</td>
					<td>3개</td>
					<td><a href="#">수정</a>&nbsp;&nbsp;&nbsp;<a href="#">삭제</a></td>
				</tr>
				<tr>
					<td>자칭홍미녀</td>
					<td>1개</td>
					<td><a href="#">수정</a>&nbsp;&nbsp;&nbsp;<a href="#">삭제</a></td>
				</tr>
				<tr>
					<td>김pd보다훨잘생긴</td>
					<td>2개</td>
					<td><a href="#">수정</a>&nbsp;&nbsp;&nbsp;<a href="#">삭제</a></td>
				</tr>
				<tr>
					<td>뿌염영혜</td>
					<td>2개</td>
					<td><a href="#">수정</a>&nbsp;&nbsp;&nbsp;<a href="#">삭제</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 태그가 없을 때
	<div id="no_tag">
		<h4>아직 사진 또는 비디오에 태그를 달지 않았습니다. 사진을 올릴 때 태그를 달아보세요.</h4>
	</div>
	 -->

	<div class="footer">
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>


</body>
</html>