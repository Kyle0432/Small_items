package Java常用类;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestDate {
	/*
	 * “三天打渔两天晒网”  1990-01-01  XXXX-XX-XX 打渔？晒网？
	 */
	//返回date1与date2之间的天数,date1早于date2
	public int getDays(String date1,String date2) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		long milliTime = d2.getTime()-d1.getTime();
		return (int)milliTime/1000/3600/24 + 1;
		                   //转换秒/转换时/转换天
		
	}
	
	@Test
	public void test4() throws ParseException{
		String str1 = "1990-01-01";
		String str2 = "1990-01-06";
		int dates = getDays(str1,str2);
		
		if(dates % 5 == 0 || dates % 5 == 4){
			System.out.println("晒网");
		}else{
			System.out.println("打渔");
		}
	}
//第三波
	//日历：Calendar类   get()/add()/set()/Date getTime()/setTime(Date d)
	@Test
	public void test3(){
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println("今天是"+day+"号");
		
	    c.add(Calendar.DAY_OF_MONTH, 2);//加了2
	    day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		c.set(Calendar.DAY_OF_MONTH, 23);//设置为23
		Date d = c.getTime();//获取时间
		System.out.println(d);
	}
//第二波
	/*
	 * java.text.SimpleDateFormat类易于国际化
	 * 格式化：日期--->文本 使用SimpleDateFormat的format()方法
	 * 解析：文本--->日期 使用SimpleDateFormat的parse()方法
	 */	
	@Test
	public void test2() throws ParseException{
	//1,格式化1
		SimpleDateFormat  sdf = new SimpleDateFormat();
		String date = sdf.format(new Date());//返回的是String类型的
		System.out.println(date);//18-8-27 下午6:07
	//2,格式化2
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年-MM月-dd日 hh时-mm分-ss秒");
		String date1 = sdf1.format(new Date());
		System.out.println(date1);//2018年-08月-27日 06时-12分-32秒
	//3,解析:表示格式化的转换为CST类型的
		Date date2 = sdf.parse("18-8-27 下午6:07");
		System.out.println(date2);
		Date date3 = sdf1.parse("2018年-08月-27日 06时-12分-32秒");
		System.out.println(date3);
	}
//第一波
//java.util.Date不易于国际化
   @Test
   public void test1(){
	   //创建一个Date的实例
	   Date d1 = new Date();
	   System.out.println(d1.toString());//Mon Aug 27 17:58:48 CST 2018
	   System.out.println(d1.getTime());//1535363972487是Long型的
	   Date d2 = new Date(1535363972487L);
	   System.out.println(d2);//又可转化为:Mon Aug 27 17:58:48 CST 2018类型
   }
}
