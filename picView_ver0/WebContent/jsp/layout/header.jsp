<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.net.URLEncoder" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- <script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
Bootstrap
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/kfonts2.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet"> -->


<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<!--Bootstrap -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="../main/css/activity.css" rel="stylesheet">
<script src="../main/js/activity.js"></script>
<!-- <script src="../../jsp/layout/js/alarm.js"></script> -->

<script type="text/javascript">
	
$(function(){
  $('.alarm').click(function(){
       index_chk = 0;
      
       $('.notification-count').html(0);
       if($('#fbNotificationsFlyout').css('display') =='block'){
          $('#fbNotificationsFlyout').css('display','none');
       }else{
          $('#fbNotificationsFlyout').css('display','block');
   	 	 }
    	   
  	 });
	});
	
	
	function logout(){
		alert("로그 아웃 되었습니다.");
		location.href="../login/logout";
	}
	var tag = 'text';
	
	/* 모두, 태그, 카테고리별 검색창 클릭 */
	$(function() {
		$('.search-in-button').click(function() {
			tag = $(this).attr('value');
		});
		
		$('#searchButton').click(function() {
			//인코딩
			var search = encodeURI($('#search').val());
			location.href="../../jsp/search/search.jsp?search="+search;
		})
	})
	
	var dataM=1, dataF=1, dataT=1;
	/* 검색창 ajax */ 
	function searchButton(){
		var html1 = "";
		$('#search').attr('value', search);

 		var html = "<div class='main search-contacts-results'>";
 		html += "<div class='view search-photos-yours-view' style='height:268px'>";
 	   	html += "<h5 class='search-results-header' id='explan'>";
		html +=	"<a class='view-more-link member' data-track='search-viewall-user' "+
		" data-rapid_p='47'>모두 보기</a>회원님의 사진</h5>";
		
	 $.getJSON("search",{search:encodeURIComponent(search),tag:encodeURIComponent(tag)},function(data){
		 $('#member').empty();
		 //검색된 값 없으면 아예 출력x
		 if(data==0){
			 dataM = data;
			 html="";	
		 }
		  $.each(data,function(index,pic){
				
			  //사진 붙는곳
				html += "<div class='view photo-list-photo-view awake'>";
				html += "<div class='interaction-view'>";
				html += "<div class='photo-list-photo-interaction'>";
				html += "<a class='overlay' href='../../jsp/basic/picDetail?pic_no="+pic.pic_no+ "&search=" + search + "'>"+
					"<img class='picture' src='../../upload/"+pic.pic_add+"'></a>";

				html += "<div class='view photo-list-view'>";
				html += "<div class='interaction-bar'>";
				html += "<div class='text'>";
				html += "<a class='title' href='#'>"+ pic.pic_title+ "</a>";
				html += "<a class='attribution' href='../../jsp/myRoom/myShowForm"+pic.mem_no+"'>회원님에 의해!</a></div>";

				html += "<div class='tool'>";
				html += "<a class='fave-area' href='#'></a>";
				html += "<span class='glyphicon glyphicon-star-empty'>"+ pic.good_count+ "</span>";
			 	html += "<i class='fave-star fave can-not-fave'></i></a></div>";

				html += "<div class='tool'>";
				html += "<a class='comment-area' href='#'></a>";
				html += "<span class='glyphicon glyphicon-comment'>"+pic.count_rep_no+"</span>";
				html += "<i class='fave-star fave can-not-fave'></i></a></div>";
				
				html += "</div></div></div></div></div>";
			}); 
		 	
		  html+="</div></div>";
		 
		  
		  $('#member').append(html);
		});
	 
	 	//팔로우한 사람 사진
		var html3 = "<div class='main search-contacts-results'>";
		html3 += "<div class='view search-photos-yours-view' style='height:268px'>";
	   	html3 += "<h5 class='search-results-header' id='explan'>";
		html3 +=	"<a class='view-more-link follow' data-track='search-viewall-user' "+
		"data-rapid_p='47'>모두 보기</a>팔로우하는 사람이 올린 사진</h5>";

	 $.getJSON("searchFollow",{search:encodeURIComponent(search),tag:encodeURIComponent(tag)},function(data){
		 $('#follow').empty();
		
		 if(data==0){
			 dataF = data;
			 console.log('팔로우 사진 없어!!'+dataF);
			html3="";	
		 }
		  $.each(data,function(index,pic){

			  //사진 붙는곳
			    html3 += "<div class='view photo-list-photo-view awake'>";
				html3 += "<div class='interaction-view'>";
				html3 += "<div class='photo-list-photo-interaction'>";
				html3 += "<a class='overlay' href='../../jsp/basic/picDetail?pic_no="+pic.pic_no+ "&search=" + search + "'>"+
					"<img class='picture' src='../../upload/"+pic.pic_add+"'></a>";

				html3 += "<div class='view photo-list-view'>";
				html3 += "<div class='interaction-bar'>";
				html3 += "<div class='text'>";
				html3 += "<a class='title' href='#'>"+ pic.pic_title+ "</a>";
				html3 += "<a class='attribution' href='../../jsp/myRoom/myShowForm"+pic.mem_no+"'>출처 : "+pic.mem_name+"</a></div>";

				html3 += "<div class='tool'>";
				html3 += "<a class='fave-area' href='#'></a>";
				html3 += "<span class='glyphicon glyphicon-star-empty'>"+ pic.good_count+ "</span>";
			 	html3 += "<i class='fave-star fave can-not-fave'></i></a></div>";

				html3 += "<div class='tool'>";
				html3 += "<a class='comment-area' href='#'></a>";
				html3 += "<span class='glyphicon glyphicon-comment'>"+pic.count_rep_no+"</span>";
				html3 += "<i class='fave-star fave can-not-fave'></i></a></div>";
				
				html3 += "</div></div></div></div></div>";
			}); 
		 	
		  html3+="</div></div>";
		 
		  
		  $('#follow').append(html3);
		});
	 	

		var html2 = "<div class='main search-photos-results'>";
		html2 += "<div class='view search-photos-everyone-view'>";
		html2 += "<h5 class='search-results-header' id='explan'>";
		html2 += "<a class='view-more-link' data-track='search-viewall'>"+
		"</a>모든 사진</h5>";
	 
		var count=[];
		
	 //모든 사진 불러오기
	 $.getJSON("searchTotal",{search:encodeURIComponent(search),tag:encodeURIComponent(tag)},function(data){
		 $('#all').empty();
		 //검색된 값 없으면 아예 출력x
		 if(data==0){
			 dataT = data;
			 html2="";	
		 }
		$.each(data,function(index,pic){
			 //사진 붙는곳
			    html2 += "<div class='view photo-list-photo-view awake'>";
				html2 += "<div class='interaction-view'>";
				html2 += "<div class='photo-list-photo-interaction'>";
				html2 += "<a class='overlay' href='../../jsp/basic/picDetail?pic_no="+pic.pic_no+ "&search=" + search + "'>"+
					"<img class='allPicture' src='../../upload/"+pic.pic_add+"'></a>";

				html2 += "<div class='view photo-list-view'>";
				html2 += "<div class='interaction-bar'>";
				html2 += "<div class='text'>";
				html2 += "<a class='title' href='#'>"+ pic.pic_title+"</a>";
				html2 += "<a class='attribution' href='../../jsp/myRoom/myShowForm"+pic.mem_no+"'>출처 : "+pic.mem_name+"</a></div>";

				html2 += "<div class='tool'>";
				html2 += "<a class='fave-area' href='#'></a>";
				html2 += "<span class='glyphicon glyphicon-star-empty'>"+ pic.good_count+ "</span>";
			 	html2 += "<i class='fave-star fave can-not-fave'></i></a></div>";

				html2 += "<div class='tool'>";
				html2 += "<a class='comment-area' href='#'></a>";
				html2 += "<span class='glyphicon glyphicon-comment'>"+pic.count_rep_no+"</span>";
				html2 += "<i class='fave-star fave can-not-fave'></i></a></div>";
				
				html2 += "</div></div></div></div></div>";
			}); 
		 	
		  html2+="</div></div>";
		  
		  $('#all').append(html2);
		  
		  /* if(dataM==0 && dataF==0 && dataT==0){
		 		html1 = "<div class='no-results-message'><h5 class='empty'>죄송합니다! "+search+" 와(과) 일치하는 항목이 없습니다.</h5>"+
		 		"<h5 class='empty' id='message'>검색 범위를 확대해 보세요.</h5></div>";
		 		console.log('값없음');
		 	}
		 	$('#member').append(html1); */
		});   
	 }
	
