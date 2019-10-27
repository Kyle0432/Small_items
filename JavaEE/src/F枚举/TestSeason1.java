package F枚举;

public class TestSeason1 {
   public static void main(String[] args) {
	   Season1 spring = Season1.SPRING;//因为是有static修饰 
	   System.out.println(spring);//重写了toString方法
	   spring.show();
	   System.out.println(spring.getSeasonDesc());
	   
	   //枚举的应用方法
	   //1，values() 表示获取里面的所有值，并且有数组来接收
	   Season1[] seasons = Season1.values();
	   for(int i = 0;i < seasons.length;i++){
			System.out.println(seasons[i]);
		}
	   //2，valueOf(String name):要传入的形参name是枚举类对象的名字
	   //否则，报java.lang.IllegalArgumentException异常
	   //效果是相当于又复制了一份SPRING的内容
	   String str = "SPRING";
	   Season1 sea = Season1.valueOf(str);
	   System.out.println(sea);
}
}
//枚举类 
enum Season1{
	//上面main方法照样调用
	SPRING ("spring","春暖花开"),
	FSUMMER ("summer","夏日炎炎"),
	FALL ("fall","秋高气爽"),
	WINTER ("winter","白雪皑皑");

	private final String seasonName;
	private final String seasonDesc;

	private Season1(String seasonName,String seasonDesc){
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	public void show(){
		System.out.println("这是一个季节");
	}
}