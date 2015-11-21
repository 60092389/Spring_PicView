package picView.cate.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import picView.cate.model.Category;
import picView.cate.model.CategoryDao;
import picView.cate.model.ListModel;
import picView.cate.model.Search;
import picView.member.service.Action;
import picView.member.service.ActionForward;

public class ListCategoryAction2 implements Action {

	private static final int PAGE_SIZE = 5;
	
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*CategoryDao dao = CategoryDao.getInstatnce();
		List<Category> cate_list = dao.selectCategory();
		
		request.setAttribute("cate_list", cate_list);
		ActionForward forward = new ActionForward();
		forward.setPath("category_Admin.jsp");
		forward.setReDirect(false);
		return forward;*/
		
		System.out.println(request.getParameterValues("area"));
		System.out.println("%"+request.getParameter("searchKey")+"%");
		
		request.setCharacterEncoding("utf-8");
		CategoryDao dao = CategoryDao.getInstatnce();
		Search search = new Search();
		HttpSession session = request.getSession();
		
		if(request.getParameter("temp") != null){
			session.removeAttribute("search");
		}
		
		if(request.getParameterValues("area") != null){
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%"+request.getParameter("searchKey")+"%");
			session.setAttribute("search", search);
		}
		
		if(session.getAttribute("search") != null){
			search=(Search)session.getAttribute("search");
		}
		
		String req = request.getParameter("pageNum");
		int requestPage = 1;
		if(req != null){
			requestPage = Integer.parseInt(req);
		}
		
		int totalRow = dao.countCate(search);
		int totalPage = totalRow/PAGE_SIZE;
		if(totalRow%PAGE_SIZE > 0){
			totalPage++;
		}
		
		int startPage = requestPage - (requestPage - 1) % 5;
		int endPage = startPage + 4;
		if(endPage > totalPage){
			endPage = totalPage;
		}
		
		List<Category> list = dao.ListCategory((requestPage-1)*PAGE_SIZE, search);
		
		ListModel listModel = new ListModel(list, requestPage, totalPage, startPage, endPage);
		
		ActionForward forward = new ActionForward();
		
		request.setAttribute("listModel", listModel);
		
		forward.setReDirect(false);
		forward.setPath("category_Admin.jsp");
		
		return forward;
		
	}

}
