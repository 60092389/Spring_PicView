package picView.search.mapper;

import java.util.List;

import picView.member.model.Member;
import picView.picture.model.Picture;
import picView.search.model.Search;

public interface SearchMapper {

	//검색
	public List<Picture> searchList(Search search);
	public List<Picture> searchTotal(Search search);
	public List<Picture> searchFollow(Search search);
	
	//검색 후 색상검색
	public List<Picture> memColor(Search search);
	public List<Picture> followColor(Search search);
	public List<Picture> allColor(Search search);
	
	//회원 검색
	public List<Member> searchPeople(Search search);

	//사진 댓글 카운트
	public int replyCount(int pic_no);
}
