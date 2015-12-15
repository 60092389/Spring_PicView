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

<link href="./css/my_Show.css" rel="stylesheet">
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
			<jsp:param value="${fol_check }" name="fol_check"/>
		</jsp:include>
	</div>

	<div id="myMenu_navi">
		<jsp:include page="menu_nav.jsp">
			<jsp:param value="${member}" name="member"/>
			<jsp:param value="${level }" name="level"/>
		</jsp:include>
	</div>
	
	<script type="text/javascript" src="../../js/bootstrap.min.js"></script>



	<div class="contents">
		<div class="fluid-magic-tools-view">
		<div class="secondary-tools">
				<div class="view fluid-magic-slideshow-view">
					<a class="slideshow-toggle" title="슬라이드쇼 전환">
						<span class="slide"></span></a>
				</div>
				<div class="view fluid-magic-search-view">
					<a class="search-toggle" href="#"></a>
					<input type="hidden" name="mem_no_search" id="mem_no_search" value="${member.mem_no }">
					<input class="magic-search" type="text" value="" placeholder="사진 스트림 검색">
					<a class="overlay"><span class="search"></span></a>
				</div>
				
			</div>
			
			<div id="show_btn" class="btn-group">
				<c:if test="${level == '1' }">
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
				</c:if>
			</div>
			
		</div>
		 

			<div class="photo-grid-container">
					<c:forEach var="s" items="${myShowList}">
						
				 		 <div class="photo-grid-item">
				 		 	<a class="overlay" href="../../jsp/basic/basic_pic_Detail?pic_no=${s.pic_no}">
				 		 	
								<img src="../../upload/${s.pic_add}">
							</a>
							
							<div class="view photo-list-view">
								<div class="interaction-bar" style="display: none;">
									<div class="text">
										<a class="title" href="#">${s.pic_title}</a>
										
										<c:if test="${level == '1' }">
										<a class="attribution" href="#">회원님에 의해!</a>
										</c:if>
										<c:if test="${level != '1' }">
										<a class="attribution" href="#">출처 : ${member.mem_name }</a>
										</c:if>
										
									</div>
									<div class="tool">
										<a class="fave-area" href="#"></a>
										<span class="glyphicon glyphicon-star-empty">${s.good_count}</span>
									<i class="fave-star fave can-not-fave"></i>
									</div>
									<c:forEach var="r" items="${rep_count}">
										<c:if test="${r.pic_no == s.pic_no }">
											<div class="tool">
												<a class="comment-area" href="#"></a>
												<span class="glyphicon glyphicon-comment">${r.rep_count}</span>
												<i class="fave-star fave can-not-fave"></i>
											</div>
										</c:if>
									</c:forEach>
								</div>
							</div>
				  		</div>
				  	</c:forEach>
				</div> 
		
			
	<c:if test="${empty myShowList}">
		<c:if test="${level == 1 }">
		<div class="no_picture">
			<h3>공개 사진이 없습니다.</h3>
		<p>
			여러분의 포토스트림은 공개 포트폴리오입니다.<br>포토스트림을 채우려면 카메라 롤을 사용하여 사진을 공개로
			설정하세요.
		</p>
		</div>
		</c:if>
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
			$(this).find('.btn-group').addClass('open');

		});
		
		$('.search').click(function() {
			var search = encodeURI($('.magic-search').val());
			console.log(search);
			
			var mem_no = $('#mem_no_search').val();
			
			
			location.href="../../jsp/myRoom/myShowForm"+mem_no+"?search="+search;
		})
	
		var pic_open = 'all';
		
		$('.show').click(function() {
			var mem_no = $('#mem_no_search').val();
			pic_open = $(this).attr('name');
			title = $(this).attr('title');
			$('.dropdown-toggle').empty();
			$('.dropdown-toggle').append(title);
			
			$('.sendShow').attr('value',pic_open);
			location.href="../../jsp/myRoom/myShowForm"+mem_no+"?pic_open="+pic_open;

		});

		
		$('.slideshow-toggle').click(function() {
			var mem_no = $('#mem_no_search').val();
			location.href="../../jsp/myRoom/myShowSlide"+mem_no+"?pic_open="+pic_open;
		});
	}) 
})
</script>

</body>
</html>