package B�߼�������1;
/*
 * ������������������̬��
 * 1.��̬��ָ����ʲô����̬�ԣ��������Ϊһ������Ķ��ֱ�����̬�� 
 *   1����������������д  2���������Ķ�̬��
 * 
 * 2.�������Ķ�̬��ʹ�õ�ǰ�᣺��Ҫ����ļ̳Т�Ҫ������Ը��෽������д
 * 
 * 3.�������з�Ϊ����״̬������״̬��
 *   ���ڶ�̬����˵������ʱ��"�����"���������ñ������Ϊ���������
 *   ����ʱ��"���ұ�",��ע�����������ʵ�壺����Ķ�����ôִ�еķ�������������д�ġ�
 *   
 * 4.�������Ķ�̬�ԣ�����ʹ�������ԡ�
 */
public class TestPerson {
     public static void main(String[] args) {
    	 P p = new P();
 		p.eat();
 		p.walk();

 		Man m = new Man();
 		m.eat();
 		m.walk();
 		System.out.println();

 		// �������Ķ�̬�ԣ����������ָ���������
 		P p1 = new Man();// ����ת��
 		// ���ⷽ�����ã�ͨ�����������ָ������Ķ���ʵ�壬�����÷���ʱ��ʵ��ִ�е���������д����ķ���
 		p1.eat();
 		p1.walk();
 		System.out.println("$" + p1.id);//1001

// 		p1.smoking = null;
 		// p1.entertainment();

 		P p2 = new Woman();
 		p2.eat();
 		p2.walk();
 		// p2.shopping();
 		Woman w = (Woman) p2;// ����ת��,ʹ��ǿת����()
 		w.shopping();

 		// java.lang.ClassCastException
 		// Woman w1 = (Woman)p1;
 		// w1.shopping();

 		// Woman w2 = (Woman)new Man();
 		// instanceof:
 		// ��ʽ�� ����a instanceof ��A���ж϶���a�Ƿ�����A��һ��ʵ��.�ǵĻ�������true�����򷵻�false
 		// ��a��A���ʵ������ôaҲһ����A��ĸ����ʵ����
 		if (p1 instanceof Woman) {
 			System.out.println("hello!");
 			Woman w1 = (Woman) p1;
 			w1.shopping();
	}
}
}
class P {
	private String name;
	private int age;
	int id = 1001;
	public P() {
		super();
	}
	public P(String name, int age) {
		super();
		this.name = name;
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
	public void walk(){
		System.out.println("����·");
	}
	public void eat(){
		System.out.println("�˳Է�");
	}
}
class Man extends P{
	 boolean smoking;
	 int id = 1002;
	public Man() {
		super();
	}
	public Man(boolean smoking) {
		super();
		this.smoking = smoking;
	}
	public boolean isSmoking() {
		return smoking;
	}
	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}
	public void walk(){
		System.out.println("���˱�ͦ����·");
	}
	public void eat(){
		System.out.println("����Ӧ�ö���⣡");
	}	
	public void entertainment(){
		System.out.println("�������");
	}
}
class Woman extends P{
	private boolean isBeauty;
	public boolean isBeauty() {
		return isBeauty;
	}
	public void setBeauty(boolean isBeauty) {
		this.isBeauty = isBeauty;
	}
	public Woman() {
		super();
	}
	public Woman(boolean isBeauty) {
		super();
		this.isBeauty = isBeauty;
	}
	public void walk(){
		System.out.println("Ů�������·������");
	}
	public void eat(){
		System.out.println("Ů��Ӧ���ٳԣ�����");
	}
	public void shopping(){
		System.out.println("Ů�˰�����");
	}
}