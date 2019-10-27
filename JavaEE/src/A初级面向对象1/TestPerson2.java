package A初级面向对象1;
/*
 * 1.面向对象的编程关注于类的设计
 * 2.设计类实际上就是设计类的成员
 * 3.基本的类的成员：属性（成员变量或Field）  & 方法（Method）
 */
public class TestPerson2 {
public static void main(String[] args) {
	Person1 p = new Person1();
     p.setName("kyle");
     p.sex = true;
     p.info();
}
}
class Person1{
	//属性 
	String name;
	int age = 10;
	boolean sex ;
	//方法
	public void eat(){
		System.out.println("人吃饭");
	}
	public void sleep(){
		System.out.println("人睡觉");
	}
	//可给name赋值
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void info(){
		this.eat();//也可省略this.  直接eat()；
		this.sleep();
		System.out.println("name:"+name+"age"+age+"sex"+sex);
	}
}
