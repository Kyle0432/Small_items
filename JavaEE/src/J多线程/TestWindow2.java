package J���߳�;
//ʹ��ʵ��Runnable�ӿڵķ�ʽ����Ʊ
/*
* �˳�������̵߳İ�ȫ���⣺��ӡ��Ʊʱ���������Ʊ����Ʊ
*/

public class TestWindow2 {
   public static void main(String[] args) {
	Window1 w = new Window1();
	Thread t1 = new Thread(w);
	Thread t2 = new Thread(w);
	Thread t3 = new Thread(w);
	
	t1.setName("����1:");
	t2.setName("����2:");
	t3.setName("����3:");
	
	t1.start();
	t2.start();
	t3.start();
}//��ʱ��һ��������100��Ʊ
}
class Window1 implements Runnable{
	int ticket = 100;
	public void run(){//��ʱ�ǵ���run����һ��ticket�ʹ�100��1,forѭ���ǵ���һ��ȫ����ӡ��100��,���Ի���Գ���100��
		while(true){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(ticket > 0){
				System.out.println(Thread.currentThread().getName()+""+ticket--);
			}else{
				break;
			}
		}
	}
}