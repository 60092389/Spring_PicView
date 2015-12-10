// ajax 리스트 불러옴
/*function listAnalysis() {
	$(function() {
		$.ajax({
			type : 'POST',
			url : 'Anal_json',
			dataType : 'json',
			success : function(list) {
				$.each(list, function(anal) {
					var result = list[anal];
					$('#anal_table').html(result);
				});
			}
		});

	});
}*/


// 검색어별 유입률

// 조회수별

// 날짜별



/* 입력 값 선언 */
var sDate;
var eDate;
var selectedChartType;

/* 차트에 binding할 Array 선언 */
var anl_no_group = [];
var mem_no_group = [];
var pic_no_group = [];
var pic_title_group = [];
var pic_date_group = [];
var pic_add_group = [];
var pic_count_group = [];
var good_count_group = [];
var rep_count_group = [];
var anl_word_group = [];
var anl_date_group = [];
var anl_count_group = [];



// 날짜 형식 변환
/*function inDate() { 
	 $(function() {
		 $.getJSON('Anal_json', function(data) { 
			 $.each(data, function(index, anal) { 
				var year = new Date(anal.anl_date).getFullYear();
				var month = new Date(anal.anl_date).getMonth() + 1;
				var day = new Date(anal.anl_date).getDate();
				
				if(month < 10){
					month = '0' + month; 
				} else if (day < 10){
					day = '0' + day;
				}
			
				var date = year + "-" + month + "-" + day;
				 	anl_date.push(date + ","); 
			 	}); 
			 
			 	anl_date.replace(/[,]+$/, '');
			 	//alert(anl_date);
		 });
	 });
 }*/
 

// 검색어별 분석(검색어별 사진, 검색단어, 검색날짜, 검색횟수)

