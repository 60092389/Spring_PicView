<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>동물 및 식물</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../jsp/basic/js/jquery.raty.js"></script>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../jsp/basic/css/ani_plant.css" rel="stylesheet">
</head>
<body>
	<div id="contents">
		<div id="ani_plant_title">
			<h4>동물 및 식물</h4>
		</div>
		<div id="ani_plant_table">
			<table class="table table-hover responsive">
				<tr>
					<th id="title"><label for="Name"
						class="col-xs-1 col-md-1 col-lg-1">동식물명</label></th>
					<td id="content">
						<div class="col-xs-10 col-md-10 col-lg-10">
							<input type="text" class="form-control" name="name">
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>