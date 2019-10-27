package HandToken;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TokenServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       try{
    	   Thread.sleep(2000);
       }catch(InterruptedException e){
    	   e.printStackTrace();
       }
       HttpSession session = request.getSession();
       Object token = session.getAttribute("token");
       String tokenValue = request.getParameter("token");
       System.out.println(token);
       System.out.println(tokenValue);
       
       if(token != null && token.equals(tokenValue)){
    	   session.removeAttribute("token");
       }else{
    	   response.sendRedirect(request.getContextPath()+"/Session3/token.jsp");
    	   return;
       }
       String name = request.getParameter("name");
       System.out.println("name"+name);
       //重定向可避免在还没有达到jsp页面前就重复提交了
       response.sendRedirect(request.getContextPath()+"/Session3/success.jsp");
	}
}
