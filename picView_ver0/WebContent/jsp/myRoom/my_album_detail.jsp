<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="../../css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="album/css/jquery.jMosaic.css" />
<link rel="stylesheet" href="album/css/chromagallery.css">
<link rel="stylesheet" href="album/css/my_album_detail.css">


</head>
<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<script src="album/js/jquery.min.js"></script>
	<script src="album/js/jquery.jMosaic.js"></script>
	<script src="album/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		//For blocks or images of size, you can use $(document).ready
		$(document).ready(function() {
			$('.pictures').jMosaic({
				//items_type : "div",
				min_row_height : 150,
				margin : 3,
				is_first_big : false
			});

		});

		//If this image without attribute WIDTH or HEIGH, you can use $(window).load
		$(window).load(function() {
			//$('.pictures').jMosaic({min_row_height: 150, margin: 3, is_first_big: true});
		});

		//You can update on $(window).resize
		$(window).resize(function() {
			//$('.pictures').jMosaic({min_row_height: 150, margin: 3, is_first_big: true});

		});
	</script>

	<br>
	<br>
	<div class="back">
		&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
			class="btn btn-default btn-sm" value="앨범 목록으로 돌아가기"
			onclick="location.href='my_album'"> &nbsp;&nbsp;&nbsp;&nbsp;
		<form action="my_album_update" id="my_album_update">
			<input type="text" name="mem_no" value="${mem_no }" id="hiddeninfor">
			<input type="text" name="alb_no" value="${alb_no }" id="hiddeninfor">
			<input type="submit" class="btn btn-default btn-sm" value="앨범 수정하기">
		</form>
	</div>
	<br>
	<hr>
	<div class="contents">

		<div class="alb_name"
			style="background-image: url('../../upload/${detailAlbumPic[0] }')">
			<br> <br>
			<h2>제목 : ${detailAlbum.alb_name }</h2>
			<br>
			<h3>키워드 : ${detailAlbum.alb_word }</h3>
		</div>
		<br>
		<div class="alb_content">
			<h4>${detailAlbum.alb_content }</h4>
		</div>
		
		<br> <br>
		<div class="alb_detail">
		
			<div class="content">
				<div class="chroma-gallery mygallery">
					<c:forEach items="${detailAlbumPic }" var="detailAlbumPic">
					<img src="../../upload/${detailAlbumPic }" alt="${detailAlbum.alb_name }" data-largesrc="/picView_test/upload/${detailAlbumPic }">
					</c:forEach>				
				</div>
			</div>

		</div>
	</div>


	<script src="album/js/modernizr-chrg.min.js"></script>
	<script src="album/js/masonry.min.js"></script>
	<script src="album/js/chromagallery.js"></script>
	<script type="text/javascript">
		$(document).ready(function() 
		{
		    $(".mygallery").chromaGallery();
		});
	</script>




</body>
</html>