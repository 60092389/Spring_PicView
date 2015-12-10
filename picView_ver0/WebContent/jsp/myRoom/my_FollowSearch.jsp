<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">



<link href="../../css/picView_custom.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<script src="js/my_Follow.js"></script>
<link href="../../jsp/myRoom/css/my_Menu.css" rel="stylesheet">
<link href="css/my_Follow.css" rel="stylesheet">

<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<script src="../../js/bootstrap.min.js"></script>
<title>팔로우 검색</title>


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
	<link href="css/my_Follow.css" rel="stylesheet">


	<div class="center contents">
		<div class=" follow_contents">
			<h2>친구추천 페이지</h2>
			<c:if test="${level == '1' }">
				<div>
					<input type="hidden" name="mem_no" id="mem_no" value="${authInfo.mem_no }">
					<input class="btn btn-default follow-btn fol-btn" type="button" value="팔로우" >
				</div>
				<div>
					<input class="btn btn-default follower-btn fol-btn" type="button" value="팔로워">
				</div>
				<div>
					<input class="btn btn-default followRec-btn fol-btn" type="button" value="추천친구">
				</div>
				</c:if>
			</div>

			<div class="center_table">
				<div class="alert suggested_msg">
					<div class="iconify"></div>
					<div class="msg">
						<h2>픽뷰의 회원추천입니다!</h2>
						<div>
							픽뷰의 회원추천은 회원님의 관심 카테고리에 맞춰 추천됩니다!<br>
							픽뷰의 회원추천은 최근에 활동을한 회원들 중에서 추천됩니다!<br>
							지금 빨리 다른 회원을 팔로우 하여 관심 분야에 대한 사진을 공유해보세요!
						</div>
					</div>
				</div>
								
				<div class="recommand_fri">
					<c:forEach var="fr" items="${recommandMember}">
						<c:if test="${fr.mem_no !=0 }">
							<div class="result-card linked">
								<div class="sizer-cropper" title="${fr.mem_id}">
									<div class="avatar-content">
										<div class="avatar person medium"
												style="background-image: url('../../upload/${fr.mem_pic}')"></div>
									</div>
									<div class="text-content">
										<div class="title">${fr.mem_name }</div>
										<div class="subtitle"><span>${fr.mem_id }</span></div>
										<div class="links">
											<p><span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
												${fr.pic_count }</p>
											<p><span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
												${fr.category_name }</p>											
										</div>
									</div>
									<a class="click-anywhere" href="myShowForm${fr.mem_no}"></a>
								</div>
								
								<div class="default_follow button-content">
									<form action="addNewFollow" method="post">
										<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${mem_no},${fr.mem_no }</textarea>
										<input class="btn btn-primary in_black" type="submit" value="+팔로우" /> 
									</form>
								</div>
								
							</div>
						</c:if>
					</c:forEach>				
				</div>
				
		
	</div>
</body>
</html>
















