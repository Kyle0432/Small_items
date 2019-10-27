package JavaWeb;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HttpFilter.HttpFilter;

public class PasswordFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
      String initPassword = getFilterConfig().getServletContext().getInitParameter("password");
      String password = request.getParameter("password");
		
      
      if(!initPassword.equals(password)){
    	  request.setAttribute("message", "ÃÜÂë²»ÕýÈ·");
    	  request.getRequestDispatcher("/login.jsp").forward(request, response);
    	  return;
      }
      
      filterChain.doFilter(request, response);
	}

}
