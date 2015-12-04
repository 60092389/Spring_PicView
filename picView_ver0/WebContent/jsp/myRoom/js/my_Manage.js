
/*사진 관련 이벤트*/

	$(function(){
		$('.info_hidden').css('display','none');
	
		
		//jquery_ui.js에서 체크해제랑 체크하기 주석에 코드넣음
		/*$('.center_picture').click(function(){			
			if($(this).find('.pic_check').css('display')=='block'){
				$(this).find('.pic_check').css('display', 'none');
				$(this).find('.back_color').css('opacity','0');
				
			}else{
				$(this).find('.pic_check').css('display','block');
				$(this).find('.back_color').css('opacity','0.5');
			}
		});*/
		
		$('.year_left').click(function(){
			if($(this).find('.center_left_month').css('display')=='none'){
				$(this).find('.center_left_month').css('display','block');
			}else{
				$(this).find('.center_left_month').css('display','none');
			}
		});
		$('.year_left').mouseover(function(){
			$(this).css('cursor','pointer');
			$(this).find('.center_left_year').css('font-size','14px');
			$(this).find('.center_left_year').css('color','#5F5AF3');
		});
		$('.year_left').mouseout(function(){
			$(this).css('cursor','default');
			$(this).find('.center_left_year').css('font-size','14px');
			$(this).find('.center_left_year').css('color','#B4B4B4');
		});
		
		

		$('.center_picture').mouseover(function(){
			$(this).css('opacity','0.6');
			$(this).find('.info_hidden').css('display','inline-block');
			$(this).css('cursor', 'pointer');
			
		});
		
		$('.center_picture').mouseout(function(){
			$(this).css('opacity','1');
			$('.info_hidden').css('display','none');
			$(this).css('cursor', 'default');
		});
	});
	
	
	$(function() {

		$('.center_main').selectable({
			distance : 0,
			filter : 'div.center_picture'
		}, {
			//사진선택할때마다 해당사진의 pic_no 저장
			stop : function() {					
				var result = $('.select_result').empty();
				var result2= $('.update_pic_img').empty();
				var up_pic_count= 0;
				$(".ui-selected", this).each(function() {
					var index = $(this).attr('id');
					result.append((index) + ',');
					result2.append("<img src='../../upload/"+$(this).find('.info_hidden').attr('id')+
							"'width='60px' height='60px' style='margin-right:5px'>");
					
					up_pic_count++;
					$('.count_pic').empty();
					$('.count_pic').append(up_pic_count);
					
					/* $('.select_cancel').click(function(){
						$('.ui-selected').removeClass('ui-selected');
						result.empty();
						result2.empty(); 
					});		 */				
				});
				
				//선택된 사진이 있으면 편집버튼들 뜨고 없으면 안뜨게하기
				$(".center_picture", this).each(function() {
					if ($('.center_picture').hasClass("ui-selected")) {
						$(".update_window").removeClass('none');
						
					} else {
						$(".update_window").addClass('none');
					}

				});
			}
		});
	});

	//사진정보 변경후 alert
	$(function() {
		$('.modal_update_submit').click('hide.bs.modal', function() {
			alert('변경되었습니다.');
		})
	});
	
	//선택취소
	$(function(){
		$('.select_cancel').click(function(){
			if($('.center_picture').hasClass('ui-selected')){
				$('.center_picture').removeClass('ui-selected');
				$('.update_pic_img').empty();
				$('.update_window').addClass('none');
				$('.pic_check').css('display','none');
				$('.back_color').css('opacity','0');
				$('.select_result').empty();
			}
		});
	});
	
	//선택된사진삭제
	function form(){
	document.getElementById("delete_form").submit();
	
	}
	
	
	
