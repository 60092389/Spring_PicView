package picView.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import picView.admin.action.ActionForward;
import picView.member.model.MemberDao2;

public class DeleteMember implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		MemberDao2 dao = MemberDao2.getInstance();
		ActionForward foward = new ActionForward();
			
		String mem = request.getParameter("mem_no");
		int mem_no=0;
		if(mem != null){
			mem_no = Integer.parseInt(mem);
		}
		System.out.println(mem_no);
		
		dao.deleteMember(mem_no);
			
		foward.setReDirect(true);
		foward.setPath("list.ao");
		
		return foward;
	}

}
