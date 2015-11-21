<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>패션</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../jsp/basic/css/fashion.css" rel="stylesheet">
</head>
<body>
	<div id="contents">
		<div id="fashion_title">
			<h4>패션</h4>
		</div>
		<div id="fashion_table">
			<table class="table table-hover responsive">
				<tr>
					<th id="title"><label for="Name"
						class="col-xs-4 col-md-4 col-lg-4">브랜드명</label></th>
					<td id="content">
						<div class="col-xs-8 col-md-8 col-lg-8">
							<input type="text" class="form-control" name="brand">
						</div>
					</td>
				</tr>
				<tr>
					<th id="title"><label for="Name"
						class="col-xs-4 col-md-4 col-lg-4">사이트</label></th>
					<td id="content">
						<div id="link" class="col-xs-8 col-md-8 col-lg-8">
							<input type="text" class="form-control" name="site">
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>