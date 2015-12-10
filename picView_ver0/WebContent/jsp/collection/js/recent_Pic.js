//사진 하나에 마우스 오버하면 하나만 정보뜨게 함
$(function() {
	var index_chk =0;
	
	var requestPage =1;
	var index_chk =0;
	$('#requestPage').val(1);
	$(window).scroll(function(){
		if  ($(window).scrollTop() == $(document).height() - $(window).height()){
		   receiveMessage();
		}
	});
	$.ajax({
		type:"GET",
		url:"count_Recent",
		dateType:"json",
		success:function(data){
			//alert(data.requestPage);
			$('#totalCount').val(data);
			receiveMessage();
			
		}
	});
	
	function receiveMessage() {
		var requestPage = $('#requestPage').val();
		
		 if(!requestPage){
			 requestPage = 1;
		 }
		 
		$.ajax({

			type:"GET",
			url:"recent_Pic/"+requestPage,
			dateType:"json",
			error:function(){
				$("#messages").append("<span style='color:red;'>불러오기 오류!</span>");
			},
			success:function(data){
				
				var totalCount = $('#totalCount').val();
					requestPage++;
					if(requestPage < totalCount){
					$('#requestPage').val(requestPage);
					var list = data.list;
					
					$.each(list, function(index,recent){
						
						var recent_html = "<div class='photo-list-photo-view' id='photo_list"+index_chk+"' style='width: 514px; height: 315px; background-image: url(../../upload/"+recent.pic_add+");transform: translate(0px, 4px);'>";
						recent_html +="<div class='photo-list-photo-interaction'>";
						recent_html +="<div class='interaction-bar' id='interaction"+index_chk+"'  title='"+recent.pic_title+"' >";
						recent_html +="<div class='text'><a class='title' href='basic_pic_Detail?pic_no="+recent.pic_no+"' >"+recent.pic_title+"</a></div>";
						recent_html +="<div class='tool'><a class='fave-area' href='basic_pic_Detail?pic_no="+recent.pic_no+"'>";
						recent_html +="<i></i><span class='icon-count'>"+recent.pic_date+"</span></a></div>";
						recent_html +="</div></div></div>";
		      			
		      			
		      	
					   
					     $('.photo-list-view').append(recent_html);
					     index_chk++;
					       
			         });
					
					}
				
				$('.photo-list-photo-view').each(function(index,item){	
					$('#interaction'+index).css('display', 'none');
					$('#photo_list'+index).hover(function() {
						$('#interaction'+index).css('display', 'flex');
		        	}, function() {
		        		$('#interaction'+index).css('display', 'none');
		           });
				});	
					
				
					
			}

		});
		
		
		
	}

});
