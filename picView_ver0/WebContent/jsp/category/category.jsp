<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/recent_Pic.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../category/css/main_menu2.css" />
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../myRoom/album/css/chromagallery.css">
<link href="./css/category.css" rel="stylesheet">

<title>Insert title here</title>


<script type="text/javascript">
	/* $(function() {
	 $(document).on('mouseover', '.photo-list-photo-view', function() {
	 $(this).find('.interaction-bar').css('display', 'inline-blcok');
	 }).on('mouseout', function() {
	 $('.interaction-bar').css('display', 'none');
	 });
	
	 }); */
</script>
</head>
<body>

	<div id="content">

		<div class="header">
			<jsp:include page="../layout/header.jsp"></jsp:include>
		</div>
		<script src="../../js/jquery.min.js"></script>
		<script src="../../js/bootstrap.min.js"></script>
		<script src="../category/js/notipopup.js"></script>
		<script src="../category/js/siteSecurity.js"></script>
		<script src="../category/js/jquery.scrollUp.min.js"></script>
		<script src="js/recent_Pic.js"></script>
		<script src="js/category.js"></script>
		<script src="../myRoom/album/js/bootstrap.min.js"></script>
	

		<div class="contents">
			<div class="fluid-centered">
				<div class="title-row">
					<h3>카테고리별사진</h3>
				</div>
				<div class="view photo-list-view">
					<div class="chroma-gallery mygallery">
						<c:forEach items="${piclist }" var="piclist">
							
							<img src="../../upload/${piclist.pic_add }"
								alt="${piclist.pic_title }"
								data-largesrc="../../upload/${piclist.pic_add }" name="${piclist.pic_no }">
						</c:forEach>
					</div>
				</div>




				<%-- <div class="view photo-list-view">
					<!--사진보기  -->
					 <c:forEach items="${piclist }" var="piclist">
						<div class="photo-list-photo-view"
							style="width: 514px; height: 315px; background-image: url('../../upload/${piclist.pic_add }'); transform: translate(0px, 4px);">
							<div class="photo-list-photo-interaction">
								<div class="interaction-bar"
									title="A ride with Charon 출처: Pietro Faccioli">
									<!--댓글,제목창  -->

									<div class="text">
										<a class="title" href="#" data-rapid_p="64"></a> 
										<a class="attribution" href="#" data-rapid_p="65"></a>
									</div>
									<div class="tool">
										<a class="fave-area" href="#" data-rapid_p="66"> <i
											class="fave-star"></i> <span class="icon-count">${piclist.good_count }+</span>
										</a>
									</div>
									<div class="tool">
										<a class="comment-area" href="#" data-rapid_p="67"> <i
											class="comments"></i> <span class="icon-count">${piclist.pic_count }</span>
										</a>
									</div>
								</div>
								<!--제목,댓글창 끝  -->
							</div>
						</div>
					</c:forEach>
				</div> --%>


			</div>
			<!--사진보기 끝  -->
			<div id="aside_menu">
				<form action="category_search" action="category_search">
					<div id="picture_menu" class="row center_right col-xs-4 col-lg-4">
						<c:forEach var="category" items="${cateList}">

							<div id="picture" class="col-sm-4 col-md-4">
								<div class="Interest Module FollowButton">
									<div class="wholeInterestMask hidden">
										<div class="check"></div>
										<div class="mask"></div>
									</div>
									<div class="interestWrapper" style="background-color: #403F14">
										<div class="interestImage"
											style="background-image: url('../../images/category/${category.category_img_add}')"></div>

										<div class="interestLabel">
											<h4>${category.category_name }
												<input type="checkbox" name="category_no" id="category_no"
													value="${category.category_no }" />
											</h4>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div id="search">
						<input class="btn btn-primary" type="button" value="전체보기"
							onclick="search_all()"> <input id="search_btn"
							class="btn btn-primary" type="submit" value="검색"
							name="search_btn">
					</div>
				</form>

				<a href="#" id="menubutton"><img src="./imgs/menu_button2.PNG"
					alt=""></a>
			</div>
		</div>


	</div>

	<script src="../myRoom/album/js/modernizr-chrg.min.js"></script>
	<script src="../myRoom/album/js/masonry.min.js"></script>
	<script src="../myRoom/album/js/chromagallery.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".mygallery").chromaGallery();
		});
	</script>


</body>
</html>