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
         //1,获取请求参数:CHECK_CODE_PARAM_NAME
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
		
		//2,获取session中的CHECK_CODE_KEY属性值
		String sessionCode = (String)request.getSession().getAttribute("CHECK_CODE_KEY");
		System.out.println(paramCode);
		System.out.println(sessionCode);
		
		//3,对比看是否一致,若一致说明验证正确,若不一致,说明验证码错误
		if(!(paramCode != null && paramCode.equals(sessionCode))){
			request.getSession().setAttribute("message", "验证码不一致");
			response.sendRedirect(request.getContextPath()+"/Session4/index.jsp");
			return;
		}
		System.out.println("验证成功");
	}
}
