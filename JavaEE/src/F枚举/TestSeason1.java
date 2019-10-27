package Fö��;

public class TestSeason1 {
   public static void main(String[] args) {
	   Season1 spring = Season1.SPRING;//��Ϊ����static���� 
	   System.out.println(spring);//��д��toString����
	   spring.show();
	   System.out.println(spring.getSeasonDesc());
	   
	   //ö�ٵ�Ӧ�÷���
	   //1��values() ��ʾ��ȡ���������ֵ������������������
	   Season1[] seasons = Season1.values();
	   for(int i = 0;i < seasons.length;i++){
			System.out.println(seasons[i]);
		}
	   //2��valueOf(String name):Ҫ������β�name��ö������������
	   //���򣬱�java.lang.IllegalArgumentException�쳣
	   //Ч�����൱���ָ�����һ��SPRING������
	   String str = "SPRING";
	   Season1 sea = Season1.valueOf(str);
	   System.out.println(sea);
}
}
//ö���� 
enum Season1{
	//����main������������
	SPRING ("spring","��ů����"),
	FSUMMER ("summer","��������"),
	FALL ("fall","�����ˬ"),
	WINTER ("winter","��ѩ����");

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
		System.out.println("����һ������");
	}
}