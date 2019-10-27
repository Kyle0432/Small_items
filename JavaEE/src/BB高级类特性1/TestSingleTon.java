package BB高级类特性1;
/*
 * 设计模式：设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。
 * 23种设计模式。
 * 
 * 单例的设计模式：
 * 1.解决的问题：使得一个类只能够创建一个对象。
 * 2.如何实现？见如下的4步
 */
public class TestSingleTon {
     public static void main(String[] args) {
    	   SingleTon s1 = SingleTon.getInstance();
           SingleTon s2 = SingleTon.getInstance();
           System.out.println(s1 == s2);//打印的对象地址相同   所以创建的是同一个对象
	}
}
//只能创建Singleton的单个实例
class SingleTon{
	//1,私有化构造器,使得在类的外部不能够调用此构造器
	private SingleTon(){
		
	}
	//2,在类的内部创建一个类的实例
	private static SingleTon instance = new SingleTon();
	//3,私有化此对象,通过公共的方法来调用
	//4,此公共的方法,只能通过类来调用,因为设置为static的同时类的实例也必须static来声明
	public static SingleTon getInstance(){
		return instance;
	}
}