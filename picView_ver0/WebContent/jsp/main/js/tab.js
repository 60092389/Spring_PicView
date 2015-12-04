jQuery(function($){
	function init_tabs() {
		$(".tab_content").css("display","none");
		if (!$('ul.tabs').length) { return; }
		$('div.tab_content_wrap').each(function() {
			$(this).find('div.tab_content:first').show();
		});
		$('ul.tabs a').click(function() {
			if (!$(this).hasClass('current')) {
				$(this).addClass('current').parent('li').siblings('li').find('a.current').removeClass('current');
				$($(this).attr('href')).show("1000").siblings('div.tab_content').hide("1000");
			}
			this.blur();
			return false;
		});
	}
	$(document).ready(function() {
		init_tabs();
	});
});