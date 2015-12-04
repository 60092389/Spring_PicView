<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="smart_editer2_in.css" rel="stylesheet">
<link href="smart_editer2_item.css" rel="stylesheet">
<script src="/finall_151120_2/js/jquery.min.js"></script>
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
		
		//oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", [$('.title').val()]);
		    html += "<p><img src="+image+" alt="+title+" class='thumb' width='55' height='75'>&nbsp;";
			html += "<br></p><p>"+title+"</p>";
			html += "<p>작가 : "+author+"</p>";
			html += "<p>출판사 : "+publisher+"</p>";
			html += "<p>발매 :"+pubdate+"<br></p>";
			
			//alert(html);
		opener.parent.submitContents(html);
		window.close();
	});
	/* $('.se2_db_tab' ).index().each(function(index){
		alert(index);
		$('li').eq(index).click(function(){
			alert(index);
			$( 'li').eq(index).attr( 'class', 'active');	
		})
        
        
    }); */
	
    //$('#category_chk').eq(0).prop('checked',"checked");  
	$(document).on("click","#button_chk",function(){
		   
		 $('li' ).each(function(index,item){
			
            $( 'li').eq(index).attr( 'class', '');
            $("input:checkbox[name='category_chk']").eq(index).removeAttr("checked");
            
        });
        var index2 = $( 'li').index(this);
       $( 'li').eq(index2).attr( 'class', 'active');
       
       $("input:checkbox[name='category_chk']").eq(index2).prop('checked',"checked");

		
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
					<li id="button_chk" class="active"><button type="button" class="se2_db1"><span>책</span></button>
					<input type="checkbox" name="category_chk" id="category_chk" value="book">
						<div class="se2_db_container">
						<div class="se2_db_header">
							<select class="st_ty1">
							<option value="st_aqtitle">책 제목</option>
							<option value="st_aqauthor">작가</option>
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
					</li>
					<li id="button_chk" class="active"><button type="button" class="se2_db6"><span>인물</span></button>
					<input type="checkbox" name="category_chk" id="category_chk" value="encyc" >
						<div class="se2_db_container">
						<div class="se2_db_header">
							<select class="st_ty1">
							<option value="st_aqtitle">책 제목</option>
							<option value="st_aqauthor">작가</option>
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
							<li class="_rollover">
						    <img src="${list.image }" alt="${list.title }" width="55" height="75" class="thumb" onerror="this.onerror='';this.src='http://static.se2.naver.com/static/img/dbattach/noimg5575.gif'">
						    <input type="hidden" class="image" name="image" value="${list.image }">
						    <span class="se2_t_skin"></span>
							    <dl class="se2_dl_ty1">
								    <dt>
								    	<span>${list.title }<input type="hidden" name="title" class="title" value="${list.title }"></span>
								    </dt>
							    	<dd>
							    	<em>설명&nbsp;${list.description}<input type="hidden" name="pubdate" value="${list.description }" class="pubdate"></em>
							   	    </dd>
							    </dl>
						    </li>
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
					</li>
					
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