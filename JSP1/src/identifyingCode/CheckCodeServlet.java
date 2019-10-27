package identifyingCode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         //1,��ȡ�������:CHECK_CODE_PARAM_NAME
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
		
		//2,��ȡsession�е�CHECK_CODE_KEY����ֵ
		String sessionCode = (String)request.getSession().getAttribute("CHECK_CODE_KEY");
		System.out.println(paramCode);
		System.out.println(sessionCode);
		
		//3,�Աȿ��Ƿ�һ��,��һ��˵����֤��ȷ,����һ��,˵����֤�����
		if(!(paramCode != null && paramCode.equals(sessionCode))){
			request.getSession().setAttribute("message", "��֤�벻һ��");
			response.sendRedirect(request.getContextPath()+"/Session4/index.jsp");
			return;
		}
		System.out.println("��֤�ɹ�");
	}
}
