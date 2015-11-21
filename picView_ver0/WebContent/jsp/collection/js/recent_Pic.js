//사진 하나에 마우스 오버하면 하나만 정보뜨게 함
$(function() {
	$('.interaction-bar').css('display', 'none');

	$('.photo-list-photo-view').mouseover(function() {
		$(this).find('.interaction-bar').css('display', 'flex');
	});
	$('.photo-list-photo-view').mouseout(function() {
		$('.interaction-bar').css('display', 'none');
	});

});
