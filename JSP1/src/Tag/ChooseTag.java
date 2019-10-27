package Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {
	/*> �ڸ���ǩ choose �ж���һ�� "ȫ��" �� boolean ���͵� flag: �����ж��ӱ�ǩ������������������Ƿ�ִ��. 
	
	* �� when �� test Ϊ true, �� when �ĸ���ǩ�� flag ҲΪ true, ��ִ�� when �ı�ǩ��(���������ǩ�������), 
	     ͬʱ�� flag ����Ϊ false
	* �� when �� test Ϊ true, �� when �ĸ���ǩ�� flag Ϊ false, ��ִ�б�ǩ��. 
	* �� flag Ϊ true, otherwise ִ�б�ǩ��. */

     private boolean flag = true;
     
     public void setFlag(boolean flag) {
		this.flag = flag;
	 }
     public boolean isFlag(){
    	 return flag;
     }
     @Override
    public void doTag() throws JspException, IOException {
        getJspBody().invoke(null);
     }
}
