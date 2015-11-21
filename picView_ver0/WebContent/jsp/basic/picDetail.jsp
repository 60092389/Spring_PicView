<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>

<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="css/picDetail.css" rel="stylesheet">
<link href="css/pic_slider.css" rel="stylesheet">


</head>
<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>

	<div class="contents">
	
	  <div class="view photo-well-scrappy-view">	
		<div class="height-controller enable-zoom" style="height: 430px;">
			<div id="jssor_1" style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 900px; height: 600px; overflow: hidden; visibility: hidden;">사진 슬라이드 
		        Loading Screen
		        <div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
		            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
		            <div style="position:absolute;display:block;background:url('img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
		        </div>
		        <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 900px; height: 600px; overflow: hidden;">
		            <div style="display: none;">
		                <img data-u="image" src="img/002.jpg" />
		                <img data-u="thumb" src="img/thumb-002.jpg" />
		            </div>
		            <div style="display: none;">
		                <img data-u="image" src="img/003.jpg" />
		                <img data-u="thumb" src="img/thumb-003.jpg" />
		            </div>	
		            <div style="display: none;">
		                <img data-u="image" src="img/004.jpg" />
		                <img data-u="thumb" src="img/thumb-004.jpg" />
		            </div>
		           
		        </div>
		        
		        Thumbnail Navigator
		        <div u="thumbnavigator" class="jssort03" style="position:absolute;left:0px;bottom:0px;width:900px;height:60px;" data-autocenter="1">
		            <div style="position: absolute; top: 0; left: 0; width: 100%; height:100%; background-color: #000; filter:alpha(opacity=30.0); opacity:0.3;"></div>
		            Thumbnail Item Skin Begin
		            <div u="slides" style="cursor: default;">
		                <div u="prototype" class="p">
		                    <div class="w">
		                        <div u="thumbnailtemplate" class="t"></div>
		                    </div>
		                    <div class="c"></div>
		                </div>
		            </div>
		            Thumbnail Item Skin End
		        </div>
		        Arrow Navigator
		        <span data-u="arrowleft" class="jssora02l" style="top:123px;left:8px;width:55px;height:55px;" data-autocenter="2"></span>
		        <span data-u="arrowright" class="jssora02r" style="top:123px;right:8px;width:55px;height:55px;" data-autocenter="2"></span>
		        
		    </div><!-- 사진 슬라이드 끝 -->
		</div>
	  </div>
	  <div  class="view sub-photo-view"><!-- 하단정보  -->
	     <div class="sub-photo-container centered-content">
	       <div class="view sub-photo-left-view"><!-- 왼쪽 상세보기 시작  -->
	         <div class="view attribution-view clear-float photo-attribution">
				  <div class="avatar person medium" style="background-image: url(//c2.staticflickr.com/8/7329/buddyicons/51919822@N05_l.jpg?1383412877#51919822@N05);"></div>
				  <div class="attribution-info">
				  	<a class="owner-name truncate" title="Vincent Ting 님의 포토스트림으로 이동" href="/photos/formosating/" >
