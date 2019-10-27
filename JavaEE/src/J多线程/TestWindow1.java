package J多线程;
//模拟火车站售票窗口，开启三个窗口售票，总票数为100张
//存在线程的安全问题
public class TestWindow1 {
   public static void main(String[] args) {
	Window w1 = new Window();
	Window w2 = new Window();
	Window w3 = new Window();
	
	w1.setName("窗口1:");
	w2.setName("窗口2:");
	w3.setName("窗口3:");
	
	w1.start();
	w2.start();
	w3.start();
}  //此时最后的结果是每个窗口都会有100张票
   //原因是每个对象都会独立调用一次,而不是共享100张
}
class Window extends Thread{
	//设置静态 表示为共享一个数据.w1,w2,w3都指向ticket
	static int ticket = 100;
	public void run(){
		while(true){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(ticket > 0){
				System.out.println(Thread.currentThread().getName()+":"+ ticket--);
			}else{
				break;
			}
		}
	}
}