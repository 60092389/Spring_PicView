<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./bootstrap.min.css" rel="stylesheet">
<link href="./custom2.css" rel="stylesheet">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../jsp/login/css/register7.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script src="jquery.validate.js"></script>


<script type="text/javascript">

$(function(){
	var cnt = 0;
	$('.FollowButton').on('click',function(){
		var index2 = $('.FollowButton').index(this);
		
		if($('.wholeInterestMask').eq(index2).attr('class') == 'wholeInterestMask hidden'){	
			$('.wholeInterestMask').eq(index2).attr('class','wholeInterestMask');
			$('.wholeInterestMask').eq(index2).css('display','block');
			$("input:checkbox[name='category_no']").eq(index2).prop('checked',"checked");
			
			cnt++;
				if(cnt>3){
					alert('카테고리는 3개까지 선택가능합니다.');
					$('.wholeInterestMask').eq(index2).attr('class','wholeInterestMask hidden');
					$('.wholeInterestMask').eq(index2).css('display','none');
					$("input:checkbox[id='category_no']").eq(index2).removeAttr("checked");
					cnt--;
				}
		}else{
			$('.wholeInterestMask').eq(index2).attr('class','wholeInterestMask hidden');
			$('.wholeInterestMask').eq(index2).css('display','none');
			$("input[name=category_no]:checkbox").eq(index2).removeAttr("checked"); 
			
			cnt--;
		}
		
	});
});
	
	
</script>


<title>계정관리</title>
</head>
<body>


<!-- 헤더 -->
<div class="header">
	<jsp:include page="../layout/header.jsp"></jsp:include>
</div> 


<!-- 컨텐츠 -->
<div class="center">
	<div class="register">
	<h1>계정관리</h1><br><br>
	</div>
	<div class="contents">
	
		<div class="center_left col-xs-7 col-lg-7">
			<form class="form-horizontal" role="form">  
        
			<div class="form-group">
			 <label for="Name" class="col-xs-2 col-lg-2 control-label">이름변경</label>
				<div class="col-xs-3 col-lg-3 col-sm-3" >
				 <input type="text"  name="lastName" class="form-control"  placeholder="성" name="name">
				 </div>
				 <div class="col-xs-4 col-lg-4 col-sm-4">
				 <input type="text"  name="firstName"  class="form-control" placeholder="이름" name="name'">
				 </div>
		   </div>


        <div class="form-group">   
            <label for="password" class="col-xs-2 col-lg-2 control-label">비밀번호 수정</label>
            <div class="col-xs-5 col-lg-5 col-sm-5">
                <input type="password" class="form-control" placeholder="비밀번호"> 
            </div>
        </div>

        
        <label for="gender" class="col-xs-2 col-lg-2 control-label"></label>
        <div class="selectbox">
        	<div class="birth">
        			<select id="year" name="year" class="form-control col-sm-2 col-lg-2">
					<option value="">년도
					  	<%for(int i=2015; i>=1920 ;i--){ %>
					  	<option value="<%=i%>"><%=i+"년" %></option>
					  	<%}%>
					</select> 
				 </div> 
			
			<div class="birth">
				   <select id="month" name="month" class="form-control col-sm-2 col-lg-2">
					  	<option value="">월
					  	<%for(int i=1; i<13 ;i++){ %>
					  	<option value="<%=i%>"><%=i+"월" %></option>
					  	<%} %>
				  	</select>
				</div>  	
				  	
				<div class="birth">  	
				   <select id="day" name="birth" class="form-control col-sm-2 col-lg-2">
					  	<option value="">일
					  	<%for(int i=1; i<32 ;i++){ %>
					  	<option value="<%=i%>"><%=i+"일" %></option>
					  	<%} %>
				  	</select>
				  </div>
		  </div>
        	<br>
               <div class="form-group"> 
                 <label for="gender" class="col-xs-2 col-lg-2 control-label">성별 </label>
        			<div class="form-group col-sm-7 col-lg-7">	
        			&nbsp;&nbsp;
				 <input type="radio" name="gender" value="남자">남자&nbsp;&nbsp;&nbsp;&nbsp;
				 <input type="radio" name="gender" value="여자">여자
				 </div>
				 </div>
			</form>
		</div>

		
		<!-- 카테고리 -->
	   <div id="category_area" class="row center_right col-xs-4 col-lg-4">
	   		<c:forEach var="category" items="${cate_list}">
	   			
	   			<div class="col-sm-4 col-md-4">
			      <div class="Interest Module FollowButton">
				     <div class="wholeInterestMask hidden">
							<div class="check"> </div>
							<div class="mask"> </div>
					   </div>
				     <div class="interestWrapper" style="background-color: #403F14">
				       		<div class="interestImage" style="background-image: url('../../upload/${category.category_img_add}')"></div>
				       		
					       		<div class="interestLabel">
								<h4>${category.category_name }
									<input type="checkbox" name="category_no" id="category_no" value="${category.category_no }" />
								</h4>
							</div>
				     </div>
			      </div>
	     		</div>
	   		</c:forEach>
	  
	 </div>
         
        <!-- 로그인 버튼 -->
         <div class="login">
          		<label class="col-sm-12 col-sm-12">
       				<input type="submit"  id="loginbutton" value="수정하기" class="btn btn-primary btn-lg">
       			</label>
       	  </div>
       	  
	</div>
</div>



	<!-- 푸터 -->
<div class="footer">
		<jsp:include page="../layout/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>