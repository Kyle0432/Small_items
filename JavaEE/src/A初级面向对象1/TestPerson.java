package A�����������1;
/*
 * Ҫ��(1)����Person��Ķ������øö����name��age��sex���ԣ�����study������
 * ����ַ�����studying��������showAge()������ʾageֵ������addAge()����������
 * ��age����ֵ����2�ꡣ
(2)�����ڶ�������ִ���������������ͬһ����Ĳ�ͬ����֮��Ĺ�ϵ��
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
	System.out.println("����"+a);
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
	//�����ô˷����Ķ����age��������i��,�������µ�age
	public int addAge(int i){
		this.age += i;
		return age;
	}
}
