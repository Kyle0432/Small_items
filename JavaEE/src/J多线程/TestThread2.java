package J���߳�;
//�������̵߳ķ�ʽһ���̳���Thread��
class PrintNum extends Thread{
	public void run(){
		for(int i = 1; i <= 100; i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName()+":"+ i);
			}
		}
	}
	public PrintNum(String name){
		super(name);//���ø���Thread�Ĺ�����
	}
}
public class TestThread2 {
    public static void main(String[] args) {
    	PrintNum p1 = new PrintNum("�߳�1");
    	PrintNum p2 = new PrintNum("�߳�2");
    	p1.setPriority(Thread.MAX_PRIORITY);
    	p2.setPriority(Thread.MIN_PRIORITY);
    	p1.start();
    	p2.start();
	}
   
}
