$(function () {
	 
	   if (window.location.hostname === 'localhost') {
		    // Demo settings:
		   
		    	$('#fileupload').fileupload({
		    		maxChunkSize: 10000000, // 10 MB
		            url: 'fupload.po',
		            dataType: 'json',
		            beforeSend: function () {
		            	var form_title = $.trim($('#form_title').val());
		   			 	if (form_title  === '') {
		   			        alert('제목을 입력하세요');
		   			        return false;
		   			    }
		            },
		            success : function(data){
		            },
		            complete : function(data){
		            	alert('업로드 되었습니다');
		            	location.href='../myRoom/my_Show.html';
		            }
		        });
		    	
		   
		}
	});