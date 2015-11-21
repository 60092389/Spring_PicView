package picView.cate.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import picView.cate.service.ListCategoryAction;
import picView.cate.service.ListCategoryAction2;
import picView.cate.service.ListCategoryAction3;
import picView.cate.service.insertAction;
import picView.member.service.Action;
import picView.member.service.ActionForward;

@WebServlet("*.done")
public class CateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CateController() {
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
    	
    	
    	if(command.equals("jsp/admin/insertAction.done")){
    		System.out.println("되라");
    	  	action = new insertAction();
    		try {
   				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("jsp/admin/listAction.done")){
    		action = new ListCategoryAction2();
    		try{
    			forward = action.execute(request, response);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}else if(command.equals("jsp/category/categoryAction.done") ||
    			command.equals("jsp/account/categoryAction.done")){
    		action = new ListCategoryAction3();
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
    			RequestDispatcher dispatcher =
    					request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    	
    	
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
    
        

}
