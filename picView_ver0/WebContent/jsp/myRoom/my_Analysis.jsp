<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유입 분석페이지</title>

<script src="./js/my_Analysis.js"></script>
<!-- js -->
<!-- <script src="../../js/jquery.min.js"></script> -->
<script src="./js/jquery-latest.js"></script>

<!-- css -->
<link href="./css/jquery-ui.css" rel="stylesheet">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="./css/my_Analysis.css" rel="stylesheet">
<link href="./sorter/style.css" rel="stylesheet">


<!-- <link href="./css/theme.bootstrap.css" rel="stylesheet"> -->

<!-- <link href="./css/table_sorter_style.css" rel="stylesheet"> -->

</head>
<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>

	<%-- <div class="my_Menu">
		<jsp:include page="../myRoom/my_Menu.jsp">
			<jsp:param value="${member}" name="member"/>
		</jsp:include>
	</div>

	<div id="myMenu_navi">
		<jsp:include page="../myRoom/menu_nav.jsp">
			<jsp:param value="${member}" name="member"/>
			<jsp:param value="${level }" name="level"/>
		</jsp:include>
	</div> --%>

	<div id="myMenu_navi">
		<ul class="nav nav-pills">
			<li class="menu"><a href="my_Manage.html">사진 관리</a></li>
			<li class="menu"><a href="my_Show.html">보여 주기</a></li>
			<li class="menu"><a href="#">사진첩</a></li>
			<li class="menu"><a href="#">관심 사진</a></li>
			<li class="menu"><a href="follow.jsp">친구 목록</a></li>
			<li class="menu active"><a href="my_Analysis.jsp">유입 분석</a></li>
		</ul>
	</div>

	<div class="contents">
		<!-- 통계 -->
		<div id="analysis">
			<!-- 통계별 메뉴 -->
			<div id="side_menu" class="anal_group">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#" id="date_Anal">날짜별</a></li>
					<li><a href="#" id="pic_Anal">사진별</a></li>
					<li><a href="#" id="search_Anal">검색어별</a></li>
				</ul>
			</div>

			<div id="dvSearchDate">
				<input type="text" id="txtStartDate" maxlength="12" /> ~ <input
					type="text" id="txtEndDate" maxlength="12" /> <input type="submit"
					id="btnSubmit" value="조회" />
			</div>

			<div id="dvChartType">
				<table id="tbChartType">
					<tr class="header">
						<td>차트</td>
					</tr>
					<tr>
						<td><select id="selChartType" class="subSearchType">
								<option id="opChartType00" value="column">막대차트</option>
								<option id="opChartType01" value="line">라인차트</option>
						</select></td>
					</tr>
				</table>
			</div>

			<!-- 차트 -->
			<div id="dvChart" style="width: 1200px"></div>
		</div>



		<div class="dvSeparator">
			<hr />
		</div>

		<div id="anal_table_area">
			<table id="anal_table" border="1" cellpadding="0"
				cellspacing="0" class="tablesorter">
			</table>
		</div>

	</div>


	<!-- datepicker 이용 js -->
	<script src="./js/jquery-ui.js"></script>

	<!-- 차트 이용 js -->
	<script src="./js/highcharts.js"></script>
	<script src="../../js/bootstrap.min.js"></script>

	<!-- table sorter 이용 js -->
	<script src="./js/jquery.tablesorter.js"></script>
	<script src="./js/jquery.tablesorter.widgets.js"></script>
	<script src="./js/jquery.tablesorter.pager.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			date_Analysis();
			
			//$("table").tablesorter({widthFixed: true, widgets: ['zebra']}).tablesorterPager({container: $("#pager")}); 
			
			$('#date_Anal').click(function() {
				$(this).parent().parent().find('li').attr('class', '');
				$(this).parent('li').attr('class', 'active');
				date_Analysis();
			});

			$('#pic_Anal').click(function() {
				$(this).parent().parent().find('li').attr('class', '');
				$(this).parent('li').attr('class', 'active');
				pic_Analysis();
			});

			$('#search_Anal').click(function() {
				$(this).parent().parent().find('li').attr('class', '');
				$(this).parent('li').attr('class', 'active');
				search_Analysis();
			});

		});
	</script>

</body>
</html>