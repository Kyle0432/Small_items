package J���߳�;
/*
 * ����һ�����̣߳����1-100֮����Ȼ���������ͬ���أ����߳�ִ��ͬ���Ĳ���
 * �������̵߳ĵ�һ�ַ�ʽ���̳�java.lang.Thread��
 */
public class TestThread1 {
    public static void main(String[] args) {
		//3,��������Ķ���
    	SubThread st1 = new SubThread();
    	SubThread st2 = new SubThread();
    	//4,�����̵߳�start(); �������߳�:������Ӧ��run()����
    	//һ���߳�ֻ�ܹ� ִ��һ�� start()
    	//����ͨ��Threadʵ��������run()ȥ����һ���߳�
    	st1.start();
    	//st1.start();
    	st2.start();
    	for(int i = 1;i <= 100;i++){
			System.out.println(Thread.currentThread().getName() +":" + i);
		}
	}
}
//1,����һ���̳���Thread������
class SubThread extends Thread{
//2,��дThread���run()����,������ʵ�ִ����߳�Ҫ��ɵĹ���
	public void run(){
		for(int i = 1; i <= 100; i++){
			System.out.println(Thread.currentThread().getName()+":"+i);			
		}
	}
}