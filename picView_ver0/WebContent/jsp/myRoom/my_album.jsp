<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/bootstrap.min.css" type="text/css" />
<link href="album/css/my_Manage.css" rel="stylesheet">
<link rel="stylesheet" href="album/css/style.css" type="text/css" media="screen" charset="utf-8">
<link rel="stylesheet" href="album/css/my_album.css" type="text/css">
<script src="album/js/jquery.min.js"></script>
<script src="album/js/jquery-1.3.1.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="album/js/slider.js" type="text/javascript" charset="utf-8"></script>
<script src="album/js/my_Manage3.js"></script>


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



	<div class="contentsd">

		<br> <br>
		<div id="page">
			<div id="wrapper">

				<img id="movingboxes"src="album/img/movingboxes.png" alt="moving boxes" />
				<form id="add" action="album_add">
					<input id="hiddenval" type="text" value="1" name="mem_no">
					<input id="hiddenval" type="text" value="" name="getalb_word">
					<input id="addbutton" class="btn btn-default btn-lg" type="submit"
						value="앨범 추가하기">
				</form>
				<div id="slider">

					<img class="scrollButtons left" src="album/img/leftarrow.png">

					<div style="overflow: hidden;" class="scroll">
						<div class="scrollContainer">
							<c:forEach var="albumpiclist" items="${albumpiclist }"
								varStatus="apl">
								<div class="panel" id="panel_${mem_no }">
									<div class="inside">
										<img src="../../upload/${albumpiclist}"
											alt="picture_${albumpiclist}" />
										<c:forEach var="albumlist" items="${albumlist }"
											varStatus="alb">
											<c:choose>
												<c:when test="${apl.index == alb.index }">
													<h2>제목 : ${albumlist.alb_name }</h2>
													<p>
														키워드 : ${albumlist.alb_word } <a
															href="my_album_detail?alb_no=${albumlist.alb_no }&mem_no=${albumlist.mem_no}">
															앨범보기 </a>
													</p>
												</c:when>
											</c:choose>
										</c:forEach>
									</div>
								</div>
							</c:forEach>
						</div>

						<div id="left-shadow"></div>
						<div id="right-shadow"></div>

					</div>

					<img class="scrollButtons right" src="album/img/rightarrow.png">

				</div>

			</div>

		</div>

	</div>




</body>
</html>