package B�߼�������1;
//�������ʵ������ȫ����
public class TestDog {
	public static void main(String[] args) {
		Dog d = new Dog();//new ����� Dog()�ǹ�����  ��ʾ���øù�����
		d.setAge(10);
		d.setName("����");
		d.setHostName("С��");
		System.out.println("name:" + d.getName() + " age:" + d.getAge()
				+ "hostName:" + d.getHostName());		
		System.out.println(d.toString());//��ӡ����d����ĵ�ַ �� ��toString�Ͳ���һ��
	}
}
// ����
class Creator {
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Creator() {
		super();//���ø���Object
		System.out.println("this is Creator's constructor");
	}
}
// ������
class Animal extends Creator {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Animal() {
		super();//��ʱ���õ��Ǹ����޲ι�����
		System.out.println("this is Animal's constructor");
	}
}
// ��
class Dog extends Animal {
	private String hostName;
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Dog() {
		super();//��ʱ���õ��Ǹ����޲ι�����
		System.out.println("this is Dog's constructor");
	}
}
