
/*사진 관련 이벤트*/

	$(function(){
		$('.info_hidden').css('display','none');
	
		$('.center_picture').click(function(){			
			if($(this).find('.pic_check').css('display')=='block'){
				$(this).find('.pic_check').css('display', 'none');
				$(this).find('.back_color').css('opacity','0');
				
			}else{
				$(this).find('.pic_check').css('display','block');
				$(this).find('.back_color').css('opacity','0.5');
			}
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
	
	
	
