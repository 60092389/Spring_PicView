<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>

<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="css/loginForm_2.css" rel="stylesheet">
<script type="text/javascript">
	function login_check() {
		var o = document.loginForm;
		if (!o.id.value) {
			alert('아이디를 입력하세요');
			o.id.focus();
		} else if (!o.pass.value) {
			alert('비밀번호를 입력하세요');
			o.pass.focus();
		} else {
			o.action = "loginForm.so";
			o.submit();
		}
	}
</script>
</head>

<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>

	<div class="contents">
		<div class="login">
			<form class="form-horizontal" action="loginForm.so" name="loginForm">


				<div id="id" class="input-group">
					<span class="input-group-addon"> <span
						class="glyphicon glyphicon-user"> </span>
					</span> <input class="form-control" name="id" type="text"
						placeholder="아이디">

				</div>
				<div id="pass" class="input-group">
					<span class="input-group-addon"> <span
						class="glyphicon glyphicon-lock"></span>
					</span> <input class="form-control" name="pass" type="password"
						placeholder="비밀번호">

				</div>
				<div class="button">
					<input id="login" class="btn btn-primary" type="button"
						onclick="login_check();" value="로그인">&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="join" class="btn btn-primary" type="button" value="회원가입">
				</div>
			</form>
		</div>
	</div>

	<div class="footer">
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>