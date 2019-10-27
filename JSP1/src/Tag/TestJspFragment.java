package Tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFragment extends SimpleTagSupport {
     
	@Override
	public void doTag() throws JspException, IOException {
        //获取标签体
		JspFragment bodycontext = getJspBody();
        //JspFragment.invoke(Write):Write即为标签体内容输出的字符流
		//若为null,则输出到getJspContext.getOut().即输出到页面上
		 
		//1,利用StringWrite 得到标签体的内容
		StringWriter sw = new StringWriter();
		bodycontext.invoke(sw);
		//2,把标签体的内容都变为大写
		String context = sw.toString().toUpperCase();
		//3,获取Jsp页面的out隐含对象,输出到页面上
		getJspContext().getOut().print(context);
	}
	
}