</script>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default navbar-fixed-top navnav" role="navigation">
			<div class="container header-container">
		<!-- 비회원일 경우 -->
	  <c:if test="${authInfo.mem_no == null }">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div id="logo">
					<a href="../index/index.jsp"><img id="logo" src="../../images/logo.jpg"></a>
				</div>
			</div>

			<!-- 비회원 -->
			<div class="collapse navbar-collapse navbar-ex1-collapse row">
				<ul class="nav navbar-nav">

					<li><a href="../jsp/collection/recent_Pic.jsp">모아보기</a></li>
					<li><a href="#">도움말</a></li>
					<li style="width: 360px">&nbsp;</li>

					<li class="searchList" id="searchList">

					<div id="searchForm">	
			   	    	<input role="search" id="search" name="search" type="text" class="form-control" placeholder="검색">
					
					</div>
					 <button id="searchButton" class="btn btn-default" onclick="searchButton()">검색</button>
					</li> 
					<li><a href="#" class="upload-padding"><span id="upload"
							class="glyphicon glyphicon-cloud-upload"></span></a></li>
					<li><a href="../login/loginForm.jsp">로그인</a></li>
					<li><a href="../login/insertForm">가입</a></li>
				</ul>
				
			</div> 
			<!-- 비회원 끝 -->
		</c:if>
	
		<!-- 로그인했을 경우 -->
		<c:if test="${authInfo.mem_no != null }">
		 <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
	          <span class="sr-only">Toggle navigation</span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <div id="logo">
					<a href="../main/loginMain.jsp"><img id="logo" src="../../images/logo.jpg"></a>
				</div>
	      </div> -->

			<!-- 회원메뉴 시작 -->
				 <div class="collapse navbar-collapse navbar-ex1-collapse row">
	        <ul class="nav navbar-nav">
	          <li><a class="dropdown dropdown-toggle active" href="#" data-toggle="dropdown"
	          aria-haspopup="true" aria-expanded="true">
	          		내공간<span class="caret"></span></a>
	          	<ul class="dropdown-menu" role="menu">
	          		<li><a href="../myRoom/manageForm">내사진 관리</a></li>
	          		<li><a href="../myRoom/myShowForm${authInfo.mem_no }">보여주기</a></li>
	          		<li><a href="../myRoom/my_album${authInfo.mem_no }">앨범</a></li>
	          		<li><a href="../myRoom/my_Follow${authInfo.mem_no }">친구목록</a></li>
	          		<li><a href="../myRoom/my_Analysis">유입분석</a></li>
	          		<li><a href="#">프로필</a></li>
	          	</ul>
	          </li>
	          <li><a class="dropdown active" href="#" data-toggle="dropdown">
	          		둘러보기<span class="caret"></span></a>
	          	<ul class="dropdown-menu" role="menu">
	          		<li><a href="../collection/recent_Pic.jsp">최근사진</a></li>
	          		<li><a href="../category/category_list">카테고리별</a></li>
	          	</ul>
	          </li>
	          <li style="width:350px">&nbsp;</li>
	          
	          <li class="searchList" id="searchList">
	          	<div id="searchForm">	
			   	    	<input role="search" id="search" name="search" type="text" class="form-control" placeholder="검색">
					
							</div>
					 		<button id="searchButton" class="btn btn-default" onclick="searchButton()">검색</button>
	          </li>
	          
	          <li class="alarm"><a href="#"><span id="alarm"
                     class="glyphicon glyphicon-bell"></span>
                     <!-- <span class="glyphicon glyphicon-comment notification-icon icon-comment" aria-hidden="">
                     <span class="notification-count" data-role="notification-count">0</span> -->
                     </span>
                     </a>
                  <div id="fbNotificationsFlyout" class="__tw _4xi1 uiToggleFlyout" style="display:none">
                     
                  
                     <div class="uiHeader uiHeaderBottomBorder jewelHeader" >
                     <input type="hidden" name="totalCount_activity" id="totalCount_activity" value=""> 
                     <input type="hidden" name="wri_date_year" id="wri_date_year" value="">
                           <div class="clearfix uiHeaderTop">
                              <h4 class="uiHeaderTitle">알림</h4>
                           </div>
                     </div>
                     <div id="activity_div" >
                          <ul class="activity_ul">
                         </ul>   
                     </div>
                  </div>      
           </li>
	          
	          <li><a href="../upload/fileUpload" class="upload-padding"><span id="upload"
							class="glyphicon glyphicon-cloud-upload"></span></a></li>
	          <li><a class="dropdown active account-padding" href="#" data-toggle="dropdown">
	          	계정<span class="caret"></span></a>
	          	<ul class="dropdown-menu" role="menu">
	          		<li><a href="../message/message">쪽지함</a></li>
	          		<li><a onclick="logout()">로그아웃</a></li>
	          	</ul>
	          </li>
	        </ul>
	        
	      </div> -->
	      <!-- 회원메뉴 끝 -->
			</c:if>
		</div>

		</nav>
	</div>

</body>
</body>
</html>