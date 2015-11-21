	$(function() {
		$('.info_bar').css('display', 'none');

		$('.picture_list').mouseover(function() {
			$(this).find('div').css('display', 'block');
		});
		$('.picture_list').mouseout(function() {
			$('.info_bar').css('display', 'none');
		});

	});
	
	$(function(){
		$('.picture_list').click(function(){
			var id = $(this).find('input').attr("value");
			location.href = "../../jsp/basic/picDetail.jsp?pic_no=" + id;
			
		});
		$('#picture_area').mouseover(function(){
	         $(this).css('cursor', 'pointer');
	      });
	});
	