package B高级类特性1;
/*
 * super:可以用来修饰属性、方法、构造器
 * 
 * 1)当子类与父类中有同名的属性时，可以通过"super.此属性"显式的调用父类中声明的属性.
 * 若想调用子类的同名的属性“this.此属性”
 * 
 * 2)当子类重写父类的方法以后，在子类中若想再显式的调用父类的被重写的方法，就需要使用“super.方法”
 * 
 * 3)super修饰构造器：通过在子类中使用“super(形参列表)”来显式的调用父类中指定的构造器。
 *    >在构造器内部，“super(形参列表)”必须要声明在首行！
 *    >在构造器内部，“this(形参列表)”或“super(形参列表)”只能出现一个！
 *    >当构造器中，不显式的调用“this(形参列表)”或“super(形参列表)”其中任何一个，默认调用的是
 *      父类空参的构造器！
 *    建议：设计一个类时，尽量要提供一个空参的构造器！
 */
public class TestStudent {
  public static void main(String[] args) {
		Student s = new Student();
		s.show();
		s.info();
		System.out.println(s.getName() + ":" + s.getAge());	
		Student s1 = new Student("北京希望大学");
		System.out.println(s1.getName() + ":" + s1.getAge() + "," + s1.getSchoolName());	
		System.out.println(Person.class.getSuperclass().getName());
}
}
 class Person {
	protected String name;
	protected int age;
	int id = 1001;//人的身份证号
	public Person() {
		//super();不写会默认super();
		System.out.println("这是Person空参的构造器！");
		this.name = "AA";
		this.age = 1;
	}
	public Person(String name) {
		this();
		this.name = name;
	}
	public Person(String name, int age) {
		this(name);
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void eat() {
		System.out.println("eating");
	}
	public void sleep() {
		System.out.println("sleeping");
		this.eat();
	}
	// 比较当前对象与形参的对象的age谁大。
	public int compare(Person p) {
		if (this.age > p.age)
			return 1;
		else if (this.age < p.age)
			return -1;
		else
			return 0;
	}
}
class Student extends Person{
		private String schoolName;
		int id = 1002;//学号	
		public Student(){
			//super();
		}	
		public Student(String schoolName){
			super("李雷",23);
			this.schoolName = schoolName;
		}	
		public String getSchoolName() {
			return schoolName;
		}
		public void setSchoolName(String schoolName) {
			this.schoolName = schoolName;
		}
		public void eat() {
			System.out.println("学生吃饭");
		}	
		public void info(){
			this.eat();
			super.eat();
			//super.sleep();
		}
		public void show(){
			System.out.println(this.id);//1002
			System.out.println(super.name);
			System.out.println(super.id);//1001
		}	
	}