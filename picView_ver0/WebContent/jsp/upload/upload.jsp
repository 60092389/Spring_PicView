<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="upload.css" rel="stylesheet">
<link href="smart_editer2_in.css" rel="stylesheet">
<link href="smart_editer2_item.css" rel="stylesheet">
<script src="../../js/jquery.min.js"></script>
<script src="draganddrop.js"></script>
<script type="text/javascript" src="./editer/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">

	 $(function(){
		$('#information').click(function(){
			var popupUrl="popup_api.jsp";
			var popOption ="width=460, height=470, resizable=no, scrollbars=no,status=no";
			window.open(popupUrl,"popup",popOption);
		});
		
		/* $('#action-publish').on("click",function(){
			$('#upload_form').submit();
		}) */
		
	}); 

</script>
</head>
<body>
	<div id="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>
	<div id="main" class="clearfix" role="main" style="position: relative;">
		<div id="global-dialog-background"></div>
		<div id="upload-cr">
			<div id="upload-container">
				<div id="upload-screen">
					<div id="panel-grid" class="">
					 <%-- <form method="post" enctype="multipart/form-data" action="fileUpload/post{1}"> --%>
					 <form:form modelAttribute="uploadForm" id="upload_form" method="post" enctype="multipart/form-data">
						<!-- 설명 시작 -->
						<div id="editr-panel" class="widened enabled selection-single">
							<div id="editr-panel-resize" class=""></div>
								<div id="editr-panel-bg" style="height:500px;">
									<div id="editr-panel-scroll-wrapper">
										<h3 id="editr-panel-title">사진 1장 편집:</h3>
										<div id="editr-panel-form">
											<ul id="yui_3_11_0_3_1447996615343_950" class="editr-options">
												<li id="editr-panel-title-description" class="editr-option" tabindex="1">
													<label for="Name" class="col-xs-2 col-lg-2 control-label">제목</label>
													<div class="col-xs-10 col-lg-10"> 
													<input type="text" name="pic_title" id="pic_title" class="form-control" placeholder="제목">
													</div>
												</li>
												<li id="editr-panel-tags" class="editr-option closed default" tabindex="3">
													<label for="Name" class="col-xs-2 col-lg-2 control-label">태그</label>
													<div class="col-xs-10 col-lg-10"> 
													<input type="text" name="tag_name" id="tag_name" class="form-control" placeholder="태그와 태그는 쉼표(,)로 구분하세요">
													</div>
												</li>
												<li id="editr-panel-tags" class="editr-option closed default" tabindex="4">
													<label for="Name" class="col-xs-2 col-lg-2 control-label">카테고리</label>
													<div class="col-xs-10 col-lg-10"> 
													<select class="form-control" id="category_no" name="category_no">
													  <option value="1">예술 및 공연</option>
													  <option value="2">음악</option>
													  <option value="3">여행 및 풍경</option>
													  <option value="4">패션</option>
													  <option value="5">도서</option>
													  <option value="6">동물 및 식물</option>
													  <option value="7">인물</option>
													  <option value="8">디자인</option>
													  <option value="9">사회적 이슈</option>
													  <option value="10">음식</option>
													  <option value="11">스포츠</option>
													  <option value="12">기타</option>
													</select>
													</div>
												</li>	
												
												
												<li id="editr-panel-sets" class="editr-option" tabindex="5">
													<label for="Name" class="col-xs-2 col-lg-2 control-label">설명</label>
													<div class="col-xs-10 col-lg-10"> 
													<div id="se2_tool" class="se2_tool">
														<div class="se2_icon_tool">
														<ul class="se2_itool1">
															<li class="se2_mn husky_seditor_ui_photo_attach">
																<!-- <button class="" type="button">
																<p><span class="glyphicon glyphicon-search" aria-hidden="true"> Search</span></p>
																</button>  -->
																<button type="button" id="information" class="btn btn-warning">정보찾기</button>
															</li>
															
														</ul>
														</div>
													</div>														
													<textarea name="pic_content" id="ir1" rows="5" cols="50" class="form-control"></textarea>
													</div>
												</li>
												<li id="editr-panel-tags" class="editr-option closed default" tabindex="3">
													<label for="Name" class="col-xs-2 col-lg-2 control-label">위치주소</label>
													<div class="col-xs-10 col-lg-10"> 
													<input type="text" name="pic_location" id="pic_location" class="form-control" placeholder="주소를 입력하면 사진 세부보기에서 지도를 확인할 수 있습니다.">
													</div>
												</li>
												<li id="editr-panel-people" class="editr-option" tabindex="4">
													<label for="Name" class="col-xs-2 col-lg-2 control-label">권한설정</label>
													<div class="col-xs-10 col-lg-10">
														<label class="radio-inline ">
														 <input type="radio" name="pic_open" id="pic_open" value="1">&nbsp;모두 공개&nbsp;&nbsp;
														</label>
														<label class="radio-inline">
														 <input type="radio" name="pic_open" id="pic_open" value="2">&nbsp;친구 공개&nbsp;&nbsp;
														</label>
														<label class="radio-inline">
														 <input type="radio" name="pic_open" id="pic_open" value="3">&nbsp;비공개&nbsp;&nbsp;
														</label>
													
													</div>
												</li>
												
											</ul>
										</div>
									</div>
								</div>
						</div>
						<!-- 설명 끝 -->
						
						<div id="working-area-controls-box">
							<div id="working-area-controls">
								
								<div class="action-div">
									<input id="action-publish" class="Butt extra-highlight" type="button" value="사진 1장 업로드">
								</div>
								
									<div id="controls-box">
										<div id="controls-add-remove-photos">
											<div id="yui_3_11_0_3_1447996615343_1095" class="browse-button-wrapper">
												<button class="Butt" title="업로드할 파일 선택">
													<span class="icon-plus">+</span>
													추가
												</button>
												<input id="button-add-photos" name="uploadfile" class="fupload browse-button browse-button-add-more choose-from-client" type="file" accept="image/*,video/*" multiple>
												
											</div>
											<span id="remove-wrapper">
												<span class="nice-divider"> </span>
												<a id="remove-selected" class="toggle-button" title="선택한 항목 삭제" href="#remove-selected">
													<span class="icon-remove">-</span>
													<span id="yui_3_11_0_3_1448002662666_1016" class="item-count">
														강퇴
														<span></span>
													</span>
												</a>
											</span>
										</div>
									</div>
									
								
							</div>
						</div>
						
						<!-- 오른쪽 시작 -->
						<div id="working-area-wrapper" class="widened">
							<div id="working-area" class="default-content-type-photo default-safety-level-safe default-license-arr hide-focus enable-hover">
							  <div class="dragAndDropDiv">
								<div id="display-container" >
									
									<!-- <div class="photo-item selected" >
										<div class="selected-wrapper">
											<div class="photo-thumbnail">
												<img class="thumbnail" alt="" src="https://farm1.staticflickr.com/728/22744563687_8ba5219fbf_m.jpg" style="transform: rotate(360deg) scale(1);">
												<output id="thumbs"></output>
											</div>
											x
										</div>
									</div> -->
									<!-- <div class="photo-editable">
										<div class="photo-title-editable">
											
										</div>
									</div> -->
								</div>
						     </div>
							</div>
						</div>
						<!-- 오른쪽 끝ㄴ -->
					  </form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "ir1",
    sSkinURI: "./editer/SmartEditor2Skin.html",
    fCreator: "createSEditor2",
    htParams : { 
        fOnBeforeUnload : function(){}
    }
    
});

function submitContents(str) {
    // 에디터의 내용이 textarea에 적용된다.
    
    oEditors.getById["ir1"].exec("PASTE_HTML", [str]);
 
    // 에디터의 내용에 대한 값 검증은 이곳에서
    
    //document.getElementById("ir1").value
    //를 이용해서 처리한다.
 
    try {
        //elClickedObj.form.submit();
    } catch(e) {}
}
</script>
</body>
</html>
