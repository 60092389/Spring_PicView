package picView.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.follow.model.Follow;
import picView.follow.model.FollowDao;
import picView.member.model.Member;
import picView.picture.model.Picture;
import picView.search.model.MemberResult;
import picView.search.model.Search;
import picView.search.model.SearchDao;
import picView.search.model.SearchResult;

@Service
public class SearchService {
	private SearchDao searchDao;
	private FollowDao followDao;
	
	@Autowired
	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	
	@Autowired	
	public void setFollowDao(FollowDao followDao) {
		this.followDao = followDao;
	}


	//회원 사진 가져오기
		public List<SearchResult> searchList(Search search){
			return searchDao.searchList(search);
		}
		
		//팔로우 사진
		public List<SearchResult> searchFollow(Search search){
			return searchDao.searchFollow(search);
		}
		
		//모든 사진 가져오기
		public List<SearchResult> searchTotal(Search search){
			return searchDao.searchTotal(search);
		}

		/*
		 * 색상
		 */
		
		//회원 색상 검색
		public List<SearchResult> memColor(Search search){
			return searchDao.memColor(search);
		}
		//팔로우 색상 검색
		public List<SearchResult> followColor(Search search){
			return searchDao.followColor(search);
		}
		// 모든 사진 색상 검색
		public List<SearchResult> allColor(Search search){
			return searchDao.allColor(search);
		}
	
	//회원 검색
	public List<MemberResult> searchPeople(Search search, int mem_no){
		
		List<Member> mem_search_list = searchDao.searchPeople(search);
		
		List<Follow> follow_list = followDao.listFollow(mem_no);
		
		List<MemberResult> search_result = new ArrayList<MemberResult>();
		
		
		
		for(int i=0; i<mem_search_list.size(); i++){
			MemberResult mem = new MemberResult();
			int fol_check =0;
			
			mem.setMem_no(mem_search_list.get(i).getMem_no());
			mem.setMem_id(mem_search_list.get(i).getMem_id());
			mem.setMem_name(mem_search_list.get(i).getMem_name());
			mem.setMem_pic(mem_search_list.get(i).getMem_pic());
			mem.setMem_date(mem_search_list.get(i).getMem_date());
			
			
			System.out.println("검색회원 : "+mem_search_list.get(i).getMem_no());
			for(int j=0; j<follow_list.size(); j++){
				
				if(mem_search_list.get(i).getMem_no() == follow_list.get(j).getFollow_fri_no()
						&& follow_list.get(j).getFollow_check().equals("1")){
						//내가 상대를 팔로우하는 상태
						fol_check = 1;		
				}
				if(mem_search_list.get(i).getMem_no() == follow_list.get(j).getFollow_fri_no()
						&& follow_list.get(j).getFollow_check().equals("2")){
					
						fol_check = 2;
						
				}
				if(mem_search_list.get(i).getMem_no() == follow_list.get(j).getFollow_fri_no()
						&& follow_list.get(j).getFollow_check().equals("3")){

						fol_check = 3;
				}
			}
			mem.setFol_check(fol_check);	
			search_result.add(mem);
		}
		
		return search_result;
	}

}
