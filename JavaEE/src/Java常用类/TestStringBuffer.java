package Java常用类;

import org.junit.Test;

/*
 * java.lang.StringBuffer：可变的字符序列
 * java.lang.StringBuilder:可变的字符序列，是jdk5.0新加入的，线程不安全，效率要高于StringBuffer.
 */
/*
 * 对比String，StringBuffer,StringBuilder三者在添加上的效率：
 * 效率从高到底： StringBuilde > StringBuffer > String
 */
public class TestStringBuffer {
	/*
	 * java.lang.StringBuffer和StringBuilder:代表可变的字符序列，可以对字符串内容进行增删
	 * 
	 *  StringBuffer append(String s),   StringBuffer append(int n) ,  
	 StringBuffer append(Object o) ,  StringBuffer append(char n),
	 StringBuffer append(long n),  StringBuffer append(boolean n),
	 StringBuffer insert(int index, String str) 
	 public StringBuffer reverse() :反转此StringBuffer
	 StringBuffer delete(int startIndex, int endIndex) 
	 public char charAt(int n )
	 public void setCharAt(int n ,char ch)
	 StringBuffer replace( int startIndex ,int endIndex, String str) 
	 public int indexOf(String str)
	 public String substring(int start,int end)
	 public int length()

	 总结：添加：append() 删除：delete(int i,int j) 修改：setCharAt(int index,char ch) 查 charAt(int n);
	 插入：insert(int index,String str)  反转：reverse() 长度：length()
	 */
   @Test
   public void test1(){
	   StringBuffer sb = new StringBuffer();
	   System.out.println(sb.length());//长度
	   sb.append("abc").append("123").append(true);//追加
	   System.out.println(sb);
	   sb.delete(2, 3);//指定删除的范围
	   System.out.println(sb);
	   sb.insert(3, "hello");//指定索引插入内容
	   System.err.println(sb);
	   StringBuffer sb1 = sb.reverse();//反转
	   System.out.println(sb1);
   }
}
