<%@page import="picView.picture.model.Picture"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>내사진관리</title>

<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="css/my_Menu.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="../../jsp/myRoom/css/my_Popular_Good.css" rel="stylesheet">
<link href="../../jsp/myRoom/css/my_Manage.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>



<script type="text/javascript">
	function upload() {
		location.href = "../basic/upload_index.jsp"
	}
</script>


<title>My_Manage</title>
</head>
<body class="body">
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<div class="my_Menu">
		<jsp:include page="../myRoom/my_Menu.jsp"></jsp:include>
	</div>

	<link rel="stylesheet" href="css/jquery-ui.css">
	<link rel="stylesheet" href="css/selectize.css">
	<script src="js/jquery-1.11.3.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/selectize.js"></script>
	<script src="js/my_Manage.js"></script>
	<script type="text/javascript">
		
	</script>

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
	
	<div class="center contents" data-spy="scroll" data-target="#myScrollspy">
	<div class="manage_form">
		<!-- 사진이 없을때 -->
		<c:if test="${empty list}">
			<div class="temp">
				<div class="no_picture">

					<h3>업로드된 사진이 없습니다.</h3>
					<p>사진을 업로드하여 여러분의 사진을 다른 사람들한테 자랑하세요.</p>
				</div>
				<br><br>
				<div class="button">
					<input id="login" class="btn btn-primary" type="button"
						value="업로드 하기" onclick="upload()">
				</div>
			</div>
		</c:if>
		
		
		<div class="center_left" id="myScrollspy"  data-spy="affix" data-offset-top="140">			
			<!-- 날짜별 사진보기  foreach 써서 날짜 넣기-->			
			<c:forEach var="year" items="${years }">
			<ul class="year_left">				
				<li class="center_left_year">${year }</li>
				<ul class="center_left_month">
					<c:forEach var="months" items="${months }">	
					<c:set var="month_year" value="${fn:substring(months, 0, 4) }"></c:set>
					<c:if test="${year == month_year }">
						<li><a href="#${months }">${fn:substring(months, 5, 7)}월</a></li>
					</c:if>
					</c:forEach>					
				</ul>
					
			</ul>	
			</c:forEach>		
		</div>
		
				
		
		<div class="center_main">
			
			<!-- foreach 써서 날짜 앨범 넣기 -->
			<c:forEach var="d" items="${date }">
				<div class="center_wrap"
					id="<fmt:formatDate value="${d.pic_date }" pattern="yyyy-MM"/>">
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
								<input type="hidden" value="${l.pic_no }">
								<div class="info_top info_hidden" id="${l.pic_add }">
									<a class="pic_detail" href="../../jsp/basic/picDetail.jsp?pic_no=${l.pic_no }">
										<span	class="glyphicon glyphicon-resize-full"></span></a>
								</div>
								<div class="info_bottom" id="${l.pic_add }">
									<div class="dropdown" id="pic_open_scope">
										<a data-toggle="dropdown" href="#">
											<span class="glyphicon glyphicon-eye-open"></span></a>
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
		
		
	
		
		
		<div class="update_window none" 
				style="left: 132px; right: 132px; margin-left: 0px; width:inherit; bottom: 0px;">
			
			<div class="update_pic_count">
				<span class="count_pic"></span>개 선택됨
				<span class="select_cancel">선택취소</span>
			</div>
			<div class="update_pic_img">
				
			</div>			
			<div class="update_pic_show">
				<span><a data-toggle="modal" data-target="#pic_open_update">
					<span class="glyphicon glyphicon-lock" aria-hidden="true"/>권한설정</a></span>
					
				<span><a data-toggle="modal" data-target="#pic_info_update">
					<span class="glyphicon glyphicon-edit" aria-hidden="true"/>편집</a></span>					
					
				<form id="delete_form" action="deletePicture" method="post" style="display: inline">
					<textarea rows="5" cols="5" class="select_result" name="pic_no"
						style="display: none"></textarea>
					<input type="text" name="mem_no" value="${mem_no }" style="display:none"/>
					<span><a href='javascript:form()'>
					<span class="glyphicon glyphicon-trash" aria-hidden="true"/>삭제</a></span>
				</form>
			</div>
		
		</div>
		</div>		
	</div>

	<!-- 권한설정 Modal -->
	<div class="modal fade" id="pic_open_update" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal" action="updatePictureOpen"
					method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">사진의 권한을 변경하시겠습니까?</h4>
					</div>
					<div class="modal-body">

						<textarea rows="5" cols="5" class="select_result" name="pic_no"
							style="display: none"></textarea>

						<input type="hidden" name="mem_no" value="${mem_no}"> <select
							name="pic_open" class="form-control col-sm-2 col-lg-2">
							<option value="1">공개</option>
							<option value="2">친구공개</option>
							<option value="3">비공개</option>
						</select>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						<button type="submit" class="btn btn-primary modal_update_submit">변경</button>
					</div>
				</form>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->


	<!-- 편집 Modal -->
	<div class="modal fade" id="pic_info_update" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form-horizontal" action="updatePictureInfo"
					method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">사진의 정보를 변경하시겠습니까?</h4>
					</div>
					<div class="modal-body form-group">

						<textarea rows="5" cols="5" class="select_result" name="pic_no"
							style="display: none"></textarea>

						<input type="hidden" name="mem_no" value="${mem_no}"> <label
							for="pic_title" class="control-label">사진제목</label>
						<div id="pic_title_area">
							<input type="text" class="form-control" name="pic_title">
						</div>

						<label for="pic_content" class="control-label">사진내용</label>
						<div id="pic_content_area">
							<textarea class="form-control" rows="5" name="pic_content"></textarea>
						</div>

						<label for="pic_content" class="control-label">사진권한설정</label> <select
							name="pic_open" class="form-control">
							<option value="0">선택</option>
							<option value="1">공개</option>
							<option value="2">친구공개</option>
							<option value="3">비공개</option>
						</select>


						<div id="pic_tag_area" class="control-group">
							<label for="pic_tag" class="control-label">태그추가</label>
							<input type="text" id="input-tags" class="input-tags demo-default"
								name="pic_tag">
						</div>

						<script>
							$('#input-tags').selectize({
								plugins : [ 'remove_button' ],
								delimiter : ',',
								persist : false,
								create : function(input) {
									return {
										value : input,
										text : input
									}
								}
							});
						</script>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						<button type="submit" class="btn btn-primary modal_update_submit">변경</button>
					</div>
				</form>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->


</body>
</html>