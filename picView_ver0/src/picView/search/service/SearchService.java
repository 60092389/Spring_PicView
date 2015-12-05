package picView.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.member.model.Member;
import picView.picture.model.Picture;
import picView.search.model.Search;
import picView.search.model.SearchDao;

@Service
public class SearchService {
	private SearchDao searchDao;
	
	@Autowired
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	
	//회원 사진 가져오기
	public List<Picture> searchList(Search search){
		return searchDao.searchList(search);
	}
	
	//팔로우 사진
	public List<Picture> searchFollow(Search search){
		return searchDao.searchFollow(search);
	}
	
	//모든 사진 가져오기
	public List<Picture> searchTotal(Search search){
		return searchDao.searchTotal(search);
	}

	/*
	 * 색상
	 */
	
	//회원 색상 검색
	public List<Picture> memColor(Search search){
		return searchDao.memColor(search);
	}
	//팔로우 색상 검색
	public List<Picture> followColor(Search search){
		return searchDao.followColor(search);
	}
	// 모든 사진 색상 검색
	public List<Picture> allColor(Search search){
		return searchDao.allColor(search);
	}
	
	//회원 검색
	public List<Member> searchPeople(Search search){
		return searchDao.searchPeople(search);
	}

	//사진 개수
	public int replyCount(int pic_no){
		return searchDao.replyCount(pic_no);
	}
	
}
