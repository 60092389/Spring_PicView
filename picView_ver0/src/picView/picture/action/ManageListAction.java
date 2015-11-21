package picView.picture.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import picView.picture.model.Picture;
import picView.picture.model.PictureDao;
import picView.picture.action.Action;
import picView.picture.action.ActionForward;

public class ManageListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		int mem_no = Integer.parseInt(String.valueOf(session.getAttribute("mem_no")));
		
		
		//Picture picture = new Picture();
		PictureDao dao = PictureDao.getInstance();
		List<Picture> ManagePicList = dao.ManageListPicture(mem_no);
		List<Picture> picDate = dao.PictureDate(mem_no);
		
		request.setAttribute("list", ManagePicList);
		request.setAttribute("date", picDate);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("my_Manage.jsp");
		forward.setReDirect(false);
		
		System.out.println(forward.getPath());
		
		return forward;
		
	}

}
