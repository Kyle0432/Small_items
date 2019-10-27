package shopping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessStep1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		      //1,获取选中的图书信息
				String [] books = request.getParameterValues("book");
			  //2,把图书信息放入到HttpSession
		        request.getSession().setAttribute("books", books);
			  //3,重定向页面到 shoppingcart/step-2.jsp,并且使用绝对路径
				response.sendRedirect(request.getContextPath()+"/shoppingcart/step-2.jsp");
	}
}
