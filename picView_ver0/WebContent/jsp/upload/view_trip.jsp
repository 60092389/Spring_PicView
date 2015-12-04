<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>여행 및 풍경</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../jsp/basic/js/jquery.raty.js"></script>
<script type="text/javascript"
	src="http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=63a683902e9d30dc3c7226cb1e57599f"></script>

<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../jsp/basic/css/ani_plant.css" rel="stylesheet">
</head>
<body>
	<div id="contents">
		<div id="view_trip_title">
			<h4>여행 및 풍경</h4>
		</div>
		<div id="view_trip_table">
		 <form name="view_trip" method="post" action="map_post">
			<table class="table table-hover responsive">
				<tr>
					<th id="title"><label for="Name"
						class="col-xs-1 col-md-1 col-lg-1">장소명</label></th>
					<td id="content">
						<div>
							<input type="text" class="form-control" name="place" >
							<input type="submit" value="검색">
						</div>
						<input type="text" id="x_value" name="x_value" value="${x }">
						<input type="text" id="y_value" name="y_value" value="${y }">
						<input type="text" id="x_y" name="x_y" value="${x_y}">
						<input type="text" id="address" name="address" value="${address}">
					</td>
				</tr>
				<tr>
					<th id="title"><label for="Name"
						class="col-xs-1 col-md-1 col-lg-1">위치</label></th>
					<td id="content">
						<div id="map" class="col-xs-10 col-md-10 col-lg-10"></div>
					</td>
				</tr>
			</table>
	     </form>
		</div>
	</div>
