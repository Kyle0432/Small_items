package A初级面向对象3;
/*
 * 定义一个ManKind类，包括
成员变量int sex和int salary；
方法void manOrWorman()：根据sex的值显示“man”(sex==1)或者“woman”(sex==0)；
方法void employeed()：根据salary的值显示“no job”(salary==0)或者“ job”(salary!=0)。

 */
public class TestKids {
   public static void main(String[] args) {
	   kids k = new kids();//注意kids类会继承Mnakind所写的构造方法,但是不能赋值,因为是Mankind类私有的
	   k.setSalary(0);
	   k.setSex(1);
	   k.setYearsOld(19);
	   
	   k.employees();
	   k.manOrWoman();
	   k.printAge();
}
}
class Mankind{
	private int sex;
	private int salary;	
	public Mankind() {
		super();
	}
	public Mankind(int sex, int salary) {
		this.sex = sex;
		this.salary = salary;
	}
	public int getSex(){
		return sex;
	}
	public void setSex(int sex){
		this.sex = sex;
	}
	public int getSalary(){
		return salary;
	}
	public void setSalary(int salary){
		this.salary = salary;
	}
	public void manOrWoman(){
		if(sex == 1){
			System.out.println("Man");
		}else if( sex == 0){
			System.out.println("Woman");
		}else{
			System.out.println("输入有误");
		}
	}
	public void employees(){
		if(salary == 0){
			System.out.println(" no job");
		}else if(salary > 0){
			System.out.println("job");
		}
	}
}
class kids extends Mankind{
	private int yearsOld;
	public void setYearsOld(int yearsOld){
		this.yearsOld = yearsOld;
	}
	public int getYearsOld(){
		return yearsOld;
	}
	public void printAge(){
		System.out.println(this.yearsOld +"years old");
	}
}