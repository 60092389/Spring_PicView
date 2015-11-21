<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>나페이지</title>

<style type="text/css">
	.header{
		height:10%;
	}
	.contents{
		height:80%;
		margin-top:10px;
	}
	.footer{
		height:10%;
	}
</style>

<script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
		<link href="../../css/picView_custom.css" rel="stylesheet">

</head>
<body>
	<div class="header">
	<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<div class="contents">
		<div class="content_head">
			<jsp:include page="./my_Menu.jsp"></jsp:include>
		</div>
		<div class="contetnt_center">
		<h2>뉴스피드</h2>
		</div>
	</div>
	 <div class="footer">
	 <jsp:include page="../layout/footer.jsp"></jsp:include>
	 </div>
</body>
</html>