package picView.follow.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.follow.mapper.FollowMapper;

@Component
public class FollowDao {
	
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}
	
	//아무관계없을때 팔로우하기
	public void addNewFollow(Follow follow){
		myTemplate.getMapper(FollowMapper.class).addNewFollow(follow);
	}
	
	public List<Follow> listFollowCheck(int mem_no){
		return myTemplate.getMapper(FollowMapper.class).listFollowCheck(mem_no);
	}
	
	public void updateFollowCheck(Follow follow){
		myTemplate.getMapper(FollowMapper.class).updateFollowCheck(follow);
	}
	
	//나만 팔로우하는 상태 취소
	public void cancelFollow(Follow follow){
		myTemplate.getMapper(FollowMapper.class).cancelFollow(follow);
	}
	
	//추천친구에서쓰는 회원들간의 관계유무를 위한리스트
	public List<Follow> followCheck(Follow follow){
		
		return myTemplate.getMapper(FollowMapper.class).followCheck(follow);
	}
	
	
	public List<Follow> listFollow(int mem_no){
		
		return myTemplate.getMapper(FollowMapper.class).listFollow(mem_no);
	}
	
	

}
