package A初级面向对象2;
/*
 * 一、类的第三个成员：构造器(constructor 构造方法)   construction  CCB  ICBC   oop
 * constructor:建造者 
 * 构造器的作用：①创建对象 ②给创建的对象的属性赋值
 * 
 * 1.设计类时，若不显式声明类的构造器的话，程序会默认提供一个空参的构造器
 * 2.一旦显式的定义类的构造器，那么默认的构造器就不再提供。
 * 3.如何声明类的构造器。格式：权限修饰符  类名(形参){ }
 * 4.类的多个构造器之间构成重载
 * 
 * 
 * 二、类对象的属性赋值的先后顺序：①属性的默认初始化 ②属性的显式初始化③通过构造器给属性初始化
 * 						  ④通过"对象.方法"的方式给属性赋值
 * 
 */
public class TestPersonpoint {
public static void main(String[] args) {
	  Man p1 = new Man();//Man()是个构造器   它会自动调用构造器
	  System.out.println(p1.getName()+":"+p1.getAge());
	  String str = new String("java ");
	  System.out.println(str);
	  System.out.println("==================");
	  Man p2 = new Man("KYEL");
	  System.out.println();
	  System.out.println(p2.getName());
	  System.out.println(p2.getAge());
	  System.out.println("====================");
	  Man p3 = new Man("李星",19);
	  System.out.println("name: "+p3.getName()+"age: "+p3.getAge());
}
}
class Man{
	//属性
	private String name;
	private int age ;
	//构造器
	//以下四个构造器构成重载
	public Man(){
		//无参构造可直接赋值
		age = 10;
		name = "张三";
	}
	public Man(String name){
		this.name = name;
	}
	public Man(int age){
		this.age = age;
	}
	public Man(String name , int age){
		this.name = name;
		this.age  = age;
	}
	//方法
	public void setName(String name){
		this.name = name ;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age ;
	}
	public int getAge(){
		return age;
	}
}
