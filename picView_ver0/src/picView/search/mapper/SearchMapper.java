package picView.search.mapper;

import java.util.List;

import picView.member.model.Member;
import picView.picture.model.Picture;
import picView.search.model.Search;
import picView.search.model.SearchResult;

public interface SearchMapper {

	//검색
	public List<SearchResult> searchList(Search search);
	public List<SearchResult> searchFollow(Search search);
	public List<SearchResult> searchTotal(Search search);
	
	//검색 후 색상검색
	public List<SearchResult> memColor(Search search);
	public List<SearchResult> followColor(Search search);
	public List<SearchResult> allColor(Search search);
	
	//회원 검색
	public List<Member> searchPeople(Search search);

	//사진 댓글 카운트

}
