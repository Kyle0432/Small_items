package J多线程2;
/*
 * 银行有一个账户。
有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
1.是否涉及到多线程？是！有两个储户(两种方式创建多线程)
2.是否有共享数据？有！同一个账户
3.得考虑线程的同步。（两种方法处理线程的安全）
//拓展：实现二者交替打印。使用线程的通信
 */
public class TestAccount {
    public static void main(String[] args) {
    	Account acct = new Account();
    	Customer customer1 = new Customer(acct);
    	Customer customer2 = new Customer(acct);
		Thread t1 = new Thread(customer1);
		Thread t2 = new Thread(customer2);
		t1.setName("甲");
		t2.setName("乙");	
		t1.start();
		t2.start();
	}
}
class Account{
	private int balance;
	public Account(){
		
	}
	//存钱到同一个账户是个共享数据
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
//两个储户相当于线程
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