<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>그 외 - 인기별(좋아하는 사진)</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>

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

	<div class="contents">
		<div id="pop_nav">
			<ul class="nav nav-tabs">
				<li><a href="my_Popular_Hit.jsp">조회수</a></li>
				<li class="active"><a href="my_Popular_Good.jsp">좋아하는 사진</a></li>
				<li><a href="my_Popular_Reply.jsp">댓글수</a></li>
			</ul>
		</div>

		<div id="good_table">
			<table class="table table-hover responsive">
				<tr>
					<th id="num">번호</th>
					<th id="pic">사진</th>
					<th id="name">이름</th>
					<th id="hit">조회수</th>
					<th id="good">좋아하는<br>사람</th>
					<th id="reply">댓글수</th>
				</tr>
				<tr>
					<td>1</td>
					<td><img src="../../images/main/main_1.JPG"></td>
					<td>므찌다</td>
					<td>30</td>
					<td>30</td>
					<td>30</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="footer">
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>

</body>
</html>