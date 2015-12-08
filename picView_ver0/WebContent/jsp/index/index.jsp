<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>


<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="css/index.css" rel="stylesheet">
<!-- Bootstrap -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="/picView_ver0/jsp/index/css/index.css" rel="stylesheet">


</head>
<body>

	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<div class="contents">
		<div class="content">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">

				<!--페이지-->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
					<li data-target="#myCarousel" data-slide-to="4"></li>
				</ol>
				<!--페이지-->

				<div class="carousel-inner">
					<!--슬라이드1-->
					<div class="item active">
						<img src="../../images/main/main_1.JPG"
							style="width: 100%; height: 560px" alt="First slide">

						<div class="container">
							<div class="carousel-caption">
								<!-- <h1>사진을 마음껏 공유하세요</h1> -->

							</div>
						</div>
					</div>
					<!--슬라이드1-->

					<!--슬라이드2-->
					<div class="item">
						<img src="../../images/main/background_01.jpg"
							style="width: 100%; height: 560px" data-src="" alt="Second slide">
						<div class="container">
							<div class="carousel-caption">
								<!-- <h1>사진을 모아 자신만의 앨범을 만드세요</h1> -->

							</div>
						</div>
					</div>
					<!--슬라이드2-->

					<!--슬라이드3-->
					<div class="item">
						<img src="../../images/main/background_02.jpg"
							style="width: 100%; height: 560px" data-src="" alt="Third slide">
						<div class="container">
							<div class="carousel-caption">
								<!-- <h1>다른 사람의 사진들을 구경하고 두고두고 보세요</h1> -->

							</div>
						</div>
					</div>
					<!--슬라이드3-->
					<!--슬라이드3-->
					<div class="item">
						<img src="../../images/main/main_4.jpg"
							style="width: 100%; height: 560px" data-src="" alt="Third slide">
						<div class="container">
							<div class="carousel-caption">
								<!-- <h1>Slide 3</h1> -->

							</div>
						</div>
					</div>
					<!--슬라이드3-->
					<!--슬라이드3-->
					<div class="item">
						<img src="../../images/main/background_03.jpg"
							style="width: 100%; height: 560px" data-src="" alt="Third slide">
						<div class="container">
							<div class="carousel-caption">
								<!-- <h1>Slide 3</h1> -->

							</div>
						</div>
					</div>
					<!--슬라이드3-->
				</div>


				<!--이전, 다음 버튼-->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"><span
					class="glyphicon glyphicon-chevron-left"></span></a> <a
					class="right carousel-control" href="#myCarousel" data-slide="next"><span
					class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
		<!-- contents끝 -->
		<div class="footer">
			<div class="bucket01">
				<div class="bucket01_stack"></div>
				<div class="centered">
					<h3>사진을 다시 삭제하지 마세요.</h3>
					<p>1,000GB의 사진 저장 공간이 무료로 제공됩니다. 전체 컬렉션 자동 백업도 가능합니다.</p>
				</div>
			</div>
			<div class="bucket02">
				<div class="centered02">
					<h3>어디에서나 사진을 볼 수 있습니다.</h3>
					<p>어디에 있든지 사진을 항상 확인할 수 있습니다. 수상 경력에 빛나는 앱으로 보고 편집하고 공유하세요.</p>
					<div class="platforms">
						<div class="platform-apple"></div>
						<div class="platform-android"></div>
						<div class="platform-mac"></div>
						<div class="platform-windows"></div>
					</div>
				</div>
			</div>
			<div class="bucket03">
				<div class="centered">
					<h3>검색의 눈부신 발전</h3>
					<p>사진 검색을 통해 놀라운 발전을 이루었습니다. 이제 원하는 사진을 신속하고 쉽게 찾을 수 있습니다.</p>
				</div>
			</div>
		</div>

		<div class="inspiration-bucket">
			<div class="copy">
				<h3>놀라운 영감</h3>
				<p>아마추어 사진작가와 전문 사진작가로 구성된 커뮤니티에서 공유되고 있는 아름다운 사진을 찾아보세요.</p>

			</div>
		</div>
		<div class="bottom-bucket">
			<div class="background"></div>
			<div class="not-quite-centered">
				<h3>사진을 마음껏 저장하세요.</h3>
				<p>전 세계 어디서나 어떤 장치를 사용하든 간에 사진을 업로드, 액세스, 정리, 편집, 공유할 수 있습니다.</p>
				<br>
				<br>
				<!-- <center><a class="medium-ass butt" data-track="signup-bottom" href="/signup" data-rapid_p="42">야후 계정 만들기</a></center> -->
			</div>
		</div>
	</div>



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../../js/bootstrap.min.js"></script>
	<script>
		$('.carousel').carousel()
	</script>

</body>
</html>