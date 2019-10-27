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
    //1,�õ���ǩ�������
    JspFragment bodyContext = getJspBody();
    StringWriter sw = new StringWriter();
    bodyContext.invoke(sw);
    String context = sw.toString();
    //2,��ɴ�д
    context = context.toUpperCase();
    //3,�õ�out��������
    //4,ѭ�����
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
