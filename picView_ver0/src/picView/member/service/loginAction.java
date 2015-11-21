/*package picView.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import picView.member.model.Member;
import picView.member.model.MemberDao2;

public class loginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		Member member = new Member();
		
		member.setMem_id(id);
		member.setMem_pwd(pass);
		
		MemberDao2 dao = MemberDao2.getInstance();
		Member member2 = dao.loginMember(member);
		
		int re = 0;
		
		
		
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		
		if(member2 != null){
			re = 1;
		}else if(member2 == null){
			re = -1;
		}

		if(re>0){
			
			session.setAttribute("mem_no", member2.getMem_no());
			session.setAttribute("mem_name", member2.getMem_name());
			session.setAttribute("mem_id", member2.getMem_id());
			session.setAttribute("mem_pwd", member2.getMem_pwd());
			session.setAttribute("mem_birth", member2.getMem_birth());
			session.setAttribute("mem_sex", member2.getMem_sex());
			session.setAttribute("category_no", member2.getCategory_no());
			session.setAttribute("black_check", member2.getBlack_check());
			session.setAttribute("pic_count", member2.getPic_count());
			session.setAttribute("mem_date", member2.getMem_date());
			//int ok = Integer.parseInt((String) session.getAttribute("mem_no"));
			forward.setPath("../myRoom/my_Manage.html");
			forward.setReDirect(true);
		}else{
			forward.setPath("../login/loginForm.jsp");
			forward.setReDirect(true);
		}

		return forward;
	}

}
*/