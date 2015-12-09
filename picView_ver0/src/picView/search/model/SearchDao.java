package picView.search.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.member.model.Member;
import picView.search.mapper.SearchMapper;

@Component
public class SearchDao {
	
	@Autowired
	private SqlSessionTemplate myTemplate;
	
	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate){
		this.myTemplate = myTemplate;
	}
	
	//사진 가져오기
		public List<SearchResult> searchList(Search search){

			return myTemplate.getMapper(SearchMapper.class).searchList(search);
		}
		
		//팔로우 사진 가져오기
		public List<SearchResult> searchFollow(Search search){

			return myTemplate.getMapper(SearchMapper.class).searchFollow(search);
		}
		
		//모든 사진 가져오기
		public List<SearchResult> searchTotal(Search search){
			return myTemplate.getMapper(SearchMapper.class).searchTotal(search);
		}
		
		/*
		 * 색상검색 
		 * 
		 */
		//회원 색상 검색
		public List<SearchResult> memColor(Search search){
			return myTemplate.getMapper(SearchMapper.class).memColor(search);
		}
		//팔로우 색상 검색
		public List<SearchResult> followColor(Search search){
			return myTemplate.getMapper(SearchMapper.class).followColor(search);
		}
		//모든 사진 색상 검색
		public List<SearchResult> allColor(Search search){
			return myTemplate.getMapper(SearchMapper.class).allColor(search);
		}
		
	
	
	/*
	 *  회원 검색
	 */
	public List<Member> searchPeople(Search search){
		return myTemplate.getMapper(SearchMapper.class).searchPeople(search);
	}
	
}
