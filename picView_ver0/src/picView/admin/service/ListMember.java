package picView.admin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import picView.admin.model.Search;
import picView.admin.service.ActionForward;
import picView.blacklist.model.BlackSearch;

import picView.member.model.Member;
import picView.member.model.MemberDao2;
import picView.blacklist.model.BlackListDao;
import picView.admin.model.ListModel;
import picView.blacklist.model.BlackListModel;
import picView.blacklist.model.BlackResult;

public class ListMember implements Action{
		private final static int PAGE_SIZE = 10;  
		
		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		request.setCharacterEncoding("utf-8");
		MemberDao2 dao = MemberDao2.getInstance();
		BlackListDao dao2 = BlackListDao.getInstance();
		
		Search search = new Search();
		BlackSearch blackSearch = new BlackSearch();
		
		HttpSession session = request.getSession();
		HttpSession blackSession = request.getSession();
		
		//멤버 리스트의 search와 페이징 
		if(request.getParameter("temp") != null){
			session.removeAttribute("search");
		}
		
		if(request.getParameterValues("area") != null){
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" + request.getParameter("searchKey") + "%");
			session.setAttribute("search", search);
		}
		
		if(session.getAttribute("search") != null){
			search = (Search)session.getAttribute("search");
		}
		
		String mem_req = request.getParameter("pageNo");
		int mem_requestPage = 1;
		if(mem_req != null){
			mem_requestPage = Integer.parseInt(mem_req);
		}
		
		int mem_totalRow = dao.totalRow(search);
		int mem_totalPage = mem_totalRow/PAGE_SIZE;
		if(mem_totalRow%PAGE_SIZE > 0){
			mem_totalPage++;
		}
		
		int mem_startPage = mem_requestPage - (mem_requestPage - 1) % 5;
		int mem_endPage = mem_startPage + 4;
		if(mem_endPage > mem_totalPage){
			mem_endPage = mem_totalPage;
		}
			
		List<Member> list = dao.listMember((mem_requestPage - 1)*PAGE_SIZE, search);
		ListModel listModel = new ListModel(list, mem_requestPage, mem_totalPage, mem_startPage, mem_endPage);
		//멤버리스트 페이징
		
		
		//블랙리스트 페이징
		//멤버 리스트의 search와 페이징 
				if(request.getParameter("temp") != null){
					blackSession.removeAttribute("blackSearch");
				}
				
				if(request.getParameterValues("blackarea") != null){
					blackSearch.setBlackarea(request.getParameterValues("blackarea"));
					blackSearch.setBlacksearchKey("%" + request.getParameter("blacksearchKey") + "%");
					blackSession.setAttribute("blackSearch", blackSearch);
				}
				
				if(session.getAttribute("blackSearch") != null){
					blackSearch = (BlackSearch)blackSession.getAttribute("blackSearch");
				}
				
				String black_req = request.getParameter("blackPageNo");
				int black_requestPage = 1;
				if(black_req != null){
					black_requestPage = Integer.parseInt(black_req);
				}
				
				int black_totalRow = dao2.totalRow(blackSearch);
				int black_totalPage = black_totalRow/PAGE_SIZE;
				if(black_totalRow%PAGE_SIZE > 0){
					black_totalPage++;
				}
				
				int black_startPage = black_requestPage - (black_requestPage - 1) % 5;
				int black_endPage = black_startPage + 4;
				if(black_endPage > black_totalPage){
					black_endPage = black_totalPage;
				}

		List<BlackResult> listBlack = dao2.listBlack((black_requestPage - 1)*PAGE_SIZE, blackSearch);
		BlackListModel listBlackModel = new BlackListModel(listBlack, black_requestPage, black_totalPage, black_startPage, black_endPage);
		
		request.setAttribute("listModel", listModel);
		request.setAttribute("listBlack", listBlackModel);
		
		ActionForward foward = new ActionForward();
		
		foward.setReDirect(false);
		foward.setPath("member_Admin.jsp");
		
		return foward;
	
	}
}
