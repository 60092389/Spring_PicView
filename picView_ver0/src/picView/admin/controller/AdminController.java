/*package picView.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import picView.admin.service.Action;
import picView.admin.service.ActionForward;
import picView.admin.service.DeleteMember;
import picView.admin.service.ListMember;

@WebServlet("*.ao")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String requestURI = request.getRequestURI();
    	System.out.println(requestURI);
    	
    	if(request.getCharacterEncoding() == null){
    		request.setCharacterEncoding("utf-8");
    	}
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+1);
    	System.out.println(command);
    	
    	ActionForward forward = null;
    	Action action = null;
    	
    	if(command.equals("jsp/admin/list.ao")){
    		action = new ListMember();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	else if(command.equals("jsp/admin/deleteMember.ao")){
    		action = new DeleteMember();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
     
    	if(forward != null){
    		if(forward.isReDirect()){
    			response.sendRedirect(forward.getPath());

    		}else{
    			RequestDispatcher dispacher = 
    					request.getRequestDispatcher(forward.getPath());
    			dispacher.forward(request, response);
    		}
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}*/