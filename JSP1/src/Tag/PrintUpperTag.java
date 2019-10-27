package Tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintUpperTag extends SimpleTagSupport {
    private String time;
    public void setTime(String time) {
		this.time = time;
	}
    @Override
    public void doTag() throws JspException, IOException {
    //1,得到标签体的内容
    JspFragment bodyContext = getJspBody();
    StringWriter sw = new StringWriter();
    bodyContext.invoke(sw);
    String context = sw.toString();
    //2,变成大写
    context = context.toUpperCase();
    //3,得到out隐含对象
    //4,循环输出
    int count = 1;
    try {
		count = Integer.parseInt(time);
	} catch (Exception e) {
		e.printStackTrace();
	}
     for(int i = 0; i<count ;i++){
        getJspContext().getOut().print(i+1+"."+context+"<br>");    	 
     }
    }
}
