package Java������;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestDate {
	/*
	 * �������������ɹ����  1990-01-01  XXXX-XX-XX ���棿ɹ����
	 */
	//����date1��date2֮�������,date1����date2
	public int getDays(String date1,String date2) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		long milliTime = d2.getTime()-d1.getTime();
		return (int)milliTime/1000/3600/24 + 1;
		                   //ת����/ת��ʱ/ת����
		
	}
	
	@Test
	public void test4() throws ParseException{
		String str1 = "1990-01-01";
		String str2 = "1990-01-06";
		int dates = getDays(str1,str2);
		
		if(dates % 5 == 0 || dates % 5 == 4){
			System.out.println("ɹ��");
		}else{
			System.out.println("����");
		}
	}
//������
	//������Calendar��   get()/add()/set()/Date getTime()/setTime(Date d)
	@Test
	public void test3(){
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println("������"+day+"��");
		
	    c.add(Calendar.DAY_OF_MONTH, 2);//����2
	    day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		c.set(Calendar.DAY_OF_MONTH, 23);//����Ϊ23
		Date d = c.getTime();//��ȡʱ��
		System.out.println(d);
	}
//�ڶ���
	/*
	 * java.text.SimpleDateFormat�����ڹ��ʻ�
	 * ��ʽ��������--->�ı� ʹ��SimpleDateFormat��format()����
	 * �������ı�--->���� ʹ��SimpleDateFormat��parse()����
	 */	
	@Test
	public void test2() throws ParseException{
	//1,��ʽ��1
		SimpleDateFormat  sdf = new SimpleDateFormat();
		String date = sdf.format(new Date());//���ص���String���͵�
		System.out.println(date);//18-8-27 ����6:07
	//2,��ʽ��2
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��-MM��-dd�� hhʱ-mm��-ss��");
		String date1 = sdf1.format(new Date());
		System.out.println(date1);//2018��-08��-27�� 06ʱ-12��-32��
	//3,����:��ʾ��ʽ����ת��ΪCST���͵�
		Date date2 = sdf.parse("18-8-27 ����6:07");
		System.out.println(date2);
		Date date3 = sdf1.parse("2018��-08��-27�� 06ʱ-12��-32��");
		System.out.println(date3);
	}
//��һ��
//java.util.Date�����ڹ��ʻ�
   @Test
   public void test1(){
	   //����һ��Date��ʵ��
	   Date d1 = new Date();
	   System.out.println(d1.toString());//Mon Aug 27 17:58:48 CST 2018
	   System.out.println(d1.getTime());//1535363972487��Long�͵�
	   Date d2 = new Date(1535363972487L);
	   System.out.println(d2);//�ֿ�ת��Ϊ:Mon Aug 27 17:58:48 CST 2018����
   }
}
