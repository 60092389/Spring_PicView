package picView.newsfeed.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import picView.newsfeed.model.ActivityList;
import picView.newsfeed.model.FriendList;
import picView.newsfeed.model.Good;
import picView.newsfeed.model.Newsfeed;
import picView.picture.model.Picture;


public interface NewsfeedMapper {

	public List<Newsfeed> list_newsfeed(RowBounds row, int mem_no); //뉴스피드 리스트
	public int count_newsfeed(int mem_no);//뉴스피드 갯수
	public List<FriendList> list_friend(int mem_no);//친구목록
	
	public List<ActivityList> list_activity(RowBounds row);//액티비티 리스트
	public int count_activity();//액티비티 갯수
	
	public int photo_good(Picture picture);//좋아요 확인
	public int photo_delete(Picture picture);//좋아요 삭제
	public int photo_insert(Picture picture);//좋아요 등록
	
	public int photo_good_chk(Picture picture);//처음에 들어왔을 때 좋아요 체크 확인  
}
