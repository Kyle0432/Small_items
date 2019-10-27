package BB�߼�������1;
//����ʽ:���ܴ����̰߳�ȫ�����
public class TestSingleTon1 {
    public static void main(String[] args) {
    	SingleTon1 s1 = SingleTon1.getInstance();
    	SingleTon1 s2 = SingleTon1.getInstance();
    	System.out.println(s1 == s2);
	}
}
class SingleTon1{
	//˽�л�������
	private SingleTon1(){
		
	}
	//�����ʵ��
	private static SingleTon1 instance = null;
	//˽�л�����
	//ͨ�������ķ�����ȡ����
	public static SingleTon1 getInstance(){
		if(instance == null){
			instance = new SingleTon1();
		}
		return instance;
	}
}