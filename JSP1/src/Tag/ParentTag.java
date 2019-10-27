package Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ParentTag extends SimpleTagSupport {
         private String name = "Kyle";
         public String getName() {
			return name;
		}
         @Override
        public void doTag() throws JspException, IOException {
        	 //输出在控制台上
           System.out.println("父标签的标签处理器类name:"+name);
           getJspBody().invoke(null);
           
         }
}
