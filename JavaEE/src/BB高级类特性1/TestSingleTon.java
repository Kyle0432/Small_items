package BB�߼�������1;
/*
 * ���ģʽ�����ģʽ���ڴ�����ʵ�����ܽ�����ۻ�֮����ѡ�Ĵ���ṹ����̷���Լ���������˼����ʽ��
 * 23�����ģʽ��
 * 
 * ���������ģʽ��
 * 1.��������⣺ʹ��һ����ֻ�ܹ�����һ������
 * 2.���ʵ�֣������µ�4��
 */
public class TestSingleTon {
     public static void main(String[] args) {
    	   SingleTon s1 = SingleTon.getInstance();
           SingleTon s2 = SingleTon.getInstance();
           System.out.println(s1 == s2);//��ӡ�Ķ����ַ��ͬ   ���Դ�������ͬһ������
	}
}
//ֻ�ܴ���Singleton�ĵ���ʵ��
class SingleTon{
	//1,˽�л�������,ʹ��������ⲿ���ܹ����ô˹�����
	private SingleTon(){
		
	}
	//2,������ڲ�����һ�����ʵ��
	private static SingleTon instance = new SingleTon();
	//3,˽�л��˶���,ͨ�������ķ���������
	//4,�˹����ķ���,ֻ��ͨ����������,��Ϊ����Ϊstatic��ͬʱ���ʵ��Ҳ����static������
	public static SingleTon getInstance(){
		return instance;
	}
}