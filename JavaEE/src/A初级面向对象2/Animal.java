package A�����������2;

public class Animal {
	public static void main(String[] args) {
		Animals as = new Animals();
		as.setLegs(4);
		as.setNmae("С��");
		as.eat();
		as.info();
		System.out.println("--------------");
		as.setLegs(-1);
		as.setNmae("С��");
		as.eat();
		as.info();
	}
}
class Animals{
	//private ���ε����ԣ�ֻ���ڱ����б����ã����˴��࣬�Ͳ��ܱ�������
		private String name;
		private int legs;
		private String color;
		public double weight;
		//û��public��ʵ�ͱ�ʾȱʡ  (default) ֻȨ�����÷�Χ�ڱ�����
		void eat(){
			System.out.println("�����ʳ");
		}
		void sleep(){
			System.out.println("����˯��");
		}
		public void info(){
			System.out.println("name: "+name+"legs: "+legs);
		}
		public void setLegs(int l){
			if(l > 0 && l % 2 == 0){
				legs = l;
			}else{
				System.out.println("���������Ϣ����");
			}
		}
		public int getLegs(){
			return legs;
		}
		public String getName(){
			return name;
		}
		public void setNmae(String name){
			this.name = name;
		}
}