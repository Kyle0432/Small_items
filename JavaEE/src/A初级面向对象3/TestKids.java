package A�����������3;
/*
 * ����һ��ManKind�࣬����
��Ա����int sex��int salary��
����void manOrWorman()������sex��ֵ��ʾ��man��(sex==1)���ߡ�woman��(sex==0)��
����void employeed()������salary��ֵ��ʾ��no job��(salary==0)���ߡ� job��(salary!=0)��

 */
public class TestKids {
   public static void main(String[] args) {
	   kids k = new kids();//ע��kids���̳�Mnakind��д�Ĺ��췽��,���ǲ��ܸ�ֵ,��Ϊ��Mankind��˽�е�
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
			System.out.println("��������");
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