package A初级面向对象1;
/*
 * 要求：(1)创建Person类的对象，设置该对象的name、age和sex属性，调用study方法，
 * 输出字符串“studying”，调用showAge()方法显示age值，调用addAge()方法给对象
 * 的age属性值增加2岁。
(2)创建第二个对象，执行上述操作，体会同一个类的不同对象之间的关系。
 */
public class TestPerson {
public static void main(String[] args) {
	Person p = new Person();
	p.setAge(20);
	p.setName("kyle");
	p.setSex(true);
	System.out.println("------------");
	p.showAge();
	p.study();
	int a = p.addAge(3);
	System.out.println("年龄"+a);
   }
}
class Person{
	private String name;
	private int age ;
	private boolean sex;
	public void setName(String name){
		this.name = name;
	}
	public String getNmae(){
		return name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	public void setSex(boolean sex){
		this.sex = sex;
	}
	public boolean getSex(){
		return sex;
	}
	public void study(){
		System.out.println("studying");
	}
	public void showAge(){
		System.out.println(age);
	}
	//给调用此方法的对象的age属性增加i岁,并返回新的age
	public int addAge(int i){
		this.age += i;
		return age;
	}
}
