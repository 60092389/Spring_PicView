(function() {

		// store the slider in a local variable
		var $window = $(window), flexslider = {
			vars : {}
		};

		// tiny helper function to add breakpoints
		function getGridSize() {
			return (window.innerWidth < 600) ? 2
					: (window.innerWidth < 900) ? 3 : 4;
		}

		/* $(function() {
			SyntaxHighlighter.all();
		}); */

		$window.load(function() {
			$('.flexslider').flexslider({
				animation : "slide",
				animationLoop : false,
				itemWidth : 250,
				itemMargin : 5,
				minItems : getGridSize(), // use function to pull in initial value
				maxItems : getGridSize(), // use function to pull in initial value

			});
		});

		// check grid size on resize event
		$window.resize(function() {
			var gridSize = getGridSize();

			flexslider.vars.minItems = gridSize;
			flexslider.vars.maxItems = gridSize;
		});
	}());

	function drag(target, pic) { //드래그 시작시 호출 할 함수
		pic.dataTransfer.setData('Text', target.id);
		pic.dataTransfer.setData('Data', target.getAttribute('name'));
	};

	function drop(target, pic) { //드롭시 호출 할 함수

		var id = pic.dataTransfer.getData('Text');
		var tagname = pic.dataTransfer.getData('Data');

		target.appendChild(document.getElementById(id));
		pic.preventDefault();
		$('.selectize-input').addClass('has-options').addClass('has-items');
		$('.selectize-input').append(
				'<div class="item" data-value='+tagname+' id="'+id+'">'
						+ tagname + '</div>');

		var temp = "";
		var tagplus = "";
		$('.selectize-input div').each(function(index, item) {

			var plust = $(this).attr('id');
			tagplus = temp + ',' + plust;
			temp = tagplus;
		});
		$('input[name=pic_no]').attr('value', tagplus);

	};

	//아래사진들 드랍시 소스
	function drop2(target, pic) {
		var id = pic.dataTransfer.getData('Text');
		var tagname = pic.dataTransfer.getData('Data');

		$('.sub_ul li').hasClass(
				target.appendChild(document.getElementById(id)),
				pic.preventDefault());
		$('.selectize-input div[data-value=' + tagname + ']').remove();
		var droptag = "";
		var tmp = "";
		$('.selectize-input div').each(function(index, item) {

			var dropt = $(this).attr('id');
			droptag = tmp + ',' + dropt;
			tmp = dropt;
		});

		$('input[name=pic_no]').attr('value', droptag);

	};