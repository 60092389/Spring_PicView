package picView.newsfeed.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import picView.newsfeed.model.ActivityModel;
import picView.newsfeed.model.FriendList;
import picView.newsfeed.model.Good;
import picView.newsfeed.model.ListNewsfeedModel;
import picView.newsfeed.service.NewsfeedService;
import picView.picture.model.Picture;


@RequestMapping("/jsp/main/")
@Controller
public class NewsfeedController {
	
	private NewsfeedService service;
	
	@Autowired
	public void setService(NewsfeedService service) {
		this.service = service;
	}
	
	@RequestMapping(value="newsfeed/{requestPage}",method=RequestMethod.GET)
	public @ResponseBody ListNewsfeedModel list_newsfeed(@PathVariable String requestPage,HttpServletRequest request){
		System.out.println("-----------CONTROLLER---------------");
		System.out.println("requestPage = " + requestPage);
		
		
		return service.list_newsfeed(Integer.parseInt(requestPage));
	}
	
	@RequestMapping(value="count_newsfeed",method=RequestMethod.GET)
	public @ResponseBody int count_newsfeed(){
		
		return service.count_newsfeed();
	}
	@RequestMapping(value="friend_list",method=RequestMethod.GET)
	public @ResponseBody List<FriendList> friend_list(){
		return service.list_friend();
	}
	@RequestMapping(value="count_activity",method=RequestMethod.GET)
	public @ResponseBody int count_activity(){
		return service.count_activity();
	}
	
	@RequestMapping(value="activity_list/{requestPage}",method=RequestMethod.GET)
	public @ResponseBody ActivityModel activity_list(@PathVariable String requestPage){
		return service.list_activity(Integer.parseInt(requestPage));
	}
	
	@RequestMapping(value="photo_good",method=RequestMethod.POST)
	public @ResponseBody int photo_good(Picture picture){
		int re = service.photo_good(picture);
		int rr = 0;
		if(re>0){
			service.photo_delete(picture);
			rr = 1;
		}else{
			service.photo_insert(picture);
			rr = 2;
		}
		return rr;
	}
	@RequestMapping(value="photo_good_chk",method=RequestMethod.GET)
	public @ResponseBody int photo_good_chk(Picture picture){
		int re = service.photo_good_chk(picture);
		int chk=0;
		if(re>0){
			chk =1;
		}else{
			chk = 2;
		}
		return chk;
	}
	
	
	
}
