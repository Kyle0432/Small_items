package A�����������1;
/*
 * 1.�������ı�̹�ע��������
 * 2.�����ʵ���Ͼ��������ĳ�Ա
 * 3.��������ĳ�Ա�����ԣ���Ա������Field��  & ������Method��
 */
public class TestPerson2 {
public static void main(String[] args) {
	Person1 p = new Person1();
     p.setName("kyle");
     p.sex = true;
     p.info();
}
}
class Person1{
	//���� 
	String name;
	int age = 10;
	boolean sex ;
	//����
	public void eat(){
		System.out.println("�˳Է�");
	}
	public void sleep(){
		System.out.println("��˯��");
	}
	//�ɸ�name��ֵ
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void info(){
		this.eat();//Ҳ��ʡ��this.  ֱ��eat()��
		this.sleep();
		System.out.println("name:"+name+"age"+age+"sex"+sex);
	}
}
