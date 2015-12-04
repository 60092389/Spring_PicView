<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/finall_151120_2/js/jquery.min.js"></script>
<link href="/finall_151120_2/css/bootstrap.min.css" rel="stylesheet">
<link href="./css/pic_slider.css" rel="stylesheet">
<script type="text/javascript" src="./js/tab.js"></script>
</head>
<body>
<!-- 탭시작 -->
<div class="tab-wrap">
	<ul class="tabs">
		<li>
			<a href="#tab_content_primary_01">Tab 1</a>
		</li>
		<li>
			<a href="#tab_content_primary_02">Tab 2 </a>
		</li>
		<li>
			<a href="#tab_content_primary_03">Tab 3</a>
		</li>
		
	</ul>
	<div class="tab_content_wrap">
		<div id="tab_content_primary_01" class="tab_content">
			<!-- 사진 슬라이드 시작-->
			<div id="jssor_1" style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 900px; height: 600px; overflow: hidden; visibility: hidden;">사진 슬라이드 
		        Loading Screen
		        <div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
		            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
		            <div style="position:absolute;display:block;background:url('img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
		        </div>
		        <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 900px; height: 600px; overflow: hidden;">
		            <div style="display: none;">
		                <img data-u="image" src="./img/002.jpg" />
		                <img data-u="thumb" src="./img/thumb-002.jpg" />
		            </div>
		            <div style="display: none;">
		                <img data-u="image" src="./img/003.jpg" />
		                <img data-u="thumb" src="./img/thumb-003.jpg" />
		            </div>	
		            <div style="display: none;">
		                <img data-u="image" src="./img/004.jpg" />
		                <img data-u="thumb" src="./img/thumb-004.jpg" />
		            </div>
		           
		        </div>
		        
		        Thumbnail Navigator
		        <div u="thumbnavigator" class="jssort03" style="position:absolute;left:0px;bottom:0px;width:900px;height:60px;" data-autocenter="1">
		            <div style="position: absolute; top: 0; left: 0; width: 100%; height:100%; background-color: #000; filter:alpha(opacity=30.0); opacity:0.3;"></div>
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
		        
		    </div>
		    <!-- 사진 슬라이드 끝 -->
		</div>
		<div id="tab_content_primary_02" class="tab_content">
			<p>
				<strong>Content Area 02</strong>
			</p>
			<p>
				Tab Link 02 의 내용.<br /><br />
			</p>
		</div>
		<div id="tab_content_primary_03" class="tab_content">
			<p>
				<strong>Content Area 03</strong>
			</p>
			<p>
				Tab Link 03 의 내용.<br /><br />
			</p>
		</div>
		
	</div><!-- //tab_content_wrap -->
</div><!-- //tab-wrap -->
<!-- // 탭끝 -->
<script type="text/javascript" src="js/jssor.slider-20.mini.js"></script>
<script type="text/javascript" src="js/pic_slider.js"></script>
</body>
</html>