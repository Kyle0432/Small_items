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
        	 //����ڿ���̨��
           System.out.println("����ǩ�ı�ǩ��������name:"+name);
           getJspBody().invoke(null);
           
         }
}
