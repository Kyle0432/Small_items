package A初级面向对象1;
/*
 * 题目一：
 * 编写程序，定义三个重载方法并调用。方法名为mOL。
 三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，
 相乘并输出结果，输出字符串信息。
 在主类的main ()方法中分别用参数区别调用三个方法。
题目二：
定义三个重载方法max()，第一个方法求两个int值中的最大值，
第二个方法求两个double值中的最大值，
第三个方法求三个double值中的最大值，并分别调用三个方法。
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
	System.out.println("最大值分别是:"+a+","+dou+","+dou2);
	
}
//以下三个方法构成重载
public void mOL(int i){
	System.out.println(i*i);
}
public void mOL(int i ,int j){
	System.out.println(i*j);
}
public void mOL(String str){
	System.out.println(str);
}
//以下三个方法构成重载
public int max(int i ,int j){
/*	方法一: int result = 0;
	if(i > j){
		result = i;
	}else if(i < j){
		result = j;
	}
	return result;*/
	//方法二:
	return (i > j)? i:j;
}
public double max(double d1,double d2){
	return (d1>d2)? d1:d2;
}
public double max(double d1,double d2,double d3){
	//进行多个三元运算运算
	return (d1>d2?d1:d2)>d3?(d1>d2?d1:d2):d3;
}
}

