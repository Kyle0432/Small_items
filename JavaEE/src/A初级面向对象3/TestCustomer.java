package A�����������3;
/*
 * ��1��	����һ��Customer �����ֽ� Jane Smith, 
 * ����һ���˺�Ϊ1000�����Ϊ2000Ԫ��������Ϊ 1.23�� ���˻���
 ��2��	��Jane Smith������
 ���� 100 Ԫ����ȡ��960Ԫ����ȡ��2000Ԫ��
 ��ӡ��Jane Smith �Ļ�����Ϣ
 Customer [Smith, Jane] has a account: id is 1000, 
 annualInterestRate is 1.23��, balance is 1140.0
 */
public class TestCustomer {
    public static void main(String[] args) {
		Customer cs = new Customer("Jane","Smith");
		Account ac = new Account(1000, 2000, 0.0123);
		/*cs.setAccount(ac);�м����acһ��Ҫ֮ǰ��ʵ���������Ķ����������������:new Account(1000, 2000, 0.0123)  ���û�������ʵ����,���޷������β�*/
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
	private int id;//�˺�
	private double balance;//���
	private double annualInterestRate;//������
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
	//���
	public void rest(){
		System.out.println("����ǰ���Ϊ: "+balance);
	}
	//ȡǮ
	public void withdraw(double amount){
		if(balance >= amount){
			balance -= amount;
			System.out.println("�ɹ�ȡ��:"+amount);
		}else{
			System.out.println("����ǰ����,ȡ��ʧ��");
		}
	}
	//��Ǯ
	public void deposit(double amount){
		balance += amount;
		System.out.println("�ɹ�����:"+amount);
	}
	//���յĽ��
	public void finalCash(){
		System.out.println("���ս��Ϊ: "+balance );
	}
}
