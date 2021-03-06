<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.net.URLDecoder" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="css/searchPerson.css" rel="stylesheet">
<link href="css/search.css" rel="stylesheet">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<title>검색 </title>
<script type="text/javascript">
	<%
		String search = URLDecoder.decode(request.getParameter("search"),"UTF-8");
	%>
	
	var search = "<%=search%>";
	var html1="";
	

	//사람 탭 넘어가기
	$(function() {
		$('.pictureLink').click(function() {
			location.href="../../jsp/search/search.jsp?search=" + search;
		});
	})
	
	$(function() {
		$('#search').attr('value', search);
		$.getJSON("searchPeople",{search:encodeURIComponent(search)},
			function(data){
				 $('#people-result-my').empty();
				 if(data==0){
					 console.log('검색된 회원 없어!!')
					html="";	
				 }
				 
				 html="";
				  $.each(data,function(index,pic){
					 var year = new Date(pic.mem_date).getFullYear();
			     var month = new Date(pic.mem_date).getMonth() + 1;
			     var day = new Date(pic.mem_date).getDate();
			     var date = year + "-" + month;
			       
			     var id = pic.mem_id.split("@");
			     
			         
			     html += "<div class='result-card linked reboot-restyle'>";
					 html += "<div class='sizer-cropper'>";
					 html += "<div class='avatar-content'>";
					 html +="<div class='avatar person medium'"+
					 "style='background-image: url(../../upload/"+pic.mem_pic+");'></div></div>";
					 
					 html += "<div class='text-content'>";
					 html += "<div class='name'>"+pic.mem_name+"</div>";
					 html += "<div class='subtitle'><span>"+id[0]+"</span></div>";
					 html += "<div class='links'><span><a href='#'>";
					 html += "<span class='glyphicon glyphicon-picture'>"+pic.pic_count+"</span></a></span>";
					 html += "<span class='links-metadata'>"+date+" 가입</span></div></div>";
					 html += "<a class='click-anywhere' href='../../jsp/myRoom/myShowForm"+pic.mem_no+"'></a>";
					 html += "</div>";
					 html += "<div class='button-content'>";
					 
					 
					 if(pic.fol_check ==0){
						/*  html += "<button class='btn btn-primary follow not-following' type='button'>+팔로우</button>"; */
						 html += "<div class='view follow-view deafult_follow'>";
						 html +="<form action='addNewFollow' method='post'>";
						 html +="<textarea rows='5' cols='5' name='mem_nos' style='display:none;'>"+${authInfo.mem_no}+","+pic.mem_no+"</textarea>";
						 html +="<input class='btn btn-primary in_black' type='submit' value='+팔로우' />";
						 html +="</form>";
						 html +="</div>";
					 }
					 if(pic.fol_check == 1){
						 html += "<div class='view follow-view only_follow only_follow2'>";
						 html +="<form action='cancelFollow' method='post'>";
						 html +="<textarea rows='5' cols='5' name='mem_nos' style='display:none;'>"+${authInfo.mem_no}+","+pic.mem_no+"</textarea>";
						 html +="<input class='btn btn-danger in_black' type='submit' value='팔로우 취소' />";
						 html +="</form>";
						 html +="</div>";
					 }
					 if(pic.fol_check == 2){
						 html += "<div class='view follow-view only_follower only_follower2'>";
						 html +="<form action='addFollow' method='post'>";
						 html +="<textarea rows='5' cols='5' name='mem_nos' style='display:none;'>"+${authInfo.mem_no}+","+pic.mem_no+"</textarea>";
						 html +="<input class='btn btn-success in_black' type='submit' value='+맞팔로우' />";
						 html +="</form>";
						 html +="</div>";
					 }
					 if(pic.fol_check == 3){
						 html += "<div class='view follow-view each_follow each_follow2'>";
						 html +="<form action='cancelEachFollow' method='post'>";
						 html +="<textarea rows='5' cols='5' name='mem_nos' style='display:none;'>"+${authInfo.mem_no}+","+pic.mem_no+"</textarea>";
						 html +="<input class='btn btn-warning in_black' type='submit' value='맞팔 취소' />";
						 html +="</form>";
						 html +="</div>";
					 }			 
					 
					 html += "</div></div></div>";
				
				  }); 
				  
				 $('#people-result-my').append(html);
				 
				 if(data==0){
				 		html1 = "<div class='no-results-message'><h5 class='empty'>죄송합니다! "+search+" 와(과) 일치하는 항목이 없습니다.</h5>"+
				 		"<h5 class='empty' id='message'>검색 범위를 확대해 보세요.</h5></div>";
				 		
				 		console.log('값없음');
				 }
				 $('#people-result-my').append(html1);
			});
	})


</script>
</head>
<body>

<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
</div>

	<div id="content">
		<!-- 사람, 사진 검색 탭 -->
		<div class="contents">
				<div class="view search-subnav-slender-view">
					<div class="search-subnav using-slender-advanced-panel"
						id="search-people">
						<div id="people" class="search-subnav-sizing fluid-centered">
							<div class="search-subnav-content">
								<ul class="links">
									<li class="link" data-id="photos">
									<a class="pictureLink" data-rapid_p="39">
											<div class="title" id="explan2">사진</div>
									</a></li>
									<li class="link selected" data-id="people"><a href="#"
										data-rapid_p="40">
											<div class="title" id="explan2">사람</div>
									</a></li>
								</ul>
								<ul class="tools">
								</ul>
							</div>
						</div>
					</div>
				</div>
			
		

		<div class="view search-people-results-view">
			<div class="main full-bleed fluid-centered">
				 <div class="my-people">
					<h5 id="title">PicView 회원</h5>
					 <div id="people-result-my">
					</div>
				</div> 
			</div>
		</div>
	</div>
</div>
</body>
</html>