package J���߳�;
/*
 * �������̵߳ķ�ʽ����ͨ��ʵ�ֵķ�ʽ
 * 
 * �Ա�һ�¼̳еķ�ʽ vs ʵ�ֵķ�ʽ
 * 1.��ϵ��public class Thread implements Runnable
 * 2.�ĸ���ʽ�ã�ʵ�ֵķ�ʽ���ڼ̳еķ�ʽ
 *    why?  �� ������java���̳еľ�����
 *    		�� �������߳�Ҫ����ͬһ����Դ(������)�����ʺ�ʹ��ʵ�ֵķ�ʽ
 */
//1,����һ��ʵ��Runnable�ӿڵ���
class PrintNum1 implements Runnable{
//2,ʵ�ֽӿڵĳ��󷽷�
	public void run(){
		//���߳�ִ�еĴ���
		//forѭ���ǵ���һ��ȫ����ӡ��100��,���Ի���Գ���100��
		for(int i = 1; i <= 100; i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
}
public class TestThread4 {
   public static void main(String[] args) {
//3,����һ��Runnable�ӿ�ʵ����Ķ���
	   PrintNum1 p1 = new PrintNum1();
//		p.start(); �Ǵ����
//		p.run();   �Ǵ����   
// ��Ҫ����һ�����߳�,����Ҫ����start(),ֻ��Thread�����д˷���,����һ������Thread����ϵ;	 
//4,���˶�����Ϊ�βδ���
	   Thread t1 = new Thread(p1);
//5,����start()����:�����̲߳�ִ��run()
	   t1.start();//�����߳�,ִ��Thread��������ʱ�������βεĶ����run()����,��ʵ�൱��wִ��run����;
//�ٴ���һ���߳�
	   Thread t2 = new Thread(p1);
	   t2.start();	   
}
}
