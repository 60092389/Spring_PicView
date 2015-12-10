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
<link href="../../jsp/myRoom/css/my_Menu.css" rel="stylesheet">
<link href="css/my_Follow.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<script src="./js/my_Follow.js"></script>

<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<script src="../../js/bootstrap.min.js"></script>

<title>팔로우</title>
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
		<jsp:include page="../myRoom/menu_nav.jsp">
			<jsp:param value="${member}" name="member"/>
			<jsp:param value="${level }" name="level"/>
		</jsp:include>
	</div>


	<div class="center contents">
		<div class="follow_contents">
			<div class="center_head">
				<h2>${member.mem_name }님이 팔로우 하는 사람들</h2>	
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
		
			<div class="browse_content">
				<ol class="browse browse_people browse_people_thumb">
					<c:forEach var="m" items="${members}">
						<c:forEach var="f" items="${follows }">
							<c:choose>
								<c:when test="${(f.follow_fri_no == m.mem_no && f.follow_check == '1' && m.mem_no != member.mem_no ) && f.follow_fri_no != 0}">
									<!--나만 상대방을 팔로우 상태일 때-->									
									<li class="only_follow only_follow2">
										<a title="mem_no" href="myShowForm${m.mem_no}">
											<img alt="" src="../../upload/${m.mem_pic }" class="profile_pic">
											<div class="data">
												<p class="fri_name">${m.mem_name }</p>
												<p class="fri_status">(팔로우중)</p>
											</div>
										</a>
										<c:if test="${level == '1' }">
										<div class="fri_button">
											<form action="cancelFollow" method="post">
												<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${authInfo.mem_no},${m.mem_no }</textarea>
												<input class="btn btn-danger btn-xs in_black" type="submit" value="팔로우취소" /> 
											</form>
										</div>
										</c:if>											
									</li>											
								</c:when>
								<c:when test="${(f.follow_fri_no == m.mem_no && f.follow_check == '3' && m.mem_no != member.mem_no) && f.follow_fri_no != 0}">
									<!--서로 팔로잉 상태일 때-->
									<li class="each_follow each_follow2">
										<a title="mem_no" href="myShowForm${m.mem_no}">
											<img alt="" src="../../upload/${m.mem_pic }" class="profile_pic">
											<div class="data">
												<p class="fri_name">${m.mem_name }</p>
												<p class="fri_status">(맞팔로우)</p>
											</div>
										</a>
										<c:if test="${level == '1' }">
										<div class="fri_button">
											<form action="cancelEachFollow" method="post">
												<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${authInfo.mem_no},${m.mem_no }</textarea>
												<input class="btn btn-warning btn-xs in_black" type="submit" value="팔로우취소" /> 
											</form>
										</div>		
										</c:if>						
									</li>
								</c:when>													
							</c:choose>	
						</c:forEach>
					</c:forEach>
				</ol>
			</div>
			<br>
			<br>
		</div>
	</div>
	
		


</body>
</html>