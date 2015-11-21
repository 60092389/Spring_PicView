<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" rel="stylesheet">
<title>카테고리관리</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="header">
		<jsp:include page="../layout/adminHeader.jsp"></jsp:include>
	</div>

	
	<div id="category" class="admin-center contents">
		<div class="category-add">
			<h1>카테고리추가</h1>
			<form class="form-horizontal" action="insertAction.done" method="post" enctype="multipart/form-data">
				<table class="category-add-table table">
					<tr>
						<th>카테고리명</th>
						<td><input type="text" name="category_name" class="form-control"></td>
					</tr>
					<tr>	
						<th>카테고리이미지</th>
						<td><input type="file" name="category_img_add"></td>
					</tr>
					<tr>
						<th>카테고리순서</th>
						<td><input type="text" name="category_seq" class="form-control"></td>
					</tr>
				</table>
				<input type="submit" value="추가" id="add_btn" class="btn">
			</form>	
		</div>
		
		<div class="category-manage">
			<!-- <h1>카테고리관리</h1> -->
			<div class="category-list">
				<table class="category-list-table table">
					<thead>
						<tr>
							<th>카테고리번호</th>
							<th>카테고리사진</th>
							<th>카테고리명</th>
							<th>카테고리등록일</th>
							<th>카테고리순서</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cate" items="${listModel.list}">
							<tr>
								<td>${cate.category_no }</td>
								<td>
									<c:if test="${cate.category_img_add != null}">
										<!-- upload/원본head_small.pattern -->
										<c:set var="head" value="${fn:substring(cate.category_img_add, 0, fn:length(cate.category_img_add)-4) }"></c:set>
										<c:set var="pattern" value="${fn:substringAfter(cate.category_img_add, head) }"></c:set>
										<img src="../../upload/${head }_small${pattern}"/>					
									</c:if>
								</td>
								<td>${cate.category_name }</td>
								<td>${cate.category_date }</td>
								<td>${cate.category_seq }</td>
							</tr>
						</c:forEach>
						<tfoot>
							<tr>
								<td colspan="5">
									<form action="listAction.done" method="post" class="form-horizontal">
										<input type="checkbox" name="area" value="category_no"/>카테고리번호
										<input type="checkbox" name="area" value="category_name"/>카테고리명
										<input type="checkbox" name="area" value="category_seq"/>카테고리순서
										<input type="text" name="searchKey" size="15"/>
										<input type="hidden" name="temp" value="temp"/>
										<input type="submit" value="검색">
									</form>
								</td>
							</tr>
						</tfoot>
					</tbody>
				</table>
				<c:if test="${listModel.startPage > 5 }">
      		<a href = "listAction.done?pageNum=${listModel.startPage-5}">[이전]</a>
   			</c:if>
   
				<c:forEach var="pageNo" begin="${listModel.startPage }" end="${listModel.endPage }">
    		  <c:if test="${listModel.requestPage == pageNo}"><b></c:if>
      			<a href="listAction.done?pageNum=${pageNo }">[${pageNo }]</a>
      		<c:if test="${listModel.requestPage == pageNo }"></b></c:if>
   			</c:forEach>
   
				<c:if test="${listModel.endPage < listModel.totalPageCount }">
					<a href = "listAction.done?pageNum=${listModel.startPage+5}">[이후]</a>
   			</c:if>
			</div>
		</div>
	</div>
	
	<div class="footer">
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>	
</body>
</html>