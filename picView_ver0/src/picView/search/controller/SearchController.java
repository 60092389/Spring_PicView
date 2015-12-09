package picView.search.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.experimental.results.ResultMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import picView.member.model.AuthInfo;
import picView.member.model.Member;
import picView.picture.model.Picture;
import picView.search.model.MemberResult;
import picView.search.model.Search;
import picView.search.model.SearchResult;
import picView.search.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@Autowired
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	// 회원 사진
	@RequestMapping("/jsp/**/search")
	public @ResponseBody List<SearchResult> search(@RequestParam(value = "search") String search,
			@RequestParam(value="tag")String tag, Model model, HttpSession session)
			throws UnsupportedEncodingException {
		search = URLDecoder.decode(search, "UTF-8");
		tag = URLDecoder.decode(tag, "UTF-8");
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();
		System.out.println("search 컨트롤러의 mem_no 값 "+mem_no);
		
		//int mem_no = 4;
		
		Search searchVO = new Search();
		searchVO.setMem_no(mem_no);
		searchVO.setSearchKey(search);
		searchVO.setTags(tag);

		System.out.println(tag);
		
		return searchService.searchList(searchVO);
	}
	
	//팔로우 사진
	@RequestMapping("/jsp/**/searchFollow")
	public @ResponseBody List<SearchResult> searchFollow(@RequestParam(value = "search") String search,
			@RequestParam(value="tag")String tag, HttpSession session)
			throws UnsupportedEncodingException {
		search = URLDecoder.decode(search, "UTF-8");
		tag = URLDecoder.decode(tag, "UTF-8");
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();	
		//int mem_no = 4;
				
		Search searchVO = new Search();
		searchVO.setSearchKey(search);
		searchVO.setMem_no(mem_no);
		searchVO.setTags(tag);

		return searchService.searchFollow(searchVO);
	}
	
	// 모든 사진 
	@RequestMapping("/jsp/**/searchTotal")
	public @ResponseBody List<SearchResult> searchTotal(@RequestParam(value = "search") String search,
			@RequestParam(value="tag")String tag)
			throws UnsupportedEncodingException {
		search = URLDecoder.decode(search, "UTF-8");
		tag = URLDecoder.decode(tag, "UTF-8");
		
		Search searchVO = new Search();
		searchVO.setSearchKey(search);
		searchVO.setTags(tag);

		return searchService.searchTotal(searchVO);
	}


	// 회원 색상 검색
	@RequestMapping("/jsp/**/memColor")
	public @ResponseBody List<SearchResult> searchColor(@RequestParam(value = "search") String search,
			@RequestParam(value="tag")String tag,HttpSession session)
			throws UnsupportedEncodingException {
		search = URLDecoder.decode(search, "UTF-8");
		tag = URLDecoder.decode(tag, "UTF-8");
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();
		//int mem_no = 4;
		
		String[] word = search.split(",");
		Search searchVO = new Search();
		
		for(int i=0;i<word.length;i++){
			System.out.print(word[i]+"\t");
		}
		
		String[] color = new String[word.length - 1];
		//단어, 태그 search 객체에 담기
		searchVO.setSearchKey(word[0]);
		searchVO.setTags(tag);
		searchVO.setMem_no(mem_no);

		if (word.length == 2) {
			color[0] = word[1];
			searchVO.setColor(color);
		} else if (word.length == 3) {
			for(int i=0;i<2;i++){
				color[i]=word[i+1];
			}
			searchVO.setColor(color);
		} else if (word.length == 4) {
			for(int i=0;i<3;i++){
				color[i]=word[i+1];
			}
			searchVO.setColor(color);
		}

		return searchService.memColor(searchVO);
	}
	
	
	//팔로우 색상 검색
	@RequestMapping("/jsp/**/followColor")
	public @ResponseBody List<SearchResult> followColor(@RequestParam(value = "search") String search,
			@RequestParam(value="tag")String tag, HttpSession session)
			throws UnsupportedEncodingException {
		search = URLDecoder.decode(search, "UTF-8");
		tag = URLDecoder.decode(tag, "UTF-8");
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();

		String[] word = search.split(",");
		Search searchVO = new Search();
		
		String[] color = new String[word.length - 1];
	
		searchVO.setSearchKey(word[0]);
		searchVO.setTags(tag);
		searchVO.setMem_no(mem_no);
		
		if (word.length == 2) {
			color[0] = word[1];
			searchVO.setColor(color);
		} else if (word.length == 3) {
			for(int i=0;i<2;i++){
				color[i]=word[i+1];
			}
			searchVO.setColor(color);
		} else if (word.length == 4) {
			for(int i=0;i<3;i++){
				color[i]=word[i+1];
			}
			searchVO.setColor(color);
		}
		return searchService.followColor(searchVO);
	}
	
	//모든 색상 검색
		@RequestMapping("/jsp/**/allColor")
		public @ResponseBody List<SearchResult> allColor(@RequestParam(value = "search") String search,
				@RequestParam(value="tag")String tag)
				throws UnsupportedEncodingException {
			search = URLDecoder.decode(search, "UTF-8");
			tag = URLDecoder.decode(tag, "UTF-8");
			

			String[] word = search.split(",");
			Search searchVO = new Search();

			
			String[] color = new String[word.length - 1];
		
			searchVO.setSearchKey(word[0]);
			searchVO.setTags(tag);

			if (word.length == 2) {
				color[0] = word[1];
				searchVO.setColor(color);
			} else if (word.length == 3) {
				for(int i=0;i<2;i++){
					color[i]=word[i+1];
				}
				searchVO.setColor(color);
			} else if (word.length == 4) {
				for(int i=0;i<3;i++){
					color[i]=word[i+1];
				}
				searchVO.setColor(color);
			}
			return searchService.allColor(searchVO);
		}
		
		@RequestMapping("/jsp/**/searchPeople")
		public @ResponseBody List<MemberResult> searchPeople(@RequestParam(value = "search") String search,
					HttpSession session)
				throws UnsupportedEncodingException {
			search = URLDecoder.decode(search, "UTF-8");
			
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			
			int mem_no = authInfo.getMem_no();

			Search searchVO = new Search();
			searchVO.setSearchKey(search);
			
			List<MemberResult> memberResult =  searchService.searchPeople(searchVO, mem_no);
			
			for(int i=0; i<memberResult.size(); i++){
				System.out.println(memberResult.get(i).getFol_check());
			}

			return memberResult;
		}
}
