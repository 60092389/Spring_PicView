
/*사진 관련 이벤트*/

	$(function(){
		
	
		$('.pic_check').click(function(){
			var mem_no = $('.center_picture').attr('id');
			var alb_no = $(this).attr('id');
			location.href= "my_album_detail?mem_no="+mem_no+"&alb_no="+alb_no;
		});

		$('.center_picture').mouseover(function(){
			
			if($(this).find('.pic_check').css('display')=='block'){
				$(this).find('.pic_check').css('display', 'none');
				$(this).find('.back_color').css('opacity','0.5');
				
			}else{
				$(this).find('.pic_check').css('display','block');
				$(this).find('.back_color').css('opacity','0.7');
			}
				$(this).css('opacity','0.5');
				$(this).find('.info_hidden').css('display','inline-block');
				$(this).css('cursor', 'pointer');
				
			
			
		});
		
		$('.center_picture').mouseout(function(){
			$(this).css('opacity','1');
			$('.info_hidden').css('display','none');
			$(this).css('cursor', 'default');
			
			if($(this).find('.pic_check').css('display')=='block'){
				$(this).find('.pic_check').css('display', 'none');
				$(this).find('.back_color').css('opacity','0');
				
			}else{
				$(this).find('.pic_check').css('display','block');
				$(this).find('.back_color').css('opacity','0.5');
			}
		});
		$('.level').each(function(index, item){
			
				var level = $(this).attr('id');
				//alert("level" + level);
				if(level == 3){
					$(this).parent().parent().css('opacity', '0.5');
				}
			
		});
		
	});
	