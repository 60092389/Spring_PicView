package picView.picture.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import picView.cate.model.Category;
import picView.cate.model.CategoryDao;
import picView.member.service.Action;
import picView.member.service.ActionForward;

public class UploadCategoryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CategoryDao dao = CategoryDao.getInstatnce();
		List<Category> cate_select = dao.ListCategory2();
		
		request.setAttribute("cate_select", cate_select);
		ActionForward forward = new ActionForward();
		forward.setPath("upload.jsp");
		forward.setReDirect(false);
		return forward;
		
	}

}
