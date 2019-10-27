package Java������;

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
	//3.��ȡһ���ַ�������һ���ַ����г��ֵĴ������ж�str2��str1�г��ֵĴ���
    public static int getTime(String str1,String str2){
    	int count = 0;
    	int len;
    	while((len = str1.indexOf(str2)) != -1){
    		count++;
    		//��ʾ����һ��Ҫ��ȥ��һ���ַ���
    		str1 = str1.substring(len+str2.length());
    	}
    	return count;
    }
  //2.��һ���ַ������з�ת�����ַ�����ָ�����ֽ��з�ת�����罫��abcdefg����תΪ��abfedcg��
    public static String reverseString(String str,int start,int end){
    	char[] c = str.toCharArray();//�ַ��� -->�ַ�����
    	return reverseArray(c,start,end);
    }
    public static String reverseArray(char[] c,int start,int end){
    	for(int i = start, j = end ; i < j;i++,j--){
    		char temp = c[i];
    		c[i] = c[j];
    		c[j] = temp;
    	}
    	//�ַ�����--->�ַ���
    	return new String(c);
    }
  //1.ģ��һ��trim������ȥ���ַ������˵Ŀո�
    public static String myTrim(String str){
    	int start = 0; 
    	int end = str.length()-1;
    	while(start < end && str.charAt(start) == ' '){
    		start++;
    	}
    	while(start < end && str.charAt(end) == ' '){
    		end --;
    	}
    	return str.substring(start,end+1);//����ҿ�
    }
}
