package A初级面向对象2;

public class TestCar {
     public static void main(String[] args) {
		Car c1 = new Car();
		c1.info();
		System.out.println("----------------");
		c1.setName("玛莎拉蒂");
		c1.setWheel(4);
		c1.info();
		System.out.println("---------------");
		c1.setName("劳斯莱斯");
		c1.setWheel(6);
		c1.info();
		System.out.println("------------------");
		Factory f = new Factory();
		   Car c2 = f.produceCar();//因为返回的Car的对象,所以要用Car类型接收
		   f.describleCar(c2);//此时的c2对象指向的空间都是默认值，都是为空的
		   System.out.println("--------------------");
		   Car c3 = f.produceCar("法拉利", 4);//此时c3对象指向的空间有("法拉利", 4)两个值
		   f.describleCar(c3);//因为返回的Car的对象,所以要用Car类型接收
		   
	}
}
class Factory{
	//制造车(两个方法构成重载)
	/*Car类型的所以返回要是它的对象.
	一般是关联关系比如是其他类的类型,
	首先要先实例化创建对象，因为最后要返回该对象*/
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
	//描述车的信息
	public void describleCar(Car c){
		c.info();//此时info里的值变化看实参传来的对象是否指向有值的空间
	}
}
class Car{
	//属性
	private String name ;
	private int wheel;
	//方法
	public void info(){
		this.show();
		System.out.println("name: "+name+"wheel: "+wheel);
	}
	public void show(){
		System.out.println("我是一辆车");
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