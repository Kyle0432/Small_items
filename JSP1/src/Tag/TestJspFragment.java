package Tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFragment extends SimpleTagSupport {
     
	@Override
	public void doTag() throws JspException, IOException {
        //��ȡ��ǩ��
		JspFragment bodycontext = getJspBody();
        //JspFragment.invoke(Write):Write��Ϊ��ǩ������������ַ���
		//��Ϊnull,�������getJspContext.getOut().�������ҳ����
		 
		//1,����StringWrite �õ���ǩ�������
		StringWriter sw = new StringWriter();
		bodycontext.invoke(sw);
		//2,�ѱ�ǩ������ݶ���Ϊ��д
		String context = sw.toString().toUpperCase();
		//3,��ȡJspҳ���out��������,�����ҳ����
		getJspContext().getOut().print(context);
	}
	
}
