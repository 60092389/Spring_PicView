
window.onload = $(function(){
	var k =0;
	$(".member_list", this).each(function() {
		if ($(this).find('.follow_col').find('.only_follow').hasClass('only_follow2')) {
			$(this).find('.follow_col').find('.default_follow').addClass('none');
			$(this).find('.follow_col').find('.only_follower').addClass('none');
			
		}else if($(this).find('.follow_col').find('.only_follower').hasClass('only_follower2')){
			$(this).find('.follow_col').find('.default_follow').addClass('none');		
		}else if($(this).find('.follow_col').find('.each_follow').hasClass('each_follow2')){
			$(this).find('.follow_col').find('.default_follow').addClass('none');
		}

	});
});

$(function(){
	$('.follow-btn').click(function(){
		location.href = "my_Follow";
	});
});

$(function(){
	$('.follower-btn').click(function(){
		location.href = "my_Follower";
	});
});

$(function(){
	$('.followRec-btn').click(function(){
		location.href = "listFri";
	});
});
													