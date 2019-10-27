package J多线程;
/*
 * Thread的常用方法：
 * 1.start()：启动线程并执行相应的run()方法
 * 2.run():子线程要执行的代码放入run()方法中
 * 3.currentThread()：静态的，调取当前的线程
 * 4.getName():获取此线程的名字
 * 5.setName():设置此线程的名字
 * 6.yield():调用此方法的线程释放当前CPU的执行权
 * 7.join():在A线程中调用B线程的join()方法，表示：当执行到此方法，A线程停止执行，直至B线程执行完毕，
 * A线程再接着join()之后的代码执行
 * 8.isAlive():判断当前线程是否还存活
 * 9.sleep(long l):显式的让当前线程睡眠l毫秒
 * 10.线程通信：wait()   notify()  notifyAll()
 * 
 * 设置线程的优先级
 * getPriority() ：返回线程优先值 
   setPriority(int newPriority) ：改变线程的优先级

 */
public class TestThread3 {
    public static void main(String[] args) {
		SubThread1 st1 = new SubThread1();
		//设置子线程的名字
		st1.setName("子线程");
		//设置子线程优先级
		st1.setPriority(Thread.MAX_PRIORITY);
		//子线程进行休眠1s
		try {
			st1.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//启动线程
		st1.start();
		//主线程设置名字
		Thread.currentThread().setName("=======主线程");
		for(int i = 0; i <= 100; i++){			
//			try {
//				//主线程进行休眠
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			//调用当前主线程并获取名字
			System.out.println(Thread.currentThread().getName()+":"+i);	
			if(i == 20){
				try {
					st1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class SubThread1 extends Thread{
	public void run(){
		for(int i = 1; i <= 100; i++){		
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}