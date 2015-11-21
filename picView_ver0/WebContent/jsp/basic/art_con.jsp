<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>예술 및 공연 폼</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../jsp/basic/js/jquery.raty.js"></script>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../jsp/basic/css/art_con.css" rel="stylesheet">
</head>
<body>
	<div id="contents">
		<div id="art_con_title">
			<h4>예술 및 공연</h4>
		</div>
		<div id="art_con_table">
			<table class="table table-hover responsive">
				<tr>
					<th id="title"><label for="Name"
						class="col-xs-4 col-md-4 col-lg-4">제목</label></th>
					<td id="content">
						<div class="col-xs-8 col-md-8 col-lg-8">
							<input type="text" class="form-control" name="title">
						</div>
					</td>
				</tr>
				<tr>
					<th id="title"><label for="Name"
						class="col-xs-4 col-md-4 col-lg-4">평점</label></th>
					<td id="content">
						<div class="col-xs-8 col-md-8 col-lg-8">
							<div id="star"></div>
							<input id="starRating" type="hidden" value="3" name="grade">
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>

<script type="text/javascript">
	$(function() {
		$('div#star').raty({
			score : 3,
			path : "images",
			width : 200,
			click : function(score, evt) {
				$("#starRating").val(score);
			}
		});
	});
</script>

</html>