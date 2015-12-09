$(function(){
	$('.ui-button').click(function(){
		var pic_no = $('#pic_no').val();
		var rep_content = $('#rep_content').val();
		$.ajax({

			type:"GET",
			url:"photo_reply_detail",
			data:{
				"pic_no":pic_no,
				"rep_content" : rep_content
			},
			success: function(data){
					var html = '<li class="comment">';
					html +='<div class="comment-icon circle-icon ">';
					html +='<a href="/photos/34225448@N06/">';
					html +='<img width="32" height="32" src="//c2.staticflickr.com/6/5616/buddyicons/34225448@N06.jpg?1413297268#34225448@N06">';
					html +='</a>';
					html +='</div>';
					html +='<p class="comment-author">';
					html +='<a href="/photos/34225448@N06/">'+data.mem_name+'</a>';
					html +='<span class="comment-date">'+data.rep_date+'</span>';
					html +='</p>';
					html +='<div class="comment-content">'+data.rep_content+'</div>';
					html +='</li>';
					
					$('.comments').append(html);
					
					$('#rep_content').val('');
			},
			error:function(){
				
				alert('실패');
			}
			
		});
		
	});
	var pic_no_chk = $('#pic_no').val();
	$.ajax({
		
		url:"list_reply_detail/"+pic_no_chk,
		type: "GET",
		success:function(data){
			$.each(data, function(index,reply){
				
				var html = '<li class="comment">';
				html +='<div class="comment-icon circle-icon ">';
				html +='<a href="/photos/34225448@N06/">';
				html +='<img width="32" height="32" src="//c2.staticflickr.com/6/5616/buddyicons/34225448@N06.jpg?1413297268#34225448@N06">';
				html +='</a>';
				html +='</div>';
				html +='<p class="comment-author">';
				html +='<a href="/photos/34225448@N06/">'+reply.mem_name+'</a>';
				html +='<span class="comment-date">'+reply.rep_date+'</span>';
				html +='</p>';
				html +='<div class="comment-content">'+reply.rep_content+'</div>';
				html +='</li>';
				
				$('.comments').append(html);
                	
            });
				
			
			
		}
	});
});