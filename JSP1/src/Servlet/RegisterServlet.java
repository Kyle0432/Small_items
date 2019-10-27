package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.print("<h3>All Parameters From REquest</h3>");
		out.print("<table border=1 align=left>\n");
		out.print("<tr bgcolor=\"#FFFFFF\">\n");
		out.print("<th>Parameter Name <th> Parameter Value");
		Enumeration enuNames = request.getParameterNames();
		
		while(enuNames.hasMoreElements()){
			String strParam=(String)enuNames.nextElement();
			out.print("<tr><td>"+strParam+"\n<td>");
			String [] paramValues = request.getParameterValues(strParam);
			if(paramValues.length ==1){
				String paramValue = paramValues[0];
				if(paramValues.length == 0){
					out.print("<i>Empty</i>");
				}else{
					out.print(paramValues);
				}
			}else{
				out.print("<ul>");
				for(int i = 0; i < paramValues.length; i++){
					out.print("<li>"+paramValues[i]);
				}
				out.print("</ul>");
			}
 		}
		out.println("</table>\n</body></HTML>");
		out.flush();
		out.close();
	}

}
