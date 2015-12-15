$(function(){
	var index_chk =0;
	$('#requestPage_main').val(1);
	$(window).scroll(function(){
		if  ($(window).scrollTop() == $(document).height() - $(window).height()){
		   receiveMessage();
		}
	});
	var mem_no = $('#mem_no').val();
	
	
	$.ajax({
		type:"GET",
		url:"count_newsfeed",
		dateType:"json",
		success:function(data){
			//alert(data.requestPage);
			$('#totalCount_main').val(data);
			receiveMessage();
			friendList();
			
		}
	});
	function friendList(){
		$.getJSON( "friend_list", function(data){ //responseBody를 이용하면 키값이 없기때문에 바로 data로 받아짐
            //var data= responseData.list;
           
           $.each(data, function(index,friend){
        	   var friend_html ="<li class='suggestion clearfix'>";
				friend_html +="<a class='buddyicon-link' href='../../jsp/myRoom/myShowForm"+friend.follow_fri_no+"'>";
				friend_html +="<img class='defer' width='32' height='32' alt='Aurore PP' src='../../upload/"+friend.mem_pic+"' style='opacity: 1; transition: opacity 0.25s ease-in-out 0s;'>";
				friend_html +="</a><span class='username'><a href='../../jsp/myRoom/myShowForm"+friend.follow_fri_no+"'>"+friend.mem_name+"</a>";
				friend_html +="</span></li>";
			  
				$('.peopleYouMayKnow').append(friend_html);
           });
      });

	}
	function receiveMessage() {
		var requestPage = $('#requestPage_main').val();
		
		 if(!requestPage){
			 requestPage = 1;
		 }
		 
		$.ajax({

			type:"GET",
			url:"newsfeed/"+requestPage,
			dateType:"json",
			error:function(){
				$("#messages").append("<span style='color:red;'>불러오기 오류!</span>");
			},
			success:function(data){
				
				var totalCount = $('#totalCount_main').val();
				var total = data.total_count;
					if(total == 1){
						requestPage = 0;
					}else{
						requestPage++;
					}
					if(requestPage < totalCount){
						
						$('#requestPage_main').val(requestPage);
						
						var list = data.list;
						
					
					$.each(list, function(index,newsfeed){
						if(newsfeed.pic_add !=undefined){
							var length = newsfeed.pic_add.length;
							var pic_name = newsfeed.pic_add.substring(15,length);
						}
						 var friend_html = "<div id='firstCard' class='card card-a card-bundle clearfix firstCard'>";
						 	 friend_html += "<div class='imgContainer'>";
						 	 friend_html += "<div class='imgWrapper'>";
 						 	 friend_html += "<div class='session-image-wrapper'>";
						 	 friend_html += "<a href='../basic/basic_pic_Detail?pic_no="+newsfeed.pic_no+"'>";
						 	 friend_html += "<img class='main-session-photo' style='width: 750px; height: auto;' alt='Tulips' src='../../upload/"+newsfeed.pic_add+"'>";
						 	 friend_html += "<span class='thin-facade'></span>";
						 	 friend_html += "</a></div>";
						 	 friend_html += "<div class='sub-photo-view'>";
						 	 friend_html += "<a class='buddyicon; href='/photos/134675537@N03'>";
						 	 friend_html += "<img class='defer src='../../upload/"+newsfeed.pic_add+"'>";
						 	 friend_html += "</a><span class='photo-details'>";
						 	 friend_html += "<div class='name'><a class='' href='../../jsp/myRoom/myShowForm"+newsfeed.mem_no+"'>"+newsfeed.mem_name+"</a>";
							 friend_html += "<span class='activity-item-date'>· "+newsfeed.pic_date+"</span>";
							 friend_html += "</div><div class='title'><a href='../basic/basic_pic_Detail?pic_no="+newsfeed.pic_no+"'>"+pic_name+"</a>";
							 friend_html += "</div></span><ul class='photo-engagement'><li class='favorites' id='favorites"+index_chk+"'>";
							 friend_html += "<a class='rapidnofollow2'  href='#' onclick='return false;'><i>★</i></a></li>";
							 friend_html += "<li class='comments'><a class='rapidnofollow1' href='#' onclick='return false;'>";
							 friend_html += "<i >💬</i></a></li>"
							 friend_html += "</ul></div></div>";
							 friend_html += "</div>";
							 friend_html += "<div id='comments"+index_chk+"' class='comments-popover' style='display:none'>";
							 friend_html += "<div class='comments-inner'>";
							 friend_html += "<div class='close_button'>";
							 friend_html += "<button type='button' id='close"+index+"' class='close'>&times;</button>"; 
							 friend_html += "</div>";
							 friend_html += "<form id='comment-form' class='comment-form"+index_chk+"' method='post' >";
							 friend_html += "<input type='hidden' name='mem_no' id='mem_no' value='"+mem_no+"'>";
							 friend_html += "<input type='hidden' name='pic_no' id='pic_no' value='"+newsfeed.pic_no+"' class='pic_no"+index_chk+"'>";
							 friend_html += "<img class='buddyicon' src='https://s.yimg.com/pw/images/buddyicon05.png#136434429@N02'>";
							 friend_html += "<textarea id='message' class='message' tabindex='2' name='rep_content' id='rep_content' cols='80' rows='2'></textarea>";
							 friend_html += "<input class='submit-comment' type='button' tabindex='2' value='Comment' name='submit'>";
							 friend_html += "</form></div></div>";
							 friend_html += "</div>";
							
							 
					    var follow_html = "<div class='card micro-card card-contacted card-follow clearfix'>";
					    	follow_html +="<div class='content-section-wrapper'>";
					    	follow_html +="<div class='content-section'>";
					    	follow_html +="<span class='action-author'>";
					    	follow_html +="<a class='buddyicon' href='/photos/118500465@N06'>";
					    	follow_html +="<img class='defer' width='32' height='32' src='../../upload/"+newsfeed.mem_pic+"'>";
					    	follow_html +="</a><a class='usernameLink' href='../myRoom/my_Follower'>"+newsfeed.mem_name+"</a>님이 회원님을 팔로우하고 있습니다.";
					    	follow_html +="<div id='comments"+index_chk+"' style='display:none;'><input class='submit-comment' type='button' tabindex='2' value='Comment' name='submit'>";
					    	follow_html +="<a class='rapidnofollow1' href='#' onclick='return false;'></a><button type='button' id='close"+index+"' class='close'>";
					    	follow_html +="<a class='rapidnofollow2'  href='#' onclick='return false;'></a>";
					    	follow_html +="<input type='hidden' name='pic_no' id='pic_no' value='"+newsfeed.pic_no+"' class='pic_no"+index_chk+"'></div></div></div></div>";
					    	follow_html +="";
					    	follow_html +="";
					    
					    var good_html ="<div class='favorite_view'>";
					    	good_html += "<div class='sub-photo-view2'>";
					    	good_html += "<span class='photo-details2'>";
					    	good_html += "<div class='name'>";
					    	good_html += "<a class='' href='../../jsp/myRoom/myShowForm"+newsfeed.mem_no+"'>"+newsfeed.mem_name+"</a>님이 좋아했습니다.";
					    	good_html += "</div></span></div>";
					    	good_html += "<div id='firstCard2' class='card2 card-a card-bundle clearfix firstCard'>";
					    	good_html += "<div class='imgContainer'>";
					    	good_html += "<div class='imgWrapper'>";
					    	good_html += "<div class='session-image-wrapper'>";
					    	good_html += "<a href='../basic/basic_pic_Detail?pic_no="+newsfeed.pic_no+"'>";
					    	good_html += "<img class='main-session-photo' style='width: 750px; height: auto;' alt='Tulips' src='../../upload/"+newsfeed.pic_add+"'>";
					    	good_html += "<span class='thin-facade'></span>";
					    	good_html += "</a><div id='comments"+index_chk+"' style='display:none;'><input class='submit-comment' type='button' tabindex='2' value='Comment' name='submit'><a class='rapidnofollow1' href='#' onclick='return false;'></a>";
					    	good_html += "<button type='button' id='close"+index+"' class='close'>";
					    	good_html +="<a class='rapidnofollow2'  href='#' onclick='return false;'></a>";
					    	good_html += "<input type='hidden' name='pic_no' id='pic_no' value='"+newsfeed.pic_no+"' class='pic_no"+index_chk+"'></div></div></div></div></div></div>";
							
					    	if(newsfeed.subject == "friend"){
								 $('#activityFeed').append(friend_html);
							}
					    	if(newsfeed.subject == "follow"){
								 $('#activityFeed').append(follow_html);
							 }
					        if(newsfeed.subject =="good"){
					        	$('#activityFeed').append(good_html);
					        }
					        
					        good_chk(newsfeed.pic_no,index_chk);	
					       
					        index_chk++;
			         });
					
					}
					
					$('.close').click(function(){
						
						var index = $('.close').index(this);
						
						$('#comments'+index).css('display','none');
					});
					
					$('.rapidnofollow2').click(function(){
						var index2 = $( '.rapidnofollow2').index(this);
						
						var pic_no = $('.pic_no'+index2).val();
						var mem_no = $('#mem_no').val();
						$.ajax({
							type:"POST",
							url:"photo_good",
							data:{
								"mem_no" : mem_no,
								"pic_no" : pic_no
							},
							success:function(data){
								if(data==2){
									$('#favorites'+index2).addClass('favorites is_fav');
								}else if(data==1){
									$('#favorites'+index2).removeClass('is_fav');
								}
							}
							
						});
					});
					
					$('.rapidnofollow1').click(function(){
						
						 $('.comments-popover' ).each(function(index,item){
				             if($( '.comments-popover').eq(index).css('display') =='block'){
				            	 $( '.comments-popover').eq(index).css('display','none');
				             }
				         });
						var message = $('.message');
						var index2 = $( '.rapidnofollow1').index(this);
						var box = $('.comment-form'+index2);
						if(box.find(message).val() != ""){
							box.find(message).val(' ');
						}
						var pic_no = $('.pic_no'+index2).val();
						reply_list(pic_no,index2);
						if($('#comments'+index2).css('display') == 'none'){
							$('#comments'+index2).css('display','block');
						}else{
							
							$('#comments'+index2).css('display','none');
						}
				        
						
					});
					
					$('.submit-comment').click(function(){
						var index = $('.submit-comment').index(this);
						var formData = $(".comment-form"+index).serialize();
						$.ajax({

							type:"POST",
							url:"photo_reply",
							data:formData,
							success: function(data){
								if(data==1){
									alert('등록되었습니다.');
								}
								$('#comments'+index).css('display','none');
							},
							
							error:function(){
							}
							
						});
					});
					function reply_list(pic_no,set_index){
						var comments_inner = $('.comments-inner');
							$.ajax({
								
								url:"list_reply/"+pic_no,
								type: "GET",
								success:function(data){
									$('.comment-wrapper').remove();
									$.each(data, function(index,reply){
										
					                	var reply_list2 = "<div class='comment-wrapper'>";
						                	reply_list2 += "<a class='buddyicon' href='/photos/136537338@N08'>";
						                	reply_list2 += "<img src='https://s.yimg.com/pw/images/buddyicon02.png#136537338@N08'></a>";
						                	reply_list2 += "<a class='usernameLink' href='/photos/136537338@N08'>"+reply.mem_name+"</a>.";
						                	reply_list2 += "<span class='action-date'>"+reply.rep_date+"</span>";
						                	reply_list2 += "<div class='comment-display'><p>"+reply.rep_content+"</p></div></div>";
											$('#comments'+set_index).find($('.comment-form'+set_index)).before(reply_list2);
						                	
					                });
										
									
									
								}
							});
						
					}
					
			}

		});
		
		
		
	}
	function good_chk(pic_no,index){
			var mem_no = $('#mem_no').val();
			$.ajax({
				type:"GET",
				url:"photo_good_chk",
				dataType:"json",
				data:{
					"mem_no" : mem_no,
					"pic_no" : pic_no
				},
				success:function(data){
					if(data ==1){
						$('#favorites'+index).addClass('favorites is_fav');
					}
					/*if(data==2){
						$('#favorites'+index2).addClass('favorites is_fav');
					}else if(data==1){
						$('#favorites'+index2).removeClass('is_fav');
					}*/
				}
				
			});
	}
	
	
	
	
		
	
});