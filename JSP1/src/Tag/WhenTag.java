package Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {
    private boolean test;
    
    public void setText(boolean text) {
		this.test = test;
	}
    @Override
    public void doTag() throws JspException, IOException {
       if(test){
    	     //getParent()��ʾ�õ�����ǩ������,(ChooseTag)��ʾ��ָ�����Ǹ�����ǩ,Ҫ��Ȼ�Ͳ�֪���ĸ�����ǩ��
    	      ChooseTag chooseTag = (ChooseTag)getParent();
    	      boolean flag = chooseTag.isFlag();
    	     if(flag){//flagĬ�ϱ�ʾΪtrue
    	    	 getJspBody().invoke(null);
    	    	 chooseTag.setFlag(false);
    	     }
       }
    }
}
