package picView.newsfeed.model;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.newsfeed.mapper.NewsfeedMapper;
import picView.picture.model.Picture;

@Component
public class NewsfeedDao {
	
	private SqlSessionTemplate myTemplate;
	
	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}
	
	public List<Newsfeed> list_newsfeed(int startRow, int mem_no){
		
		return myTemplate.getMapper(NewsfeedMapper.class).list_newsfeed(new RowBounds(startRow, 5),mem_no);
	}
	
	public int count_newsfeed(int mem_no){
		return myTemplate.getMapper(NewsfeedMapper.class).count_newsfeed(mem_no);
	}
	public List<FriendList> list_friend(int mem_no){
		return myTemplate.getMapper(NewsfeedMapper.class).list_friend(mem_no);
	}
	public List<ActivityList> list_activity(int startRow,int mem_no){
		
		return myTemplate.getMapper(NewsfeedMapper.class).list_activity(new RowBounds(startRow, 5),mem_no);
	}
	public int count_activity(int mem_no){
		return myTemplate.getMapper(NewsfeedMapper.class).count_activity(mem_no);
	}
	
	public int photo_good(Picture picture){
		return myTemplate.getMapper(NewsfeedMapper.class).photo_good(picture);
	}
	public int photo_insert(Picture picture){
		return myTemplate.getMapper(NewsfeedMapper.class).photo_insert(picture);
	}
	public int photo_delete(Picture picture){
		return myTemplate.getMapper(NewsfeedMapper.class).photo_delete(picture);
	}
	public int photo_good_chk(Picture picture){
		return myTemplate.getMapper(NewsfeedMapper.class).photo_good_chk(picture);
	}
	public int count_activity_alarm(int mem_no){
		return myTemplate.getMapper(NewsfeedMapper.class).count_activity_alarm(mem_no);
	}
	
}
