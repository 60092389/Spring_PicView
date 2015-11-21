<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/admin.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<title>회원관리</title>
<script type="text/javascript">

	$(function(){
		$('.in_black').click(function(){
			var id = $(this).parent().find('input').attr("value");
			location.href = "insertBlack.fo?mem_no=" + id;
			alert("추가되었습니다.");
		});
	});

	
	$(function(){
		$('.in_delete').click(function(){
			var id = $(this).parent().find('input').attr("value");
			location.href = "deleteMember.ao?mem_no=" + id;
			alert("삭제되었습니다.");
		});
	});
	
	$(function(){
		$('.black_delete').click(function(){
			var id = $(this).parent().find('input').attr("value");
			location.href = "deleteBlack.fo?mem_no=" + id;
			alert("삭제되었습니다.");
		});
	});
	
</script>
</head>
<body>
	<div class="header">
		<jsp:include page="../layout/adminHeader.jsp"></jsp:include>
	</div>
	
	<div id="member-admin-center" class="admin-center contents">
			<br><br>
			<!-- 회원 목록 출력 -->
			<div class="member_table" >
			<h2>회원관리</h2>
				<table  class="memberlist table table-bordered table-hover">
					<thead>
					<tr>
							<th><a href="#">회원번호</a></th>
							<th><a href="#">회원명</a></th>
							<th><a href="#">회원ID</a></th>
							<th>가입날짜</th>
							<th>신고사진 수</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="m" items="${listModel.list}">
						<tr>
							<td>${m.mem_no }</td>
							<td><a href="#">${m.mem_name }</a></td>
							<td><a href="#">${m.mem_id}</a></td>
							<td><fmt:formatDate value="${m.mem_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${m.pic_count }</td>
							<td>
							<input type="hidden" class="hidden_mem_no" value="${m.mem_no}">
							<input class="btn btn-warning btn-xs in_black" type="button" value="블랙추가"/>
							<input class="btn btn-danger btn-xs in_delete" type="button" value="삭제"/>
														
							</td>
						</tr>
					   </c:forEach>
					</tbody>
					
					
					
					<!-- 회원목록 검색창 -->
					<tfoot>
						<tr>
							<td colspan=6>
								<form action="list.ao" method="post" class="form-inline">
									<div class="form-group">
										<div class="checkbox">
											<label class="checkbox-inline">
 											 <input type="checkbox" id="blankCheckbox" name="area" value="mem_name"> 회원명</label>
											<label class="checkbox-inline">
 											 <input type="checkbox" id="blankCheckbox" name="area" value="mem_id"> 회원ID</label>
											<label class="checkbox-inline">
 											 <input type="checkbox" id="blankCheckbox" name="area" value="pic_count"> 신고사진 수 &nbsp;</label>
										
										<input type="text" class="form-control"  placeholder="검색어를 입력하세요" name="searchKey" size="20"></input>
										<input type="hidden" name="temp" value="temp"></input><!-- 페이징할때 search값 넘길때 사용 -->
										<input type="submit" class="btn btn-default" value="검색">
										</div>
									</div>
								</form>

								<br><br>
								<c:if test="${ listModel.startPage > 5 }">
									<a class="btn btn-danger" href="list.ao?pageNo=${ listModel.startPage - 5 }">이전</a>
								</c:if>
								<c:forEach var="pageNo" begin="${ listModel.startPage }" end="${ listModel.endPage }">
									<c:if test="${ listModel.requestPage == pageNo }"><b></c:if>
									<a  class="btn btn-warning" href="list.ao?pageNo=${ pageNo }">${ pageNo }</a>
									<c:if test="${ listModel.requestPage == pageNo }"></b></c:if>
								</c:forEach>
								<c:if test="${ listModel.endPage < listModel.totalPage  }">
									<a class="btn btn-danger" href="list.ao?pageNo=${ listModel.startPage + 5 }">다음</a>
								</c:if>
							</td>
						</tr>
					</tfoot>
				</table>
				
			
			</div>
			
			<!-- 블랙리스트 출력 -->
			<div class="black_table">
				<h2>블랙리스트관리</h2>
				<table  class="blacklist table table-bordered table-hover">
					<thead>
					<tr>
							<th><a href="#">블랙번호</a></th>
							<th><a href="#">회원번호</a></th>
							<th><a href="#">회원명</a></th>
							<th><a href="#">회원ID</a></th>
							<th></a>블랙등록날짜</a></th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<c:forEach var="b" items="${listBlack.list}">
					<tbody>
						<tr>
							<td>${b.black_no}</td>
							<td>${b.mem_no}</td>
							<td><a href="#">${b.mem_name }</a></td>
							<td><a href="#">${b.mem_id}</a></td>
							<td><fmt:formatDate value="${b.black_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							
							<td>
							<input type="hidden" class="hidden_mem_no" value="${b.mem_no}">
							<input class="btn btn-danger btn-xs black_delete" type="button" value="삭제"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
					
				<tfoot>
						<tr>
							<td colspan=6>
								<form action="listBlack.fo" method="post" class="form-inline">
									<div class="form-group">
										<div class="checkbox">
											<label class="checkbox-inline">
 											 <input type="checkbox" id="blankCheckbox" name="blackarea" value="mem_name"> 회원명
											</label>
											<label class="checkbox-inline">
 											 <input type="checkbox" id="blankCheckbox" name="blackarea" value="mem_id"> 회원ID &nbsp;
											</label>
										</div>
										<input type="text" class="form-control" placeholder="검색어를 입력하세요"  name="blacksearchKey" size="20"></input>											
										<input type="hidden" name="temp" value="temp"></input><!-- 페이징할때 search값 넘길때 사용 -->
										<input type="submit" class="btn btn-default" value="검색">
									</div>
								</form>

								<br><br>
								<c:if test="${ listBlack.startPage > 5 }">
									<a class="btn btn-danger" href="listBlack.fo?blackPageNo=${ listBlack.startPage - 5 }">이전</a>
								</c:if>
								<c:forEach var="blackPageNo" begin="${ listBlack.startPage }" end="${ listBlack.endPage }">
									<c:if test="${ listBlack.requestPage == blackPageNo }"><b></c:if>
									<a  class="btn btn-warning" href="listBlack.fo?blackPageNo=${ blackPageNo }">${ blackPageNo }</a>
									<c:if test="${ listBlack.requestPage == blackPageNo }"></b></c:if>
								</c:forEach>
								<c:if test="${ listBlack.endPage < listBlack.totalPage  }">
									<a class="btn btn-danger" href="listBlack.fo?blackPageNo=${ listBlack.startPage + 5 }">다음</a>
								</c:if>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
			<br><br>
	</div>
	
	
	<div class="footer">
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>

</body>
</html>