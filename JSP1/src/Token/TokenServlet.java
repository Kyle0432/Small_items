package Token;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//�ӳ�˯��
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String name = request.getParameter("name");
		System.out.println("name"+name);
		//ͨ������ת��
		request.getRequestDispatcher(request.getContextPath()+"/Session2/success.jsp");
	}
}
