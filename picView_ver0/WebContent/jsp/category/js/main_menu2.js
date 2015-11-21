$(function() {
	$('#notipopup').notipopup({
		startX : '20%',
		startY : '10%',
		close : '.close',
		todayclose : '.todayclose'
	});
})

$(function() {
	$.scrollUp({
		scrollName : 'scrollUp', // Element ID
		topDistance : '300', // Distance from top before showing element
		// (px)
		topSpeed : 300, // Speed back to top (ms)
		animation : 'fade', // Fade, slide, none
		animationInSpeed : 200, // Animation in speed (ms)
		animationOutSpeed : 200, // Animation out speed (ms)
		scrollText : 'Scroll to top', // Text for element
		activeOverlay : false, // Set CSS color to display scrollUp active
	// point, e.g '#00FFFF'
	});
});

$(function() {
	$('#aside_menu').css({
		left : '-420px'
	}).addClass('open');
	$('body').css({
		marginLeft : '-200px'
	});
	$('#menubutton').find('img').attr('src', './imgs/menu_button1.PNG');
});

$(function() {
	$('.product').on('click', function(e) {
		$('#content').empty().load("New.html");
		e.preventDefault();
	});

});

$(function() {
	$('body').siteSecurity({
		f12 : 'n',
		rightclick : 'y',
		select : 'y',
		drag : 'y'
	});
})

$(function() {
	$('#content').load("main.html");

	$('.logo > a').on('click', function(e) {
		$('#content').empty().load("main.html");
		e.preventDefault();
	});

	$('#about_glass').on('click', function(e) {
		$('#content').empty().load("glassbox_About.html");
		e.preventDefault();
	});

	$('.side_menu ul').addClass('sub_display');

	$('.right-menu a').on('click', function() {
		var href = $(this).attr('href');
		$('.side_menu ul').each(function() {
			var id = $(this).attr('id');
			if (href == id) {
				$(this).removeClass('sub_display');
			} else {
				$(this).addClass('sub_display')
			}
		});
		// $(this).addClass('sub_display');

		return false;
	});

	$('#menubutton').on('click', function() {
		$('#aside_menu').toggleClass('open');
		if ($('#aside_menu').hasClass('open')) {
			$('#aside_menu').animate({
				left : '-420px'
			}, 300);
			$('body').animate({
				marginLeft : '-200px'
			}, 300);
			$(this).find('img').attr('src', './imgs/menu_button1.PNG');
		} else {
			$('#aside_menu').animate({
				left : '0px'
			}, 300);
			$('body').animate({
				marginLeft : '0px'
			}, 300);
			$(this).find('img').attr('src', './imgs/menu_button2.PNG');
		}
		return false;
	});
})