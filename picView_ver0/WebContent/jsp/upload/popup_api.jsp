<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./css/smart_editer2_in.css" rel="stylesheet">
<link href="./css/smart_editer2_item.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<script src="./js/paging.js"></script>

<script type="text/javascript">
$(function(){
	
	$(document).on("click","._rollover",function(){
		
		 $('._rollover' ).each(function(index,item){
             $( '._rollover').eq(index).attr( 'class', '_rollover');
             
         });
         var index2 = $( '._rollover').index( this);
        $( '._rollover').eq(index2).attr( 'class', '_rollover active');

		
	}); 
	
	$(document).on("click",".se2_btn_apply3",function(){
		var title=$('.title').val();
		var image=$('.image').val();
		var author=$('.author').val();
		var pubdate=$('.pubdate').val();
		var publisher = $('.publisher').val();
		var html ="";
		var target_chk = $('#target_chk').val();
		
		var person_title = $('.person_title').val();
		var person_image = $('.person_image').val();
		var person_description = $('.person_description').val();
		
		var image_title = $('.image_title').val();
		var image_thumbnail = $('.image_thumbnail').val();
		
		if(target_chk=="book"){
		//oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", [$('.title').val()]);
		    html += "<p><img src="+image+" alt="+title+" class='thumb' width='55' height='75'>&nbsp;";
			html += "<br></p><p>"+title+"</p>";
			html += "<p>작가 : "+author+"</p>";
			html += "<p>출판사 : "+publisher+"</p>";
			html += "<p>발매 :"+pubdate+"<br></p>";
		}else if(target_chk=="encyc"){
			html += "<p><img src="+person_image+" alt="+person_title+" class='thumb' width='55' height='75'>&nbsp";
			html += "<br></p><p>인물: "+person_title+"</p>";
			html += "<br></p><p>설명: "+person_description+"</p>";
			
		}else if(target_chk=="image"){
			html += "<p><img src="+image_thumbnail+" alt="+image_title+" class='thumb' width='55' height='75'>&nbsp";
			html += "<br></p><p>제목: "+image_title+"</p>";
		}	
			//alert(html);
		opener.parent.submitContents(html);
		window.close();
	});
	
});


</script>
<script>
	
</script>
</head>
<body>