Vincent Ting
				  	</a>
				  	<div class="view follow-view clear-float photo-attribution">
				  		<span class="relationship">
						<button class="unfluid follow ui-button ui-button-icon">
						<span>팔로우</span>
						</button>
						</span>
				  	</div>
				  </div>
			  </div>
			  <div class="view sub-photo-title-desc-view">
			   <div class="title-desc-block showFull">
			     <h1 class=" meta-field photo-title ">Dizzy Sky , Mountain Hehuan 合歡山</h1>
			   		<h2 class=" meta-field photo-desc ">
			   		  <p>Copyright © Vincent Ting Photography. All rights reserved. Please don't use without my permission</p>
			   		</h2>
			   </div>
			  </div>
			  <div class="view sub-photo-fave-view faves-present">
			  	<a class="ui-icon-fave-star" href="#" title="좋음" ></a>
			  	<div class="faved-by">
			  		<div class="initial-faved-by-display">
			  			<a class="faved-by-person-link" href="/photos/88482742@N07/favorites/" data-rapid_p="267"> 님, Javier León (Fx) 님, </a>
							님,
							<a class="faved-by-person-link" href="/photos/nicofotog/favorites/" data-rapid_p="268"> 님, Nicofotog 님, </a>
							과
							<a class="remaining-faved-by" href="#" data-rapid_p="269"> 님, 731 님 등이</a>
							이 항목을 좋아함 
			  		</div>
			  	</div>
			  </div>
			  <div class="view sub-photo-comments-view">
			  	<div class="comments-holder order-chronological photosInComments">
			  		<div class="comments-more">
			  			<a href="#" data-rapid_p="83">43개의 이전 덧글 보기</a>
			  		</div>
			  		<ul class="comments">
			  			<li class="comment">
			  				<div class="comment-icon circle-icon ">
			  				 	<a data-action="follow" data-track="commentBuddyIconClick" href="/photos/34225448@N06/" data-person-nsid="34225448@N06" data-rapid_p="84">
									<img width="32" height="32" src="//c2.staticflickr.com/6/5616/buddyicons/34225448@N06.jpg?1413297268#34225448@N06">
								</a>
			  				</div>
			  				<p class="comment-author">
			  					<a data-action="follow" data-track="commentUserNameClick" href="/photos/34225448@N06/" data-rapid_p="85">Marcel</a>
								<span class="comment-date">3시간</span>
			  				</p>
			  				<div class="comment-content">Superbement irréel.</div>
			  			</li>
			  			<li class="comment">
			  				<div class="comment-icon circle-icon ">
			  				 	<a data-action="follow" data-track="commentBuddyIconClick" href="/photos/34225448@N06/" data-person-nsid="34225448@N06" data-rapid_p="84">
									<img width="32" height="32" src="//c2.staticflickr.com/6/5616/buddyicons/34225448@N06.jpg?1413297268#34225448@N06">
								</a>
			  				</div>
			  				<p class="comment-author">
			  					<a data-action="follow" data-track="commentUserNameClick" href="/photos/34225448@N06/" data-rapid_p="85">Marcel</a>
								<span class="comment-date">3시간</span>
			  				</p>
			  				<div class="comment-content">Superbement irréel.</div>
			  			</li>
			  			
			  		</ul>
			  			<div class="comments-form">
			  				<div class="comment-icon circle-icon">
			  					<img width="32" height="32" src="https://s.yimg.com/pw/images/buddyicon05_m.png#136434429@N02">
			  				</div>
			  				<div class="comment-form-field">
			  					<textarea class="new-comment-text" data-action="comment" data-tutorial="Enter를 누르면 게시되고 Shift+Enter를 누르면 새로운 줄이 생깁니다." data-notutorial="덧글 추가" placeholder="덧글 추가" name="comment"></textarea>
								<div class="comment-arrow"></div>
								<textarea class="false-comment-content"></textarea>
			  				</div>
			  			</div>
			  	</div>
			  </div>
			</div><!-- 왼쪽 상세정보보기 끝  -->
			<div class="view sub-photo-right-view"><!-- 오른쪽 상세정보 보기 --> 
				<div class="sub-photo-right-row1" >
					<div class="view sub-photo-right-stats-view">
						<div class="view-count">
							<span class="view-count-label"> 13,564</span>
							<span class="stats-label">뷰</span>
						</div>
						<div class="fave-count">
							<span class="fave-count-label"> 752 </span>
							<span class="stats-label">좋음</span>
						</div>
						<div class="comment-count">
							<span class="comment-count-label"> 63</span>
							<span class="stats-label">덧글</span>
						</div>	
					</div>
					<div class="view sub-photo-date-view">
						<div class="date-taken clear-float ">
							<span class="date-taken-label" title="2015년 10월 14일에 업로드"> 2015년 9월 18일에 촬영 </span>
						</div>
					</div>
					<div class="view photo-license-view">
						<div class="photo-license-info">
							<a class="photo-license-url" target="_newtab" rel="license cc:license" href="https://help.yahoo.com/kb/flickr/SLN25525.html?impressions=true" data-rapid_p="56">
							<i class="ui-icon-tiny-0cc"></i>
							<i class="ui-icon-tiny-copyright"></i>
							<span> All Rights Reserved </span>
							</a>
						</div>
					</div>
					
				</div>
				<div class="view sub-photo-contexts-view">
					<div class="view sub-photo-albums-view">
						<div class="sub-photo-context sub-photo-context-albums">
							<h5 class="total"> 이 사진은 2개의 앨범에 있습니다. </h5>
							<ul class="context-list">
								<li data-context-id="72157624542431329">
									<a class="thumbnail" style="background-image: url('//c2.staticflickr.com/4/3917/14720852508_720051fbf5_t.jpg');" href="/photos/formosating/albums/72157624542431329"></a>
									<span class="title">
										<a href="/photos/formosating/albums/72157624542431329" data-rapid_p="362">Explore</a>
									</span>
									<span class="counts"> 304개의 항목 </span>
									
								</li>
								<li data-context-id="72157624542431329">
									<a class="thumbnail" style="background-image: url('//c2.staticflickr.com/4/3917/14720852508_720051fbf5_t.jpg');" href="/photos/formosating/albums/72157624542431329"></a>
									<span class="title">
										<a href="/photos/formosating/albums/72157624542431329" data-rapid_p="362">Explore</a>
									</span>
									<span class="counts"> 304개의 항목 </span>
									
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="view sub-photo-additional-info-view">
					<div class="additional-info">
						<h3>추가 정보</h3>
						asdfasdf<br>
						asdfasd
					</div>
				</div>
				<div class="view sub-photo-tags-view">
					<div class="view sub-photo-tags-tag-view ">
						<h3 class="tag-section-header">태그</h3>
						<span class="autotags-helper">
							<i class="autotags-helper-icon"></i>
						</span>
						<ul class="tags-list">
							<li class="tag" >
								<a class="remove-tag" href="#" >
								<i class="delete-tag" title="삭제"></i>
								</a>
								<a title="sunset" href="/search/?tags=sunset" >sunset</a>
							</li>
							<li class="tag" >
								<a class="remove-tag" href="#" >
								<i class="delete-tag" title="삭제"></i>
								</a>
								<a title="sunset" href="/search/?tags=sunset" >sunset</a>
							</li>
							
						</ul>
					</div>
				</div>	
				
			</div><!-- 오른쪽 상세보기 끝 -->
		 </div>
	  </div><!-- 하단정보끝 --> 
	</div>
	<div class="footer" class="footer-full-view">
     	<jsp:include page="../layout/footer.jsp"></jsp:include>     	
  </div>

	<script type="text/javascript" src="js/jssor.slider-20.mini.js"></script>
	<script type="text/javascript" src="js/pic_slider.js"></script>    
</body>
</html>