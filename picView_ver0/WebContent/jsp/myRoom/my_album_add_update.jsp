<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="css/kfonts2.css" rel="stylesheet">
<link rel="stylesheet" href="../../css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="./album/css/flexslider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="./album/css/my_album_add.css" type="text/css" />
<link rel="stylesheet" href="./album/css/selectize.default.css" type="text/css" />
<link rel="stylesheet" href="./album/css/normalize.css" type="text/css" />
<link rel="stylesheet" href="./album/css/stylesheet.css" type="text/css /">
<link rel="styleshhet" href="./album/css/selectize.css" type="text/css" />
<link rel="stylesheet" href="album/css/my_album_add_update.css" type="text/css">
<style type="text/css">
.listpicc {
	width: 200px !important;
}

#pic_plus li {
	float: left;
	display : inline !important;
	width: 100px !important;
}

#mem_nohidden, #mem_nohidden, #hiddenalb_no{
	display: none;
}
</style>
</head>
<body onload="search()">

	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<script src="album/js/jquery.min.js"></script>
	<script src="album/js/modernizr.js"></script>
	<script defer src="./album/js/jquery.flexslider.js"></script>
	<script src="album/js/my_album_add_update.js"></script>
	<script src="album/js/jquery.js"></script>
	<script src="album/js/jquery-ui.js"></script>
	<script src="album/js/selectize.js"></script>
	<script src="album/js/index.js"></script>
<div class="contents">
	<div class="content">
		<div class="back">
			<h5>
				<!-- <a href="my_album">앨범 목록으로 돌아가기</a> -->
				<a class="back-to-albums" href="my_album${mem_no}">
					<span class="back-to-albums-icon"></span>
					<span class="back-to-albums-text" style="font-weight:600"> 앨범 목록으로 돌아가기 </span>
				</a>
			</h5>
		</div>
		<form action="album_add_updae_re" class="form-horizontal">
				
			<input type="text" id="mem_nohidden"value="${mem_no}" name="mem_no"> <input
				type="text" value="${getalb_word }" name="getalb_word"
				id="getalb_word">
			<input type="text" value="${album.alb_no }" name="alb_no" id="hiddenalb_no">	

			<div class="left col-md-4">
				<div class="form-group">
					<div class="col-xs-10 col-lg-7 col-sm-7 alb_name">
						<input type="text" class="form-control" id="alb_name"
							placeholder="제목입력란" name="alb_name" value="${album.alb_name }">
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-8 col-lg-8 col-sm-8">
						<textarea class="form-control " id="alb_content"
							name="alb_content" placeholder="앨범 내용 입력란">${album.alb_content }</textarea>
					</div>
				</div>
			</div>
			<div class="center col-md-4" style="padding: 0">
				<div class="form-group " style="margin: 0">
					<ul class="pic_plus col-xs-7 col-lg-7 col-sm-7 form-group list-inline" id="pic_plus"
						name=id ondrop="drop(this, event);" ondragenter="return false;"
						ondragover="return false;"  style="width: 430px;margin: 0px;padding: 0">
						<p class="bg-info">앨범을 만들고 싶은 사진을 끌어 당기세요</p>
						<c:forEach items="${detailAlbumPic_add}" var="detailAlbumPic_add">
							<li id="${detailAlbumPic_add.pic_no }" ondragstart="drag(this, event)"
							draggable="true" name="${detailAlbumPic_add.tag_name }"  style="margin-right: 5px; float: left; display: block; width: 391.25px;">
							<img
							id="${detailAlbumPic_add.tag_name }"
							src="../../upload/${detailAlbumPic_add.pic_add }" ></li>
						</c:forEach>

					</ul>
				</div>
			</div>
			<div class="right col-md-4" style="padding-top: 0">
				<div class="form-group">
					<div class="col-xs-3 col-lg-5 col-sm-5" style="padding-top: 0">
						<div id="pic_rec" >
							<p class="bg-info">사진의 주요 키워드가 나타납니다.</p>
							<div class="pic_rec_ul" id="pic_rec_ul">
								<div class="control-group">
									
									<input type="text" id="pic_no" name="pic_no"
										class="input-tags demo-default" value="">
										
								</div>

								<script>
									$('#pic_no').selectize({
										plugins : [ 'restore_on_backspace' ],
										persist : false,
										create : false
										
									});
									$('.selectize-input').addClass('has-options').addClass('has-items');
									var tagplus = "";
									var tempd = "";
									
									$('.pic_plus li').each(function(indext, item){
										var id = $(this).attr('id');
										var tagname = $(this).attr('name');
										$('.selectize-input').append(
												'<div class="item" data-value='+tagname+' id="'+id+'">'
														+ tagname + '</div>');
										
										var plust = $(this).attr('id');
										tagplus = tempd + ',' + plust;
										tempd = tagplus;
										
									});
									$('input[name=pic_no]').attr('value', tagplus);
									
								</script>
							</div>

						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-3 col-lg-5 col-sm-5">
						<input type="text" id="alb_word" class="form-control"
							placeholder="키워드입력란" name="alb_word" value="${album.alb_word }">
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-3 col-lg-5 col-sm-5">
						<input type="submit" id="alb_add_re" class="form-control"
							value="만들기">
					</div>
				</div>
			</div>


		</form>
	</div>


	<div class="botto">

		<div class="pic_search " style="margin-left: 46px">
			<form class="form-group" action="pic_search">
				<div class="col-xs-3 col-lg-3 col-sm-3">
					<input class="form-control" type="text"
						placeholder="사진제목 또는 태그명을 입력하세요" id="pic_search" value=""
						name="pic_search">
				</div>
				<div class="col-xs-3 col-lg-3 col-sm-3">
					<input type="text" value="${mem_no}" name="mem_no" id="mem_no">
					<input type="text" value="${getalb_word }" name="getalb_word"
						id="getalb_word"> <input
						class="form-control pic_search_btn" type="submit" value="검색"
						style="background: #0063dc none repeat scroll 0 0; border-radius: 4px;
						color: #fff;cursor: pointer;font-weight: bold; 
						padding: 4px 6px;text-decoration: none;text-overflow: ellipsis; 
						white-space: nowrap;width: 55px; ">
				</div>
			</form>
			
		</div>

		<div class="pic_bottom">
			<p class="bg-info">사진을 끌어당기세요</p>
			<div class="flexslider">
				<ul id="sub_ul" class="slides pic sub_ul"
					ondrop="drop2(this, event);" ondragenter="return false;"
					ondragover="return false;">

					<c:forEach items="${listpic }" var="listpic">
						<li class="listpicc" id="${listpic.pic_no }" ondragstart="drag(this, event)"
							draggable="true" name="${listpic.tag_name }"><img class="img-rounded"
							id="${listpic.tag_name }"
							src="../../upload/${listpic.pic_add }"></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>





	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h3 class="modal-title" id="myModalLabel">동일한 키워드의 앨범을 발견하였습니다</h3>
				</div>
				<div class="modal-body">
					<p>동일한 키워드의 앨범이 존재합니다</p>
					<p>생성하였했던 앨범의 사진을 동일 키워드의 앨범에 넣었습니다.</p>
					<p>동일 키워드명 : ${getalb_word }</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="firm()">확인</button>

					<script type="text/javascript">
						function firm() {

							location.href = "my_album";
						}
					</script>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
