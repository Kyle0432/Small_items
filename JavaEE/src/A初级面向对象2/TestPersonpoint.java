package A�����������2;
/*
 * һ����ĵ�������Ա��������(constructor ���췽��)   construction  CCB  ICBC   oop
 * constructor:������ 
 * �����������ã��ٴ������� �ڸ������Ķ�������Ը�ֵ
 * 
 * 1.�����ʱ��������ʽ������Ĺ������Ļ��������Ĭ���ṩһ���ղεĹ�����
 * 2.һ����ʽ�Ķ�����Ĺ���������ôĬ�ϵĹ������Ͳ����ṩ��
 * 3.���������Ĺ���������ʽ��Ȩ�����η�  ����(�β�){ }
 * 4.��Ķ��������֮�乹������
 * 
 * 
 * �������������Ը�ֵ���Ⱥ�˳�򣺢����Ե�Ĭ�ϳ�ʼ�� �����Ե���ʽ��ʼ����ͨ�������������Գ�ʼ��
 * 						  ��ͨ��"����.����"�ķ�ʽ�����Ը�ֵ
 * 
 */
public class TestPersonpoint {
public static void main(String[] args) {
	  Man p1 = new Man();//Man()�Ǹ�������   �����Զ����ù�����
	  System.out.println(p1.getName()+":"+p1.getAge());
	  String str = new String("java ");
	  System.out.println(str);
	  System.out.println("==================");
	  Man p2 = new Man("KYEL");
	  System.out.println();
	  System.out.println(p2.getName());
	  System.out.println(p2.getAge());
	  System.out.println("====================");
	  Man p3 = new Man("����",19);
	  System.out.println("name: "+p3.getName()+"age: "+p3.getAge());
}
}
class Man{
	//����
	private String name;
	private int age ;
	//������
	//�����ĸ���������������
	public Man(){
		//�޲ι����ֱ�Ӹ�ֵ
		age = 10;
		name = "����";
	}
	public Man(String name){
		this.name = name;
	}
	public Man(int age){
		this.age = age;
	}
	public Man(String name , int age){
		this.name = name;
		this.age  = age;
	}
	//����
	public void setName(String name){
		this.name = name ;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age ;
	}
	public int getAge(){
		return age;
	}
}
