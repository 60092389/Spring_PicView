<%@page import="picView.picture.model.Picture"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	System.out.println("리스트값 : "+request.getAttribute("list"));

	List<Picture> list = (List)request.getAttribute("list");
	
	/* for(int i=0; i<list.size(); i++){
		System.out.println(list.get(i).getPic_date());
	} */
	
	
/* 	for(int i=0; i<list.size(); i++){
		if(list.get(i+1).getPic_title() == null){
	break;
		}
		if(list.get(i).getPic_date() == list.get(i+1).getPic_date()){
	System.out.println("같은값");
		}else if(list.get(i).getPic_date() != list.get(i+1).getPic_date()){
	System.out.println(list.get(i).getPic_date());
		}
	} */
	
/* 	for(int i=0; i<list.size(); i++){
		if(list.get(i+1).getPic_title() == null){
	break;
		}
		for(int j=i+1; j<list.size(); j++){
	if(list.get(i).getPic_title().equals(list.get(j).getPic_title())){
		System.out.println(list.get(i).getPic_title());
	}
		}
	} */
%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="css/my_Menu.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="../../jsp/myRoom/css/my_Popular_Good.css" rel="stylesheet">
<link href="../../jsp/myRoom/css/my_Manage.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>





<script type="text/javascript">
	function upload() {
		location.href = "../basic/upload_index.jsp"
	}
</script>

<style>
.ui-selectee {
	background-color: silver;
	cursor: pointer;
}

.ui-selected {
	background-color: pink;
}
</style>

