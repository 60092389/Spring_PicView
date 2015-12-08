<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="./css/my_Show5.css" rel="stylesheet">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet"> 
<link href="./css/my_Menu.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<style>
	.photo-grid-container { margin:50px auto 30px auto; max-width:1100px;}
</style>

<title>보여주기</title>
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
		<jsp:include page="menu_nav.jsp">
			<jsp:param value="${member}" name="member"/>
			<jsp:param value="${level }" name="level"/>
		</jsp:include>
	</div>



	<div class="contents">
		<div class="fluid-magic-tools-view">
		<div class="secondary-tools">
				<div class="view fluid-magic-slideshow-view">
					<a class="slideshow-toggle" title="슬라이드쇼 전환">
						<span class="slide"></span></a>
				</div>
				<div class="view fluid-magic-search-view">
					<a class="search-toggle" href="#"></a>
					
					<input class="magic-search" type="text" value="" placeholder="사진 스트림 검색">
					<a class="overlay"><span class="search"></span></a>
				</div>
				
			</div>
			<div id="show_btn" class="btn-group">
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					모두 보기 <span class="caret"> </span>
				</button>
				<input class="sendShow" type="hidden" name="show" value="all">
				<ul class="dropdown-menu" role="menu">
					<li><a class="show" name="open" title="공개 보기">공개 보기</a></li>
					<li><a class="show" name="friend" title="친구 보기">친구 보기</a></li>
					<li><a class="show" name="closed" title="비공개 보기">비공개 보기</a></li>
					<li><a class="show" name="all" title="모두 보기">모두 보기</a></li>
				</ul>
			</div>
			
		</div>
		 

			 <div class="photo-grid-container">
					<c:forEach var="s" items="${myShowList}">
						
				 		 <div class="photo-grid-item">
				 		 	<a class="overlay" href="../../jsp/basic/picDetail.jsp?pic_id">
								<img src="../../upload/${s.pic_add}">
							</a>
							
							<div class="view photo-list-view">
								<div class="interaction-bar" style="display: none;">
									<div class="text">
										<a class="title" href="#">${pic.pic_title}</a>
										<a class="attribution" href="#">회원님에 의해!</a>
									</div>
									<div class="tool">
										<a class="fave-area" href="#"></a>
										<span class="glyphicon glyphicon-star-empty">${pic.good_count}</span>
									<i class="fave-star fave can-not-fave"></i>
									</div>
									<div class="tool">
										<a class="comment-area" href="#"></a>
										<span class="glyphicon glyphicon-comment">${pic.pic_count}<</span>
										<i class="fave-star fave can-not-fave"></i>
									</div>
								</div>
							</div>
				  			
				  		<%-- 	<div class="interaction-bar">
					  	  <div class="text">
					  	    <a class="title" href='#'>${pic.pic_title}</a>
					  	    <a class="attribution" href='#'>회원님에 의해!</a>
					  	  </div>
					  	  
					  	   <div class='tool'>
 							<a class='fave-area' href='#'></a>
 							<span class='glyphicon glyphicon-star-empty'>${pic.good_count}</span>
 							<i class='fave-star fave can-not-fave'></i>
 						  </div>
					  	  
					  	  <div class='tool'>
							<a class='comment-area' href='#'></a>
 							<span class='glyphicon glyphicon-comment'>${pic.pic_count}</span>
							<i class='fave-star fave can-not-fave'></i>
						 </div>	
					  	</div> --%>
				  		</div>
				  	</c:forEach>
				</div> 
		
			
	<c:if test="${empty myShowList}">
		<div class="no_picture">
			<h3>공개 사진이 없습니다.</h3>
		<p>
			여러분의 포토스트림은 공개 포트폴리오입니다.<br>포토스트림을 채우려면 카메라 롤을 사용하여 사진을 공개로
			설정하세요.
		</p>
		</div>
			<div class="button">
			<input id="login" class="btn btn-primary" type="button" value="사진 관리로 이동">
		</div>
	</c:if>
</div>	

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="./js/jquery-sortable-photos.js"></script> 

<script src="../../js/bootstrap.min.js"></script>
<script src="./js/my_Show.js"></script> 


<script>
$('.photo-grid-container').sortablePhotos({
      selector: '> .photo-grid-item',
	  padding: 5
});

$(function() {
	$(function() {
		$('#show_btn').click(function() {
			//$(this).attr('class', 'btn-group open');
			$(this).find('.btn-group').addClass('open');

		});
		
		$('.search').click(function() {
			var search = encodeURI($('.magic-search').val());
			console.log(search);
			
			location.href="../../jsp/myRoom/myShowForm?search="+search;
		})
	
		var pic_open = '';
		
		$('.show').click(function() {
			pic_open = $(this).attr('name');
			title = $(this).attr('title');
			$('.dropdown-toggle').empty();
			$('.dropdown-toggle').append(title);
			
			$('.sendShow').attr('value',pic_open);
			location.href="../../jsp/myRoom/myShowForm?pic_open="+pic_open;

		});

		
		$('.slideshow-toggle').click(function() {
			location.href="../../jsp/myRoom/myShowSlide?pic_open="+pic_open;
		});
	}) 
})
</script>

</body>
</html>