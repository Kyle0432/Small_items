package B高级类特性1;
//多态使用的一个例子
public class TestAnimal {
	public static void main(String[] args) {
		TestAnimal t = new TestAnimal();
		t.func(new Anim());//也可以通过实例化然后产生的对象放入括号里
		t.func(new Dog1());	
		t.func(new Cat());	
	}
	public void func(Anim a){//可以显示多态的作用  ,可不用创建多个方法，可用一个调用多个方法
		a.eat();
		a.jump();
		//向下转型的判断,如果a是Dog1类的对象
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
		System.out.println("进食");
	}
	public void jump(){
		System.out.println("跳");
	}
}
class Dog1 extends Anim{
	//以下前两个方法是进行覆写过的,最后一个是该方法独有的
	public void eat(){
		System.out.println("狗吃食");
	}
	public void jump(){
		System.out.println("狗急跳墙");
	}
	public void Wang(){
		System.out.println("汪汪叫");
	}
}

class Cat extends Anim{
	//以下前两个方法是进行覆写过的,最后一个是该方法独有的
	public void eat(){
		System.out.println("猫吃鱼");
	}
	public void jump(){
		System.out.println("猫跳");
	}
	public void catchMouse(){
		System.out.println("猫抓老鼠");
	}
}