</body>
<script type="text/javascript">
				var x= $('#x_value').val();
				var y = $('#y_value').val();
				var x_y = $('#x_y').val();
				var address = $('#address').val();
				if(x == "" || y ==""){
					x = 126.9773356;
					y = 37.5675451;
				}
                var oSeoulCityPoint = new nhn.api.map.LatLng(y, x);
                var defaultLevel = 11;
                var oMap = new nhn.api.map.Map(document.getElementById('map'), { 
                                                point : oSeoulCityPoint,
                                                zoom : defaultLevel,
                                                enableWheelZoom : true,
                                                enableDragPan : true,
                                                enableDblClickZoom : false,
                                                mapMode : 0,
                                                activateTrafficMap : false,
                                                activateBicycleMap : false,
                                                minMaxLevel : [ 1, 14 ],
                                                size : new nhn.api.map.Size(800, 480)           });
                var mapZoom = new nhn.api.map.ZoomControl(); // - 줌 컨트롤 선언
                mapZoom.setPosition({left:20, bottom:20}); // - 줌 컨트롤 위치 지정.
                oMap.addControl(mapZoom); // - 줌 컨트롤 추가.
                
                var oSize = new nhn.api.map.Size(28, 37);
                var oOffset = new nhn.api.map.Size(14, 37);
                var oIcon = new nhn.api.map.Icon('http://static.naver.com/maps2/icons/pin_spot2.png', oSize, oOffset);
                
                var oMarker = new nhn.api.map.Marker(oIcon, { title : address });  //마커 생성 
                oMarker.setPoint(oSeoulCityPoint); //마커 표시할 좌표 선택
                oMap.addOverlay(oMarker); //마커를 지도위에 표현 
                var oLabel = new nhn.api.map.MarkerLabel(); // - 마커 라벨 선언. 
                oMap.addOverlay(oLabel); // - 마커 라벨 지도에 추가. 기본은 라벨이 보이지 않는 상태로 추가됨. 
                oLabel.setVisible(true, oMarker); // 마커 라벨 보이기 
                /* var oSlider = new nhn.api.map.ZoomControl();
                oMap.addControl(oSlider);
                oSlider.setPosition({
                        top : 10,
                        left : 10
                });

                var oMapTypeBtn = new nhn.api.map.MapTypeBtn();
                oMap.addControl(oMapTypeBtn);
                oMapTypeBtn.setPosition({
                        bottom : 10,
                        right : 80
                });
                
                var oThemeMapBtn = new nhn.api.map.ThemeMapBtn();
                oThemeMapBtn.setPosition({
                        bottom : 10,
                        right : 10
                });
                oMap.addControl(oThemeMapBtn);

                
                var oSize = new nhn.api.map.Size(28, 37);
                var oOffset = new nhn.api.map.Size(14, 37);
                var oIcon = new nhn.api.map.Icon('http://static.naver.com/maps2/icons/pin_spot2.png', oSize, oOffset);

                var oInfoWnd = new nhn.api.map.InfoWindow();
                oInfoWnd.setVisible(false);
                oMap.addOverlay(oInfoWnd);

                oInfoWnd.setPosition({
                        top : 20,
                        left :20
                });

               
                var oPolyline = new nhn.api.map.Polyline([], {
                        strokeColor : '#f00', // - 선의 색깔
                        strokeWidth : 5, // - 선의 두께
                        strokeOpacity : 0.5 // - 선의 투명도
                }); // - polyline 선언, 첫번째 인자는 선이 그려질 점의 위치. 현재는 없음.
                oMap.addOverlay(oPolyline); // - 지도에 선을 추가함.

                oMap.attach('mouseenter', function(oCustomEvent) {

                        var oTarget = oCustomEvent.target;
                        // 마커위에 마우스 올라간거면
                        if (oTarget instanceof nhn.api.map.Marker) {
                                var oMarker = oTarget;
                                oLabel.setVisible(true, oMarker); // - 특정 마커를 지정하여 해당 마커의 title을 보여준다.
                        }
                });

                oMap.attach('mouseleave', function(oCustomEvent) {

                        var oTarget = oCustomEvent.target;
                        // 마커위에서 마우스 나간거면
                        if (oTarget instanceof nhn.api.map.Marker) {
                                oLabel.setVisible(false);
                        }
                });
                var oLabel = new nhn.api.map.MarkerLabel(); // - 마커 라벨 선언.
                oMap.addOverlay(oLabel); // - 마커 라벨 지도에 추가. 기본은 라벨이 보이지 않는 상태로 추가됨.
                //마커 아이콘
                var oMarker = new nhn.api.map.Marker(oIcon, { title : '제부도소년빅파크' });
                oMarker.setPoint(37.4535914,126.6384813);  //마커위치
                oMap.addOverlay(oMarker);         // 마커 지도에 추가
                oLabel.setVisible(true, oMarker); // 마커 라벨 보여주기 
                oMap.attach('click', function(oCustomEvent) {
                        var oPoint = oCustomEvent.point;
                        var oTarget = oCustomEvent.target;
                        oInfoWnd.setVisible(false);
                        alert(oPoint)
                        // 마커 클릭하면
                        if (oTarget instanceof nhn.api.map.Marker) {
                                // 겹침 마커 클릭한거면
                                if (oCustomEvent.clickCoveredMarker) {
                                        return;
                                }
                                // - InfoWindow 에 들어갈 내용은 setContent 로 자유롭게 넣을 수 있습니다. 외부 css를 이용할 수 있으며, 
                                // - 외부 css에 선언된 class를 이용하면 해당 class의 스타일을 바로 적용할 수 있습니다.
                                // - 단, DIV 의 position style 은 absolute 가 되면 안되며, 
                                // - absolute 의 경우 autoPosition 이 동작하지 않습니다. 
                                oInfoWnd.setContent('<DIV style="border-top:1px solid; border-bottom:2px groove black; border-left:1px solid; border-right:2px groove black;margin-bottom:1px;color:black;background-color:white; width:auto; height:auto;">'+
                                        '<span style="color: #000000 !important;display: inline-block;font-size: 12px !important;font-weight: bold !important;letter-spacing: -1px !important;white-space: nowrap !important; padding: 2px 5px 2px 2px !important">' + 
                                        'Hello World <br /> ' + oTarget.getPoint()
                                        +'<span></div>');
                                oInfoWnd.setPoint(oTarget.getPoint());
                                oInfoWnd.setPosition({right : 15, top : 30});
                                oInfoWnd.setVisible(true);
                                oInfoWnd.autoPosition();
                                return;
                        }
                        var oMarker = new nhn.api.map.Marker(oIcon, { title : '마커 : ' + oPoint.toString() });
                        oMarker.setPoint(oPoint);
                        oMap.addOverlay(oMarker);

                        var aPoints = oPolyline.getPoints(); // - 현재 폴리라인을 이루는 점을 가져와서 배열에 저장.
                        aPoints.push(oPoint); // - 추가하고자 하는 점을 추가하여 배열로 저장함.
                        oPolyline.setPoints(aPoints); // - 해당 폴리라인에 배열에 저장된 점을 추가함
                }); */
        </script>
</html>