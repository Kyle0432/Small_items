package A�����������1;
//�����������ı�̷����������Circle����Բ�������
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
	  double radius = 1.0;//�뾶
	  //�ṩ���������ڻ�ȡԲ�����
	  /* ����һ:public void findArea(){
		  //�˴���radiusΪ����findArea()�������õĶ��������radius
		  System.out.println(3.14*radius*radius);
	  }*/
	  //������:
	  public double findArea(){
		  return 3.14*radius*radius;
	  }
	  //����Բ�İ뾶
	  public double getRadius(){
		  return radius;
	  }
	  //����Բ�İ뾶
	  public void setRadius(double r){
		  radius = r;
	  }
 }