function search_Analysis(){
	initControl();
	bindData();
	
	$("#btnSubmit").click(function(event) {
		sDate = $("#txtStartDate").val();
		eDate = $("#txtEndDate").val();
		selectedChartType = $("#selChartType").val();
		bindData();
	});
	
	$("#selChartType").change(function(event) {
        sDate = $("#txtStartDate").val();
        eDate = $("#txtEndDate").val();
        selectedChartType = $("#selChartType").val();
       	bindData();
    });
	
	
	/* 컨트롤 및 전역변수 초기값 설정 */
	function initControl() {
		$(function() {

			$("#txtStartDate, #txtEndDate").datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});

		sDate = "2015-11-22";
		
		var year = new Date().getFullYear();
		var month = new Date().getMonth() + 1;
		var day = new Date().getDate();
		
		if(month < 10){
			month = '0' + month; 
		} if (day < 10){
			day = '0' + day;
		}
		
		var today = year + "-" + month + "-" + day;

		eDate = today;
		
		selectedChartType = $("#selChartType").val();
		
		$("#txtStartDate").val(sDate);
		$("#txtEndDate").val(eDate);
	}

	
	/*
	 * 1) json 파일 get 2) .getJSON 함수는 비동기 AJAX 통신이기 때문에 .getJSON 함수 내에서 차트를 그리고 테이블을
	 * 바인딩해야 한다. 3) 에러가 발생 시 catch하여 alert.
	 */
	function bindData() {

		$.ajaxSetup({
			cache : false
		});

		$.getJSON('Anal_json', function(data) {

			calcData(data);

			drawChart(selectedChartType);

			bindTable();

		}).error(
				function(jqXHR, textStatus, errorThrown) {
					alert("error occured!\nStatus : " + textStatus + "\nError : "
							+ errorThrown);
				});
	}

	/*
	 * 1) json 파일에서 받아온 데이터를 사용자가 선택한 검색 조건(기간, 연령, 게임)에 맞게 필터링 하는 함수 2) 기간, 연령, 게임은
	 * OR 조건이 아니라 AND 조건이기 때문에 모든 조건에 대해 분기를 태워준다. 3) json 데이터 중 검색조건에 충족되는 데이터를
	 * filteredList Array에 담는다. 4) filteredList를 모두 수집했다면 Day 날짜에 대해 Group By 처리하고
	 * ACC_CNT와 CUST_CNT를 SUM 처리한다. 5) 전역변수인 day, acc_cnt, customer_cnt에 값을 할당한다.
	 */

	function calcData(data) {

		anl_no_group = [];
		mem_no_group = [];
		pic_no_group = [];
		pic_title_group = [];
		pic_date_group = [];
		pic_add_group = [];
		pic_count_group = [];
		good_count_group = [];
		rep_count_group = [];
		anl_word_group = [];
		anl_date_group = [];
		anl_count_group = [];

		var filteredList = [];

		$.each(data, function(index, anal) {
			// 날짜 형식 변환
			var pic_year = new Date(anal.pic_date).getFullYear();
			var pic_month = new Date(anal.pic_date).getMonth() + 1;
			var pic_day = new Date(anal.pic_date).getDate();
			
			if(pic_month < 10){
				pic_month = '0' + pic_month; 
			} if (pic_day < 10){
				pic_day = '0' + pic_day;
			}
			
			var pic_date = pic_year + "-" + pic_month + "-" + pic_day;
			
			var anl_year = new Date(anal.anl_date).getFullYear();
			var anl_month = new Date(anal.anl_date).getMonth() + 1;
			var anl_day = new Date(anal.anl_date).getDate();
			
			if(anl_month < 10){
				anl_month = '0' + anl_month; 
			} if (anl_day < 10){
				anl_day = '0' + anl_day;
			}
			
			var anl_date = anl_year + "-" + anl_month + "-" + anl_day;

			// alert("사진조회수 필터되니" + anal.pic_count);

			if (anl_date >= sDate && anl_date <= eDate) {
				filteredList.push({
					anl_no : anal.anl_no,
					mem_no : anal.mem_no,
					pic_no : anal.pic_no,
					pic_title : anal.pic_title,
					pic_date : pic_date,
					pic_add : anal.pic_add,
					pic_count : anal.pic_count,
					good_count : anal.good_count,
					rep_count : anal.rep_count,
					anl_word : anal.anl_word,
					anl_date : anl_date,
					anl_count : anal.anl_count
				});
			}
			// alert("날짜 변환 : " + date);
		});

		// alert("필터리스트 크기" + filteredList.length);

		for (var i = 0; i < filteredList.length; i++) {
			// alert("필터리스트 나오는거니" + filteredList[i].Pic_count);

			var currentAnl_no = filteredList[i].anl_no;
			var currentMem_no = filteredList[i].mem_no;
			var currentPic_no = filteredList[i].pic_no;
			var currentPic_title = filteredList[i].pic_title;
			var currentPic_date = filteredList[i].pic_date;
			var currentPic_add = filteredList[i].pic_add;
			var currentPic_count = filteredList[i].pic_count;
			var currentGood_count = filteredList[i].good_count;
			var currentRep_count = filteredList[i].rep_count;
			var currentAnl_word = filteredList[i].anl_word;
			var currentAnl_date = filteredList[i].anl_date;
			var currentAnl_count = filteredList[i].anl_count;

			// alert("이건단어" + currentAnl_word);
			// alert("이건날짜" + currentAnl_date);

			var flag = false;
			var j;
			for (j = 0; j < anl_word_group.length; j++) {
				if (anl_word_group[j] == currentAnl_word) {
					flag = true;
					break;
				}
			}

			if (flag) {
				pic_count_group[j] += currentPic_count;
				good_count_group[j] += currentGood_count;
				rep_count_group[j] += currentRep_count;
				anl_count_group[j] = currentAnl_count;
			} else {
				anl_word_group[j] = currentAnl_word;
				pic_count_group[j] = currentPic_count;
				good_count_group[j] = currentGood_count;
				rep_count_group[j] = currentRep_count;
				anl_count_group[j] = currentAnl_count;
			}
		}
	}

	/*
	 * 차트를 그리기 위해 차트 옵션 정보를 정의하고 전역변수인 day, acc_cnt, customer_cnt Array를 차트에 바인딩한다.
	 */

	function drawChart(type) {

		var options = {
			chart : {
				renderTo : 'dvChart',
				type : type
			},
			credits: {
	            enabled: false
	        },
			title : {
				text : '유입 분석 차트'
			},
			subtitle : {
				text : '검색어별'
			},
			xAxis : {
				categories : [],
				type : 'datetime'
			},
			yAxis : {
				min : 0,
				title : {
					text : '횟수'
				}
			},
			tooltip : {
				headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
				pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
						+ '<td style="padding:0"><b>{point.y} 회</b></td></tr>',
				footerFormat : '</table>',
				shared : true,
				enabled : true,
				useHTML : true
			},
			plotOptions : {
				column : {
					pointPadding : 0.2,
					borderWidth : 0
				}
			},
			series : [ {
				name : 'pic_count'
			}, {
				name : 'rep_count'

			}, {
				name : 'good_count'
			}, {
				name : 'anl_count_group'
			} ]
		}

		options.xAxis.categories = anl_word_group;
		//options.xAxis.tickInterval = parseInt(anl_date_group.length / 3);
		//alert(pic_count_group);
		//alert(rep_count_group);

		if (type == "pie") {
			options.series[0].name = "사진조회수";
			options.series[0].data = pic_count_group;

			options.series[0].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
		} else {
			options.series[0].name = "사진조회수";
			options.series[0].data = pic_count_group;
			options.series[1].name = "댓글수";
			options.series[1].data = rep_count_group;
			options.series[2].name = "좋아요수";
			options.series[2].data = good_count_group;
			options.series[3].name = "검색횟수";
			options.series[3].data = anl_count_group;
			options.series[0].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
			options.series[1].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
			options.series[2].dataLabels = {
					enabled : true,
					format : '<b>{point.y}</b>'
			};
			options.series[3].dataLabels = {
					enabled : true,
					format : '<b>{point.y}</b>'
			};
		}

		new Highcharts.Chart(options);
	}

	/*
	 * 전역변수인 day, acc_cnt, customer_cnt Array를 이용하여 Table 소스를 생성하여 dvOutput Element에
	 * 바인딩한다.
	 */
	function bindTable() {

		var html = [];

		// 그냥
		/*html.push("<table id=\"tbContents\" class=\"table tablesorter table-bordered table-hover table-condensed\">");

		// table header(thead)
		html.push("<thead><tr class=\"header\">");
		html.push("<th>분석번호</th>");
		//html.push("<th>회원번호</th>");
		//html.push("<th>사진번호</th>");
		html.push("<th>사진</th>");
		html.push("<th>사진조회수</th>");
		html.push("<th>좋아요수</th>");
		html.push("<th>댓글수</th>");
		html.push("<th>검색단어</th>");
		html.push("<th>검색날짜</th>");
		html.push("<th>검색횟수</th>");
		html.push("</tr></thead><tbody>");

		// var data = responseData.list;
		// html.push( "<tr><td>" + data.anl_date + "</td></tr>";

		$.each(anl_date_group, function(index, anal) {
			var year = new Date(anl_date_group[index]).getFullYear();
			var month = new Date(anl_date_group[index]).getMonth() + 1;
			var day = new Date(anl_date_group[index]).getDate();
			var date = year + "-" + month + "-" + day;
			//alert(date);
			//alert("분석번호" + anl_no_group[index]);
			//alert("사진조회수여" + pic_count_group[index]);
			
			html.push("<tr>");
			html.push("<td>" + anl_no_group + "</td>");
			//html.push("<td>" + mem_no_group[index] + "</td>");
			html.push("<td>" + pic_no_group + "</td>");
			html.push("<td>" + pic_count_group + "</td>");
			html.push("<td>" + good_count_group + "</td>");
			html.push("<td>" + rep_count_group + "</td>");
			html.push("<td>" + anl_word_group + "</td>");
			html.push("<td>" + date + "</td>");
			html.push("<td>" + anl_count_group + "</td>");
			html.push("</tr>");
		});
		
		html.push("</tbody></table>");
		$("#anal_table").html(html.join(""));*/
		
		$.getJSON("Anal_json", function(data) {
			var html = [];

			html.push("<thead><tr class=\"header\">");
			html.push("<th>분석번호</th>");
			//html.push("<th>회원번호</th>");
			//html.push("<th>사진번호</th>");
			html.push("<th>사진</th>");
			html.push("<th>사진제목</th>");
			html.push("<th>사진조회수</th>");
			html.push("<th>좋아요수</th>");
			html.push("<th>댓글수</th>");
			html.push("<th>사진날짜</th>");
			html.push("<th>검색단어</th>");
			html.push("<th>검색날짜</th>");
			html.push("<th>검색횟수</th>");
			html.push("</tr></thead><tbody>");

			// var data = responseData.list;
			// html.push( "<tr><td>" + data.anl_date + "</td></tr>";

			$.each(data, function(index, anal) {
				var pic_year = new Date(anal.pic_date).getFullYear();
				var pic_month = new Date(anal.pic_date).getMonth() + 1;
				var pic_day = new Date(anal.pic_date).getDate();
				
				if(pic_month < 10){
					pic_month = '0' + pic_month; 
				} if (pic_day < 10){
					pic_day = '0' + pic_day;
				}
				
				var pic_date = pic_year + "-" + pic_month + "-" + pic_day;
				
				var anl_year = new Date(anal.anl_date).getFullYear();
				var anl_month = new Date(anal.anl_date).getMonth() + 1;
				var anl_day = new Date(anal.anl_date).getDate();
				
				if(anl_month < 10){
					anl_month = '0' + anl_month; 
				} if (anl_day < 10){
					anl_day = '0' + anl_day;
				}
				
				var anl_date = anl_year + "-" + anl_month + "-" + anl_day;

				html.push("<tr>");
				html.push("<td>" + anal.anl_no + "</td>");
				//html.push("<td>" + anal.mem_no + "</td>");
				//html.push("<td>" + anal.pic_no + "</td>");
				html.push("<td>" + "<a href = '../basic/picDetail?pic_no=" + anal.pic_no + "'>" + "<img src='../../upload/" + anal.pic_add + "'/>" + "</a>"  + "</td>");
				html.push("<td>" + anal.pic_title + "</td>");
				html.push("<td>" + anal.pic_count + "</td>");
				html.push("<td>" + anal.good_count + "</td>");
				html.push("<td>" + anal.rep_count + "</td>");
				html.push("<td>" + pic_date + "</td>");
				html.push("<td>" + anal.anl_word + "</td>");
				html.push("<td>" + anl_date + "</td>");
				html.push("<td>" + anal.anl_count + "</td>");
				html.push("</tr>");
			});
			
			html.push("</tbody>");
			html.push("<tfoot><tr><td colspan=\"10\">");
			html.push("<div class=\"pagination pagination-centered hide-if-no-paging\"></div></td></tr>");
			html.push("</tfoot>");
			
			$("#anal_table").html(html.join(""));
			
			// 테이블 정렬
			$("#anal_table").tablesorter();
			
			/*$('.sort-column').click(function (e) {
			    e.preventDefault();

			    //get the footable sort object
			    var footableSort = $('table').data('footable-sort');

			    //get the index we are wanting to sort by
			    var index = $(this).data('index');

			    //get the sort order
			    var ascending = $(this).data('ascending');

			    footableSort.doSort(index, ascending);
			});*/

			// 테이블 페이징
			$('#anal_table').footable();

            $('.clear-filter').click(function (e) {
                e.preventDefault();
                $('table.demo').trigger('footable_clear_filter');
				$('.filter-status').val('');
            });

            $('.filter-status').change(function (e) {
                e.preventDefault();
				var filter = $(this).val();
                $('#filter').val($(this).text());
                $('table.demo').trigger('footable_filter', {filter: filter});
            });
		});
	}
}



