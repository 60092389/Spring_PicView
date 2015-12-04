<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="./js/my_Follow.js"></script>
<link href="../../jsp/myRoom/css/my_Menu.css" rel="stylesheet">
<link href="css/my_Follow.css" rel="stylesheet">
<title>팔로어</title>

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
		<div class=" follow_contents">
			<div class="center_head">
				<h2>팔로어 페이지</h2>
				<div>
					<input class="btn btn-default follow-btn fol-btn" type="button" value="팔로우">
				</div>
				<div>
					<input class="btn btn-default follower-btn fol-btn" type="button" value="팔로워">
				</div>
				<div>
					<input class="btn btn-default followRec-btn fol-btn" type="button" value="추천친구">
				</div>
			</div>

			<div class="browse_content">
				<ol class="browse browse_people browse_people_thumb">
					<c:forEach var="m" items="${members}">
						<c:forEach var="f" items="${follows }">
							<c:choose>
								<c:when test="${(f.follow_fri_no == m.mem_no && f.follow_check == '2' && m.mem_no != mem_no ) && f.follow_fri_no != 0}">
									<!--상대방만 나를 팔로우 상태일 때-->										
									<li class="only_follower only_follower2">
										<a title="mem_no" href="mem_no">
											<img alt="" src="../../upload/${m.mem_pic }" class="profile_pic">
											<div class="data">
												<p class="fri_name">${m.mem_name }</p>
												<p class="fri_status">(나를 팔로우하고 있음)</p>
											</div>
										</a>
										<div class="fri_button">
											<form action="addFollow" method="post">
												<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${mem_no},${m.mem_no }</textarea>
												<input class="btn btn-success btn-xs in_black" type="submit" value="+맞팔하기" /> 
											</form>
										</div>											
									</li>											
								</c:when>
								<c:when test="${(f.follow_fri_no == m.mem_no && f.follow_check == '3' && m.mem_no != mem_no) && f.follow_fri_no != 0}">
									<!--서로 팔로잉 상태일 때-->
									<li class="each_follow each_follow2">
										<a title="mem_no" href="mem_no">
											<img alt="" src="../../upload/${m.mem_pic }" class="profile_pic">
											<div class="data">
												<p class="fri_name">${m.mem_name }</p>
												<p class="fri_status">(맞팔로우)</p>
											</div>
										</a>
										<p class="fri_button">
											<form action="cancelEachFollow" method="post">
												<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${mem_no},${m.mem_no }</textarea>
												<input class="btn btn-warning btn-xs in_black" type="submit" value="팔로우취소" /> 
											</form>
										</p>								
									</li>
								</c:when>													
							</c:choose>	
						</c:forEach>
					</c:forEach>
				</ol>
			</div>
			<br>
			<br>
		</div>
	</div>


</body>
</html>