package J多线程;
//模拟火车站售票窗口，开启三个窗口售票，总票数为100张
//存在线程的安全问题--->使用同步代码块处理。
class Window4 extends Thread{
	static int ticket = 100;
	static Object obj = new Object();
	public void run(){
		while(true){
			// synchronized (this) {//在本问题中，this表示：w1,w2,w3
			synchronized (obj){//此时obj表示共享的
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
public class TestWindow4 {
   public static void main(String[] args) {
	    Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
	    
	    w1.setName("窗口1:");
	    w2.setName("窗口2:");
	    w3.setName("窗口3:");
	    
	    w1.start();
	    w2.start();
	    w3.start();
}    
}
