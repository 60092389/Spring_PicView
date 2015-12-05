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
</head>

<body> 
	<div class="wrap wrap-index">
            <div class="slider">
                <div class="jquery-reslider">
					<c:forEach var="s" items="${myShowList}">
 						<div class="slider-block" data-url="../../upload/${s.pic_add}"></div>
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
    $('.jquery-reslider').reSlider({
        speed:1000,  //���̵�ӵ�
        delay:5000,  //�ڵ���ȯ �ӵ�
        imgCount:8,  //�̹������� 
        dots: true,   //�ϴ� ������ ��ư
        autoPlay:true//�ڵ����
    })
})
</script>
</body>
</html>