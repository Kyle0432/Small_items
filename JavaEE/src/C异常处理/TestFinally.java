package C异常处理;

public class TestFinally {
    public static void main(String[] args) {
		int i = method1();
		System.out.println(i);
	}
    public static int method1(){
    	try{
    		System.out.println(10/0);
    		return 1;
    	}catch(Exception e){
    		e.printStackTrace();
    		return 3;
    	}finally{//此时里面的代码一定会执行,之后就退出程序
    		System.out.println("kyle");
    		return 2;
    	}
    }
}	