<div id="smart_editor2">
<form name="search_api" method="post" action="search_api" > 
	<div class="se2_db_layer" style="display: block;">
		<div class="se2_in_layer">
			<div class="se2_dbset">
				<button type="button" title="닫기" class="se2_close"><span>닫기</span></button>
				<h3><strong>글감첨부</strong></h3>
				<ul class="se2_db_tab">
					
					<li id="button_chk" class="active">
						<div class="se2_db_container" id="category_div0" >
							<div class="se2_db_header">
								<select name="target">
									<option value="book">책</option>
									<option value="encyc">인물</option>
									<option value="image">사진</option>
								
								</select>
								<input type="text" name="search" placeholder="책을 검색해 주세요" class="input_ty1" accesskey="S">
								<input type="image" src="http://static.se2.naver.com/static/full/20150916/btn_sch.gif" alt="검색" class="se2_sch_ty1">
							</div>
							<div class="se2_db_result" style="display: block;">
								
							<!-- 검색결과 없는 경우 / 로딩 중 -->
							<p class="se2_db_nodata _nodata" style="display:none;"><strong>검색 결과가 없습니다.</strong>검색어를 확인하신 후 다시 검색해 주세요. </p>
							<p class="se2_loading _loading" style="display: none;"><img src="http://static.se2.naver.com/static/full/20150916/img_load1.gif" alt="로딩중" width="150" height="13"></p>
							<!-- //검색결과 없는 경우 / 로딩 중 -->
							<!-- 검색결과 템플릿 -->
								
							<ul class="se2_li_ty2 _list">
								<c:forEach var="list" items="${final_list}">
								<input type="hidden" name="target_chk" value="${list.target }" id="target_chk">
								<c:choose>
									<c:when test="${list.target=='book' }">
										<li class="_rollover">
									    <img src="${list.image }" alt="${list.title }" width="55" height="75" class="thumb" onerror="this.onerror='';this.src='http://static.se2.naver.com/static/img/dbattach/noimg5575.gif'">
									    <input type="hidden" class="image" name="image" value="${list.image }">
									    <span class="se2_t_skin"></span>
										    <dl class="se2_dl_ty1">
											    <dt>
											    	<span>${list.title }<input type="hidden" name="title" class="title" value="${list.title }"></span>
											    </dt>
										    	<dd>
										    	<em class="test">작가&nbsp;${list.author }<input type="hidden" name="author" class="author" value="${list.author }"></em>
										    	<span style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">출판사&nbsp;${list.publisher }<input type="hidden" class="publisher" name="publisher" value="${list.publisher }"></span>
										    	<em>발매&nbsp;${list.pubdate}<input type="hidden" name="pubdate" value="${list.pubdate }" class="pubdate"></em>
										   	    </dd>
										    </dl>
										
									    </li>
									</c:when>
									<c:when test="${list.target=='encyc' }">
										<li class="_rollover chk" style="width:400px">
									    <img src="${list.person_image }" alt="${list.person_title }" class="thumb" width="55" height="75" onerror="this.onerror='';this.src='http://static.se2.naver.com/static/img/dbattach/noimg5575.gif'">
									    <input type="hidden" class="person_image" name="person_image" value="${list.person_image }">
									    <span class="se2_t_skin"></span>
										    <dl class="se2_dl_ty1">
											    <dt>
											    	<span>${list.person_title }<input type="hidden" name="person_title" class="person_title" value="${list.person_title }"></span>
											    </dt>
										    	<dd>
										    	<em>설명&nbsp;${list.person_description}<input type="hidden" name="person_description" value="${list.person_description }" class="person_description"></em>
										   	    </dd>
										    </dl>
									    </li>
									
									
									</c:when>
									<c:when test="${list.target=='image' }">
										<li class="_rollover chk" style="width:400px">
									    <img src="${list.image_thumbnail }" alt="${list.image_thumbnail }" class="thumb" width="55" height="75" onerror="this.onerror='';this.src='http://static.se2.naver.com/static/img/dbattach/noimg5575.gif'">
									    <input type="hidden" class="image_thumbnail" name="image_thumbnail" value="${list.image_thumbnail }">
									    <span class="se2_t_skin"></span>
										    <dl class="se2_dl_ty1">
											    <dt>
											    	<span>${list.image_title }<input type="hidden" name="image_title" class="image_title" value="${list.image_title }"></span>
											    </dt>
										    	
										    </dl>
									    </li>
									
									
									</c:when>
								
								</c:choose>
								
								</c:forEach>
							    
							  
						     </ul>  
						     <!-- <div class="paginate_loaded" style="display:block;">
						     	<strong class="first-child">1</strong>
						     	<a href="#">2</a>
						     	<a href="#">3</a>
						     	<a href="#">4</a>
						     	<a href="#" class="last-child">5</a>
						     	<a class="next" href="#">다음</a>
						     	
						     </div> -->
							</div>
						</div>
					</li>
					<%-- <li id="button_chk" ><button type="button" class="se2_db6"><span>인물</span></button>
					<input type="radio" name="category_chk" id="category_chk" value="encyc" >
						<div class="se2_db_container" id="category_div1">
							<div class="se2_db_header">
								
								<input type="text" name="search2" placeholder="인물을 검색해 주세요" class="input_ty1" accesskey="S">
								<input type="image" src="http://static.se2.naver.com/static/full/20150916/btn_sch.gif" alt="검색" class="se2_sch_ty1">
							</div>
							<div class="se2_db_result" style="display: block;">
								
							<!-- 검색결과 없는 경우 / 로딩 중 -->
							<p class="se2_db_nodata _nodata" style="display:none;"><strong>검색 결과가 없습니다.</strong>검색어를 확인하신 후 다시 검색해 주세요. </p>
							<p class="se2_loading _loading" style="display: none;"><img src="http://static.se2.naver.com/static/full/20150916/img_load1.gif" alt="로딩중" width="150" height="13"></p>
							<!-- //검색결과 없는 경우 / 로딩 중 -->
							<!-- 검색결과 템플릿 -->
								
							<ul class="se2_li_ty2_1 _list">
								<c:forEach var="list" items="${final_list}">
								<c:if test="${list.target=='encyc' }">
								<input type="hidden" name="target" value="${list.target}" id="target">
								
								<li class="_rollover">
							    <img src="${list.person_image }" alt="${list.person_title }" width="55" height="75" class="thumb" onerror="this.onerror='';this.src='http://static.se2.naver.com/static/img/dbattach/noimg5575.gif'">
							    <input type="hidden" class="image" name="image" value="${list.person_image }">
							    <span class="se2_t_skin"></span>
								    <dl class="se2_dl_ty1">
									    <dt>
									    	<span>${list.person_title }<input type="hidden" name="title" class="title" value="${list.title }"></span>
									    </dt>
								    	<dd>
								    	<em>설명&nbsp;${list.description}<input type="hidden" name="pubdate" value="${list.description }" class="pubdate"></em>
								   	    </dd>
								    </dl>
							    </li>
							    </c:if>
								</c:forEach>
							    
							  
						     </ul>  
						     <div class="paginate_loaded" style="display:block;">
						     	<strong class="first-child">1</strong>
						     	<a href="#">2</a>
						     	<a href="#">3</a>
						     	<a href="#">4</a>
						     	<a href="#" class="last-child">5</a>
						     	<a class="next" href="#">다음</a>
						     	
						     </div>
							</div>
						</div>
					</li> --%>
					
				</ul>
				
				
				 
				
				<div class="se2_btns">
					<button type="button" class="se2_btn_apply3" style="display: inline;">
						<span>적용</span>
					</button>
					<button type="button" class="se2_close2">
						<span>닫기</span>
					</button>
					
					
					
				</div>
				
		</div>
		</div>
	</div>
</form>
</div>

</body>
</html>