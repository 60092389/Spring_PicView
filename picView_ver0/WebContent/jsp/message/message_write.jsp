<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1" name="viewport">
<title>쪽지 쓰기</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="css/message_write.css" rel="stylesheet">
<script type="text/javascript">
	/* $(function() {
		$('#msg_write').click(function() {
			location.href = "message_write?msg_no=" + msg_no;
		});

		$('#msg_list').click(function() {
			location.href = "message";
		});
	}); */
</script>
</head>
<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>

	<form id="test">
	<div class="test">
	<h1>test</h1>
	</div>
	</form>
	
	<div class="contents">
		<h1 class="mail-header">
			<a href="#">PicView 쪽지함</a> / 쪽지 작성
		</h1>

		<form action="message_write" method="post" role="form" id="write">
			<label>받는사람</label>
			<div id="to" class="form-group">
				<input type="text" id="msg_receiver" class="form-control"
					placeholder="이름" name="msg_receiver" />
					<input type="text" id="msg_sender" class="form-control"
					placeholder="보내는사람" name="msg_sender" />
			</div>
			<textarea id="msg" cols="55" rows="5" name="msg_content"></textarea>
			<div id="btn_group">
				<input type="submit" id="msg_write" class="btn btn-success"
					value="보내기"> <input type="button" id="msg_list"
					class="btn btn-success" value="목록보기">
			</div>
		</form>
	</div>
</body>
</html>