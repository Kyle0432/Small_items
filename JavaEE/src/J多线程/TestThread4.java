package J多线程;
/*
 * 创建多线程的方式二：通过实现的方式
 * 
 * 对比一下继承的方式 vs 实现的方式
 * 1.联系：public class Thread implements Runnable
 * 2.哪个方式好？实现的方式优于继承的方式
 *    why?  ① 避免了java单继承的局限性
 *    		② 如果多个线程要操作同一份资源(或数据)，更适合使用实现的方式
 */
//1,创建一个实现Runnable接口的类
class PrintNum1 implements Runnable{
//2,实现接口的抽象方法
	public void run(){
		//子线程执行的代码
		//for循环是调用一次全部打印出100次,所以会各自出现100次
		for(int i = 1; i <= 100; i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
}
public class TestThread4 {
   public static void main(String[] args) {
//3,创建一个Runnable接口实现类的对象
	   PrintNum1 p1 = new PrintNum1();
//		p.start(); 是错误的
//		p.run();   是错误的   
// 想要启动一个多线程,必须要调用start(),只有Thread里面有此方法,所以一定会与Thread有联系;	 
//4,将此对象作为形参传递
	   Thread t1 = new Thread(p1);
//5,调用start()方法:启动线程并执行run()
	   t1.start();//启动线程,执行Thread对象生成时构造器形参的对象的run()方法,其实相当于w执行run方法;
//再创建一个线程
	   Thread t2 = new Thread(p1);
	   t2.start();	   
}
}
