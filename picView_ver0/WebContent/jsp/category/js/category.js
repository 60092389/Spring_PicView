$(function() {
		$('.FollowButton')
				.on(
						'click',
						function() {
							var index2 = $('.FollowButton').index(this);

							if ($('.wholeInterestMask').eq(index2)
									.attr('class') == 'wholeInterestMask hidden') {
								$('.wholeInterestMask').eq(index2).attr(
										'class', 'wholeInterestMask');
								$('.wholeInterestMask').eq(index2).css(
										'display', 'block');
								$("input:checkbox[name='category_no']").eq(
										index2).prop('checked', "checked");
								//$('.test').hide();
								//$('.test2').show();

							} else {
								$('.wholeInterestMask').eq(index2).attr(
										'class', 'wholeInterestMask hidden');
								$('.wholeInterestMask').eq(index2).css(
										'display', 'none');
								$("input[name=category_no]:checkbox")
										.eq(index2).removeAttr("checked");
								//$('.test2').show();
								//$('.test').show();

							}

						});

		$(function() {
			$('#aside_menu').css({
				left : '-420px'
			}).addClass('open');

			$('#menubutton').find('img').attr('src', './imgs/menu_button1.PNG');
		});

		$('#menubutton').on('click', function() {
			$('#aside_menu').toggleClass('open');
			if ($('#aside_menu').hasClass('open')) {
				$('#aside_menu').animate({
					left : '-420px'
				}, 300);

				$(this).find('img').attr('src', './imgs/menu_button1.PNG');
			} else {
				$('#aside_menu').animate({
					left : '0px'
				}, 300);

				$(this).find('img').attr('src', './imgs/menu_button2.PNG');
			}
			return false;
		});

	});

	function search_all() {
		location.href = "category_list";
	}