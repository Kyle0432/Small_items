package J多线程2;
//关于懒汉式的线程安全问题：使用同步机制
//对于一般的方法内，使用同步代码块，可以考虑使用this。
//对于静态方法而言，使用当前类本身充当锁。
public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
}
class Singleton{
	private Singleton(){
		
	}
	private static Singleton instance = null;
	//静态static里面无法使用this,可以用Singleton.class表示本类对象
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
			instance = new Singleton();
			}
		}
		return instance;
	}
}