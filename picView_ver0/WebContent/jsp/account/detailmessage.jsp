<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/picView_custom.css" rel="stylesheet">
<title>메세지함</title>
</head>
<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<div class="center contents">
		<table class="message table">
			<tr>
				<th>작성자</th>
				<td>연식</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>하하</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>2015/10/14</td>
			</tr>
			<tr>
				<th>내용</th>
				<th></th>
			</tr>
			<tr>
				<td>adsfasdfadfadf</td>
			</tr>
		</table>
		<form class="sendmeesage" action="sendmeesage.jsp">
			<input class="btn btn-default" type="submit" value="보내기">
			<input class="btn btn-default" type="button" value="뒤로가기">
		</form>
	</div>
	<br><br>
	 <div id="yui_3_16_0_1_1444789083815_155" class="view footer-full-view requiredToShowOnServer">
     	<jsp:include page="../layout/footer.jsp"></jsp:include>	
     </div>

</body>
</html>