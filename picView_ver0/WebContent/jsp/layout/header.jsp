<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- <script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
Bootstrap
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/kfonts2.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet"> -->


<script src="/picView_ver0/js/jquery.min.js"></script>
<script src="/picView_ver0/js/bootstrap.min.js"></script>
<!-- Bootstrap -->
<link href="/picView_ver0/css/bootstrap.min.css" rel="stylesheet">
<link href="/picView_ver0/css/picView_custom.css" rel="stylesheet">


<script type="text/javascript">
/* 	function logout(){
		alert("로그 아웃 되었습니다.");
		location.href="../login/logout.jsp";
	} */

</script>

</head>
<body>
	<div class="container">

		<nav class="navbar navbar-default navbar-fixed-top navnav" role="navigation">

		<div class="container">
		<%-- <%
			int re = -1;
			
			if(session.getAttribute("mem_no")!=null){
				re=1;
			}			
			if(re<0){ //비회원일경우-추후수정
	  %> --%>
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div id="logo">
					<a href="../index/index.jsp"><img id="logo" src="/picView_ver0/images/logo.jpg"></a>
				</div>
			</div>

			<!-- 비회원 -->
			<div class="collapse navbar-collapse navbar-ex1-collapse row">
				<ul class="nav navbar-nav">

					<li><a href="../jsp/collection/recent_Pic.jsp">모아보기</a></li>
					<li><a href="#">도움말</a></li>
					<li style="width: 360px">&nbsp;</li>

					<li>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="검색">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>
					</li>
					<li><a href="#"><span id="upload"
							class="glyphicon glyphicon-cloud-upload"></span></a></li>
					<li><a href="../login/loginForm.jsp">로그인</a></li>
					<li><a href="../login/index.html">가입</a></li>
				</ul>
				
			</div> 
			<!-- 비회원 끝 -->

		<%-- <% 
			}else if(re>0){//회원일경우
		%> --%>
		
		
<!-- 	      <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
	          <span class="sr-only">Toggle navigation</span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <div id="logo">
					<a href="../myRoom/my_Manage.html"><img id="logo" src="../../images/logo.jpg"></a>
				</div>
	      </div> -->

			<!-- 회원메뉴 시작 -->
	<!--       <div class="collapse navbar-collapse navbar-ex1-collapse row">
	        <ul class="nav navbar-nav">
	          <li><a class="dropdown active" href="#" data-toggle="dropdown">
	          		내공간<span class="caret"></span></a>
	          	<ul class="dropdown-menu" role="menu">
	          		<li><a href="../myRoom/my_Manage.html">내사진 관리</a></li>
	          		<li><a href="../myRoom/my_Show.html">보여주기</a></li>
	          		<li><a href="#">앨범</a></li>
	          		<li><a href="#">좋아하는 사진</a></li>
	          		<li><a href="../myRoom/follow.jsp">친구목록</a></li>
	          		<li>&nbsp;</li>
	          		<li><p>그외</p></li>
	          		<li><a href="../myRoom/my_Tag.jsp">&nbsp;태그</a></li>
	          		<li><a href="../myRoom/my_Popular_Hit.jsp">&nbsp;인기</a></li>
	          		<li><a href="#">&nbsp;다운로드 기록</a></li>
	          		<li><a href="#">&nbsp;프로필</a></li>
	          	</ul>
	          </li>
	          <li><a class="dropdown active" href="#" data-toggle="dropdown">
	          		둘러보기<span class="caret"></span></a>
	          	<ul class="dropdown-menu" role="menu">
	          		<li><a href="../collection/recent_Pic.jsp">최근사진</a></li>
	          		<li><a href="../category/index.html">카테고리별</a></li>
	          		<li><a href="#">인기사진</a></li>
	          	</ul>
	          </li>
	          <li><a href="#">도움말</a></li>
	          <li style="width:350px">&nbsp;</li>
	          
	          <li>
	          	<form class="navbar-form navbar-right" role="search">
		          	<div class="form-group">
		           	   <input type="text" class="form-control" placeholder="검색">
		          	</div>
	          	    <button type="submit" class="btn btn-default">Submit</button>
	        	</form>
	          </li>
	          <li><a href="../basic/upload_index.so"><span id="upload"
							class="glyphicon glyphicon-cloud-upload"></span></a></li>
	          <li><a class="dropdown active" href="#" data-toggle="dropdown">
	          	계정<span class="caret"></span></a>
	          	<ul class="dropdown-menu" role="menu">
	          		<li><a href="../account/message.jsp">쪽지함</a></li>
	          		<li><a href="#">상세 도움말</a></li>
	          		<li><a href="../account/accountSet.jsp">계정 설정</a></li>
	          		<li><a onclick="logout()">로그아웃</a></li>
	          	</ul>
	          </li>
	        </ul>
	        
	      </div> -->
	      <!-- 회원메뉴 끝 -->
	<%-- 	<% 
			}
		%> --%>
		</div>

		</nav>
	</div>

</body>
</body>
</html>