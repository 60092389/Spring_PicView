<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" rel="stylesheet">
<title>신고물관리</title>
</head>
<body>
	
	<div class="header">
		<jsp:include page="../layout/adminHeader.jsp"></jsp:include>
	</div>
	
	<div id="report-admin-center" class="admin-center contents">
		<div class="report_table" >
			<h2>신고물관리</h2>
				<table  class="reportlist table table-bordered table-hover">
					<thead>
					<tr>
							<th><a href="#">사진번호</a></th>
							<th><a href="#">이미지</a></th>
							<th><a href="#">사진제목</a></th>
							<th><a href="#">회원ID</a></th>
							<th><a href="#">회원명</a></th>
							<th>등록날짜</th>
							<th>신고횟수</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody class="reportlist-tbody">
						<tr>
							<td><p>1</p></td>
							<td><a href="#"><img alt="test" src="../../images/main/main_1.JPG"/></a></td>
							<td><p><a href="#">호놀룰룰최연식바보</a></p></td>
							<td><p><a href="#">artroy1990@yahoo.co.kr</a></p></td>
							<td><p><a href="#">준병박</a></p></td>
							<td><p>2015-10-15 21:35:30</p></td>
							<td><p>23</p></td>
							<td>
								<p class="btn-css">
									<input class="btn btn-danger btn-default" type="button" value="삭제">
								</p>
							</td>
						</tr>
						<tr>
							<td><p><a href="#">2</a></p></td>
							<td><a href="#"><img alt="test" src="../../images/main/main_2.JPG"/></a></td>
							<td><p><a href="#">호놀룰룰황재준바보</a></p></td>
							<td><p><a href="#">aokdkdkd2333@yahoo.co.kr</a></p></td>
							<td><p><a href="#">christana_okeydokey</a></p></td>
							<td><p>2015-10-15 21:35:30</p></td>
							<td><p>50</p></td>
							<td>
								<p class="btn-css">
									<input class="btn btn-danger btn-default" type="button" value="삭제">
								</p>
							</td>
						</tr>
						<tr>
							<td><p>3</p></td>
							<td><a href="#"><img alt="test" src="../../images/main/main_3.jpg"/></a></td>
							<td><p><a href="#">호놀룰룰나는천재다</a></p></td>
							<td><p><a href="#">republic_koreaZzang@yahoo.co.kr</a></p></td>
							<td><p><a href="#">kakakakakakakakakaka</a></p></td>
							<td><p>2015-10-15 21:35:30</p></td>
							<td><p>40</p></td>
							<td>
								<p class="btn-css">
									<input class="btn btn-danger btn-default" type="button" value="삭제">
								</p>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan=8>
								<form action="#" method="post" class="form-inline">
									<div class="form-group">
										<div class="checkbox">
											<label class="checkbox-inline">
 											 <input type="checkbox" id="blankCheckbox" name="area" value="mem_name"> 회원명
											</label>
											<label class="checkbox-inline">
 											 <input type="checkbox" id="blankCheckbox" name="area" value="mem_id"> 회원ID
											</label>
											<label class="checkbox-inline">
 											 <input type="checkbox" id="blankCheckbox" name="area" value="noti_count"> 신고횟수 &nbsp;
											</label>
										</div>
										<input type="text" class="form-control" name="searchKey" size="20"></input>											
										<input type="hidden" name="temp" value="temp"></input><!-- 페이징할때 search값 넘길때 사용 -->
										<input type="submit" class="btn btn-default" value="검색">
									</div>
								</form>
							</td>
						</tr>					
					</tfoot>
				</table>
			</div>
	</div>
	
	<div class="footer">
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>