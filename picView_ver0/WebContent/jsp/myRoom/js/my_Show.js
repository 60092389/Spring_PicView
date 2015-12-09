	$(function() {
		$('.interaction-bar').css('display', 'none');

		$('.photo-grid-item').mouseover(function() {
			$(this).find('.interaction-bar').css('display', 'flex');
			$(this).find('.tool').css('display', 'inline');
			$(this).find('.glyphicon').css('display','block');
		});
		$('.photo-grid-item').mouseout(function() {
			$('.interaction-bar').css('display', 'none');
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
	