<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="js/my_Follow.js"></script>
<link href="../../jsp/myRoom/css/my_Menu.css" rel="stylesheet">
<link href="css/my_Follow.css" rel="stylesheet">
<title>팔로우 검색</title>


</head>
<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<div class="my_Menu">
		<jsp:include page="../myRoom/my_Menu.jsp"></jsp:include>
	</div>

	<div id="myMenu_navi">
		<ul class="nav nav-pills">
			<li class="menu"><a href="my_Manage.html">사진 관리</a></li>
			<li class="menu"><a href="my_Show.html">보여 주기</a></li>
			<li class="menu"><a href="#">사진첩</a></li>
			<li class="menu"><a href="#">관심 사진</a></li>
			<li class="menu active"><a href="follow.jsp">친구 목록</a></li>
			<li id="other" class="dropdown"><a href=""
				data-toggle="dropdown"> 그 외 <span class="caret"></span>
			</a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="my_Tag.jsp">태그별</a>
					<li><a href="my_Popular_Hit.jsp">인기별</a>
					<li><a href="#">다운로드 기록</a>
					<li><a href="#">프로필</a>
				</ul></li>
		</ul>
	</div>


	<div class="center contents">
		<div class=" follow_contents">
			<h2>친구추천 페이지</h2>
			<div class="center_head">
				<div>
					<input class="btn btn-default follow-btn fol-btn" type="button" value="팔로우">
				</div>
				<div>
					<input class="btn btn-default follower-btn fol-btn" type="button" value="팔로워">
				</div>
				<div>
					<input class="btn btn-default followRec-btn fol-btn" type="button" value="추천친구">
				</div>
			</div>

			<div class="center_table">
				<div class="alert suggested_msg">
					<div class="iconify"></div>
					<div class="msg">
						<h2>픽뷰의 회원추천입니다!</h2>
						<div>
							픽뷰의 회원추천은 회원님의 관심 카테고리에 맞춰 추천됩니다!<br>
							픽뷰의 회원추천은 최근에 활동을한 회원들 중에서 추천됩니다!<br>
							지금 빨리 다른 회원을 팔로우 하여 관심 분야에 대한 사진을 공유해보세요!
						</div>
					</div>
				</div>
								
				<div class="recommand_fri">
					<c:forEach var="fr" items="${recommandMember}">
						<c:if test="${fr.mem_no !=0 }">
							<div class="result-card linked">
								<div class="sizer-cropper" title="${fr.mem_id}">
									<div class="avatar-content">
										<div class="avatar person medium"
												style="background-image: url('../../upload/${fr.mem_pic}')"></div>
									</div>
									<div class="text-content">
										<div class="title">${fr.mem_name }</div>
										<div class="subtitle"><span>${fr.mem_id }</span></div>
										<div class="links">
											<p><span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
												${fr.pic_count }</p>
											<p><span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
												${fr.category_name }</p>											
										</div>
									</div>
									<a class="click-anywhere" href="#"></a>
								</div>
								
								<div class="default_follow button-content">
									<form action="addNewFollow" method="post">
										<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${mem_no},${fr.mem_no }</textarea>
										<input class="btn btn-primary in_black" type="submit" value="+팔로우" /> 
									</form>
								</div>
								
							</div>
						</c:if>
					</c:forEach>				
				</div>
				
				
				<%-- <div class="search_fri">
					<table class="memberlist table table-bordered table-hover">
						<thead>
							<tr>
								<th><a href="#">회원사진</a></th>
								<th><a href="#">회원명</a></th>
								<th><a href="#">회원ID</a></th>
								<th>가입날짜</th>
								<th>${mem_no }</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="m" items="${members}">
								<tr class="member_list">
									<td><img src="../../upload/${m.mem_pic }" width="40px" height="40px"></td>
									<td><a href="#">${m.mem_name }</a></td>
									<td><a href="#">${m.mem_id}</a></td>
									<td><fmt:formatDate value="${m.mem_date}" pattern="yyyy-MM-dd" /></td>
									
									<td class="follow_col">									
										<c:choose>
											<c:when test="${m.mem_no == mem_no }">
												<h4>회원님입니다</h4>
											</c:when>
											<c:when test="${m.mem_no != mem_no}">
												<c:forEach var="f" items="${follows }">
													<c:if test="${f.follow_fri_no == 0 && f.follow_fri_no == 0}">
														<div class="default_follow">
															<form action="addNewFollow" method="post">
																<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${mem_no},${m.mem_no }</textarea>
																<input class="btn btn-primary btn-xs in_black" type="submit" value="+팔로우" /> 
															</form>
														</div>
													</c:if>	
													<c:choose>														
														<c:when test="${(f.follow_fri_no == m.mem_no && f.follow_check == '2' && f.mem_no == mem_no) && f.follow_fri_no != 0}">
															<!--상대방만 나를 팔로우 상태일 때-->															
															<div class="only_follower only_follower2">
																<span style="display:inline; float:left">(나를 팔로우하고 있음)</span>
																<div style="display:inline; float:left; margin-left:5px;">
																	<form action="addFollow" method="post">
																		<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${mem_no},${m.mem_no }</textarea>
																		<input class="btn btn-success btn-xs in_black" type="submit" value="+맞팔하기" /> 
																	</form>
																</div>
															</div>
														</c:when>
														<c:when test="${(f.follow_fri_no == m.mem_no && f.follow_check == '1') && f.follow_fri_no != 0}">
															<!--나만 상대방을 팔로우 상태일 때-->
															<div class="only_follow only_follow2">
																<span style="display:inline; float:left">(팔로우중)</span>
																<div style="display:inline; float:left; margin-left:5px;">
																	<form action="cancelFollow" method="post">
																		<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${mem_no},${m.mem_no }</textarea>
																		<input class="btn btn-danger btn-xs in_black" type="submit" value="팔로우취소" /> 
																	</form>
																</div>
															</div>													
														</c:when>
														<c:when test="${(f.follow_fri_no == m.mem_no && f.follow_check == '3') && f.follow_fri_no != 0}">
															<!--서로 팔로잉 상태일 때-->
															<div class="each_follow each_follow2">
																<span style="display:inline; float:left">(맞팔로우)</span>
																<div style="display:inline; float:left; margin-left:5px;">
																	<form action="cancelEachFollow" method="post">
																		<textarea rows="5" cols="5" name="mem_nos" style="display:none;">${mem_no},${m.mem_no }</textarea>
																		<input class="btn btn-warning btn-xs in_black" type="submit" value="팔로우취소" /> 
																	</form>
																</div>
															</div>
														</c:when>																															
													</c:choose>														
												</c:forEach>	
											</c:when>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</tbody>



						<!-- 회원목록 검색창 -->
						<tfoot>
							<tr>
								<td colspan=5>
									<form action="listFri" method="post" class="form-inline">
										<div class="form-group">
											<div class="checkbox">
												<label class="checkbox-inline">
												<input type="checkbox" id="blankCheckbox" name="area" value="mem_name"> 회원명
												</label>
												<label class="checkbox-inline">
													<input type="checkbox" id="blankCheckbox" name="area"	value="mem_id"> 회원ID
												</label>
													<input type="text" class="form-control" placeholder="검색어를 입력하세요" name="searchKey" size="20"></input>
												<input type="hidden" name="temp" value="temp"></input>
												<!-- 페이징할때 search값 넘길때 사용 -->
												<input type="submit" class="btn btn-default" value="검색">
											</div>
										</div>
									</form> <br>
								<br> <c:if test="${ listModel.startPage > 5 }">
										<a class="btn btn-danger"
											href="list.ao?pageNo=${ listModel.startPage - 5 }">이전</a>
									</c:if> <c:forEach var="pageNo" begin="${ listModel.startPage }"
										end="${ listModel.endPage }">
										<c:if test="${ listModel.requestPage == pageNo }">
											<b>
										</c:if>
										<a class="btn btn-warning" href="list.ao?pageNo=${ pageNo }">${ pageNo }</a>
										<c:if test="${ listModel.requestPage == pageNo }">
											</b>
										</c:if>
									</c:forEach> <c:if test="${ listModel.endPage < listModel.totalPage  }">
										<a class="btn btn-danger"
											href="list.ao?pageNo=${ listModel.startPage + 5 }">다음</a>
									</c:if>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div> --%>
	</div>
</body>
</html>
















