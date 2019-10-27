package J���߳�2;
//��������ʽ���̰߳�ȫ���⣺ʹ��ͬ������
//����һ��ķ����ڣ�ʹ��ͬ������飬���Կ���ʹ��this��
//���ھ�̬�������ԣ�ʹ�õ�ǰ�౾��䵱����
public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
}
class Singleton{
	private Singleton(){
		
	}
	private static Singleton instance = null;
	//��̬static�����޷�ʹ��this,������Singleton.class��ʾ�������
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
			instance = new Singleton();
			}
		}
		return instance;
	}
}