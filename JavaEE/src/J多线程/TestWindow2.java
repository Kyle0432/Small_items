package J多线程;
//使用实现Runnable接口的方式，售票
/*
* 此程序存在线程的安全问题：打印车票时，会出现重票、错票
*/

public class TestWindow2 {
   public static void main(String[] args) {
	Window1 w = new Window1();
	Thread t1 = new Thread(w);
	Thread t2 = new Thread(w);
	Thread t3 = new Thread(w);
	
	t1.setName("窗口1:");
	t2.setName("窗口2:");
	t3.setName("窗口3:");
	
	t1.start();
	t2.start();
	t3.start();
}//此时就一个对象共享100张票
}
class Window1 implements Runnable{
	int ticket = 100;
	public void run(){//此时是调用run方法一次ticket就从100减1,for循环是调用一次全部打印出100次,所以会各自出现100次
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