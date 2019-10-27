package A初级面向对象3;
/*
 * （1）	创建一个Customer ，名字叫 Jane Smith, 
 * 他有一个账号为1000，余额为2000元，年利率为 1.23％ 的账户。
 （2）	对Jane Smith操作。
 存入 100 元，再取出960元。再取出2000元。
 打印出Jane Smith 的基本信息
 Customer [Smith, Jane] has a account: id is 1000, 
 annualInterestRate is 1.23％, balance is 1140.0
 */
public class TestCustomer {
    public static void main(String[] args) {
		Customer cs = new Customer("Jane","Smith");
		Account ac = new Account(1000, 2000, 0.0123);
		/*cs.setAccount(ac);切记如果ac一定要之前被实例化出来的对象或者用匿名对象:new Account(1000, 2000, 0.0123)  如果没有上面的实例化,就无法传入形参*/
	   ac.rest();
	   ac.deposit(1000.9);
	   ac.withdraw(200.5);
	   ac.withdraw(300.5);
       ac.finalCash();
}
}
class Customer{
	private String firstName;
	private String lastName;
	private Account account;
	public Customer (String firstName,String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Account getAccount(){
		return account;
	}
	public void setAccount(Account account){
		this.account = account;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
}
class Account{
	private int id;//账号
	private double balance;//余额
	private double annualInterestRate;//年利率
	public Account(int id, double balance,double annualInterestRate){
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	//余额
	public void rest(){
		System.out.println("您当前余额为: "+balance);
	}
	//取钱
	public void withdraw(double amount){
		if(balance >= amount){
			balance -= amount;
			System.out.println("成功取款:"+amount);
		}else{
			System.out.println("您当前余额不足,取款失败");
		}
	}
	//存钱
	public void deposit(double amount){
		balance += amount;
		System.out.println("成功存入:"+amount);
	}
	//最终的金额
	public void finalCash(){
		System.out.println("最终金额为: "+balance );
	}
}
