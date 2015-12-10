<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%
	System.out.println("사진가져오니" + request.getAttribute("detail"));
	System.out.println("사진가져오니" + request.getAttribute("pic_list"));
	System.out.println("사진번호" + request.getParameter("pic_no"));
	
	String pic_no_comment = request.getParameter("pic_no");
%>
<title>상세보기</title>

<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="css/picDetail.css" rel="stylesheet">
<link href="css/pic_slider.css" rel="stylesheet">

</head>
<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="./js/pic_detail.js"></script>
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
					
					<c:forEach var="pic_list" items="${pic_list }" >
		            <div style="display: none;">
		            	<img data-u="image" src="../../upload/${pic_list.pic_add }" />
		                <img data-u="thumb" src="../../upload/${pic_list.pic_add }" name="${pic_list.pic_no }" />
		            </div>
		            </c:forEach>
		         	           
		        </div>
		       
		        
		        <!-- Thumbnail Navigator -->
		        <div u="thumbnavigator" class="jssort03" style="position:absolute;left:0px;bottom:0px;width:900px;height:60px;" data-autocenter="1">
		            <div style="position: absolute; top: 0; left: 0; width: 100%; height:100%; background-color: #000; filter:alpha(opacity=30.0); opacity:0.3;"></div>
		            <!-- Thumbnail Item Skin Begin -->
		            <div u="slides" style="cursor: default;">
		                <div u="prototype" class="p">
		                    <div class="w">
		                        <div u="thumbnailtemplate" class="t"></div>
		                    </div>
		                  <a href="#"><div class="c"></div></a>
		                </div>
		            </div>
		            <!-- Thumbnail Item Skin End -->
		        </div>
		        
		        <!-- Arrow Navigator -->
		        <span data-u="arrowleft" class="jssora02l" style="top:123px;left:8px;width:55px;height:55px;" data-autocenter="2"></span>
		        <span data-u="arrowright" class="jssora02r" style="top:123px;right:8px;width:55px;height:55px;" data-autocenter="2"></span>
		        
		    </div><!-- 사진 슬라이드 끝 -->
		</div>
	  </div>
	  <div  class="view sub-photo-view"><!-- 하단정보  -->
	     <div class="sub-photo-container centered-content">
	       <div class="view sub-photo-left-view"><!-- 왼쪽 상세보기 시작  -->
	         <div class="view attribution-view clear-float photo-attribution">
				  <div class="avatar person medium" style="background-image: url(../../upload/${memInfo.mem_pic});"></div>
				  <!-- //c2.staticflickr.com/8/7329/buddyicons/51919822@N05_l.jpg?1383412877#51919822@N05 -->
				  <div class="attribution-info">
				  	<a class="owner-name truncate" title="Vincent Ting 님의 포토스트림으로 이동" href="/photos/formosating/" >
					${memInfo.mem_name }
				  	</a>
				  	<div class="view follow-view clear-float photo-attribution">
				  		<span class="relationship">
						<button id="follow_btn" class="btn btn-default btn-lg btn-primary">
							<span class="glyphicon glyphicon-plus">팔로우</span>
						</button>
						<input type="hidden" name="pic_no" value="${pic_no }">
						<button id="good_btn" class="btn btn-default btn-lg btn-warning">
							<span class="glyphicon glyphicon-thumbs-up">좋아요</span>							
						</button>
						</span>
				  	</div>
				  </div>
			  </div>
			  <div class="view sub-photo-title-desc-view">
			   <div class="title-desc-block showFull">
			     <h1 class=" meta-field photo-title ">${detail.pic_title }</h1>
			   </div>
			  </div>
			  <div class="view sub-photo-fave-view faves-present">
			  	<div class="faved-by">
			  		<div class="initial-faved-by-display">
			  			<h3 id="category_name"><b>카테고리명</b></h3>
			  			<button type="button" class="btn btn-info">${category_name }</button>
			  		</div>
			  	</div>
			  </div>
			  <div class="view sub-photo-comments-view">
			  	<div class="comments-holder order-chronological photosInComments">
			  		<ul class="comments">
			  			
			  			
			  		</ul>
			  			<div class="comments-form">
			  				<div class="comment-icon circle-icon">
			  					<img width="32" height="32" src="https://s.yimg.com/pw/images/buddyicon05_m.png#136434429@N02">
			  				</div>
			  				<div class="comment-form-field">
			  					<textarea class="new-comment-text" id="rep_content" name="rep_content"></textarea>
								<div class="comment-arrow"></div>
								<textarea class="false-comment-content"></textarea>
								<input type="hidden" name="pic_no" id="pic_no" value="<%=pic_no_comment%>">
								
			  				</div>
			  				
			  			</div>
			  			<button class="ui-button ui-button-cta comment">덧글</button>
			  	</div>
			  </div>
			</div><!-- 왼쪽 상세정보보기 끝  -->
			<div class="view sub-photo-right-view"><!-- 오른쪽 상세정보 보기 --> 
				<div class="sub-photo-right-row1" >
					<div class="view sub-photo-right-stats-view">
						<div class="view-count">
							<span class="view-count-label">${detail.pic_count+1 }</span>
							<span class="stats-label">뷰</span>
						</div>
						<div class="fave-count">
							<span class="fave-count-label">${detail.good_count }</span>
							<span class="stats-label">좋아요</span>
						</div>
						<div class="comment-count">
							<span class="comment-count-label">${rep_count }</span>
							<span class="stats-label">댓글</span>
						</div>	
					</div>
					<div class="view sub-photo-date-view">
						<div class="date-taken clear-float ">
							<span class="date-taken-label" title="업로드 날짜"> <fmt:formatDate value="${detail.pic_date }" pattern="yyyy"/>년 <fmt:formatDate value="${detail.pic_date }" pattern="M"/>월 <fmt:formatDate value="${detail.pic_date }" pattern="dd"/>일에 업로드 </span>
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
				
				<div class="view sub-photo-additional-info-view">
					<div class="additional-info">
						<h3><b>추가 정보</b></h3>
						${detail.pic_content }
						
						<c:if test="${detail.pic_location !=null }">
							<h3><b>지도</b></h3>
							
							<div id="staticMap" style="width:500px;height:300px;"></div>    
	
							<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=a84bb7aaf8c647c9e16659327c2f833c"></script>
							
							
							<script>
							// 이미지 지도에서 마커가 표시될 위치입니다 
							var location1 = "${detail.pic_location }";
							var location_chk = location1.split(',');
							var latitude = location_chk[0];
							var longtitude = location_chk[1];
							var markerPosition  = new daum.maps.LatLng(latitude,longtitude); 
							
							// 이미지 지도에 표시할 마커입니다
							// 이미지 지도에 표시할 마커는 Object 형태입니다
							var marker = {
							    position: markerPosition
							};
							
							var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
							    staticMapOption = { 
							        center: new daum.maps.LatLng(latitude,longtitude), // 이미지 지도의 중심좌표
							        level: 3, // 이미지 지도의 확대 레벨
							        marker: marker // 이미지 지도에 표시할 마커 
							    };    
							
							// 이미지 지도를 생성합니다
							var staticMap = new daum.maps.StaticMap(staticMapContainer, staticMapOption);
							</script>
						</c:if>
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
				
				<div class="view sub-photo-tags-view">
					<div class="view sub-photo-tags-tag-view ">
						<h3 class="tag-section-header">태그</h3>
						<span class="autotags-helper">
							<i class="autotags-helper-icon"></i>
						</span>
						<ul class="tags-list">
							<c:set var="tag_list" value="${tag_list }"/>							
							<c:set var="tag" value="${fn:split(tag_list, ',') }"/>
							<c:forEach var="tag" items="${tag }" >
								<li class="tag" >
									<a class="remove-tag" href="#" >
										<i class="delete-tag" title="삭제"></i>
									</a>
									<a title="${tag }" href="/search/?tags=${tag }" >${tag }</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>	
				
			</div><!-- 오른쪽 상세보기 끝 -->
		 </div>
	  </div><!-- 하단정보끝 --> 
	</div>

	<script type="text/javascript" src="js/jssor.slider-20.mini.js"></script>
	<script type="text/javascript" src="js/pic_slider.js"></script>
	<!-- <script type="text/javascript" src="js/picDetail.js"></script> -->
	
	<script type="text/javascript">
	$(function() {
		var this_pic = ${pic_no};
		var good_count = ${findGood };
		var alb_count = ${alb_count};
		
		$.ajax({
			type: 'get',
			url: 'picGood_print?pic_no=' + this_pic,
			//data: $('#test').serialize(),
			dataType: 'json',
			success:function(data) {
				
				$('.fave-count').empty();
				
				var good_count_txt = '';
				
				good_count_txt += '<span class="fave-count-label">' + data.good_count + '</span>';
				good_count_txt += '<span class="stats-label">좋아요</span>';
									
				$('.fave-count').append(good_count_txt);
			}
		});
		
		if(good_count == 1){
			$('#good_btn').attr('class', 'btn btn-default btn-lg btn-success');
		} else {
			$('#good_btn').attr('class', 'btn btn-default btn-lg btn-warning');
		}
			
		$('.jssora02l').click(function(){
				location.href = "picDetail?pic_no=" + (this_pic - 1);
		});
		
		$('.jssora02r').click(function(){
			location.href = "picDetail?pic_no=" + (this_pic + 1);
		});
		
		var select_pic;
		$('.c').each(function(index, item){
			select_pic = $('.c').parents().find('.w').find('img').eq(index).attr('name');
			
			$('.p').find('a').eq(index).attr('href', 'picDetail?pic_no='+select_pic);
		});
		
		$('#good_btn').click(function(){
			//location.href = "picGood_In?pic_no=" + this_pic;

			if(good_count == 0){
				good_count = 1;
				$('#good_btn').attr('class', 'btn btn-default btn-lg btn-success');
			} else {
				good_count = 0;
				$('#good_btn').attr('class', 'btn btn-default btn-lg btn-warning');
			}
			
			$.ajax({
				type: 'get',
				url: 'picGood_In?pic_no=' + this_pic,
				//data: $('#test').serialize(),
				dataType: 'json',
				success:function(data) {
					
					$('.fave-count').empty();
					
					var good_count_txt = '';
					
					good_count_txt += '<span class="fave-count-label">' + data.good_count + '</span>';
					good_count_txt += '<span class="stats-label">좋아요</span>';
										
					$('.fave-count').append(good_count_txt);
				}
			});
		});
				
		if(alb_count == 0) {		
			
			$('.sub-photo-context').empty();
			
			var noAlbum = '';
			
			noAlbum += '<div id="noAlbum">';
			noAlbum += '<h3>이 사진은 현재 아무 앨범에도 속해있지 않습니다.<h3>';
			noAlbum += '</div>';
			
			$('.sub-photo-context').append(noAlbum);
		} else {
		
			 $.ajax({
				type: 'get',
				url: 'findAlbum?pic_no=' + this_pic,
				dataType: 'json',
				error: function(){
					alert('실패');
				},
				success:function(data) {
					$('.sub-photo-context').empty();
				
					var album = '';
				
					album += '<h5 class="total"> 이 사진은' + alb_count + '개의 앨범에 있습니다. </h5>';
					album += '<ul class="context-list">';
					
					$.each(data, function(index, album2){
						album += '<li data-context-id="72157624542431329">';
						album += "<a class='thumbnail' style='background-image: url(../../upload/" + album2.pic_add + ");' href='/photos/formosating/albums/72157624542431329'></a>";
						album += '<span class="title">';
						album += '<a href="/photos/formosating/albums/72157624542431329" data-rapid_p="362">' + album2.alb_name + '</a>';
						album += '</span><span class="counts">' + album2.alb_pic_count + '</span></li>';
					
					});
					
					album += '</ul>';
					
					$('.sub-photo-context').append(album);
				}
			}); 
		}

	});
	</script>
	
</body>
</html>