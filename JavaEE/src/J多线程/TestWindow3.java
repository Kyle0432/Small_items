package J���߳�;
//ʹ��ʵ��Runnable�ӿڵķ�ʽ����Ʊ
/*
* �˳�������̵߳İ�ȫ���⣺��ӡ��Ʊʱ���������Ʊ����Ʊ
* 1.�̰߳�ȫ������ڵ�ԭ��
*   ����һ���߳��ڲ����������ݹ����У�δִ����ϵ�����£�������̲߳�����������¹������ݴ����˰�ȫ���⡣
*   
* 2.���������̵߳İ�ȫ���⣿
* 	 ������һ���̲߳���������������Ժ������̲߳��л�����빲�����ݵĲ�����
* 
* 3.java���ʵ���̵߳İ�ȫ���̵߳�ͬ������
* 		
* 		��ʽһ��ͬ�������
* 		synchronized(ͬ��������){
* 			//��Ҫ��ͬ���Ĵ���飨��Ϊ�����������ݵĴ��룩
* 		}
* 		1.�������ݣ�����̹߳�ͬ������ͬһ������(����)
* 		2.ͬ��������������һ����Ķ������䵱���ĸ��̻߳�ȡ�˼�������˭��ִ�д������ﱻͬ���Ĵ��롣�׳ƣ���
* 		Ҫ�����е��̱߳��빲��ͬһ������
* 		ע����ʵ�ֵķ�ʽ�У�����ͬ���Ļ�������ʹ��this���䵱���������ڼ̳еķ�ʽ�У�����this!
* 
* 		��ʽ����ͬ������
* 		
* 
*/
class Window3 implements Runnable{
	int ticket = 100;//��������
//	Object obj = new Object();  ��ʱthisҲ�ɸ�Ϊobj
	public void run(){
//		Animal a = new Animal();//�ֲ�����,��ʱ��a������а�ȫ����,��Ϊt1,t2,t3���󶼻����run()
		while(true){
			synchronized(this){//this��ʾ��ǰ���󣬱����м�Ϊw
			if(ticket > 0){
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":"+ ticket--);
			}else{
				break;
			 }
		   }
		}
	}
}
public class TestWindow3 {
  public static void main(String[] args) {
	   Window3 w = new Window3();
	   Thread t1 = new Thread(w);
	   Thread t2 = new Thread(w);
	   Thread t3 = new Thread(w);
	   
	   t1.setName("����1:");
	   t2.setName("����2:");
	   t3.setName("����3:");
	   
	   t1.start();
	   t2.start();
	   t3.start();
}
}
class Animal{
	
}