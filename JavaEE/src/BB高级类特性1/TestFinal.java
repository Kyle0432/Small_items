package BB�߼�������1;
/*
 * final:���յ� ���������������ࡢ���ԡ�����
 * 
 * 1.final�����ࣺ�����Ͳ��ܱ��̳С��磺String�ࡢStringBuffer�ࡢSystem��
 * 
 * 2.final���η��������ܱ���д���磺Object���getClass()
 * 
 * 3.final�������ԣ������Ծ���һ��������һ����ʼ���󣬲����ٱ���ֵ��ϰ���ϣ������ô�д�ַ���ʾ��
 * �˳��������︳ֵ���ٴ˳�������ʹ��Ĭ�ϳ�ʼ�� �ڿ�����ʽ�ĸ�ֵ������顢��������
 * 
 * ������static final���Σ�ȫ�ֳ���
 * 
 * >��finally finalize()���ֿ�
 * 
 */
public class TestFinal {
    public static void main(String[] args) {
		 C c = new C();
		 System.out.println(c.getClass());
		 System.out.println(Math.PI);
	}
}
/*
 * final�����Է���
 */
class D{
	final int I = 12;
    final double PI ;
    final String NAME ;
    public void m1(){
    	System.out.println();
    	// I = 10; I�ǳ����޷���ֵ��
    }
    {//���PI֮ǰ��Ĭ�ϻᱨ�� ,�����ڳ�ʼ���������Ӧ�ĸ�ֵ
    	 PI = 3.14;
    }//���NAME֮ǰ��Ĭ�ϻᱨ�� ,�����ڳ�ʼ���������Ӧ�ĸ�ֵ
    public D(){
    	NAME = "Kyle";
    }
    public D(String name){
    	this();
    }
}
/*
 * final���෽��
 */
final class A{
	
}
// class B extends A{
//�޷��̳�A,��Ϊ class Aǰ ��final 
//}
/*
 * final�ڷ�������
 */
class C{
	public final void method1(){
		System.out.println("method1");
	}
}
class E extends C{
//	public void method1(){
//	System.out.println("method1...");
//}����final�������޷���д��
}
