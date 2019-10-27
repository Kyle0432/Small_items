package A初级面向对象2;

public class Animal {
	public static void main(String[] args) {
		Animals as = new Animals();
		as.setLegs(4);
		as.setNmae("小花");
		as.eat();
		as.info();
		System.out.println("--------------");
		as.setLegs(-1);
		as.setNmae("小鬼");
		as.eat();
		as.info();
	}
}
class Animals{
	//private 修饰的属性，只能在本类中被调用，出了此类，就不能被调用了
		private String name;
		private int legs;
		private String color;
		public double weight;
		//没有public其实就表示缺省  (default) 只权限作用范围在本包中
		void eat(){
			System.out.println("动物进食");
		}
		void sleep(){
			System.out.println("动物睡觉");
		}
		public void info(){
			System.out.println("name: "+name+"legs: "+legs);
		}
		public void setLegs(int l){
			if(l > 0 && l % 2 == 0){
				legs = l;
			}else{
				System.out.println("您输入的信息有误");
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