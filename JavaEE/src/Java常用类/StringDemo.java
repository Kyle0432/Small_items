package Java常用类;

public class StringDemo {
    public static void main(String[] args) {
    	String str = "   abc  de  ";
		//str = "    ";
		String str1 = myTrim(str);
		System.out.println(str1);
		
		String str2 = "abcdefg";
		String str3 = reverseString(str2,2,5);
		String str4 = reverseString(str2,2,5);
		System.out.println(str3);//abfedcg
		System.out.println(str4);
		
		int i = getTime("abkkcadkabkebfkabkskab","abk");
		System.out.println(i);
		
	}
	//3.获取一个字符串在另一个字符串中出现的次数。判断str2在str1中出现的次数
    public static int getTime(String str1,String str2){
    	int count = 0;
    	int len;
    	while((len = str1.indexOf(str2)) != -1){
    		count++;
    		//表示出现一次要减去这一段字符串
    		str1 = str1.substring(len+str2.length());
    	}
    	return count;
    }
  //2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
    public static String reverseString(String str,int start,int end){
    	char[] c = str.toCharArray();//字符串 -->字符数组
    	return reverseArray(c,start,end);
    }
    public static String reverseArray(char[] c,int start,int end){
    	for(int i = start, j = end ; i < j;i++,j--){
    		char temp = c[i];
    		c[i] = c[j];
    		c[j] = temp;
    	}
    	//字符数组--->字符串
    	return new String(c);
    }
  //1.模拟一个trim方法，去除字符串两端的空格。
    public static String myTrim(String str){
    	int start = 0; 
    	int end = str.length()-1;
    	while(start < end && str.charAt(start) == ' '){
    		start++;
    	}
    	while(start < end && str.charAt(end) == ' '){
    		end --;
    	}
    	return str.substring(start,end+1);//左闭右开
    }
}
