package A�����������2;
/*
 * ��������,�����ж��������ࣺPerson��TestPerson�ࡣ�������£�
    ��setAge()�����˵ĺϷ�����(0~130)����getAge()�����˵����䡣
    ��TestPerson����ʵ����Person��Ķ���b������setAge()��getAge()���������Java�ķ�װ�ԡ�

 */
public class TestPerson {
   public static void main(String[] args) {
	  Person p = new Person("kyle",20);
	  p.setAge(99);
	  System.out.println(p.getName()+"��"+p.getAge());
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
			System.out.println("���������������");
		 }
	 }
	 public void setNmae(String name){
		 this.name = name;
	 }
	 public String getName(){
		 return name;
	 }
	 //������
	 public Person(String name, int age){
		 this.name = name;
		 this.age = age;
	 }
}