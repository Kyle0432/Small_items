package A�����������3;
/*
 * this:
 * 1.���������������ԡ�������������
 * 2.this���Ϊ��ǰ�����ǰ���ڴ����Ķ���.���磺this.name,this.show();
 * 
 * 3.�����ڹ�������ͨ����this(�β�)���ķ�ʽ��ʾ�ĵ��ñ������������ص�ָ���Ĺ�������
 *   Ҫ��1.�ڹ������ڲ��������������У�
 *       2.��һ��������n������������ô�����n-1����������ʹ����this(�β�);
 * 
 */
public class TestPerson {
public static void main(String[] args) {
	Person p = new Person();
	p.info();
	p.show();
	
}
}
class Person{
	private String name;
	private int age ;
	public Person(){
		this("kyle",19);//ע��this(�β�)�β����������ֱ����Ҫ����ֵҲ������������
		System.out.println("����Person�����޲ι�����");
	}
	public Person(String name){
		this(12);
		System.out.println("����Person�����β�Ϊname�Ĺ�����");
		this.name = name;
	}
	public Person(int age){
		System.out.println("����Person�����β�Ϊage�Ĺ�����");
		this.age = age;
	}
	public Person(String name,int age){
		this(name);
		this.name = name;
		//this():����������ʾ�ĵ��õ�ǰ������ص�ָ���Ĺ�������
		System.out.println("����Person�����β�Ϊname��age�Ĺ�����");
		this.age = age;
		
	}
	//this.name:��ʾ��ǰ���������               name:���β�
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
	public void eat(){
		System.out.println("�˳Է�");
	}
	public void sleep(){
		System.out.println("��˯��");
	}
	public void show(){
		System.out.println("����һ���ˣ��ҵ������ǣ�"+this.name);
	}
	public void info(){
		System.out.println("name: "+this.name+"age: "+this.age);
		this.show();
	}
}