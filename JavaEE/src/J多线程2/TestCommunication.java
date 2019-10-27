package J���߳�2;
//�߳�ͨ�š����µ������ؼ���ʹ�õĻ���������ͬ��������ͬ�������С�
//wait():һ��һ���߳�ִ�е�wait()�����ͷŵ�ǰ������
//notify()/notifyAll():����wait��һ�������е��߳�
//ʹ�������̴߳�ӡ 1-100. �߳�1, �߳�2 �����ӡ
public class TestCommunication {
   public static void main(String[] args) {
	   PrintNum p = new PrintNum();
	   Thread t1 = new Thread(p);
	   Thread t2 = new Thread(p);
	   
	   t1.setName("�߳�A");
	   t2.setName("�߳�B");
	   
	   t1.start();
	   t2.start();
  }
     
}
class PrintNum implements Runnable{
	int num = 1;
	public void run(){
		while(true){
			synchronized (this) {
				notify();
				if (num <= 100) {
					System.out.println(Thread.currentThread().getName() + ":" + num);
				} else {
					break;
				}
				num++;
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
/*	  int num = 100;
	  public void run(){
		  while(true){
			  synchronized (this) {
			      notify();
				if (num > 0) {
					System.out.println(Thread.currentThread().getName() + ":" + num--);
				} else {
					break;
				}
	            try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		  }
	  }*/
}