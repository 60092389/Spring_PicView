<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지함 / 쪽지 읽기</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="css/message_inbox.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>

	<div class="contents">
		<h1 class="mail-header">
			<a href="message">PicView 쪽지함</a> / 쪽지 읽기
		</h1>

		<div id="btn_group">
			<input type="button" id="meg_write" class="btn btn-danger" value="삭제">
			<input type="button" id="meg_list" class="btn btn-success" value="보관">
		</div>

		<label>보낸사람</label><a href="">황재준</a> 
		<label>받은시간</label> <span id="receive_date"> 15-11-23 [17:11]</span>
		<div id="content" class="msg_content">안녕하세요</div>

	</div>
</body>
</html>