</div>
	<script src="album/js/bootstrap.min.js"></script>
	<script>
		if ($('#getalb_word[name=getalb_word]').attr('value') != "") {
			$('#myModal').modal({
				keyboard : false
			})
		}
	</script>



	<script type="text/javascript" src="album/js/shCore.js"></script>
	<script type="text/javascript" src="album/js/shBrushXml.js"></script>
	<script type="text/javascript" src="album/js/shBrushJScript.js"></script>

	<script type="text/javascript">
		//실시간검색	
		search = function() {

			var c = "";
			// 키보드 입력시 실시간검색
			$("#pic_search").keypress(function(e) {
				if (e.which > 31 && e.which < 123) {
					c = c + String.fromCharCode(e.which);
					len = c.length;
					if (len == 1 && e.which > 96) {
						c = String.fromCharCode(e.which);
					}

					$('#sub_ul li img').hide();
					$("#sub_ul li img").each(function(i) {

						if ($(this).attr('id').substring(0, len) == c) {
							$(this).show();
						}
					});

				}
			});
			// 키보드 입력지울시 검색
			$("input#pic_search").keydown(function(e) {
				if (e.which == 8) {
					len = c.length - 1;
					c = c.substring(0, len);

					$('#sub_ul li img').hide();
					$("#sub_ul li img").each(function(i) {
						if ($(this).attr('id').substring(0, len) == c) {
							$(this).show();
						}
					});
				}
			});

		}
		/*  */
	</script>

</body>
</html>