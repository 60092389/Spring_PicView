<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.net.URLDecoder" %>

<%
		String search = URLDecoder.decode(request.getParameter("search"),"UTF-8");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 
<script src="js/arrayList.js"></script>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="css/search.css" rel="stylesheet">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<title>검색</title>
<script type="text/javascript">

	var search = "<%=search%>";
	var tag = 'text';
	
	window.onload = function() {
		$('.interaction-bar').css('display', 'none');
	}
	
	
	$(function() {
		$('.pictureLink').click(function() {
			location.href="../../jsp/search/search.jsp?search=" + search;
		});
		
		$(document).on('mouseover', '.photo-list-photo-view', function() {
			$(this).find('.interaction-bar').css('display', 'inline-blcok');
		}).on('mouseout', function() {
			$('.interaction-bar').css('display', 'none');
		});
		
		
		$('.peopleLink').click(function() {
			location.href="../../jsp/search/searchPeople.jsp?search=" + search;
		});
		
		
		$(document).on('click', '.view-more-link.member', function() {
			location.href="../../jsp/search/detailSearch.jsp?search=" +search+"&check=member";
		});
		
		$(document).on('click', '.view-more-link.follow', function() {
			location.href="../../jsp/search/detailSearch.jsp?search=" +search+"&check=follow";
		});
		
		/* 모두, 태그, 카테고리별 검색창 클릭 */
		$('.search-in-button').click(function() {
			tag = $(this).attr('value');
		});
		
		var cntCol=0;
		
		$('.color-swatch').click(function() {
				var color = $(this).attr('value');
				var index3 = $('.color-swatch').index(this);
					
				console.log('컬러값'+color);
				//중간에 span들어가서 2씩 배가 됨
				console.log('인덱스 값'+index3);
				
				
				if($(this).parent().find('span').eq(index3/2).css('display') == 'block'){
					$(this).parent().find('span').eq(index3/2).css('display','none');
				}else{
					$(this).parent().find('span').eq(index3/2).css('display','block');
				}
				
				cntCol++;
				console.log('카운트 값'+cntCol);
				console.log(tag);
				
		})


		$(function() {
			$('.search-in-button').click(function() {
				$(this).parent().find('li').attr('class','search-in-button');
				$(this).attr('class','search-in-button selected');

			});
		})
		
		$(function() {
			searchButton();
		});
	});
	
	var html1 = "";
	var dataM=1; var dataF=1, dataT=1;
	/* 검색창 ajax */
	/* function searchButton(){
		
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
			 console.log('회원 사진 없어!!');
			 
			 dataM = data;
			 html="";	
		 }
		  $.each(data,function(index,pic){
				
			  //사진 붙는곳
			  html += "<div class='interaction-view'>";
				html += "<div class='photo-list-photo-interaction'>";
				html += "<a class='overlay' href='../../jsp/basic/picDetail.jsp?pic_no="+pic.pic_no+"'>"+
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
		 //검색된 값 없으면 아예 출력x
		 if(data==0){
			 console.log('팔로우 사진 없어!!')
			 dataF = data;
			 html3="";	
		 }
		  $.each(data,function(index,pic){

			  //사진 붙는곳
			  html3 += "<div class='view photo-list-photo-view awake'>";
				html3 += "<div class='interaction-view'>";
				html3 += "<div class='photo-list-photo-interaction'>";
				html3 += "<a class='overlay' href='../../jsp/basic/picDetail.jsp?pic_no="+pic.pic_no+"'>"+
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
	 	

		var index2=0;
		var html2 = "<div class='main search-photos-results'>";
		html2 += "<div class='view search-photos-everyone-view'>";
		html2 += "<h5 class='search-results-header' id='explan'>";
		html2 += "<a class='view-more-link' data-track='search-viewall' href=''#' data-rapid_p='49'>"+
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
			html2 += "<a class='overlay' href='../../jsp/basic/picDetail.jsp?pic_no="+pic.pic_no+"'>"+
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
 
		  if(dataM==0&&dataF==0&&dataT==0){
			  
		 		html1 = "<div class='no-results-message'><h5 class='empty'>죄송합니다! "+search+" 와(과) 일치하는 항목이 없습니다.</h5>"+
		 		"<h5 class='empty' id='message'>검색 범위를 확대해 보세요.</h5></div>";
		 		
		 		console.log('값없음');
		 	}
		 	$('#member').append(html1);
		});   
	 } */
	
	/*색상 검색*/
	var arr = new Array(3);
	var colorList = new ArrayList();
	console.log('생성 후 list 사이즈'+colorList.size());
	
	$(function() {
		var cnt=0;
		console.log(cnt);
		$('.color-swatch').click(function() {
			var color = $(this).attr('value');
			console.log('모두의 첫번째'+color);
			
			console.log(colorList.size());
			colorList.add(color);
			console.log('넣고 나서');
			console.log(colorList.size());		
			
			for(var i=0;i<colorList.size()-1;i++){
				if(colorList.get(i) == color){
					console.log('여기 같을때');
					colorList.remove(colorList.size()-1);
					colorList.remove(i);
					
				}
			}
			for(var i=0;i<colorList.size();i++){
				console.log('여기 for문'+colorList.get(i));
			}
			for(var i=0;i<colorList.size();i++){
				arr[i] = colorList.get(i); 
			}
			
			for(var i=0;i<arr.length;i++){
				console.log(arr);
			}
			
			console.log('최종 size'+colorList.size());
			var search=$('#search').val();
			var search2="";
			
			
			if(colorList.size()==0){
				searchButton();
			} 
				
			//실제 전달할 값
			if(colorList.size()==1){
				search2 = search +","+ arr[0];
			}else if(colorList.size()==2){
				search2 = search +","+ arr[0]+","+arr[1];
			}
			else if(colorList.size()==3){
				search2 = search +","+ arr[0]+","+arr[1]+","+arr[2];
			}
					var html = "<div class='main search-contacts-results'>";
			 		html += "<div class='view search-photos-yours-view' style='height:268px'>";
			 	   	html += "<h5 class='search-results-header' id='explan'>";
					html +=	"<a class='view-more-link member' data-track='search-viewall-user' "+
					"data-rapid_p='47'>모두 보기</a>회원님의 사진</h5>";
					
			 $.getJSON("memColor",{search:encodeURIComponent(search2),tag:encodeURIComponent(tag)},
				  function(data){
					 $('#member').empty();
					 if(data==0){
						 console.log('회원 사진 없어!!')
						 dataM = data;
						html="";	
					 }
					  $.each(data,function(index,pic){
						
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
					html3 += "<a class='view-more-link follow' data-track='search-viewall-user' "+
					"data-rapid_p='47'>모두 보기</a>팔로우하는 사람이 올린 사진</h5>";
					
					var search = $('#search').val();

				 $.getJSON("followColor",{search:encodeURIComponent(search2),tag:encodeURIComponent(tag)},function(data){
					 $('#follow').empty();
					 if(data==0){
						 dataF = data;
						 console.log('팔로우 사진 없어!!')
						 html3="";	
					 }
					  $.each(data,function(index,pic){
							
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
					html2 += "<a class='view-more-link' data-track='search-viewall' data-rapid_p='49'>"+
					"</a>모든 사진</h5>";
					
				 //모든 사진 불러오기
				 $.getJSON("allColor",{search:encodeURIComponent(search2),tag:encodeURIComponent(tag)},function(data){
					 $('#all').empty();
					 if(data==0){
						 dataT = data;
						 html2="";	
					 }
					$.each(data,function(index,pic){
		
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
						  alert(dataM);
						  alert(dataF);
						  alert(dataM);
						  
						  
						  	console.log('M'+dataM);
						  	console.log('F'+dataF);
						  	console.log('T'+dataT);
						  	
					 		console.log('값없음');
					 		html="";
					 		html2="";
					 		html3="";
					 		html1 = "<div class='no-results-message'><h5 class='empty'>죄송합니다! "+search+" 와(과) 일치하는 항목이 없습니다.</h5>"+
					 		"<h5 class='empty' id='message'>검색 범위를 확대해 보세요.</h5></div>";
					 		$('#member').append(html1);
					 	}
					  
					  
					  html1=""; */
				});   
		});
	
		
});  
</script>
</head>
<body>
 
<div class="header">
	<jsp:include page="../layout/header.jsp"></jsp:include>
</div>   


<div id="content">
	<div>
	<!-- 사람, 사진 검색 탭 -->

	<div class="contents">
	  <div class="view search-subnav-slender-view">
		<div class="search-subnav using-slender-advanced-panel" id="search-people">
			<div class="search-subnav-sizing fluid-centered">
				<div class="search-subnav-content">
					<ul class="links">
						<li class="link selected" data-id="photos">
						<a class="pictureLink" data-rapid_p="39">
								<div class="title" id="explan2">사진</div></a>
						</li>
						<li class="link" data-id="people">
						<a class="peopleLink">
								<div class="title" id="explan3">사람</div></a>
						</li>
					</ul>
					<ul class="tools"> </ul>
				</div>
			</div>
		</div>
	</div>
		
		<!-- 색상 선택-->

		<div class="view search-slender-advanced-panel-view">
			<div class="advanced-panel" id="color-panel">
			 <div class="fluid-centered">
			    <div class="quick-filter">
			    	<div class="view search-color-picker-view">
			          <ul class="color-list">
			            <li value="red" class="color-swatch"  title="빨간색"	style="background-color: #ff2000">
			            	<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
			            </li> 
						<li value="brown" class="color-swatch" title="갈색" style="background-color: #a24615">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="orange" class="color-swatch dark-check checked " title="주황색" style="background-color: #ff7c00">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="pink" class="color-swatch dark-check checked" title="분홍색" style="background-color: #ff9f9c">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="yellow" class="color-swatch checked" title="노란색" style="background-color: #fffa00">
							<span class="color-swatch checkedBlue" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="yGreen" class="color-swatch checked" title="연두색" style="background-color: #90e200">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="green" class="color-swatch" title="초록색" style="background-color: #00ab00">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="sky" class="color-swatch" title="청록색" style="background-color: #00b2d4">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="blue" class="color-swatch" title="파란색" style="background-color: #0062c6">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="violet" class="color-swatch" title="보라색" style="background-color: #8c20ba">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="hotPink" class="color-swatch"title="진분홍색" style="background-color: #f52394">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="white" class="color-swatch dark-check outline" title="흰색" style="background-color: #ffffff">
							<span class="color-swatch checkedBlue" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="gray" class="color-swatch" title="회색" style="background-color: #7c7c7c">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
						<li value="black" class="color-swatch" title="검정색" style="background-color: #000000">
							<span class="color-swatch checked" style="display: none; padding-right: -4px; margin-left: -2px; width: 11px;"></span>
						</li>
			       	 </ul>
			    	</div>
				      <div class="view search-search-in-picker-view">
						<p  class="option-header">검색:</p>
							<ul class="search-in-list">
								<!--  selected  -->
								<li class="search-in-button selected" value="text" onclick="searchButton()">모두</li>
								<li  class="search-in-button" value="tags" onclick="searchButton()">태그</li>
								<li class="search-in-button" value="category" onclick="searchButton()">카테고리</li>
							</ul>
						</div>
			   	 	</div>
				 </div>
			</div>
		</div>
		
		
		
		<!-- 회원 사진 -->
		<main id="search-unified-content" class="main fluid-centered using-slender-advanced-panel" role="main">
			 <div id="total_picture">
		 		<div id="member"></div>
				<div id="follow"></div>
				<div id="all"></div>
			</div>
		</main>					
		</div>
	</div>
</div>
</body>
</html>