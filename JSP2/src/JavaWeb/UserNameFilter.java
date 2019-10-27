package JavaWeb;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HttpFilter.HttpFilter;

public class UserNameFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		String initUser = getFilterConfig().getInitParameter("username");
		String username = request.getParameter("username");
		
		if(!initUser.equals(username)){
			request.setAttribute("message", "用户名不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		filterChain.doFilter(request, response);
	}

}
