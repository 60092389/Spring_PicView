package picView.cate.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import picView.cate.model.Category;
import picView.cate.model.CategoryDao;
import picView.member.service.Action;
import picView.member.service.ActionForward;

public class ListCategoryAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CategoryDao dao = CategoryDao.getInstatnce();
		List<Category> cate_list = dao.ListCategory2();
		
		request.setAttribute("cate_list", cate_list);
		ActionForward forward = new ActionForward();
		forward.setPath("register.jsp");
		forward.setReDirect(false);
		return forward;
	}
	
}
