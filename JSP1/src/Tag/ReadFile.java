package Tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class ReadFile extends SimpleTagSupport {
     private String src;
     public void setSrc(String src) {
		this.src = src;
	}
     @Override
    public void doTag() throws JspException, IOException {
    	super.doTag();
    PageContext pageContext = (PageContext)getJspContext();
    InputStream in = pageContext.getServletContext().getResourceAsStream(src);
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    	
    String str = null;
    while((str = reader.readLine())!= null){
		pageContext.getOut().println(str);
		pageContext.getOut().println("<br>"); 
    }
    }
}
