package C�쳣����;

import java.util.Date;

import org.junit.Test;

/*һ���쳣����ϵ�ṹ
 * java.lang.Throwable
 * 		|-----Error:���󣬳����в����д���
 * 		|-----Exception:�쳣��Ҫ���ڱ�д����ʱ����Ҫ���ǵ�����Щ�쳣�Ĵ���
 * 				|-----����ʱ�쳣���ڱ����ڼ����ֵ��쳣��ִ��javac.exe����ʱ�������쳣�� 
 * 				|-----����ʱ�쳣���������ڼ���ֵ��쳣(ִ��java.exe����ʱ�������쳣)
 * 
 * ��ִ��һ������ʱ����������쳣����ô�쳣֮��Ĵ���Ͳ���ִ�У�
 */
public class TestException {
        //����ʱ�쳣
	@Test
	public void test6(){
		/*FileInputStream fis = new FileInputStream(new File("hello.txt"));
		int b ;
		while ((b = fis.read()) != -1){
			System.out.println((char)b);
		}
		fis.close();*/
	}
	    //����ʱ�쳣
	//4,��ָ���쳣: NullPointerException 
	@Test
	public void test5(){
		/*Person p = new Person();
		p = null;
		System.out.println(p.toString());*/
		
		String str = new String("AA");
		str = null;
		System.out.println(str.length());
	}
	//3,����ת���쳣: ClassCastException 
	@Test
	public void test4(){
		Object obj = new Date();
		String str = (String)obj;
		//String str1 = (String) new Date();
	}
	//2,�����쳣: ArithmeticException
	@Test
	public void test3(){
		int i = 10;
		System.out.println(i/0);
	}
	//1,�����±�Խ����쳣: ArrayIndexOutOfBoundsException
	@Test
	public void test2(){
		int[] i = new int[10];
		System.out.println(i[10]);
		//System.out.println(i[-10]);
	}
}
class Person{
	
}