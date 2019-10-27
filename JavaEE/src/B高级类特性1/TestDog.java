package B高级类特性1;
//子类对象实例化的全过程
public class TestDog {
	public static void main(String[] args) {
		Dog d = new Dog();//new 后面的 Dog()是构造器  表示调用该构造器
		d.setAge(10);
		d.setName("花花");
		d.setHostName("小明");
		System.out.println("name:" + d.getName() + " age:" + d.getAge()
				+ "hostName:" + d.getHostName());		
		System.out.println(d.toString());//打印的是d对象的地址 ， 加toString和不加一样
	}
}
// 生物
class Creator {
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Creator() {
		super();//调用父类Object
		System.out.println("this is Creator's constructor");
	}
}
// 动物类
class Animal extends Creator {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Animal() {
		super();//此时调用的是父类无参构造器
		System.out.println("this is Animal's constructor");
	}
}
// 狗
class Dog extends Animal {
	private String hostName;
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Dog() {
		super();//此时调用的是父类无参构造器
		System.out.println("this is Dog's constructor");
	}
}
