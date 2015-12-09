<%@page import="picView.cate.model.Category"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link href="./bootstrap.min.css" rel="stylesheet"> -->
<link href="./css/custom2.css" rel="stylesheet">
<!-- <link href="../../css/bootstrap.min.css" rel="stylesheet"> -->
<link href="./css/register.css" rel="stylesheet">
<!-- <link href="../../css/picView_custom.css" rel="stylesheet"> -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script src="jquery.validate.js"></script>

<script type="text/javascript">
	$(function() {
		var cnt = 0;
		$('.FollowButton')
				.on('click',function() {
							var index2 = $('.FollowButton').index(this);

							if ($('.wholeInterestMask').eq(index2).attr('class') == 'wholeInterestMask hidden') {
								$('.wholeInterestMask').eq(index2).attr('class',
										'wholeInterestMask');
								$('.wholeInterestMask').eq(index2).css('display', 'block');
								$("input:checkbox[name='category_no']").eq(index2).prop(
										'checked', "checked");

								cnt++;
								if (cnt > 3) {
									alert('카테고리는 3개까지 선택가능합니다.');
									$('.wholeInterestMask').eq(index2).attr('class',
											'wholeInterestMask hidden');
									$('.wholeInterestMask').eq(index2).css('display', 'none');
									$("input:checkbox[id='category_no']").eq(index2).removeAttr(
											"checked");
									cnt--;
								}
							} else {
								$('.wholeInterestMask').eq(index2).attr('class',
										'wholeInterestMask hidden');
								$('.wholeInterestMask').eq(index2).css('display', 'none');
								$("input[name=category_no]:checkbox").eq(index2).removeAttr(
										"checked");

								cnt--;
							}

						});
	});
</script>

<title>가입하기</title>
</head>
<body>


	<!-- 헤더 -->
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>


<!-- 컨텐츠 -->
	<div class="center">
		<div class="register">
			<h1>가입하기</h1>
			<br> <br>
		</div>
		<form:form action="insertForm" commandName="memberCommand"
			method="post">
			<div class="contents">
				<!-- 가입폼 -->
				<div id="register_area" class="center_left col-xs-7 col-lg-7">
					<div id="name_area" class="form-group col-xs-3 col-lg-5 col-sm-5">
						<form:input path="name" type="text" class="form-control"
							placeholder="이름" name="name" />
						<form:errors path="name"></form:errors>

					</div>


					<div id="email_area" class="form-group col-xs-7 col-lg-7 col-sm-7">

						<form:input path="id" type="email" class="form-control "
							placeholder="이메일 형식의 아이디" name="id" />
						<form:errors path="id"></form:errors>
						</div>

					<div id="pass_area" class="form-group col-xs-5 col-lg-5 col-sm-5">

						<form:input path="password" type="password" class="form-control"
							placeholder="비밀번호" name="pass" />
						<form:errors path="password"></form:errors>

					</div>

					<div class="selectbox">
						<div class="birth">
							<form:select path="year" id="year" name="year"
								class="form-control col-sm-2 col-lg-2">
								<option value="" />년도
									<%
									for (int i = 2015; i >= 1920; i--) {
								%>

								<form:option value="<%=i%>"><%=i + "년"%></form:option>
								<form:errors path="year"></form:errors>
								<%
									}
								%>

							</form:select>
							<form:errors path="day"></form:errors>
						</div>

						<div class="birth">
							<form:select path="month" id="month" name="month"
								class="form-control col-sm-2 col-lg-2">
								<option value="" />월
									<%
									for (int i = 1; i < 13; i++) {
								%>
								<form:option value="<%=i%>"><%=i + "월"%></form:option>
								<form:errors path="month"></form:errors>
								<%
									}
								%>

							</form:select>
							
						</div>

						<div class="birth">
							<form:select path="day" id="day" name="day"
								class="form-control col-sm-2 col-lg-2">
								<option value="" />일
									<%
									for (int i = 1; i < 32; i++) {
								%>

								<form:option value="<%=i%>"><%=i + "일"%></form:option>
								<form:errors path="day"></form:errors>
								
								<%
									}
								%>
								
							</form:select>
						</div>
					</div>
					<br>
					<div class="form-group">
						<div id="gender_area" class="form-group col-sm-7 col-lg-7">
							&nbsp;&nbsp;
							<form:radiobutton path="gender" name="gender" value="남자" />
							남자&nbsp;&nbsp;&nbsp;&nbsp;
							<form:radiobutton path="gender" name="gender" value="여자" />
							여자
							<br>
							<form:errors path="gender"></form:errors>
						</div>
					</div>
				</div>


				<!-- 카테고리 -->

				<div id="category_area" class="row center_right col-xs-4 col-lg-4">
					<c:forEach var="category" items="${cateList}">

						<div class="col-sm-4 col-md-4">
							<div class="Interest Module FollowButton">
								<div class="wholeInterestMask hidden">
									<div class="check"></div>
									<div class="mask"></div>
								</div>
								<div class="interestWrapper" style="background-color: #403F14">
									<div class="interestImage"
										style="background-image: url('/picView_test/images/category/${category.category_img_add}')"></div>

									<div class="interestLabel">
										<h4>${category.category_name }
											<%-- <form:input path="category_no" type="checkbox" name="category_no" id="category_no"
												value="${category.category_no }" /> --%>
											<form:checkbox path="category_no" name="category_no"
												id="category_no" value="${category.category_no }" />
												
										</h4>
										
									</div>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>

				<!-- 로그인 버튼 -->
				<div class="login">
					<input type="submit" id="loginbutton" value="가입하기"
						class="btn btn-primary btn-lg">
				</div>

			</div>
		</form:form>
	</div>


</body>
</html>