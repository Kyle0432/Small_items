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
		      //1,��ȡѡ�е�ͼ����Ϣ
				String [] books = request.getParameterValues("book");
			  //2,��ͼ����Ϣ���뵽HttpSession
		        request.getSession().setAttribute("books", books);
			  //3,�ض���ҳ�浽 shoppingcart/step-2.jsp,����ʹ�þ���·��
				response.sendRedirect(request.getContextPath()+"/shoppingcart/step-2.jsp");
	}
}
