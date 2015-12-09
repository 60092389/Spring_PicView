<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/recent_Pic.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<title>Insert title here</title>
<script src="../../js/jquery.min.js"></script>
<script src="./js/recent_Pic.js"></script>

</head>
<body>

    <div id="content">
    	<div>
			<div class="header">
		         <jsp:include page="../layout/header.jsp"></jsp:include>
		    </div>
		   <div class="contents">
		   	<input type="hidden" name="requestPage" id="requestPage">
	        <input type="hidden" name="totalCount" id="totalCount" value="">
		   	 <div class="fluid-centered">
		   	  <div class="title-row">
				<h3>최근사진</h3>
			  </div>
		      <div class="view photo-list-view"><!--사진보기  -->
		      	<!-- <div class="photo-list-photo-view" style="width: 514px; height: 315px; background-image: url('//c2.staticflickr.com/6/5801/21940322400_82e22556fb_z.jpg'); transform: translate(0px, 4px);">
		      			<div class="photo-list-photo-interaction">
		      				<div class="interaction-bar"  title="A ride with Charon 출처: Pietro Faccioli" >댓글,제목창 
		      					<div class="text">
									<a class="title" href="#" >A ride with Charon</a>
									<a class="attribution" href="#" > 출처: Pietro Faccioli </a>
								</div>
								<div class="tool">
									<a class="fave-area" href="#">
									<i class="fave-star"></i>
									<span class="icon-count">99+</span>
									</a>
								</div>
								<div class="tool">
									<a class="comment-area" href="#">
									<i class="comments"></i>
									<span class="icon-count">72</span>
									</a>
								</div>
		      				</div>제목,댓글창 끝 
		      			</div>
		      	</div> -->
				
		      	
		      	
				   
				</div>
				
				
		      </div><!--사진보기 끝  -->
		     </div>
		    <div class="footer" style="position: relative;">
					<jsp:include page="../layout/footer.jsp"></jsp:include>
				</div>
			</div>

		</div>


</body>
</html>