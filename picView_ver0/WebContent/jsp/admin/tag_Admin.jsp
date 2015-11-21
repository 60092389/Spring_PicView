<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<jsp:include page="../layout/adminHeader.jsp"></jsp:include>
	</div>
	
	<div id="tag-admin-center" class="admin-center contents">
		<div class="tag_table" >
			<h2>태그관리</h2>
				<table  class="taglist table table-bordered table-hover">
					<thead>
					<tr>
							<th><a href="#">태그명</a></th>
							<th><a href="#">태그사용횟수</a></th>
						</tr>
					</thead>
					<tbody class="taglist-tbody">
						<tr>
							<td>최연식바보</td>
							<td>32025</td>
						</tr>
						<tr>
							<td>홍채영바보</td>
							<td>29958</td>
						</tr>
						<tr>
							<td>황재준바보</td>
							<td>27777</td>
						</tr>
						<tr>
							<td>최영혜바보</td>
							<td>13777</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan=8>
								<form action="#" method="post" class="form-inline">
									<div class="form-group">
										<div class="checkbox">
											<label class="checkbox-inline">
 											 <input type="checkbox" id="blankCheckbox" name="area" value="tag_name"> 태그명
											</label>
										</div>
										<input type="text" class="form-control" name="searchKey" size="15"></input>											
										<input type="hidden" name="temp" value="temp"></input><!-- 페이징할때 search값 넘길때 사용 -->
										<input type="submit" class="btn btn-default" value="검색">
									</div>
								</form>
							</td>
						</tr>					
					</tfoot>
				</table>
			</div>
			<div class="tag_graph">
				<h1>태그그래프들어갈곳</h1>
			</div>
	</div>
	
	<div class="footer">
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>

</body>
</html>