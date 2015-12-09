package picView.newsfeed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import picView.newsfeed.model.ActivityList;
import picView.newsfeed.model.ActivityModel;
import picView.newsfeed.model.FriendList;
import picView.newsfeed.model.Good;
import picView.newsfeed.model.ListNewsfeedModel;
import picView.newsfeed.model.Newsfeed;
import picView.newsfeed.model.NewsfeedDao;
import picView.picture.model.Picture;

@Service
public class NewsfeedService {
	private static final int PAGE_SIZE = 5;
	
	private NewsfeedDao dao;
	
	@Autowired
	public void setDao(NewsfeedDao dao) {
		this.dao = dao;
	}


	public ListNewsfeedModel list_newsfeed(int requestPage,int mem_no){
		
		System.out.println("------SERVICE---------");
		int totalCount = dao.count_newsfeed(mem_no);
		System.out.println("totalCount= " + totalCount);
		int totalPageCount = totalCount/PAGE_SIZE;
		System.out.println("totalPageCount = "+ totalPageCount);
		if(totalPageCount%PAGE_SIZE >0){//나머지 글 갯수가 있다면 한페이지 더 추가해주기
			totalPageCount++;
		}
		//만약 페이지를 5개씩 보여줌, 현재페이지는 7이면 페이지는 6이 시작페이지로 와야함
		//공식
		int startPage = requestPage - (requestPage-1) % 5;
		int endPage = startPage +4;
		
		if(endPage > totalPageCount){
			endPage = totalPageCount; //만약 totalPageCount는 7까지인데 endPage는 10이 나오면 8,9,10은
									  //보여줄게 없으므로 totalPageCount와 같게 만들어줘야함
		}
		System.out.println("requestPage= " + requestPage);
		List<Newsfeed> list = dao.list_newsfeed((requestPage-1)*PAGE_SIZE, mem_no);
		
		return new ListNewsfeedModel(list, requestPage, totalPageCount, startPage, endPage);
	}
	
	public int count_newsfeed(int mem_no){
		return dao.count_newsfeed(mem_no);
	}
	
	public List<FriendList> list_friend(int mem_no){//친구 목록
		return dao.list_friend(mem_no);
	}
	public int count_activity(int mem_no){
		return dao.count_activity(mem_no);
	}
	public ActivityModel list_activity(int requestPage,int mem_no){
		System.out.println("------SERVICE---------");
		int totalCount = dao.count_activity(mem_no);
		System.out.println("totalCount= " + totalCount);
		int totalPageCount = totalCount/PAGE_SIZE;
		System.out.println("totalPageCount = "+ totalPageCount);
		if(totalPageCount%PAGE_SIZE >0){//나머지 글 갯수가 있다면 한페이지 더 추가해주기
			totalPageCount++;
		}
		//만약 페이지를 5개씩 보여줌, 현재페이지는 7이면 페이지는 6이 시작페이지로 와야함
		//공식
		int startPage = requestPage - (requestPage-1) % 5;
		int endPage = startPage +4;
		
		if(endPage > totalPageCount){
			endPage = totalPageCount; //만약 totalPageCount는 7까지인데 endPage는 10이 나오면 8,9,10은
									  //보여줄게 없으므로 totalPageCount와 같게 만들어줘야함
		}
		System.out.println("requestPage= " + requestPage);
		List<ActivityList> list =dao.list_activity((requestPage-1)*PAGE_SIZE,mem_no);
		for(int i=0;i<list.size();i++){
			System.out.println("list =======" + list.get(i).getRep_content());
		}
		return new ActivityModel(list, requestPage, totalPageCount, startPage, endPage);
	}
	
	public int photo_good(Picture picture){
		return dao.photo_good(picture);
	}
	public int photo_delete(Picture picture){
		return dao.photo_delete(picture);
	}
	public int photo_insert(Picture picture){
		return dao.photo_insert(picture);
	}
	public int photo_good_chk(Picture picture){
		return dao.photo_good_chk(picture);
	}
	public int count_activity_alarm(int mem_no){
		return dao.count_activity_alarm(mem_no);
	}
	
	
	

}