// 사진별 분석(사진 각각의 조회수, 댓글수, 좋아요수)

function pic_Analysis(){
	initControl();
	bindData();

	$("#btnSubmit").click(function(event) {
		sDate = $("#txtStartDate").val();
		eDate = $("#txtEndDate").val();
		selectedChartType = $("#selChartType").val();
		bindData();
	});
	
	$("#selChartType").change(function(event) {
        sDate = $("#txtStartDate").val();
        eDate = $("#txtEndDate").val();
        selectedChartType = $("#selChartType").val();
       	bindData();
    });
	
	/* 컨트롤 및 전역변수 초기값 설정 */
	function initControl() {
		$(function() {

			$("#txtStartDate, #txtEndDate").datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});

		sDate = "2015-11-22";
		
		var year = new Date().getFullYear();
		var month = new Date().getMonth() + 1;
		var day = new Date().getDate();
		
		if(month < 10){
			month = '0' + month; 
		} else if (day < 10){
			day = '0' + day;
		}
		
		var today = year + "-" + month + "-" + day;

		eDate = today;
		
		selectedChartType = $("#selChartType").val();
		
		$("#txtStartDate").val(sDate);
		$("#txtEndDate").val(eDate);
	}

	
	/*
	 * 1) json 파일 get 2) .getJSON 함수는 비동기 AJAX 통신이기 때문에 .getJSON 함수 내에서 차트를 그리고 테이블을
	 * 바인딩해야 한다. 3) 에러가 발생 시 catch하여 alert.
	 */
	function bindData() {

		$.ajaxSetup({
			cache : false
		});

		$.getJSON('Anal_json', function(data) {

			calcData(data);

			drawChart(selectedChartType);

			bindTable();

		}).error(
				function(jqXHR, textStatus, errorThrown) {
					alert("error occured!\nStatus : " + textStatus + "\nError : "
							+ errorThrown);
				});
	}

	/*
	 * 1) json 파일에서 받아온 데이터를 사용자가 선택한 검색 조건(기간, 연령, 게임)에 맞게 필터링 하는 함수 2) 기간, 연령, 게임은
	 * OR 조건이 아니라 AND 조건이기 때문에 모든 조건에 대해 분기를 태워준다. 3) json 데이터 중 검색조건에 충족되는 데이터를
	 * filteredList Array에 담는다. 4) filteredList를 모두 수집했다면 Day 날짜에 대해 Group By 처리하고
	 * ACC_CNT와 CUST_CNT를 SUM 처리한다. 5) 전역변수인 day, acc_cnt, customer_cnt에 값을 할당한다.
	 */

	function calcData(data) {

		anl_no_group = [];
		mem_no_group = [];
		pic_no_group = [];
		pic_title_group = [];
		pic_date_group = [];
		pic_add_group = [];
		pic_count_group = [];
		good_count_group = [];
		rep_count_group = [];
		anl_word_group = [];
		anl_date_group = [];
		anl_count_group = [];

		var filteredList = [];

		$.each(data, function(index, anal) {
			// 날짜 형식 변환
			var pic_year = new Date(anal.pic_date).getFullYear();
			var pic_month = new Date(anal.pic_date).getMonth() + 1;
			var pic_day = new Date(anal.pic_date).getDate();
			
			if(pic_month < 10){
				pic_month = '0' + pic_month; 
			} if (pic_day < 10){
				pic_day = '0' + pic_day;
			}
			
			var pic_date = pic_year + "-" + pic_month + "-" + pic_day;
			
			var anl_year = new Date(anal.anl_date).getFullYear();
			var anl_month = new Date(anal.anl_date).getMonth() + 1;
			var anl_day = new Date(anal.anl_date).getDate();
			
			if(anl_month < 10){
				anl_month = '0' + anl_month; 
			} if (anl_day < 10){
				anl_day = '0' + anl_day;
			}
			
			var anl_date = anl_year + "-" + anl_month + "-" + anl_day;

			// alert("사진조회수 필터되니" + anal.pic_count);

			if (anl_date >= sDate && anl_date <= eDate) {
				filteredList.push({
					anl_no : anal.anl_no,
					mem_no : anal.mem_no,
					pic_no : anal.pic_no,
					pic_title : anal.pic_title,
					pic_date : pic_date,
					pic_add : anal.pic_add,
					pic_count : anal.pic_count,
					good_count : anal.good_count,
					rep_count : anal.rep_count,
					anl_word : anal.anl_word,
					anl_date : anl_date,
					anl_count : anal.anl_count
				});
			}
			// alert("날짜 변환 : " + date);
		});

		// alert("필터리스트 크기" + filteredList.length);

		for (var i = 0; i < filteredList.length; i++) {
			// alert("필터리스트 나오는거니" + filteredList[i].Pic_count);

			var currentAnl_no = filteredList[i].anl_no;
			var currentMem_no = filteredList[i].mem_no;
			var currentPic_no = filteredList[i].pic_no;
			var currentPic_title = filteredList[i].pic_title;
			var currentPic_date = filteredList[i].pic_date;
			var currentPic_add = filteredList[i].pic_add;
			var currentPic_count = filteredList[i].pic_count;
			var currentGood_count = filteredList[i].good_count;
			var currentRep_count = filteredList[i].rep_count;
			var currentAnl_word = filteredList[i].anl_word;
			var currentAnl_date = filteredList[i].anl_date;
			var currentAnl_count = filteredList[i].anl_count;

			// alert("이건단어" + currentAnl_word);
			// alert("이건날짜" + currentAnl_date);

			var flag = false;
			var j;
			for (j = 0; j < pic_title_group.length; j++) {
				if (pic_title_group[j] == currentPic_title) {
					flag = true;
					break;
				}
			}

			if (flag) {
				pic_count_group[j] += currentPic_count;
				good_count_group[j] += currentGood_count;
				rep_count_group[j] += currentRep_count;
			} else {
				pic_title_group[j] = currentPic_title;
				pic_count_group[j] = currentPic_count;
				good_count_group[j] = currentGood_count;
				rep_count_group[j] = currentRep_count;
			}
		}
	}

	/*
	 * 차트를 그리기 위해 차트 옵션 정보를 정의하고 전역변수인 day, acc_cnt, customer_cnt Array를 차트에 바인딩한다.
	 */

	function drawChart(type) {

		var options = {
			chart : {
				renderTo : 'dvChart',
				type : type
			},
			credits: {
	            enabled: false
	        },
			title : {
				text : '유입 분석 차트'
			},
			subtitle : {
				text : '사진별'
			},
			xAxis : {
				categories : [],
				type : 'datetime'
			},
			yAxis : {
				min : 0,
				title : {
					text : '횟수'
				}
			},
			tooltip : {
				headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
				pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
						+ '<td style="padding:0"><b>{point.y} 회</b></td></tr>',
				footerFormat : '</table>',
				shared : true,
				enabled : true,
				useHTML : true
			},
			plotOptions : {
				column : {
					pointPadding : 0.2,
					borderWidth : 0
				}
			},
			series : [ {
				name : 'pic_count'
			}, {
				name : 'good_count'

			}, {
				name : 'rep_count'

			} ]
		}

		options.xAxis.categories = pic_title_group;
		//pic_no_group
		//<img src='../../upload/" + pic_add_group + "'/>
		
		//options.xAxis.tickInterval = parseInt(anl_date_group.length / 3);
		
		//alert(pic_count_group);
		//alert(rep_count_group);

		if (type == "pie") {
			options.series[0].name = "사진조회수";
			options.series[0].data = pic_count_group;

			options.series[0].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
		} else {
			options.series[0].name = "사진조회수";
			options.series[0].data = pic_count_group;
			options.series[1].name = "좋아요수";
			options.series[1].data = good_count_group;
			options.series[2].name = "댓글수";
			options.series[2].data = rep_count_group;
			
			options.series[0].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
			options.series[1].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
			options.series[2].dataLabels = {
					enabled : true,
					format : '<b>{point.y}</b>'
			};
		}

		new Highcharts.Chart(options);
	}

	/*
	 * 전역변수인 day, acc_cnt, customer_cnt Array를 이용하여 Table 소스를 생성하여 dvOutput Element에
	 * 바인딩한다.
	 */
	function bindTable() {

		var html = [];

		// 그냥
		/*html.push("<table id=\"tbContents\" class=\"table tablesorter table-bordered table-hover table-condensed\">");

		// table header(thead)
		html.push("<thead><tr class=\"header\">");
		html.push("<th>분석번호</th>");
		//html.push("<th>회원번호</th>");
		//html.push("<th>사진번호</th>");
		html.push("<th>사진</th>");
		html.push("<th>사진조회수</th>");
		html.push("<th>좋아요수</th>");
		html.push("<th>댓글수</th>");
		html.push("<th>검색단어</th>");
		html.push("<th>검색날짜</th>");
		html.push("<th>검색횟수</th>");
		html.push("</tr></thead><tbody>");

		// var data = responseData.list;
		// html.push( "<tr><td>" + data.anl_date + "</td></tr>";

		$.each(anl_date_group, function(index, anal) {
			var year = new Date(anl_date_group[index]).getFullYear();
			var month = new Date(anl_date_group[index]).getMonth() + 1;
			var day = new Date(anl_date_group[index]).getDate();
			var date = year + "-" + month + "-" + day;
			//alert(date);
			//alert("분석번호" + anl_no_group[index]);
			//alert("사진조회수여" + pic_count_group[index]);
			
			html.push("<tr>");
			html.push("<td>" + anl_no_group + "</td>");
			//html.push("<td>" + mem_no_group[index] + "</td>");
			html.push("<td>" + pic_no_group + "</td>");
			html.push("<td>" + pic_count_group + "</td>");
			html.push("<td>" + good_count_group + "</td>");
			html.push("<td>" + rep_count_group + "</td>");
			html.push("<td>" + anl_word_group + "</td>");
			html.push("<td>" + date + "</td>");
			html.push("<td>" + anl_count_group + "</td>");
			html.push("</tr>");
		});
		
		html.push("</tbody></table>");
		$("#anal_table").html(html.join(""));*/
		
		
		//$("#anal_table").tablesorter();
		
		$.getJSON("Anal_json", function(data) {
			var html = [];

			html.push("<thead><tr class=\"header\">");
			html.push("<th>분석번호</th>");
			//html.push("<th>회원번호</th>");
			//html.push("<th>사진번호</th>");
			html.push("<th>사진</th>");
			html.push("<th>사진제목</th>");
			html.push("<th>사진조회수</th>");
			html.push("<th>좋아요수</th>");
			html.push("<th>댓글수</th>");
			html.push("<th>사진날짜</th>");
			html.push("<th>검색단어</th>");
			html.push("<th>검색날짜</th>");
			html.push("<th>검색횟수</th>");
			html.push("</tr></thead><tbody>");

			// var data = responseData.list;
			// html.push( "<tr><td>" + data.anl_date + "</td></tr>";

			$.each(data, function(index, anal) {
				var pic_year = new Date(anal.pic_date).getFullYear();
				var pic_month = new Date(anal.pic_date).getMonth() + 1;
				var pic_day = new Date(anal.pic_date).getDate();
				
				if(pic_month < 10){
					pic_month = '0' + pic_month; 
				} if (pic_day < 10){
					pic_day = '0' + pic_day;
				}
				
				var pic_date = pic_year + "-" + pic_month + "-" + pic_day;
				
				var anl_year = new Date(anal.anl_date).getFullYear();
				var anl_month = new Date(anal.anl_date).getMonth() + 1;
				var anl_day = new Date(anal.anl_date).getDate();
				
				if(anl_month < 10){
					anl_month = '0' + anl_month; 
				} if (anl_day < 10){
					anl_day = '0' + anl_day;
				}
				
				var anl_date = anl_year + "-" + anl_month + "-" + anl_day;

				html.push("<tr>");
				html.push("<td>" + anal.anl_no + "</td>");
				//html.push("<td>" + anal.mem_no + "</td>");
				//html.push("<td>" + anal.pic_no + "</td>");
				html.push("<td>" + "<a href = '../basic/picDetail?pic_no=" + anal.pic_no + "'>" + "<img src='../../upload/" + anal.pic_add + "'/>" + "</a>"  + "</td>");
				html.push("<td>" + anal.pic_title + "</td>");
				html.push("<td>" + anal.pic_count + "</td>");
				html.push("<td>" + anal.good_count + "</td>");
				html.push("<td>" + anal.rep_count + "</td>");
				html.push("<td>" + pic_date + "</td>");
				html.push("<td>" + anal.anl_word + "</td>");
				html.push("<td>" + anl_date + "</td>");
				html.push("<td>" + anal.anl_count + "</td>");
				html.push("</tr>");
			});
			
			html.push("</tbody>");
			html.push("<tfoot><tr><td colspan=\"10\">");
			html.push("<div class=\"pagination pagination-centered hide-if-no-paging\"></div></td></tr>");
			html.push("</tfoot>");
			
			$("#anal_table").html(html.join(""));
			
			// 테이블 정렬
			$("#anal_table").tablesorter();
			
			/*$('.sort-column').click(function (e) {
			    e.preventDefault();

			    //get the footable sort object
			    var footableSort = $('table').data('footable-sort');

			    //get the index we are wanting to sort by
			    var index = $(this).data('index');

			    //get the sort order
			    var ascending = $(this).data('ascending');

			    footableSort.doSort(index, ascending);
			});*/

			// 테이블 페이징
			$('#anal_table').footable();

            $('.clear-filter').click(function (e) {
                e.preventDefault();
                $('table.demo').trigger('footable_clear_filter');
				$('.filter-status').val('');
            });

            $('.filter-status').change(function (e) {
                e.preventDefault();
				var filter = $(this).val();
                $('#filter').val($(this).text());
                $('table.demo').trigger('footable_filter', {filter: filter});
            });
		});

	}
}



