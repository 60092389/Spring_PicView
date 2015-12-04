$(document).ready(function(){
	var objDragAndDrop = $(".dragAndDropDiv");
	var fd = new FormData();
	var j=0;
    
    $(document).on("dragenter",".dragAndDropDiv",function(e){
        e.stopPropagation();
        e.preventDefault();
        $(this).css('border', '2px solid #0B85A1');
    });
    $(document).on("dragover",".dragAndDropDiv",function(e){
        e.stopPropagation();
        e.preventDefault();
    });
    $(document).on("drop",".dragAndDropDiv",function(e){
    	imagesSelected(e.originalEvent.dataTransfer.files);
        $(this).css('border', '2px dotted #0B85A1');
        e.preventDefault();
        var files = e.originalEvent.dataTransfer.files;
        
        handleFileUpload(files,objDragAndDrop);
    });
    /*마우스 오버, 마우스 아웃 시 x박스 생성*/
    $(document).on("mouseover",".photo-item",function(){
    	var index = $('.photo-item').index(this);
    	$('a.grid-item-delete').eq(index).css('display','block');
    }); 
    $(document).on("mouseout",".photo-item",function(){
    	var index = $('.photo-item').index(this);
    	$('a.grid-item-delete').eq(index).css('display','none');
    }); 
    /*마우스 오버, 마우스 아웃 시 x박스 생성 끝*/
    
    /*썸네일 삭제 시작*/
    $(document).on("click","a.grid-item-delete",function(){
    	
    	var index = $('a.grid-item-delete').index(this);
    	//fd_delete(index);
    	$('.photo-item').eq(index).remove();
    	
    	
    });
    /*썸네일 삭제 끝*/
    
    
    /*파일추가시 썸네일 보이게 설정*/
    $(document).on("change",".fupload",function(e){
    	//alert(this.id);
    	var files = !!this.files ? this.files : [];
    	for (var i = 0, f; f = files[i]; i++) {
    		if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support
    		
	        if (/^image/.test( files[0].type)){ // only image file
	            var imageReader = new FileReader();
	    	     imageReader.onload = (function(aFile) {
	    	       return function(e) {
	    	    	 var photos = "<div class=\"photo-item\" ><div class=\"selected-wrapper\"><div class=\"photo-thumbnail\"><img class=\"thumbnail\" alt=\"\" src="+e.target.result+" style=\"transform: rotate(360deg) scale(1);\"><a class=\"grid-item-delete\" title=\"삭제\" href=\"#;return false\"><span>[x]</span></a></div></div><div class=\"photo-editable\"><div class=\"photo-title-editable\">"+aFile.name+"</div></div></div>";
	    	    	 $('div#display-container').append(photos);
	    	    	 
	    	       };
	    	     })(f);
	    	     imageReader.readAsDataURL(f);
	        }
    	}
    	handleFileUpload2(files);
    	
    });
    /*파일추가시 썸네일 보이게 설정 끝*/
     
    $(document).on('dragenter', function (e){
        e.stopPropagation();
        e.preventDefault();
    });
    $(document).on('dragover', function (e){
      e.stopPropagation();
      e.preventDefault();
      objDragAndDrop.css('border', '2px dotted #0B85A1');
    });
    $(document).on('drop', function (e){
    	
        e.stopPropagation();
        e.preventDefault();
    });
    function imagesSelected(myFiles) {
    	 
    	   for (var i = 0, f; f = myFiles[i]; i++) {
    		 
    		 if (!f.type.match('image.*')) {
    	     alert("이미지 파일만 드래그 가능(only image file)");
    	     continue;
    	     }
    	     var imageReader = new FileReader();
    	     imageReader.onload = (function(aFile) {
    	       return function(e) {
    	    	 var photos = "<div class=\"photo-item\"><div class=\"selected-wrapper\"><div class=\"photo-thumbnail\"><img class=\"thumbnail\" alt=\"\" src="+e.target.result+" style=\"transform: rotate(360deg) scale(1);\"><a class=\"grid-item-delete\" title=\"삭제\" href=\"#;return false\"><span>[x]</span></a></div></div><div class=\"photo-editable\"><div class=\"photo-title-editable\">"+aFile.name+"</div></div></div>";
    	    	 $('div#display-container').append(photos);
    	       };
    	     })(f);
    	     imageReader.readAsDataURL(f);
    	   }
    	 }
    /*썸네일 삭제시 fd도 삭제되게*/
    function fd_delete(index){
    	 //$("fd").remove();
    	
    	//fd.removeData('file'+index);
    	jQuery.removeData('file3');
    }
    
    
	   
   
     
    function handleFileUpload(files,obj)
    {
       for (var i = 0; i < files.length; i++) 
       {
            
    	   fd.append('file'+j, files[i]);
    	   j++;
            //var status = new createStatusbar(obj); //Using this we can set progress.
            //status.setFileNameSize(files[i].name,files[i].size);
            //sendFileToServer(fd,status);
      
       }
    }
    
    function handleFileUpload2(files)
    {
       for (var i = 0; i < files.length; i++) 
       {
            
            fd.append('file'+j, files[i]);
            j++;
       }
       
       //console.log(fd);
       //alert(files.length);
       
       //sendFileToServer2(fd);
    }
   
         
        var rowCount=0;
        function createStatusbar(obj){
                 
            rowCount++;
            var row="odd";
            if(rowCount %2 ==0) row ="even";
            this.statusbar = $("<div class='statusbar "+row+"'></div>");
            this.filename = $("<div class='filename'></div>").appendTo(this.statusbar);
            this.size = $("<div class='filesize'></div>").appendTo(this.statusbar);
            this.progressBar = $("<div class='progressBar'><div></div></div>").appendTo(this.statusbar);
            this.abort = $("<div class='abort'>중지</div>").appendTo(this.statusbar);
             
            obj.after(this.statusbar);
          
            this.setFileNameSize = function(name,size){
                var sizeStr="";
                var sizeKB = size/1024;
                if(parseInt(sizeKB) > 1024){
                    var sizeMB = sizeKB/1024;
                    sizeStr = sizeMB.toFixed(2)+" MB";
                }else{
                    sizeStr = sizeKB.toFixed(2)+" KB";
                }
          
                //this.filename.html(name);
                //this.size.html(sizeStr);
            }
             
            this.setProgress = function(progress){       
                var progressBarWidth =progress*this.progressBar.width()/ 100;  
               // this.progressBar.find('div').animate({ width: progressBarWidth }, 10).html(progress + "% ");
                if(parseInt(progress) >= 100)
                {
                    this.abort.hide();
                }
            }
             
            this.setAbort = function(jqxhr){
                var sb = this.statusbar;
                this.abort.click(function()
                {
                    jqxhr.abort();
                    sb.hide();
                });
            }
        }
        
        $('#action-publish').on("click",function(){
        	//alert(files.length);
        	//var inputContent = oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);    
        	//$('#ir1').val();
        	oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []); 
        	
        	var pic_title = $("#pic_title").val();
        	var category_no = $('#category_no').val();
        	var tag_name = $("#tag_name").val();
        	var pic_content = document.getElementById("ir1").value;
        	var pic_open = $('#pic_open').val();
        	var pic_location = $('#pic_location').val();
        	
        	fd.append('pic_title',pic_title);
        	fd.append('category_no',category_no);
        	fd.append('tag_name',tag_name);
        	fd.append('pic_content',pic_content);
        	fd.append('pic_open',pic_open);
        	fd.append('pic_location',pic_location);
        	
        	$.ajax({
                url: 'fileUpload_submit',
                type: "post",
                dataType: "text",
                data: fd ,
                // cache: false,
                processData: false,
                contentType: false,
                success: function(data, textStatus, jqXHR) {
                	alert('1234');
                  	page_location2();
                }, error: function(jqXHR, textStatus, errorThrown) {}
            });
		})
		
		function page_location2(){
        	location.href="../myRoom/manageForm";
        }
        
        
         
        function sendFileToServer(formData,status)
        {
        	
            var uploadURL = "fileUpload/post"; //Upload URL
            var extraData ={}; //Extra Data.
            var jqXHR=$.ajax({
                    xhr: function() {
                    var xhrobj = $.ajaxSettings.xhr();
                    if (xhrobj.upload) {
                            xhrobj.upload.addEventListener('progress', function(event) {
                                var percent = 0;
                                var position = event.loaded || event.position;
                                var total = event.total;
                                if (event.lengthComputable) {
                                    percent = Math.ceil(position / total * 100);
                                }
                                //Set progress
                                status.setProgress(percent);
                            }, false);
                        }
                    return xhrobj;
                },
                
                url: uploadURL,
                type: "POST",
                contentType:false,
                processData: false,
                cache: false,
                data: formData,
                success: function(data){
                    
                	status.setProgress(100);
          
                    //$("#status1").append("File upload Done<br>");           
                }
            }); 
          
            status.setAbort(jqXHR);
        }
        
        function sendFileToServer2(formData)
        {
        	
            var uploadURL = "fileUpload/post"; //Upload URL
            var extraData ={}; //Extra Data.
            var jqXHR=$.ajax({
                    xhr: function() {
                    var xhrobj = $.ajaxSettings.xhr();
                    if (xhrobj.upload) {
                            xhrobj.upload.addEventListener('progress', function(event) {
                                var percent = 0;
                                var position = event.loaded || event.position;
                                var total = event.total;
                                if (event.lengthComputable) {
                                    percent = Math.ceil(position / total * 100);
                                }
                            }, false);
                        }
                    return xhrobj;
                },
                
                url: uploadURL,
                type: "POST",
                contentType:false,
                processData: false,
                cache: false,
                data: formData,
                success: function(data){
                
                }
            }); 
          
        }
        
        
});