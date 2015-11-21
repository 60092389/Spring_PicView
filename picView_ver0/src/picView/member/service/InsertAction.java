/*package picView.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import picView.member.model.Member;
import picView.member.model.MemberDao2;
import picView.member.service.ActionForward;

public class InsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String mem_id = request.getParameter("email");
		String mem_pwd = request.getParameter("pass");
		String mem_name = request.getParameter("name");
		String mem_year = request.getParameter("year");
		String mem_month = request.getParameter("month");
		String mem_day = request.getParameter("day");
		String mem_sex = request.getParameter("gender");
		String[] category_no = request.getParameterValues("category_no");
		
		String cate = "";
		//생년월일(mem_birth)을 년(year)+월(month)+일(day)로 합쳐서 넣음
		String mem_birth = mem_year+mem_month+mem_day;
			    
	    Member member = new Member();
	    
	    member.setMem_id(mem_id);
	    member.setMem_pwd(mem_pwd);
	    member.setMem_name(mem_name);
	    member.setMem_birth(mem_birth);
	    member.setMem_sex(mem_sex);
	    for(int i=0;i<category_no.length;i++){
	    	cate = cate +category_no[i] + ",";
	    	 
	    }
	    member.setCategory_no(cate);//카테고리 선택된것만 set해주기
	   
	    
	    
	    		
		MemberDao2 dao = MemberDao2.getInstance();
		int re = dao.insertMember(member);
		
		ActionForward forward = new ActionForward();
		
		if(re == 1){
			forward.setReDirect(true);
			forward.setPath("loginForm.jsp");
		}
		else{
			forward.setReDirect(true);
			forward.setPath("register.jsp");
		}

		return forward;
	}

}
*/