package J多线程;
//创建多线程的方式一：继承于Thread类
class PrintNum extends Thread{
	public void run(){
		for(int i = 1; i <= 100; i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName()+":"+ i);
			}
		}
	}
	public PrintNum(String name){
		super(name);//调用父类Thread的构造器
	}
}
public class TestThread2 {
    public static void main(String[] args) {
    	PrintNum p1 = new PrintNum("线程1");
    	PrintNum p2 = new PrintNum("线程2");
    	p1.setPriority(Thread.MAX_PRIORITY);
    	p2.setPriority(Thread.MIN_PRIORITY);
    	p1.start();
    	p2.start();
	}
   
}
