package BB高级类特性1;
class Root{
	static{
		System.out.println("Root的静态初始化块");
	}
	public Root(){
		System.out.println("Root的无参数构造器");
	}
	{
		System.out.println("Root的普通初始化快");
	}
}
class Mid extends Root{
	static{
		System.out.println("Mid是静态初始化块");
	}
	{
		System.out.println("Mid的普通初始化块");
	}
	public Mid(){
		System.out.println("Mid的无参的构造器");
	}
	public Mid(String msg){
		//调用本类重载的构造器
		this();
		System.out.println("Mid的带参数构造器,其参数值："+ msg);
	}
}
class Leaf extends Mid{
	static{
		System.out.println("Leaf的静态初始化块");
	}
	{
		System.out.println("Leaf的普通初始化块");
	}
	public Leaf(){
		//调用父类含参的构造器
		super("尚硅谷");
		System.out.println("执行Leaf的构造器");
	}
}
public class TestLeaf {
   public static void main(String[] args) {
	   new Leaf();//调用Leaf()无参构造器
	   System.out.println();
}
}
