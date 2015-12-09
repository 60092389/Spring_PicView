<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link href="./css/main.css" rel="stylesheet" media="screen"/>
<title>Insert title here</title>

<style type="text/css">
	.slider_size{
	background-size: 100% 100%;
	}

</style>
</head>

<body> 
	<input type="hidden" name="pic_count" id="pic_count" value="${pic_count }">
	<div class="wrap wrap-index">
            <div class="slider">
                <div class="jquery-reslider">
					<c:forEach var="s" items="${myShowList}">
 						<div class="slider-block slider_size" data-url="../../upload/${s.pic_add}"></div>
				    </c:forEach>
                    <div class="slider-direction slider-direction-next"></div>
                    <div class="slider-direction slider-direction-prev"></div>

                    <div class="slider-dots">
                    	  <ul>
						</ul>
                    </div> 
                </div>
            </div>
       </div> 
		
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="./js/jquery.reslider.js"></script>
<script>

$(function(){
	var pic_count = $("#pic_count").val();
    $('.jquery-reslider').reSlider({
        speed:500,  //페이드속도
        delay:5000,  //자동전환 속도
        imgCount: pic_count,  //이미지갯수 
        //dots: true,   //하단 페이지 버튼
        autoPlay:true//자동재생
    })
})
</script>
</body>
</html>