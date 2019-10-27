package shopping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProcessStep2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       //1,��ȡ�������: name, address ,cardType,card
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String cardType = request.getParameter("cardType");
		String card = request.getParameter("card");
		Customer customer = new Customer(name,address,cardType,card) ;
	   //2,��������Ϣ��ŵ�HttpSession��
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
	   //3,�ض���ҳ�浽confirm.jsp
		response.sendRedirect(request.getContextPath()+"/shoppingcart/confirm.jsp");
	}
}
