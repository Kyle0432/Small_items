package BB高级类特性2;
//接口的应用：代理模式
public class TestProxy {
    public static void main(String[] args) {
		Object obj = new ProxyObject();
		obj.action();
	}
}
interface Object{
	 void action();
}
//代理类
class ProxyObject implements Object{
     Object obj;
    public ProxyObject(){
    	System.out.println("代理类创建成功");
    	 obj = new Objectlmpl();
    }
	@Override
	public void action() {
		 System.out.println("代理类开始执行");
		 obj.action();
		 System.out.println("代理类执行结束");
	}	
}
class Objectlmpl implements Object{
	@Override
	public void action() {
		System.out.println("=====被代理类开始执行=====");
		System.out.println("=====具体的操作======");
		System.out.println("=====被代理类执行完毕=====");
	}
}