package A初级面向对象1;
//利用面向对象的编程方法，设计类Circle计算圆的面积。
public class TestCircle {
    public static void main(String[] args) {
		 Circle c = new Circle();
		 c.radius = 2;
		 c.findArea();
		 System.out.println(c.findArea());
		 System.out.println("------------");
		 c.setRadius(5);
		 System.out.println(c.findArea());
	}
}
 class Circle{
	  double radius = 1.0;//半径
	  //提供方法，用于获取圆的面积
	  /* 方法一:public void findArea(){
		  //此处的radius为调用findArea()方法调用的对象的属性radius
		  System.out.println(3.14*radius*radius);
	  }*/
	  //方法二:
	  public double findArea(){
		  return 3.14*radius*radius;
	  }
	  //返回圆的半径
	  public double getRadius(){
		  return radius;
	  }
	  //设置圆的半径
	  public void setRadius(double r){
		  radius = r;
	  }
 }
