<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="../../jsp/myRoom/css/my_Menu.css" rel="stylesheet">
<link href="../../jsp/myRoom/css/my_Popular_Good.css" rel="stylesheet">
<title>내친구 목록</title>
<style type="text/css">
	.center_head div{
		float: left;
	}
	.friendlist{
		clear : both;
	}
	.image{
		float:left;
	}
	
</style>
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
			<li class="menu active"><a href="follow.jsp">친구 목록</a></li>
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
		
		
		<div class="center contents">
			<h2>회원님이 팔로우하는 사람들</h2>
			<div class="center_head">
				<div><input class="btn btn-default" type="button" value="친구목록" ></div>
				<div><input class="btn btn-default" type="button" value="회원찾기"></div>
			</div>
			<br><br><br><br><br>
			<div class="center_table" >
			<table  class="friendlist table">
				<tr>
					<th><a href="#">친구명</a></th>
					<th><a href="#">공개사진</a></th>
					<th><a href="#">위치</a></th>
					<th>추가한날</th>
					<th>등록유형</th>
				</tr>
				<tr>
					<td><a href="#">재준황</a></td>
					<td><a href="#">0</a></td>
					<td>서울</td>
					<td>3주전</td>
					<td>팔로잉</td>
				</tr>
			</table>
			</div>
			<br><br>
		</div>
		
		 <div id="yui_3_16_0_1_1444789083815_155" class="view footer-full-view requiredToShowOnServer">
     		<jsp:include page="../layout/footer.jsp"></jsp:include>
    	 </div>
		
		
</body>
</html>