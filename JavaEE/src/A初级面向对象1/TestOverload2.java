package A�����������1;
/*
 * ���������أ�overload��
 * Ҫ��1.ͬһ������ 2.������������ͬ 3.�����Ĳ����б�ͬ���ٲ����ĸ�����ͬ�ڲ������Ͳ�ͬ��
 * ���䣺�����������뷽���ķ���ֵ����û�й�ϵ��
 */
public class TestOverload2 {

}
class OverLoad{
	//��������int�ͱ����ĺ�
	public int getSum(int i ,int j){
		return i+ j;
	}
	//��������int�ͱ����ĺ�
	public int getSum(int i,int j,int k){
		return i + j + k;
	}
	//��������double�����ݵĺ�
	public double getSum(double d1,double d2){
		return d1 + d2;
	}
	//��������double������ĺ�
	public void getSum(double d1, double d2, double d3){
		System.out.println(d1+d2+d3);
	}
	//���µ�����������������
	public void method1(int i,String str){
		
	}
	public void method1(String str1,int j){
		
	}
}