package picView.picture.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import picView.picture.model.PictureDao;
import picView.picture.model.PictureShow;
import picView.picture.service.ActionForward;

public class ListMyShowAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		int mem_no =  (int) session.getAttribute("mem_no");
		System.out.println(mem_no);
		
		request.setCharacterEncoding("utf-8");
		PictureDao dao = PictureDao.getInstance();
		
		List<PictureShow> list = dao.listMyShow(mem_no);
		request.setAttribute("listShow", list);
		
		System.out.println("dd");
		
		ActionForward foward = new ActionForward();
		
		foward.setReDirect(false);
		foward.setPath("my_Show.jsp");
		
		return foward;
	}
	

}
