package J���߳�2;
/*
 * ������һ���˻���
�����������ֱ���ͬһ���˻���3000Ԫ��ÿ�δ�1000����3�Ρ�ÿ�δ����ӡ�˻���
1.�Ƿ��漰�����̣߳��ǣ�����������(���ַ�ʽ�������߳�)
2.�Ƿ��й������ݣ��У�ͬһ���˻�
3.�ÿ����̵߳�ͬ���������ַ��������̵߳İ�ȫ��
//��չ��ʵ�ֶ��߽����ӡ��ʹ���̵߳�ͨ��
 */
public class TestAccount {
    public static void main(String[] args) {
    	Account acct = new Account();
    	Customer customer1 = new Customer(acct);
    	Customer customer2 = new Customer(acct);
		Thread t1 = new Thread(customer1);
		Thread t2 = new Thread(customer2);
		t1.setName("��");
		t2.setName("��");	
		t1.start();
		t2.start();
	}
}
class Account{
	private int balance;
	public Account(){
		
	}
	//��Ǯ��ͬһ���˻��Ǹ���������
	public synchronized void deposit(int amt){
		notify();
		balance += amt;
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+ balance);
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
//���������൱���߳�
class Customer implements Runnable{
	Account account;
	public Customer(Account account){
		this.account = account;
	}
	public void run(){
		for(int i = 1; i <= 3; i++){
			account.deposit(1000);
		}
	}
}