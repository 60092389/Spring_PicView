$(document).ready(function(){
	var index_chk = 0;
	var now = new Date();
	var wri_date_year = new Date(now);
	var chk_date =  $('#wri_date_year').val(wri_date_year);
	  (function poll() {
	    setTimeout(function() {
	        $.ajax({
	            url: "count_activity_alarm{chk_date}",
	            type: "GET",
	            success: function(data) {
	                index_chk = data;
	                $('.notification-count').html(index_chk);
	                
	            },
	            dataType: "json",
	            complete: poll,
	            timeout: 10000
	        })
	    }, 10000); 
	  })();
	  
	  
	  //현재시간을 체크한 다음에 체크 한 시간 보다 큰 거 나오게 하기 
	  
	 
	//갖고올때마다 인덱스가 1씩 쌓이고 알람 아이콘을 누르면 인덱스가 다시 1이됨 
});