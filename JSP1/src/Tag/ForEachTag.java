package Tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {
     private  Collection<?> items;
	 private  String var;
	 public void setItems(Collection<?> items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
       //遍历items对应的集合
	    if(items != null){
	    	for(Object obj: items){
	    		//把正在遍历的对象放到pageContext中,键:var,值：正在遍历的对象
	    		getJspContext().setAttribute(var, obj);
	    		//把标签体内容直接输出到页面上
	    		getJspBody().invoke(null);
	    	}
	    }
	}
}
