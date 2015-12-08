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
		<jsp:include page="../myRoom/my_Menu.jsp">
			<jsp:param value="${member}" name="member"/>
		</jsp:include>
	</div>

	<div id="myMenu_navi">
		<jsp:include page="../myRoom/menu_nav.jsp">
			<jsp:param value="${member}" name="member"/>
			<jsp:param value="${level }" name="level"/>
		</jsp:include>
	</div>



	<div class="album_contents">

		<br> <br>
		<div id="page">
			<div id="wrapper">

				<img id="movingboxes"src="album/img/movingboxes.png" alt="moving boxes" />
				<form id="add" action="album_add">
					<input id="hiddenval" type="text" value="${authInfo.mem_no }" name="mem_no">
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
									<div class="inside" id="${mem_no }">
										<img src="../../upload/${albumpiclist}"
											alt="picture_${albumpiclist}" />
										<c:forEach var="albumlist" items="${albumlist }"
											varStatus="alb">
											<c:choose>
												<c:when test="${apl.index == alb.index }">
													<h2>제목 : ${albumlist.alb_name }    </h2>
													<c:if test="${albumlist.alb_open==1 }">
													<c:set var="i" value="전체 공개"></c:set>
													</c:if>
													<c:if test="${albumlist.alb_open==2 }">
													<c:set var="i" value="친구만 보기"></c:set>
													</c:if>
													<c:if test="${albumlist.alb_open==3 }">
													<c:set var="i" value="비공개"></c:set>
													
													</c:if>
													
													<p class="level" id="${albumlist.alb_open }">키워드 : ${albumlist.alb_word }&nbsp;&nbsp;권한 : ${i}</p>
													<p>
														 <a
															href="my_album_detail?alb_no=${albumlist.alb_no }&fri_no=${albumlist.mem_no}">
															앨범보기 </a>
															<c:if test="${level == '1'}">
																<a href="my_album_delete?alb_no=${albumlist.alb_no }">앨범삭제</a>
															</c:if>
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