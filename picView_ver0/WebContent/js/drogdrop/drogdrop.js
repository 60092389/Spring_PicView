document.addEventListener("DOMContentLoaded",function(){

	var input=document.querySelector('input[type="file"]');
	var items=document.querySelector('#items');	
	
	items.addEventListener("dragenter" ,function(event){
		event.preventDefault();		
	},false);
	items.addEventListener("dragover" ,function(event){
		event.preventDefault();		
	},false);
	items.addEventListener("drop" ,function(event){
		event.preventDefault();
		var files = event.dataTransfer.files;
		var file = files[0];
		if(! file)
		{
			var img = document.createElement("img");
			img.src = event.dataTransfer.getData("text");
			img.title = getHTMLname(img.src);		
			img.width = "150";			
			var span = document.createElement("span");
			span.appendChild(img);
			items.appendChild(span);		
		}
		else
		{
			if(!file.type.match(/^image\//)){
				alert("이미지 파일만 drop 가능합니다.");
				return;
			}
			
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(){
				var img = document.createElement("img");
				img.src = reader.result;
				img.title = getHTMLname(img.src);		
				img.width = "150";				
				var span = document.createElement("span");
				span.appendChild(img);
				items.appendChild(span);
			}
		
		}
		
	},false);
	
	
	input.addEventListener("change",imageSelected,false);	
	//이미지 사용자 함수
	function imageSelected(event)
	{
		var files = event.target.files;
		var file = files[0];	
		if(!file) {return;}
		if(!file.type.match(/^image\//)){
			alert("이미지 파일만 선택 가능합니다.");
			return;}
		var fileInfo=document.querySelector('#result');
		fileInfo.textContent = file.name;
		var img = document.createElement("img");
		img.src = file.name;
		img.title = getHTMLname(file.name);		
		img.width = "150";
		img.id = getHTMLname(file.name);
		var span = document.createElement("span");
		span.appendChild(img);
		items.appendChild(span);
	
	
		var img_i = document.getElementById(img.id);
				
		img_i.addEventListener("dragstart",function(event){
			event.dataTransfer.setData("text",event.target.src);			
		},false);	
		
			
	}
	//파일을 이름만 불어오는 함수
	function getHTMLname(v) {
		  var p, q;
		  p=v.length;
		  while (p>0) {
		    if (v.charAt(p-1)=='/') break;
		    p--;
		    }

		  q=v.length;
		  while (q>=0) {
		    if (v.charAt(q)=='.') break;
		    q--;
		    }
		  if (q<p) q=v.length;

		  return v.substring(p, q); 
	}
	//파일의 확장자를 읽어오는 함수.
	function getHTMLext(v) {
		  var p, q;
		  p=v.length;
		  while (p>0) {
		    if (v.charAt(p-1)=='/') break;
		    p--;
		    }

		  q=v.length;
		  while (q>=0) {
		    if (v.charAt(q)=='.') break;
		    q--;
		    }
		  if (q<p) q=v.length;

		  return v.substring(q+1, v.length); 
	 }

},false);