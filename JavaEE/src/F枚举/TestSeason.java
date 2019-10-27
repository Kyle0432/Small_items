package F枚举;

public class TestSeason {
   public static void main(String[] args) {
	   Season spring = Season.SPRING;//因为是有static修饰 
	   System.out.println(spring);//重写了toString方法
	   spring.show();
	   System.out.println(spring.getSeasonDesc());
	   
}
}
//枚举类 
class Season{
	//1,提供类的属性,声明为private final
	private final String seasonName;
	private final String seasonDesc;
	//2,声明为final的属性,在构造器中初始化
	private Season(String seasonName,String seasonDesc){
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	//3,通过公共的方法来调用属性
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	//4,创建枚举类的对象:将类的对象声明 public static final
	public static final Season SPRING = new Season("spring","春暖花开");
	public static final Season FSUMMER = new Season("summer","夏日炎炎");
	public static final Season FALL = new Season("fall","秋高气爽");
	public static final Season WINTER = new Season("winter","白雪皑皑");
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	public void show(){
		System.out.println("这是一个季节");
	}
}