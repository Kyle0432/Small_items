package A�����������2;

public class TestCar {
     public static void main(String[] args) {
		Car c1 = new Car();
		c1.info();
		System.out.println("----------------");
		c1.setName("��ɯ����");
		c1.setWheel(4);
		c1.info();
		System.out.println("---------------");
		c1.setName("��˹��˹");
		c1.setWheel(6);
		c1.info();
		System.out.println("------------------");
		Factory f = new Factory();
		   Car c2 = f.produceCar();//��Ϊ���ص�Car�Ķ���,����Ҫ��Car���ͽ���
		   f.describleCar(c2);//��ʱ��c2����ָ��Ŀռ䶼��Ĭ��ֵ������Ϊ�յ�
		   System.out.println("--------------------");
		   Car c3 = f.produceCar("������", 4);//��ʱc3����ָ��Ŀռ���("������", 4)����ֵ
		   f.describleCar(c3);//��Ϊ���ص�Car�Ķ���,����Ҫ��Car���ͽ���
		   
	}
}
class Factory{
	//���쳵(����������������)
	/*Car���͵����Է���Ҫ�����Ķ���.
	һ���ǹ�����ϵ�����������������,
	����Ҫ��ʵ��������������Ϊ���Ҫ���ظö���*/
	public Car produceCar(){
		Car c4 = new Car();
		return c4;
	}
	public Car produceCar(String n,int w){
		Car c = new Car();
		c.setName(n);
		c.setWheel(w);
		return c;
	}
	//����������Ϣ
	public void describleCar(Car c){
		c.info();//��ʱinfo���ֵ�仯��ʵ�δ����Ķ����Ƿ�ָ����ֵ�Ŀռ�
	}
}
class Car{
	//����
	private String name ;
	private int wheel;
	//����
	public void info(){
		this.show();
		System.out.println("name: "+name+"wheel: "+wheel);
	}
	public void show(){
		System.out.println("����һ����");
	}
	public String getNmae(){
		return name;
	}
	public void setName(String name){
		this.name = name ;
	}
	public void setWheel(int wheel){
		this.wheel = wheel;
	}
	public int getWheel(){
		return wheel;
	}
}