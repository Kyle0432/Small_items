package Java������;

import org.junit.Test;

/*
 * java.lang.StringBuffer���ɱ���ַ�����
 * java.lang.StringBuilder:�ɱ���ַ����У���jdk5.0�¼���ģ��̲߳���ȫ��Ч��Ҫ����StringBuffer.
 */
/*
 * �Ա�String��StringBuffer,StringBuilder����������ϵ�Ч�ʣ�
 * Ч�ʴӸߵ��ף� StringBuilde > StringBuffer > String
 */
public class TestStringBuffer {
	/*
	 * java.lang.StringBuffer��StringBuilder:����ɱ���ַ����У����Զ��ַ������ݽ�����ɾ
	 * 
	 *  StringBuffer append(String s),   StringBuffer append(int n) ,  
	 StringBuffer append(Object o) ,  StringBuffer append(char n),
	 StringBuffer append(long n),  StringBuffer append(boolean n),
	 StringBuffer insert(int index, String str) 
	 public StringBuffer reverse() :��ת��StringBuffer
	 StringBuffer delete(int startIndex, int endIndex) 
	 public char charAt(int n )
	 public void setCharAt(int n ,char ch)
	 StringBuffer replace( int startIndex ,int endIndex, String str) 
	 public int indexOf(String str)
	 public String substring(int start,int end)
	 public int length()

	 �ܽ᣺��ӣ�append() ɾ����delete(int i,int j) �޸ģ�setCharAt(int index,char ch) �� charAt(int n);
	 ���룺insert(int index,String str)  ��ת��reverse() ���ȣ�length()
	 */
   @Test
   public void test1(){
	   StringBuffer sb = new StringBuffer();
	   System.out.println(sb.length());//����
	   sb.append("abc").append("123").append(true);//׷��
	   System.out.println(sb);
	   sb.delete(2, 3);//ָ��ɾ���ķ�Χ
	   System.out.println(sb);
	   sb.insert(3, "hello");//ָ��������������
	   System.err.println(sb);
	   StringBuffer sb1 = sb.reverse();//��ת
	   System.out.println(sb1);
   }
}
