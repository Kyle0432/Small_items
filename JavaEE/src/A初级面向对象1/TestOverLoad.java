package A�����������1;
/*
 * ��Ŀһ��
 * ��д���򣬶����������ط��������á�������ΪmOL��
 ���������ֱ����һ��int����������int������һ���ַ����������ֱ�ִ��ƽ�����㲢��������
 ��˲�������������ַ�����Ϣ��
 �������main ()�����зֱ��ò��������������������
��Ŀ����
�����������ط���max()����һ������������intֵ�е����ֵ��
�ڶ�������������doubleֵ�е����ֵ��
����������������doubleֵ�е����ֵ�����ֱ��������������
 */
public class TestOverLoad {
public static void main(String[] args) {
	TestOverLoad tol = new TestOverLoad();
	tol.mOL(2);
	tol.mOL(2, 5);
	tol.mOL("kyle");
	System.out.println("-------------");
	int a = tol.max(5, 3);
	double dou = tol.max(2.3, 5.6);
	double dou2 = tol.max(4.5, 21.9, 88.8);
	System.out.println("���ֵ�ֱ���:"+a+","+dou+","+dou2);
	
}
//��������������������
public void mOL(int i){
	System.out.println(i*i);
}
public void mOL(int i ,int j){
	System.out.println(i*j);
}
public void mOL(String str){
	System.out.println(str);
}
//��������������������
public int max(int i ,int j){
/*	����һ: int result = 0;
	if(i > j){
		result = i;
	}else if(i < j){
		result = j;
	}
	return result;*/
	//������:
	return (i > j)? i:j;
}
public double max(double d1,double d2){
	return (d1>d2)? d1:d2;
}
public double max(double d1,double d2,double d3){
	//���ж����Ԫ��������
	return (d1>d2?d1:d2)>d3?(d1>d2?d1:d2):d3;
}
}

