package A�����������3;
/*
 * һ�������������������̳���
 * 1.ΪʲôҪ��Ƽ̳��ԣ�
 * 
 * 2.ͨ��"class A extends B"��ʵ����ļ̳С�
 *   ���ࣺA  ���ࣨ����� SuperClass����B
 *   
 * 3.����̳и����Ժ󣬸��������������ԡ�����������Ϳ��Ի�ȡ����
 *    ��ȷ������������˽�е����Ի򷽷�ʱ������ͬ�����Ի�ȡ�õ���ֻ�����ڷ�װ�Ե���ƣ�ʹ�����಻����ֱ��
 *        ���ð��ˡ�
 *   �������ͨ���̳У���ȡ����Ľṹ֮�⣬�����Զ����Լ������еĳɷ֡�
 *   
 *   extends�������ǶԸ��๦�ܵġ���չ������ȷ���಻�Ǹ�����Ӽ���
 *   
 * 4.java����ļ̳���ֻ֧�ֵ��̳У�һ����ֻ�ܼ̳�һ�����ࡣ��֮��һ����������ж�����ࡣ
 * 5.�Ӹ�������Եĸ��
 * 
 * ������������д   ---(����������)     ���η�  ����ֵ���� ������ �������б�{}
 * 1.ǰ�᣺������̳и���
 * 2.����̳и����Ժ�������ķ��������಻���ã���ô������ԶԸ���ķ�����д(override overwrite)�����ǡ���д��
 * 3.��д�Ĺ���  1)Ҫ�����෽���ġ�����ֵ���� ������ �������б����븸��ķ���һ��
 * 			  2)���෽�������η�����С�ڸ��෽�������η�
 * 			  3)*�����෽�����쳣����ô���෽���׵��쳣���Ͳ��ܴ��ڸ���ġ�
 * 			  4)*�Ӹ���ķ�������ͬΪstatic��ͬΪ��static�ġ�
 */
public class TestExtends {
   public static void main(String[] args) {
	  Student stu = new Student();
	  stu.eat();
	  System.out.println();
	  Worker wor = new Worker();
	  wor.eat();
	  System.out.println();
	  ren per = new ren();
	  per.eat();
	  System.out.println();
	  stu.setAge(20);
	  stu.setName("kyle");
	  System.out.println(stu.getName() + ":" + stu.getAge());
  }
}
class ren{
	private String name;
	private int age ;
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
		System.out.println("�Է�");
	}
	void walk(){
		System.out.println("��·");
	}
	private void sleep(){
		System.out.println("˯��");
	}
}
class Student extends ren{
	private String SchoolName;
    public Student(){
		
	}
    public Student(String name, int age){
    	this.setName(name);
    	this.setAge(age);
    }
	public String getSchoolName() {
		return SchoolName;
	}
	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
//	�Ը���ͬ���ķ�������д������
	public void eat(){
		System.out.println("Ӧ�ö����Ӫ����");
	}
	public void walk(){
		System.out.println("��������ı���������·");
	}
	public void info(){
		eat();
		System.out.println("����һ��ѧ��");
	}
	//���ǶԸ���˽�е�sleep()��������д��
		private int sleep(){
			return 0;
		}
}
 class Worker extends ren{
	 public void eat(){
			System.out.println("���˳Է�");
		 }	 
     public void walk(){
			System.out.println("������·"); 
		 }
 }