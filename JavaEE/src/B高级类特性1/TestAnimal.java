package B�߼�������1;
//��̬ʹ�õ�һ������
public class TestAnimal {
	public static void main(String[] args) {
		TestAnimal t = new TestAnimal();
		t.func(new Anim());//Ҳ����ͨ��ʵ����Ȼ������Ķ������������
		t.func(new Dog1());	
		t.func(new Cat());	
	}
	public void func(Anim a){//������ʾ��̬������  ,�ɲ��ô����������������һ�����ö������
		a.eat();
		a.jump();
		//����ת�͵��ж�,���a��Dog1��Ķ���
		if(a instanceof Dog1){
			Dog1 d = (Dog1)a;
			d.Wang();
		}
		if(a instanceof Cat){
			Cat c = (Cat)a;
			c.catchMouse();
		}
	}
//	public void func(Dog a){
//		a.eat();
//		a.jump();
//	}
}
class Anim{
	String name;
	int age;
	public void eat(){
		System.out.println("��ʳ");
	}
	public void jump(){
		System.out.println("��");
	}
}
class Dog1 extends Anim{
	//����ǰ���������ǽ��и�д����,���һ���Ǹ÷������е�
	public void eat(){
		System.out.println("����ʳ");
	}
	public void jump(){
		System.out.println("������ǽ");
	}
	public void Wang(){
		System.out.println("������");
	}
}

class Cat extends Anim{
	//����ǰ���������ǽ��и�д����,���һ���Ǹ÷������е�
	public void eat(){
		System.out.println("è����");
	}
	public void jump(){
		System.out.println("è��");
	}
	public void catchMouse(){
		System.out.println("èץ����");
	}
}