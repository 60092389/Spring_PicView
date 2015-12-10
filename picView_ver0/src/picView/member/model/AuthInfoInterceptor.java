package picView.member.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInfoInterceptor extends HandlerInterceptorAdapter{

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      HttpSession session = request.getSession(false);
      System.out.println("session check : "+session.getAttribute("authIno"));
      if(session != null){
         AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
         System.out.println("session check2 : "+session.getAttribute("authIno"));
         if(authInfo != null){
            return true;
         }
      }
      response.sendRedirect(request.getContextPath()+"/jsp/index/index.jsp");
      return false;
   }

   
   

}