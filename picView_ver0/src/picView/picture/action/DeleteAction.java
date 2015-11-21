package picView.picture.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import picView.picture.model.PictureDao;

public class DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int pic_no = -1;
		
		if(!request.getParameter("pic_no").equals(null)){
			pic_no = Integer.parseInt(request.getParameter("pic_no"));
		}
		
		System.out.println("deletePicture의 pic_no = "+pic_no);
		
		PictureDao dao = PictureDao.getInstance();
		int re = dao.deletePicture(pic_no);
		
		ActionForward forward = new ActionForward();
		
		if(re>0){
			forward.setPath("my_Manage.html");
			forward.setReDirect(false);
		}else{
			forward.setPath("my_Manage.html");
			forward.setReDirect(false);
		}
	
		
		return forward;
	}

}
