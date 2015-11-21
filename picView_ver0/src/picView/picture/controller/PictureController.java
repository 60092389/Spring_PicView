package picView.picture.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import picView.picture.service.Action;
import picView.picture.service.ActionForward;
import picView.picture.service.DeleteAction;
import picView.picture.service.InsertAction;
import picView.picture.service.ListMyShowAction;
import picView.picture.service.ManageListAction;


@WebServlet("*.po")
public class PictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PictureController() {
        super();
        
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
    	
    	
    	if(command.equals("jsp/basic/fupload.po")){
    		
    		InsertAction action2 = new InsertAction();
    		try {
   				action2.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("jsp/myRoom/myshow.po")){
    		action = new ListMyShowAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("jsp/myRoom/manageAction.po")){
    		
    		action = new ManageListAction();
    		try {
    			forward = action.execute(request, response);			
    			
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("jsp/myRoom/deletePicture.po")){
    		action = new DeleteAction();
    		try{
    			forward = action.execute(request, response);
    		}catch(Exception e){
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

}
