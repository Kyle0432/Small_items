package Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Otherwise extends SimpleTagSupport{
       @Override
    public void doTag() throws JspException, IOException {
          ChooseTag chooseTag = (ChooseTag)getParent();
          //��ʱisFlag()Ĭ�ϱ�ʾΪTrue
           if(chooseTag.isFlag()){
        	    getJspBody().invoke(null);
           }
       }
}
