package J���߳�;
//ģ���վ��Ʊ���ڣ���������������Ʊ����Ʊ��Ϊ100��
//�����̵߳İ�ȫ����
public class TestWindow1 {
   public static void main(String[] args) {
	Window w1 = new Window();
	Window w2 = new Window();
	Window w3 = new Window();
	
	w1.setName("����1:");
	w2.setName("����2:");
	w3.setName("����3:");
	
	w1.start();
	w2.start();
	w3.start();
}  //��ʱ���Ľ����ÿ�����ڶ�����100��Ʊ
   //ԭ����ÿ�����󶼻��������һ��,�����ǹ���100��
}
class Window extends Thread{
	//���þ�̬ ��ʾΪ����һ������.w1,w2,w3��ָ��ticket
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