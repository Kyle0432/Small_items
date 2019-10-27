package Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {
	/*> 在父标签 choose 中定义一个 "全局" 的 boolean 类型的 flag: 用于判断子标签在满足条件的情况下是否执行. 
	
	* 若 when 的 test 为 true, 且 when 的父标签的 flag 也为 true, 则执行 when 的标签体(正常输出标签体的内容), 
	     同时把 flag 设置为 false
	* 若 when 的 test 为 true, 且 when 的父标签的 flag 为 false, 则不执行标签体. 
	* 若 flag 为 true, otherwise 执行标签体. */

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
