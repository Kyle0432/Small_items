package A初级面向对象3;

public class TestBoyAndGirl {
	//类外可以实例化   但是实例化的对象无法再方法外调用 ，必须在方法里面调用
    public static void main(String[] args) {
    	Boy boy = new Boy();
    	boy.setName("kyle");
    	boy.setAge(19);
    	Girl girl = new Girl();
    	girl.setName("Barbed");
    	
    	boy.marry(girl);
    	boy.shout();
    	System.out.println();
    	girl.marry(boy);
	}     
}
class Boy{
	private String name;
	private int age;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void marry(Girl girl){
		System.out.println("我要娶: "+girl.getName());
	}
	public void marry(Boy boy){
	   System.out.println("我要嫁给: "+boy.getName());
	}
	public void shout(){
		if(this.age >= 22){
			System.out.println("我们到了结婚的年龄了");
		}else{
			System.out.println("我们还是谈谈恋爱吧！");
		}
	}
}
class Girl{
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public void marry(Boy boy){
		System.out.println("我要嫁给: "+boy.getName() );
		boy.marry(this);/*括号了面的this:表示谁调用这个方法谁就是this,
		                                                  显然在主方法里是girl对象调用该方法,
		                                                     所以这里的this就相当于girl对象*/
	}
}
