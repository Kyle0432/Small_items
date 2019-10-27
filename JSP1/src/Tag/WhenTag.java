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
    	     //getParent()表示得到父标签的引用,(ChooseTag)表示所指定的那个父标签,要不然就不知道哪个父标签了
    	      ChooseTag chooseTag = (ChooseTag)getParent();
    	      boolean flag = chooseTag.isFlag();
    	     if(flag){//flag默认表示为true
    	    	 getJspBody().invoke(null);
    	    	 chooseTag.setFlag(false);
    	     }
       }
    }
}
