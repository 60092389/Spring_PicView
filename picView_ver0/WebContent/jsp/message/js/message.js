$(function() {

	$(document).on('click', '#all_check', function() {
		$('.check').prop('checked', this.checked); // 전체 선택 / 선택해제
	});

	$(document).on('click', '#remove_btn', function() {
		if (confirm('쪽지를 삭제하시겠습니까?')) {

			var msg_no = "";

			$('input.check:checked').each(function() { // 여러개 클릭
				// $(this).parents('tr').remove();
				msg_no += $(this).val() + ",";
			});

			msg_no = msg_no.replace(/[,]+$/, '');
			location.href = "message_delete?msg_no=" + msg_no;

			/*
			 * $.ajax({ url : 'message_delete/, type : 'post', data : {
			 * msg_no_list : msg_no, } dataType : 'text', success :
			 * function(data) { //alert('ajax!! : ' + data); //location.href =
			 * "message_json"; //$.each(data, function(index, message){ //
			 * $('#message').append('<tr><td>' + message.msg_no + '</td></tr>');
			 * //}); alert('성공'); }, error : function() { alert('error');} });
			 */

			/*
			 * $.getJSON('message_json', function(data){ $.each(data,
			 * function(index, message){ $('#message').append('<tbody><tr><td>' + '<input
			 * type="checkbox" value="message.msg_no" class="check"
			 * name="check"/>' + '</td>' + '<td>' + message.msg_sender + '</td>' + '</td>' + '<td>' +
			 * message.msg_content + '</td>' + '<td>' + '123' + '</td></tr></tbody>');
			 * }); });
			 */
		}
	});
	
	$(document).on('click', '#save_btn', function() {
		var msg_no = ''; 
		
		$('input.check:checked').each(function() {
			msg_no += $(this).val() + ",";
		});
		
		msg_no = msg_no.replace(/[,]+$/, '');
		alert(msg_no);
		
		location.href = "saveMessage?msg_no=" + msg_no;
	});

	$('#send_btn').click(function() {	// 쪽지 여러명 쓰기 안돼
		var sender = '';
		
		$('input.check:checked').each(function() {
			sender += $(this).parent('td').find('.sender').val() + ",";
		});

		sender = sender.replace(/[,]+$/, '');
		alert(sender);
		// location.href = "message_write"
	});

	$('#receive_list').click(function() {
		$(this).parent().parent().find('li').attr('class', '');
		$(this).parent('li').attr('class', 'active');

		$.ajax({
			type: 'get',
			url: 'message_list_json',
			error: function(){
				alert('실패');
			},
			success:function(data){
				
				alert("받은쪽지함 성공");
				
				$('#search').empty();
				$('#btn_group').empty();
				$('#message_table').empty();
				
				var search = '';
				
				search += '<select><option>전체쪽지</option><option>받은쪽지</option>';
				search += '<option>보낸쪽지</option><option>보관쪽지</option></select>';
				search += '<select><option>아이디</option><option>이름</option><option>내용</option></select>';
				search += '<input type="text" id="search_input" class="form-control" placeholder="쪽지검색" />';
				search += '<a href=""><span id="search_icon" class="glyphicon glyphicon-search"></span></a>';
				
				$('#search').append(search);
				
				
				var btn_group = '';
				
				btn_group += '<input id="remove_btn" type="button" value="삭제" /> ';
				btn_group += '<input id="save_btn" type="button" value="보관" />';
				btn_group += '<input id="send_btn"	type="button" value="답장" />';
				
				$('#btn_group').append(btn_group);
				
				
				var message_table = '';
				
				message_table += '<table cellpadding="0" cellspacing="0" id="message" class="table table-bordered table-hover table-condensed">';
				message_table += '<colgroup><col width="50"><col width="130"><col width="*"><col width="150"></colgroup>';
				message_table += '<thead><tr><th><input id="all_check" type="checkbox" /></th>';
				message_table += '<th>보낸사람</th><th>내용</th><th>날짜</th></tr></thead><tbody>';
				
				$.each(data, function(index, list){
					message_table += '<tr><td><input type="checkbox" value="' + list.msg_no + '" class="check" name="check" />';
					message_table += '<input type="hidden" value="' + list.msg_sender + '" class="sender" name="sender" />';
					message_table += '<td>' + list.msg_sender + '</td>';
					message_table += '<td><a href="/jsp/message/message_detail/' + list.msg_no + '">' + list.msg_content +  '</a></td>';
					
					var wri_date_year = new Date(list.msg_wri_date).getFullYear();
					var wri_date_month = new Date(list.msg_wri_date).getMonth() + 1;
					var wri_date_day = new Date(list.msg_wri_date).getDate();
					var wri_date_hours = new Date(list.msg_wri_date).getHours();
					var wri_date_minutes = new Date(list.msg_wri_date).getMinutes();
					var wri_date_seconds = new Date(list.msg_wri_date).getSeconds();
					
					if(wri_date_month < 10){
						wri_date_month = '0' + wri_date_month; 
					} if (wri_date_day < 10){
						wri_date_day = '0' + wri_date_day;
					} if (wri_date_hours < 10) {
						wri_date_hours = '0' + wri_date_hours;
					} if (wri_date_minutes < 10) {
						wri_date_minutes = '0' + wri_date_minutes;
					} if (wri_date_seconds < 10) {
						wri_date_seconds = '0' + wri_date_seconds;
					}

					var msg_wri_date = wri_date_year + "-" + wri_date_month + "-" + wri_date_day + " [" +
						wri_date_hours + ":" + wri_date_minutes + ":" + wri_date_seconds + ']';
					
					message_table += '<td>' + msg_wri_date + '</td></tr>';
				
				});
				
				message_table += '</tbody></table>';
						
				$('#message_table').append(message_table);
			}
		});
	});

	$('#send_list').click(function() {
		$(this).parent().parent().find('li').attr('class', '');
		$(this).parent('li').attr('class', 'active');
		
		$.ajax({
			type: 'get',
			url: 'send_list_json',
			dataType: 'json',
			error: function(){
				alert('실패');
			},
			success:function(data) {
				
				alert("보낸쪽지함 성공");
				
				$('#search').empty();
				$('#btn_group').empty();
				$('#message_table').empty();
				
				var search = '';
				
				search += '<select><option>전체쪽지</option><option>받은쪽지</option>';
				search += '<option>보낸쪽지</option><option>보관쪽지</option></select>';
				search += '<select><option>아이디</option><option>이름</option><option>내용</option></select>';
				search += '<input type="text" id="search_input" class="form-control" placeholder="쪽지검색" />';
				search += '<a href=""><span id="search_icon" class="glyphicon glyphicon-search"></span></a>';
				
				$('#search').append(search);
				
				
				var btn_group = '';
				
				btn_group += '<input id="remove_btn" type="button" value="삭제" /> ';
				btn_group += '<input id="save_btn" type="button" value="보관" />';
				btn_group += '<input id="send_btn"	type="button" value="답장" />';
				
				$('#btn_group').append(btn_group);
				
				
				var html = '';
				html += '<table cellpadding="0" cellspacing="0" id="message" class="table table-bordered table-hover table-condensed">';
				html += '<colgroup><col width="50"><col width="130"><col width="*"><col width="150"><col width="150"></colgroup>';
				html += '<thead><tr><th><input id="all_check" type="checkbox" /></th><th>받는사람</th>';
				html += '<th>내용</th><th>보낸날짜</th><th>받은날짜</th></tr></thead><tbody>';
					
				$.each(data, function(index, send){
					html += '<tr><td><input type="checkbox" value="' + send.msg_no + '" class="check" name="check" />';
					html += '<input type="hidden" value="' + send.msg_receiver + '" class="sender" name="sender" />';
					html += '<td>' + send.msg_receiver + '</td>';
					html += '<td><a href="/jsp/message/message_detail/' + send.msg_no + '">' + send.msg_content + '</a></td>';
					
					var wri_date_year = new Date(send.msg_wri_date).getFullYear();
					var wri_date_month = new Date(send.msg_wri_date).getMonth() + 1;
					var wri_date_day = new Date(send.msg_wri_date).getDate();
					var wri_date_hours = new Date(send.msg_wri_date).getHours();
					var wri_date_minutes = new Date(send.msg_wri_date).getMinutes();
					var wri_date_seconds = new Date(send.msg_wri_date).getSeconds();
					
					if(wri_date_month < 10){
						wri_date_month = '0' + wri_date_month; 
					} if (wri_date_day < 10){
						wri_date_day = '0' + wri_date_day;
					} if (wri_date_hours < 10) {
						wri_date_hours = '0' + wri_date_hours;
					} if (wri_date_minutes < 10) {
						wri_date_minutes = '0' + wri_date_minutes;
					} if (wri_date_seconds < 10) {
						wri_date_seconds = '0' + wri_date_seconds;
					}

					var msg_wri_date = wri_date_year + "-" + wri_date_month + "-" + wri_date_day + " [" +
						wri_date_hours + ":" + wri_date_minutes + ":" + wri_date_seconds + ']';
						
					html += '<td>'+ msg_wri_date + '</td>';
					
					var rec_date_year = new Date(send.msg_rec_date).getFullYear();
					var rec_date_month = new Date(send.msg_rec_date).getMonth() + 1;
					var rec_date_day = new Date(send.msg_rec_date).getDate();
					var rec_date_hours = new Date(send.msg_rec_date).getHours();
					var rec_date_minutes = new Date(send.msg_rec_date).getMinutes();
					var rec_date_seconds = new Date(send.msg_rec_date).getSeconds();
					
					if(rec_date_month < 10){
						rec_date_month = '0' + rec_date_month; 
					} if (rec_date_day < 10){
						rec_date_day = '0' + rec_date_day;
					} if (rec_date_hours < 10) {
						rec_date_hours = '0' + rec_date_hours;
					} if (rec_date_minutes < 10) {
						rec_date_minutes = '0' + rec_date_minutes;
					} if (rec_date_seconds < 10) {
						rec_date_seconds = '0' + rec_date_seconds;
					}
					
					var msg_rec_date = rec_date_year + '-' + rec_date_month + '-' + rec_date_day + ' [' +
						rec_date_hours + ':' + rec_date_minutes + ':' + rec_date_seconds + ']';
					
					if(isNaN(msg_rec_date)){
						msg_rec_date = "읽지않음";
					}
					
					html += '<td>'+ msg_rec_date + '</td></tr>';
				});
				
				html += '</tbody></table>';
				
				$('#message_table').append(html);
			}
		
		});
		
		// location.href = "send_list";
	});

	$('#save_list').click(function() {
		$(this).parent().parent().find('li').attr('class', '');
		$(this).parent('li').attr('class', 'active');
		
		$.ajax({
			type: 'get',
			url: 'save_list_json',
			dataType: 'json',
			error: function(){
				alert('실패');
			},
			success:function(data) {
				
				alert("쪽지보관함 성공");

				$('#message_table').empty();
				
				var html = '';
				html += '<table cellpadding="0" cellspacing="0" id="message" class="table table-bordered table-hover table-condensed">';
				html += '<colgroup><col width="50"><col width="130"><col width="*"><col width="150"></colgroup>';
				html += '<thead><tr><th><input id="all_check" type="checkbox" /></th><th>보낸사람</th>';
				html += '<th>내용</th><th>날짜</th></tr></thead><tbody>';
					
				$.each(data, function(index, save){
					html += '<tr><td><input type="checkbox" value="' + save.msg_no + '" class="check" name="check" />';
					html += '<input type="hidden" value="' + save.msg_sender + '" class="sender" name="sender" />';
					html += '<td>' + save.msg_sender + '</td>';
					html += '<td><a href="/jsp/message/message_detail/' + save.msg_no + '">' + save.msg_content + '</a></td>';
					
					var wri_date_year = new Date(save.msg_wri_date).getFullYear();
					var wri_date_month = new Date(save.msg_wri_date).getMonth() + 1;
					var wri_date_day = new Date(save.msg_wri_date).getDate();
					var wri_date_hours = new Date(save.msg_wri_date).getHours();
					var wri_date_minutes = new Date(save.msg_wri_date).getMinutes();
					var wri_date_seconds = new Date(save.msg_wri_date).getSeconds();
					
					if(wri_date_month < 10){
						wri_date_month = '0' + wri_date_month; 
					} if (wri_date_day < 10){
						wri_date_day = '0' + wri_date_day;
					} if (wri_date_hours < 10) {
						wri_date_hours = '0' + wri_date_hours;
					} if (wri_date_minutes < 10) {
						wri_date_minutes = '0' + wri_date_minutes;
					} if (wri_date_seconds < 10) {
						wri_date_seconds = '0' + wri_date_seconds;
					}

					var msg_wri_date = wri_date_year + "-" + wri_date_month + "-" + wri_date_day + " [" +
						wri_date_hours + ":" + wri_date_minutes + ":" + wri_date_seconds + ']';			
						
					html += '<td>'+ msg_wri_date + '</td></tr>';	
				});
				
				html += '</tbody></table>';
				
				$('#message_table').append(html);
			}
		
		});
		// location.href = "save_list";
	});
	
	$('#message_write_btn').click(function() {	
		alert('쪽지 쓰기');
		
		$.ajax({
			type: 'get',
			url: 'message_write',
			dataType: 'html',
			error: function(){
				alert('실패');
			},
			success:function(){
				alert('성공');
				$('#search').empty();
				$('#btn_group').empty();
				$('#message_table').empty();
				$('#title_area').empty();
				
				var html = '';
				html += '<div id="write_form">'
				html += '<form action="message_write" method="post" role="form" id="message_send">';
				html += '<label>받는사람</label><div id="to" class="form-group">';
				html += '<input type="text" id="msg_receiver" class="form-control" placeholder="이름" name="msg_receiver" />';
				html += '<input type="text" id="msg_sender" class="form-control" placeholder="보내는사람" name="msg_sender" />';
				html += '</div><textarea id="msg" cols="55" rows="5" name="msg_content"></textarea>';
				html += '<div id="write_btn_group"><input type="submit" id="msg_write" class="btn btn-success" value="보내기">';
				html += '<input type="button" id="msg_list" class="btn btn-success" value="목록보기">';
				html += '</div></div></form>';

				$('#btn_group').append(html);
				
				var title = '';
				title += '<h1 class="mail-header"><a href="message">PicView 쪽지함</a> / 쪽지 작성</h1>';
				
				$('#title_area').append(title);
			}
		});

		// location.href = "message_write";
	});
	
	$(document).on('click', '#msg_write', function() {
		alert('쪽지쓰기완료');
		
		$.ajax({
			type: 'post',
			url: 'message_write',
			data: $('#message_send').serialize(),
			error: function(){
				alert('실패');
			},
			success:function(){

				$('#message_table').empty();
				
				var message_table = '';
				
				message_table += '<table cellpadding="0" cellspacing="0" id="message" class="table table-bordered table-hover table-condensed">';
				message_table += '<colgroup><col width="50"><col width="130"><col width="*"><col width="150"></colgroup>';
				message_table += '<thead><tr><th><input id="all_check" type="checkbox" /></th>';
				message_table += '<th>보낸사람</th>th>내용</th><th>날짜</th></tr></thead><tbody>';
				
				$.each(data, function(index, list){
					message_table += '<tr><td><input type="checkbox" value="' + list.msg_no + '" class="check" name="check" />';
					message_table += '<input type="hidden" value="' + list.msg_sender + '" class="sender" name="sender" />';
					message_table += '<td>' + list.msg_sender + '</td>';
					message_table += '<td><a href="/jsp/message/message_detail/' + list.msg_no + '">' + list.msg_content +  '</a></td>';
				
					var wri_date_year = new Date(list.msg_wri_date).getFullYear();
					var wri_date_month = new Date(list.msg_wri_date).getMonth() + 1;
					var wri_date_day = new Date(list.msg_wri_date).getDate();
					var wri_date_hours = new Date(list.msg_wri_date).getHours();
					var wri_date_minutes = new Date(list.msg_wri_date).getMinutes();
					var wri_date_seconds = new Date(list.msg_wri_date).getSeconds();
					
					if(wri_date_month < 10){
						wri_date_month = '0' + wri_date_month; 
					} if (wri_date_day < 10){
						wri_date_day = '0' + wri_date_day;
					} if (wri_date_hours < 10) {
						wri_date_hours = '0' + wri_date_hours;
					} if (wri_date_minutes < 10) {
						wri_date_minutes = '0' + wri_date_minutes;
					} if (wri_date_seconds < 10) {
						wri_date_seconds = '0' + wri_date_seconds;
					}

					var msg_wri_date = wri_date_year + "-" + wri_date_month + "-" + wri_date_day + " [" +
						wri_date_hours + ":" + wri_date_minutes + ":" + wri_date_seconds + ']';
					
					message_table += '<td>' + msg_wri_date + '</td></tr>';
				
				});
				
				message_table += '</tbody></table>';
						
				$('#message_table').append(message_table);
			}
		});
	});
	
	/*$('table a').click(function() {
		alert('쪽지 자세히보기');
		$.ajax({
			type: 'get',
			url: 'message_detail/{msg_no}',
			//data: $('#message_send').serialize(),
			error:function(){
				alert('실패');
			},
			success:function(){

				$('#message_table').empty();
				
				var message_detail_table = '';
				
				message_table += '<table cellpadding="0" cellspacing="0" id="message" class="table table-bordered table-hover table-condensed">';
				message_table += '<colgroup><col width="50"><col width="130"><col width="*"><col width="150"></colgroup>';
				message_table += '<thead><tr><th><input id="all_check" type="checkbox" /></th>';
				message_table += '<th>보낸사람</th>th>내용</th><th>날짜</th></tr></thead><tbody>';
				
				$.each(data, function(index, list){
					message_table += '<tr><td><input type="checkbox" value="' + list.msg_no + '" class="check" name="check" />';
					message_table += '<input type="hidden" value="' + list.msg_sender + '" class="sender" name="sender" />';
					message_table += '<td>' + list.msg_sender + '</td>';
					message_table += '<td><a href="/jsp/message/message_detail/' + list.msg_no + '">' + list.msg_content +  '</a></td>';
				
					var wri_date_year = new Date(list.msg_wri_date).getFullYear();
					var wri_date_month = new Date(list.msg_wri_date).getMonth() + 1;
					var wri_date_day = new Date(list.msg_wri_date).getDate();
					var wri_date_hours = new Date(list.msg_wri_date).getHours();
					var wri_date_minutes = new Date(list.msg_wri_date).getMinutes();
					var wri_date_seconds = new Date(list.msg_wri_date).getSeconds();
					
					if(wri_date_month < 10){
						wri_date_month = '0' + wri_date_month; 
					} else if (wri_date_day < 10){
						wri_date_day = '0' + wri_date_day;
					} else if (wri_date_hours < 10) {
						wri_date_hours = '0' + wri_date_hours;
					} else if (wri_date_minutes < 10) {
						wri_date_minutes = '0' + wri_date_minutes;
					} else if (wri_date_seconds < 10) {
						wri_date_seconds = '0' + wri_date_seconds;
					}
					
					var msg_wri_date = wri_date_year + '-' + wri_date_month + '-' + wri_date_day + ' [' +
						wri_date_hours + ':' + wri_date_minutes + ':' + wri_date_seconds + ']';
					
					message_table += '<td>' + msg_wri_date + '</td></tr>';
				
				});
				
				message_table += '</tbody></table>';
						
				$('#message_table').append(message_table);
			}
		});
	});*/
	
	$(document).on('click', '#msg_list', function() {	/// /안돼
		alert('메인으로');
		$.ajax({
			type: 'get',
			url: 'message_list_json',
			error: function(){
				alert('실패');
			},
			success:function(data){
				alert('목록보기');			
				
				$('#search').empty();
				$('#btn_group').empty();
				$('#message_table').empty();
				
				var search = '';
				
				search += '<select><option>전체쪽지</option><option>받은쪽지</option>';
				search += '<option>보낸쪽지</option><option>보관쪽지</option></select>';
				search += '<select><option>아이디</option><option>이름</option><option>내용</option></select>';
				search += '<input type="text" id="search_input" class="form-control" placeholder="쪽지검색" />';
				search += '<a href=""><span id="search_icon" class="glyphicon glyphicon-search"></span></a>';
				
				$('#search').append(search);
				
				
				var btn_group = '';
				
				btn_group += '<input id="remove_btn" type="button" value="삭제" /> ';
				btn_group += '<input id="save_btn" type="button" value="보관" />';
				btn_group += '<input id="send_btn"	type="button" value="답장" />';
				
				$('#btn_group').append(btn_group);
				
				var message_table = '';
				
				message_table += '<table cellpadding="0" cellspacing="0" id="message" class="table table-bordered table-hover table-condensed">';
				message_table += '<colgroup><col width="50"><col width="130"><col width="*"><col width="150"></colgroup>';
				message_table += '<thead><tr><th><input id="all_check" type="checkbox" /></th>';
				message_table += '<th>보낸사람</th><th>내용</th><th>날짜</th></tr></thead><tbody>';
				
				$.each(data, function(index, list){
					message_table += '<tr><td><input type="checkbox" value="' + list.msg_no + '" class="check" name="check" />';
					message_table += '<input type="hidden" value="' + list.msg_sender + '" class="sender" name="sender" />';
					message_table += '<td>' + list.msg_sender + '</td>';
					message_table += '<td><a href="/jsp/message/message_detail/' + list.msg_no + '">' + list.msg_content +  '</a></td>';
				
					var wri_date_year = new Date(list.msg_wri_date).getFullYear();
					var wri_date_month = new Date(list.msg_wri_date).getMonth() + 1;
					var wri_date_day = new Date(list.msg_wri_date).getDate();
					var wri_date_hours = new Date(list.msg_wri_date).getHours();
					var wri_date_minutes = new Date(list.msg_wri_date).getMinutes();
					var wri_date_seconds = new Date(list.msg_wri_date).getSeconds();
					
					if(wri_date_month < 10){
						wri_date_month = '0' + wri_date_month; 
					} if (wri_date_day < 10){
						wri_date_day = '0' + wri_date_day;
					} if (wri_date_hours < 10) {
						wri_date_hours = '0' + wri_date_hours;
					} if (wri_date_minutes < 10) {
						wri_date_minutes = '0' + wri_date_minutes;
					} if (wri_date_seconds < 10) {
						wri_date_seconds = '0' + wri_date_seconds;
					}

					var msg_wri_date = wri_date_year + "-" + wri_date_month + "-" + wri_date_day + " [" +
						wri_date_hours + ":" + wri_date_minutes + ":" + wri_date_seconds + ']';
					
					message_table += '<td>' + msg_wri_date + '</td></tr>';
				
				});
				
				message_table += '</tbody></table>';
						
				$('#message_table').append(message_table);
			}
		});
	});
	
});

