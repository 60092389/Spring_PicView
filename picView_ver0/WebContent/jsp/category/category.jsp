<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../category/js/main_menu2.js"></script>
<script src="../category/js/notipopup.js"></script>
<script src="../category/js/siteSecurity.js"></script>
<script src="../category/js/jquery.scrollUp.min.js"></script>
<link rel="stylesheet" type="text/css" href="../category/css/main_menu2.css" />
<link href="../category/css/custom2.css" rel="stylesheet">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../jsp/login/css/register7.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		var cnt = 0;
		$('.FollowButton')
				.on(
						'click',
						function() {
							var index2 = $('.FollowButton').index(this);

							if ($('.wholeInterestMask').eq(index2)
									.attr('class') == 'wholeInterestMask hidden') {
								$('.wholeInterestMask').eq(index2).attr(
										'class', 'wholeInterestMask');
								$('.wholeInterestMask').eq(index2).css(
										'display', 'block');
								$("input:checkbox[name='category_no']").eq(
										index2).prop('checked', "checked");

							
								}
							} else {
								$('.wholeInterestMask').eq(index2).attr(
										'class', 'wholeInterestMask hidden');
								$('.wholeInterestMask').eq(index2).css(
										'display', 'none');
								$("input[name=category_no]:checkbox")
										.eq(index2).removeAttr("checked");

						
							}

						});
	});
</script>
</head>
<body>
	<nav id="aside_menu">
	<div id="picture_menu" class="row center_right col-xs-4 col-lg-4">
		<c:forEach var="category" items="${cate_list}">

			<div id="picture" class="col-sm-4 col-md-4">
				<div class="Interest Module FollowButton">
					<div class="wholeInterestMask hidden">
						<div class="check"></div>
						<div class="mask"></div>
					</div>
					<div class="interestWrapper" style="background-color: #403F14">
						<div class="interestImage"
							style="background-image: url('../../upload/${category.category_img_add}')"></div>

						<div class="interestLabel">
							<h4>${category.category_name }
								<input type="checkbox" name="category_no" id="category_no"
									value="${category.category_no }" />
							</h4>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div id="search">
		<input id="search_btn" class="btn btn-primary" type="submit"
			value="검색">
	</div>


	<a href="#" id="menubutton"><img src="./imgs/menu_button2.PNG"
		alt=""></a> </nav>
</body>
</html>