// 날짜별 분석(날짜별 사진조회수, 댓글수, 좋아요수 총합)

function date_Analysis(){
	initControl();
	bindData();
	
	$("#btnSubmit").click(function(event) {
		sDate = $("#txtStartDate").val();
		eDate = $("#txtEndDate").val();
		selectedChartType = $("#selChartType").val();
		bindData();
	});
	
	$("#selChartType").change(function(event) {
        sDate = $("#txtStartDate").val();
        eDate = $("#txtEndDate").val();
        selectedChartType = $("#selChartType").val();
       	bindData();
    });
		
	/* 컨트롤 및 전역변수 초기값 설정 */
	function initControl() {
		$(function() {

			$("#txtStartDate, #txtEndDate").datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});

		sDate = "2015-11-22";
		
		var year = new Date().getFullYear();
		var month = new Date().getMonth() + 1;
		var day = new Date().getDate();
		
		if(month < 10){
			month = '0' + month; 
		} if (day < 10){
			day = '0' + day;
		}
		
		var today = year + "-" + month + "-" + day;

		eDate = today;
		
		selectedChartType = $("#selChartType").val();
		
		$("#txtStartDate").val(sDate);
		$("#txtEndDate").val(eDate);
	}

	
	/*
	 * 1) json 파일 get 2) .getJSON 함수는 비동기 AJAX 통신이기 때문에 .getJSON 함수 내에서 차트를 그리고 테이블을
	 * 바인딩해야 한다. 3) 에러가 발생 시 catch하여 alert.
	 */
	function bindData() {

		$.ajaxSetup({
			cache : false
		});

		$.getJSON('Anal_json', function(data) {

			calcData(data);

			drawChart(selectedChartType);

			bindTable();

		}).error(
				function(jqXHR, textStatus, errorThrown) {
					alert("error occured!\nStatus : " + textStatus + "\nError : "
							+ errorThrown);
				});
	}

	/*
	 * 1) json 파일에서 받아온 데이터를 사용자가 선택한 검색 조건(기간, 연령, 게임)에 맞게 필터링 하는 함수 2) 기간, 연령, 게임은
	 * OR 조건이 아니라 AND 조건이기 때문에 모든 조건에 대해 분기를 태워준다. 3) json 데이터 중 검색조건에 충족되는 데이터를
	 * filteredList Array에 담는다. 4) filteredList를 모두 수집했다면 Day 날짜에 대해 Group By 처리하고
	 * ACC_CNT와 CUST_CNT를 SUM 처리한다. 5) 전역변수인 day, acc_cnt, customer_cnt에 값을 할당한다.
	 */

	function calcData(data) {

		anl_no_group = [];
		mem_no_group = [];
		pic_no_group = [];
		pic_title_group = [];
		pic_date_group = [];
		pic_add_group = [];
		pic_count_group = [];
		good_count_group = [];
		rep_count_group = [];
		anl_word_group = [];
		anl_date_group = [];
		anl_count_group = [];

		var filteredList = [];

		$.each(data, function(index, anal) {
			// 날짜 형식 변환
			var pic_year = new Date(anal.pic_date).getFullYear();
			var pic_month = new Date(anal.pic_date).getMonth() + 1;
			var pic_day = new Date(anal.pic_date).getDate();
			
			if(pic_month < 10){
				pic_month = '0' + pic_month; 
			} if (pic_day < 10){
				pic_day = '0' + pic_day;
			}
			
			var pic_date = pic_year + "-" + pic_month + "-" + pic_day;
			
			var anl_year = new Date(anal.anl_date).getFullYear();
			var anl_month = new Date(anal.anl_date).getMonth() + 1;
			var anl_day = new Date(anal.anl_date).getDate();
			
			if(anl_month < 10){
				anl_month = '0' + anl_month; 
			} if (anl_day < 10){
				anl_day = '0' + anl_day;
			}
			
			var anl_date = anl_year + "-" + anl_month + "-" + anl_day;

			// alert("사진조회수 필터되니" + anal.pic_count);

			if (anl_date >= sDate && anl_date <= eDate) {
				filteredList.push({
					anl_no : anal.anl_no,
					mem_no : anal.mem_no,
					pic_no : anal.pic_no,
					pic_title : anal.pic_title,
					pic_date : pic_date,
					pic_add : anal.pic_add,
					pic_count : anal.pic_count,
					good_count : anal.good_count,
					rep_count : anal.rep_count,
					anl_word : anal.anl_word,
					anl_date : anl_date,
					anl_count : anal.anl_count
				});
			}
			// alert("날짜 변환 : " + date);
		});

		// alert("필터리스트 크기" + filteredList.length);

		for (var i = 0; i < filteredList.length; i++) {
			// alert("필터리스트 나오는거니" + filteredList[i].Pic_count);

			var currentAnl_no = filteredList[i].anl_no;
			var currentMem_no = filteredList[i].mem_no;
			var currentPic_no = filteredList[i].pic_no;
			var currentPic_title = filteredList[i].pic_title;
			var currentPic_date = filteredList[i].pic_date;
			var currentPic_add = filteredList[i].pic_add;
			var currentPic_count = filteredList[i].pic_count;
			var currentGood_count = filteredList[i].good_count;
			var currentRep_count = filteredList[i].rep_count;
			var currentAnl_word = filteredList[i].anl_word;
			var currentAnl_date = filteredList[i].anl_date;
			var currentAnl_count = filteredList[i].anl_count;

			// alert("이건단어" + currentAnl_word);
			// alert("이건날짜" + currentAnl_date);

			var flag = false;
			var j;
			for (j = 0; j < pic_date_group.length; j++) {
				if (pic_date_group[j] == currentPic_date) {
					flag = true;
					break;
				}
			}

			if (flag) {
				pic_count_group[j] += currentPic_count;
				good_count_group[j] += currentGood_count;
				rep_count_group[j] += currentRep_count;
			} else {
				pic_date_group[j] = currentAnl_date;
				pic_count_group[j] = currentPic_count;
				good_count_group[j] = currentGood_count;
				rep_count_group[j] = currentRep_count;
			}
		}
	}

	/*
	 * 차트를 그리기 위해 차트 옵션 정보를 정의하고 전역변수인 day, acc_cnt, customer_cnt Array를 차트에 바인딩한다.
	 */

	function drawChart(type) {

		var options = {
			chart : {
				renderTo : 'dvChart',
				type : type
			},
			credits: {
	            enabled: false
	        },
			title : {
				text : '유입 분석 차트'
			},
			subtitle : {
				text : '날짜별'
			},
			xAxis : {
				categories : [],
				type : 'datetime'
			},
			yAxis : {
				min : 0,
				title : {
					text : '횟수'
				}
			},
			tooltip : {
				headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
				pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
						+ '<td style="padding:0"><b>{point.y} 회</b></td></tr>',
				footerFormat : '</table>',
				shared : true,
				enabled : true,
				useHTML : true
			},
			plotOptions : {
				column : {
					pointPadding : 0.2,
					borderWidth : 0
				}
			},
			series : [ {
				name : 'pic_count'
			}, {
				name : 'good_count'

			}, {
				name : 'rep_count'
			} ]
		}

		options.xAxis.categories = pic_date_group;
		options.xAxis.tickInterval = parseInt(pic_date_group.length / 3);
		//alert(pic_count_group);
		//alert(rep_count_group);

		if (type == "pie") {
			options.series[0].name = "사진조회수";
			options.series[0].data = pic_count_group;

			options.series[0].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
		} else {
			options.series[0].name = "사진조회수";
			options.series[0].data = pic_count_group;
			options.series[1].name = "좋아요수";
			options.series[1].data = good_count_group;
			options.series[2].name = "댓글수";
			options.series[2].data = rep_count_group;
			options.series[0].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
			options.series[1].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
			options.series[2].dataLabels = {
				enabled : true,
				format : '<b>{point.y}</b>'
			};
		}

		new Highcharts.Chart(options);
	}

	/*
	 * 전역변수인 day, acc_cnt, customer_cnt Array를 이용하여 Table 소스를 생성하여 dvOutput Element에
	 * 바인딩한다.
	 */
	function bindTable() {

		var html = [];
		
		// 그냥
		/*html.push("<table id=\"tbContents\" class=\"table tablesorter table-bordered table-hover table-condensed\">");

		// table header(thead)
		html.push("<thead><tr class=\"header\">");
		html.push("<th>분석번호</th>");
		//html.push("<th>회원번호</th>");
		//html.push("<th>사진번호</th>");
		html.push("<th>사진</th>");
		html.push("<th>사진조회수</th>");
		html.push("<th>좋아요수</th>");
		html.push("<th>댓글수</th>");
		html.push("<th>검색단어</th>");
		html.push("<th>검색날짜</th>");
		html.push("<th>검색횟수</th>");
		html.push("</tr></thead><tbody>");

		// var data = responseData.list;
		// html.push( "<tr><td>" + data.anl_date + "</td></tr>";

		$.each(anl_date_group, function(index, anal) {
			var year = new Date(anl_date_group[index]).getFullYear();
			var month = new Date(anl_date_group[index]).getMonth() + 1;
			var day = new Date(anl_date_group[index]).getDate();
			var date = year + "-" + month + "-" + day;
			//alert(date);
			//alert("분석번호" + anl_no_group[index]);
			//alert("사진조회수여" + pic_count_group[index]);
			
			html.push("<tr>");
			html.push("<td>" + anl_no_group + "</td>");
			//html.push("<td>" + mem_no_group[index] + "</td>");
			html.push("<td>" + pic_no_group + "</td>");
			html.push("<td>" + pic_count_group + "</td>");
			html.push("<td>" + good_count_group + "</td>");
			html.push("<td>" + rep_count_group + "</td>");
			html.push("<td>" + anl_word_group + "</td>");
			html.push("<td>" + date + "</td>");
			html.push("<td>" + anl_count_group + "</td>");
			html.push("</tr>");
		});
		
		html.push("</tbody></table>");
		$("#anal_table").html(html.join(""));*/
		
		$.getJSON("Anal_json", function(data) {
			var html = [];
			var count = 0;

			html.push("<thead><tr class=\"header\">");
			html.push("<th>분석번호</th>");
			//html.push("<th>회원번호</th>");
			//html.push("<th>사진번호</th>");
			html.push("<th>사진</th>");
			html.push("<th>사진제목</th>");
			html.push("<th>사진조회수</th>");
			html.push("<th>좋아요수</th>");
			html.push("<th>댓글수</th>");
			html.push("<th>사진날짜</th>");
			html.push("<th>검색단어</th>");
			html.push("<th>검색날짜</th>");
			html.push("<th>검색횟수</th>");
			html.push("</tr></thead><tbody>");

			// var data = responseData.list;
			// html.push( "<tr><td>" + data.anl_date + "</td></tr>";
			
			$.each(data, function(index, anal) {
				//count++;
				
				var pic_year = new Date(anal.pic_date).getFullYear();
				var pic_month = new Date(anal.pic_date).getMonth() + 1;
				var pic_day = new Date(anal.pic_date).getDate();
				
				if(pic_month < 10){
					pic_month = '0' + pic_month; 
				} if (pic_day < 10){
					pic_day = '0' + pic_day;
				}
				
				var pic_date = pic_year + "-" + pic_month + "-" + pic_day;
				
				var anl_year = new Date(anal.anl_date).getFullYear();
				var anl_month = new Date(anal.anl_date).getMonth() + 1;
				var anl_day = new Date(anal.anl_date).getDate();
				
				if(anl_month < 10){
					anl_month = '0' + anl_month; 
				} if (anl_day < 10){
					anl_day = '0' + anl_day;
				}
				
				var anl_date = anl_year + "-" + anl_month + "-" + anl_day;

				html.push("<tr>");
				html.push("<td>" + anal.anl_no + "</td>");
				//html.push("<td>" + anal.mem_no + "</td>");
				//html.push("<td>" + anal.pic_no + "</td>");
				html.push("<td>" + "<a href = '../basic/picDetail?pic_no=" + anal.pic_no + "'>" + "<img src='../../upload/" + anal.pic_add + "'/>" + "</a>"  + "</td>");
				html.push("<td>" + anal.pic_title + "</td>");
				html.push("<td>" + anal.pic_count + "</td>");
				html.push("<td>" + anal.good_count + "</td>");
				html.push("<td>" + anal.rep_count + "</td>");
				html.push("<td>" + pic_date + "</td>");
				html.push("<td>" + anal.anl_word + "</td>");
				html.push("<td>" + anl_date + "</td>");
				html.push("<td>" + anal.anl_count + "</td>");
				html.push("</tr>");
				
				/*if(count == 10){
					return false;
				}*/
			});

			html.push("</tbody>");
			html.push("<tfoot><tr><td colspan=\"10\">");
			html.push("<div class=\"pagination pagination-centered hide-if-no-paging\"></div></td></tr>");
			html.push("</tfoot>");
			
			$("#anal_table").html(html.join(""));
			
			// 테이블 정렬
			$("#anal_table").tablesorter();
			
			/*$('.sort-column').click(function (e) {
			    e.preventDefault();

			    //get the footable sort object
			    var footableSort = $('table').data('footable-sort');

			    //get the index we are wanting to sort by
			    var index = $(this).data('index');

			    //get the sort order
			    var ascending = $(this).data('ascending');

			    footableSort.doSort(index, ascending);
			});*/

			// 테이블 페이징
			$('#anal_table').footable();

            $('.clear-filter').click(function (e) {
                e.preventDefault();
                $('table.demo').trigger('footable_clear_filter');
				$('.filter-status').val('');
            });

            $('.filter-status').change(function (e) {
                e.preventDefault();
				var filter = $(this).val();
                $('#filter').val($(this).text());
                $('table.demo').trigger('footable_filter', {filter: filter});
            });
		});
	}	
}


/*function tableSort(){
	$("#anal_table").tablesorter();
	$("#tbContents").tablesorter(); 
}*/
 