<title>My_Manage</title>
</head>
<body data-spy="scroll" data-target="#myScrollspy" class="body">
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<div class="my_Menu">
		<jsp:include page="../myRoom/my_Menu.jsp"></jsp:include>
	</div>
	<!-- <script src="selectables/jquery-1.4.js"></script>-->
	<!-- <script src="selectables/jquery-ui-1.9.2.custom.js"></script> -->
	<!-- <script src="selectables/jquery-ui-1.8.custom.min.js"></script>-->
	<!-- <script src="selectables/jquery-1.4.js"></script>-->
	<!-- <script src="jquery-ui.min.js"></script>-->
	<!-- <link href="selectables/jquery-ui-1.8.custom.css" rel="stylesheet"> -->
	<link rel="stylesheet" href="css/jquery-ui.css">
	<script src="js/jquery-1.11.3.js"></script>
	<script src="js/jquery-ui.js"></script>




	<script type="text/javascript">
		/* $(document).ready(function() {

			$('.center_main').selectable({
				distance:1,
				filter : 'div.center_picture'
			},{
				stop: function(){
					var result = $('#select_result').empty();
					$(".ui-selected", this).each(function(){
						var index = $('.pic_no').index(this);
						result.append("#");
					});
				}				
			});			
		});  */

		$(function() {

			$('.center_main').selectable({
				distance : 1,
				filter : 'div.center_picture'
			}, {
				stop : function() {
					var result = $('#select_result').empty();
					$(".ui-selected", this).each(function() {
						var index = $(this).attr('id');
						result.append((index) + ',');
					});
				}
			});
		});
		/* $(function() {
			var result = $('#select_result').empty();
			
			$('.center_main').selectable({
				distance:1,
				filter : 'div.center_picture',
				selected: function(){
					var idlist = $(this).attr('id');
					result.append((idlist)+',');
				}
			});			
		}); */
		/* $(function() {
			var result = $('#select_result').empty();
			var id;
			$('.center_main').selectable({
				distance : 1,
				filter : 'div.center_picture',
				selected : function(event, ui) {
					$(".ui-selected", this).each(function(){
						id = $(this).attr('id');
						
					});		
					result.append((id) + ',');
				}
			});
		}); */
	</script>
	<script src="js/my_Manage.js"></script>



	<div id="myMenu_navi">
		<ul class="nav nav-pills">
			<li class="menu active"><a href="my_Manage.html">사진 관리</a></li>
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


	<div class="center contents">

		<!-- 사진이 없을때 -->
		<c:if test="${empty list}">
			<div class="temp">
				<div class="no_picture">

					<h3>업로드된 사진이 없습니다.</h3>
					<p>사진을 업로드하여 여러분의 사진을 다른 사람들한테 자랑하세요.</p>
				</div>
				<div class="button">
					<input id="login" class="btn btn-primary" type="button"
						value="업로드 하기" onclick="upload()">
				</div>
			</div>
		</c:if>

		<div class="center_left" id="myScrollspy">
			<!-- 날짜별 사진보기  foreach 써서 날짜 넣기-->
			<ul class="nav nav-pills nav-stacked">
				<c:forEach var="a" items="${date }">
					<li><a
						href="#<fmt:formatDate value="${a.pic_date }" pattern="yyyy-MM-dd"/>">
							<fmt:formatDate value="${a.pic_date }" pattern="yyyy-MM-dd" />
					</a></li>
				</c:forEach>
			</ul>
		</div>

		<div class="center_main">

			<button class="btn btn-primary btn-lg" data-toggle="modal"
				data-target="#myModal">선택된 사진 권한 설정</button>
			<!-- <p>
				<textarea rows="5" cols="5" id="select_result">none</textarea>
			</p> -->
			<!-- foreach 써서 날짜 앨범 넣기 -->
			<c:forEach var="d" items="${date }">
				<div class="center_wrap"
					id="<fmt:formatDate value="${d.pic_date }" pattern="yyyy-MM-dd"/>">
					<div class="center_date">
						<p id="date_css">
							<fmt:formatDate value="${d.pic_date }" pattern="yyyy-MM-dd" />
						</p>
					</div>

					<c:forEach var="l" items="${list }">
						<c:if test="${d.pic_date == l.pic_date }">
							<div id="${l.pic_no }" class="center_picture"
								style="background-image: url('../../upload/${l.pic_add }');">
								<div class="pic_check"></div>
								<div class="back_color"></div>
								<%-- <img src="../../upload/${l.pic_add }" /> --%>
								<input type="hidden" value="${l.pic_no }">
								<div class="info_top info_hidden" id="${l.pic_add }">
									<a class="pic_detail"
										href="../../jsp/basic/picDetail.jsp?pic_no=${l.pic_no }"><span
										class="glyphicon glyphicon-resize-full"></span></a>
								</div>
								<div class="info_bottom" id="${l.pic_add }">
									<div class="dropdown" id="pic_open_scope">
										<a data-toggle="dropdown" href="#"><span
											class="glyphicon glyphicon-eye-open"></span></a>
										<ul class="dropdown-menu" role="menu">
											<li role="presentation"><a role="menuitem" tabindex="-1"
												href="#">공개</a></li>
											<li role="presentation"><a role="menuitem" tabindex="-1"
												href="#">친구공개</a></li>
											<li role="presentation"><a role="menuitem" tabindex="-1"
												href="#">비공개</a></li>
										</ul>
									</div>
									<span class="pic_count">${l.pic_count }</span>
									<div class="dropdown" id="pic_manage">
										<a data-toggle="dropdown" href="#"><span
											class="glyphicon glyphicon-cog"></span></a>
										<ul class="dropdown-menu" role="menu">
											<li role="presentation"><a role="menuitem" tabindex="-1"
												href="deletePicture.po?pic_no=${l.pic_no }">사진삭제</a></li>
											<li role="presentation"><a role="menuitem" tabindex="-1"
												href="#">사진수정</a></li>
										</ul>
									</div>
								</div>

							</div>
						</c:if>
					</c:forEach>
				</div>
			</c:forEach>
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
					<h4 class="modal-title" id="myModalLabel">모달 제목</h4>
				</div>
				<div class="modal-body">
					<p>여기는 내용이 들어 가는 곳</p>
					<p>
						<textarea rows="5" cols="5" id="select_result">none</textarea>
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary">변경 사항 저장</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->


</body>
</html>