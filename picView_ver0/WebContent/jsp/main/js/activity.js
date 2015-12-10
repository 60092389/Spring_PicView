$(function(){
	/*$('#activity_div').scroll(function(){
		if  ($(window).scrollTop() == $(document).height() - $(window).height()){
		   receiveMessage();
		}
	});*/
	$('#requestPage_activity').val(1);
	var index_chk =0;
	$("#activity_div").scroll( function() {
		  var elem = $("#activity_div");

		  if ( elem[0].scrollHeight - elem.scrollTop() == elem.outerHeight())
		    {
			  receiveMessage();
		    }
		});

	$.ajax({
		type:"GET",
		url:"count_activity",
		dateType:"json",
		success:function(data){
			//alert(data.requestPage);
			$('#totalCount_activity').val(data);
			receiveMessage();
		}
	});
	
	function receiveMessage() {
		var requestPage = $('#requestPage_activity').val();
		
		 if(!requestPage){
			 requestPage = 1;
		 }
		 
		$.ajax({

			type:"GET",
			url:"activity_list/"+requestPage,
			dateType:"json",
			error:function(){
				$("#messages").append("<span style='color:red;'>불러오기 오류!</span>");
			},
			success:function(data){
				var totalCount = $('#totalCount_activity').val();
				var total = data.total_count;
					if(total == 1){
						requestPage = 0;
					}else{
						requestPage++;
					}
					if(requestPage < totalCount){
						$('#requestPage_activity').val(requestPage);

						$('#requestPage_activity').val(requestPage);
						
						var list = data.list;
						$.each(list, function(index,activity){
							var subject="";
							if(activity.subject == "follow"){
								subject = "님이 팔로우 요청했습니다."
									location_chk="../myRoom/my_Follower";
							}
							if(activity.subject == "reply"){
								subject = "님이 회원님의 사진에 댓글을 작성했습니다."
									location_chk="../basic/basic_pic_Detail?pic_no="+activity.pic_no;
							}
							if(activity.subject == "good"){
								subject = "님이 회원님의 사진을 좋아했습니다."
									location_chk="../basic/basic_pic_Detail?pic_no="+activity.pic_no;
							}
							
							var html = "<li class='_33c' id='_33c"+index_chk+"'>";
								html += "<div class='anchorContainer'>";
								html += "<a class='_33e' href='"+location_chk+"'>";
								html += "<div class='clearfix'><div class='_ohe lfloat'>";
								html += "<span class='_33h img _8o _8r' style='background-image: url(../../upload/"+activity.mem_pic+");'></span>";
								html += "</div><div class='_42ef _8u'>";
								html += "<div class='clearfix'><span>";
								html += "<span class='fwb'>"+activity.mem_name+"</span>";
								html += "<span>"+subject+"</span>";
								html += "</span></div></div>";
								html += "</div></a></div></li>";
								
								
								$('.activity_ul').append(html);
								index_chk++;
				         });
					
					
					}
					$('._33c' ).each(function(index,item){
				        $('#_33c'+index).hover(function() {
				        		$('#_33c'+index).css('background-color','rgba(0, 0, 0, 0.07)');
				        	}, function() {
				        		$('#_33c'+index).css('background-color','rgba(0, 0, 0, 0)');
				        });
				  });	
					
					
					
			}

		});
	}	
	
	
	

		
	
});