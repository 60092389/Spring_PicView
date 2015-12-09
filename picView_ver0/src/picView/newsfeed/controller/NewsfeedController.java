package picView.newsfeed.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import picView.member.model.AuthInfo;
import picView.newsfeed.model.ActivityList;
import picView.newsfeed.model.ActivityModel;
import picView.newsfeed.model.FriendList;
import picView.newsfeed.model.Good;
import picView.newsfeed.model.ListNewsfeedModel;
import picView.newsfeed.service.NewsfeedService;
import picView.picture.model.Picture;


@RequestMapping("/jsp/**/")
@Controller
public class NewsfeedController {
	
	private NewsfeedService service;
	
	@Autowired
	public void setService(NewsfeedService service) {
		this.service = service;
	}
	
	@RequestMapping(value="newsfeed/{requestPage}",method=RequestMethod.GET)
	public @ResponseBody ListNewsfeedModel list_newsfeed(@PathVariable String requestPage,HttpServletRequest request,
				HttpSession session){
		System.out.println("-----------CONTROLLER---------------");
		System.out.println("requestPage = " + requestPage);
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		
		return service.list_newsfeed(Integer.parseInt(requestPage),mem_no);
	}
	
	@RequestMapping(value="count_newsfeed",method=RequestMethod.GET)
	public @ResponseBody int count_newsfeed(HttpSession session){
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		
		return service.count_newsfeed(mem_no);
	}
	@RequestMapping(value="friend_list",method=RequestMethod.GET)
	public @ResponseBody List<FriendList> friend_list(HttpSession session){
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		
		return service.list_friend(mem_no);
	}
	@RequestMapping(value="count_activity",method=RequestMethod.GET)
	public @ResponseBody int count_activity(HttpSession session){
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		return service.count_activity(mem_no);
	}
	
	@RequestMapping(value="activity_list/{requestPage}",method=RequestMethod.GET)
	public @ResponseBody ActivityModel activity_list(@PathVariable String requestPage,HttpSession session){
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		return service.list_activity(Integer.parseInt(requestPage),mem_no);
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
	
	@RequestMapping(value="count_activity_alarm{chk_date}",method=RequestMethod.GET )
	public @ResponseBody int count_activity_alarm(@PathVariable Timestamp chk_date,HttpSession session){
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int mem_no = authInfo.getMem_no();
		ActivityList activity = new ActivityList();
		activity.setMem_no(mem_no);
		activity.setRep_date(chk_date);
		
		System.out.println("chk_date ===" + activity.getRep_date());
		return service.count_activity_alarm(mem_no);
	}
	
	
}
