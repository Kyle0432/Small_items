package BB高级类特性1;
//懒汉式:可能存在线程安全问题的
public class TestSingleTon1 {
    public static void main(String[] args) {
    	SingleTon1 s1 = SingleTon1.getInstance();
    	SingleTon1 s2 = SingleTon1.getInstance();
    	System.out.println(s1 == s2);
	}
}
class SingleTon1{
	//私有化构造器
	private SingleTon1(){
		
	}
	//对象的实例
	private static SingleTon1 instance = null;
	//私有化对象
	//通过公共的方法获取对象
	public static SingleTon1 getInstance(){
		if(instance == null){
			instance = new SingleTon1();
		}
		return instance;
	}
}