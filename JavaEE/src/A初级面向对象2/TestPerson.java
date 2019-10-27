package A初级面向对象2;
/*
 * 创建程序,在其中定义两个类：Person和TestPerson类。定义如下：
    用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄。
    在TestPerson类中实例化Person类的对象b，调用setAge()和getAge()方法，体会Java的封装性。

 */
public class TestPerson {
   public static void main(String[] args) {
	  Person p = new Person("kyle",20);
	  p.setAge(99);
	  System.out.println(p.getName()+"；"+p.getAge());
}
}
class Person{
	 private int age;
	 private String name;
	 public int getAge(){
		 return age;
	 }
	 public void setAge(int a){
		 if(a > 0 && a<=130){
			 age = a;
		 }else{
			System.out.println("您输入的数据有误！");
		 }
	 }
	 public void setNmae(String name){
		 this.name = name;
	 }
	 public String getName(){
		 return name;
	 }
	 //构造器
	 public Person(String name, int age){
		 this.name = name;
		 this.age = age;
	 }
}