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
				itemWidth : 200,
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
		if(tagname == null){
			id = tagname;
		}

		

		target.appendChild(document.getElementById(id));
		pic.preventDefault();
		$('.selectize-input').addClass('has-options').addClass('has-items');
		var tag_check = tagname;				
		var tag_check_arr = tag_check.split(",");
		
		
		$(tag_check_arr).each(function(index, item){
			$('.selectize-input').append('<div class="item" data-value='+item+' id="'+id+'">'+ item+'</div>');	
			
		});
		/*$('.selectize-input').append(
				'<div class="item" data-value='+tagname+' id="'+id+'">'
						+ tagname + '</div>');*/

		var temp = "";
		var tagplus = "";
		var tempd= "";
		$('#pic_plus li').each(function(index, item) {
			
			var plust = $(item).attr('id');
			/*if(plust[index-1] == plust[index]){
				tagplust = temp;
			}*/
			//alert("tempd" +tempd);
			/*if(tempd == plust){
				plust = "";
			}*/	
			//else {
				
				tagplus = temp + ',' + plust;
				temp = tagplus;
		//	}
				
				//tempd = plust;
	
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
		var tag_check = tagname;				
		var tag_check_arr = tag_check.split(",");
		$(tag_check_arr).each(function(index, item){
			$('.selectize-input div[data-value=' + item + ']').remove();
			
		});
		//$('.selectize-input div[data-value=' + tag_check_arr + ']').remove();
		var droptag = "";
		var tmp = "";
		$('#pic_plust li').each(function(index, item){
			var dropt = $(item).attr('id');
			droptag = tmp + ',' + dropt;
			tmp = dropt;
		});
	/*	$('.selectize-input div').each(function(index, item) {
			
			var dropt = $(this).attr('id');
			droptag = tmp + ',' + dropt;
			tmp = dropt;
		});*/

		$('input[name=pic_no]').attr('value', droptag);

	};