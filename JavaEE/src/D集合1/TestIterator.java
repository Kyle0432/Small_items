package D����1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class TestIterator {
   @Test
   public void testIterator(){
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(new String("AA"));
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 23));
		//ͨ������Ӧ�ĵ���������
		Iterator iterator = coll.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
   }
   @Test
   public void testIterator2(){
			Collection coll = new ArrayList();
			coll.add(123);
			coll.add(new String("AA"));
			coll.add(new Date());
			coll.add("BB");
			coll.add(new Person("MM", 23));
			//ͨ����ǿforѭ������
			for(Object obj:coll){
				System.out.println(obj);
			}
   }
	//ʹ����ǿforѭ��ʵ������ı���
	@Test
	public void testFor1(){
		String[] str = new String[]{"AA","BB","DD"};
		for(String s:str){
			System.out.println(s);
		}
	}
	//�����⣺
		@Test
		public void testFor3(){
			String[] str = new String[]{"AA","BB","DD"};
			for(String s : str){
				s =  "MM";//�˴���s���¶���ľֲ���������ֵ���޸Ĳ����str�������Ӱ�졣
				System.out.println(s);
			}		
			
			for(int i = 0;i < str.length;i++){
				System.out.println(str[i]);
			}
		}
		@Test
		public void testFor2(){
			String[] str = new String[]{"AA","BB","DD"};
			for(int i = 0;i < str.length;i++){
				str[i] = i + "";
			}
			
			for(int i = 0;i < str.length;i++){
				System.out.println(str[i]);
			}
		}
		
		//***********************************************
}
