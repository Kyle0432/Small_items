package Fö��;

public class TestSeason {
   public static void main(String[] args) {
	   Season spring = Season.SPRING;//��Ϊ����static���� 
	   System.out.println(spring);//��д��toString����
	   spring.show();
	   System.out.println(spring.getSeasonDesc());
	   
}
}
//ö���� 
class Season{
	//1,�ṩ�������,����Ϊprivate final
	private final String seasonName;
	private final String seasonDesc;
	//2,����Ϊfinal������,�ڹ������г�ʼ��
	private Season(String seasonName,String seasonDesc){
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	//3,ͨ�������ķ�������������
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	//4,����ö����Ķ���:����Ķ������� public static final
	public static final Season SPRING = new Season("spring","��ů����");
	public static final Season FSUMMER = new Season("summer","��������");
	public static final Season FALL = new Season("fall","�����ˬ");
	public static final Season WINTER = new Season("winter","��ѩ����");
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	public void show(){
		System.out.println("����һ������");
	}
}