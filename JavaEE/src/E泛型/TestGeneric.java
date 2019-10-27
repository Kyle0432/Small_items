package E����;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * ���͵�ʹ��
 * 1.�ڼ�����ʹ�÷���(����)
 * 2.�Զ��巺���ࡢ���ͽӿڡ����ͷ�������� --->ʹ�ã�
 * 3.������̳еĹ�ϵ
 * 4.ͨ���
 */
public class TestGeneric {
	//1.�ڼ�����û��ʹ�÷��͵������
	@Test
	public void test1(){
		List list = new ArrayList();
		list.add(89);
		list.add(99);
		list.add(78);
		//1,û��ʹ�÷���,�κ�Object��������Ķ��������ӽ���
		list.add(new String("AA"));
		for(int i = 0 ;i<list.size();i++){
		//2,ǿ��ת��Ϊint����,���ܱ�ClassCastException���쳣
			int score =(Integer)list.get(i);
			System.out.println(i);
		}
	}
	//2.�ڼ�����ʹ�÷���
	@Test
	public void test2(){
		List<Integer> list = new ArrayList<>();
		list.add(99);
		list.add(88);
		list.add(79);
		//list.add(new String("BB"));
		/*��ʽһ:
		for(int i = 0 ;i < list.size();i++){
			int score = list.get(i);
		  System.out.println(score);
		}*/
		//��ʽ��:
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		/*��ʽ��:
		for(int i:list){
			System.out.println(i);
		}*/
	}
	//Map������ʹ�÷���
	@Test
	public void test3(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("AA", 99);
		map.put("BB", 89);
		map.put("CC", 79);
		
		Set<Map.Entry<String,Integer>> set = map.entrySet();
		for(Map.Entry<String,Integer> o:set){
			System.out.println(o.getKey()+"--->"+o.getValue());
		}		
	}
	//�Զ��巺�����ʹ��
	@Test
	public void test4(){
		//1,��ʵ����������Ķ���ʱ,ָ�����͵�����
		//ָ���Ժ�,��Ӧ����������ʹ�÷��͵�λ��,����Ϊʵ������ָ���ķ��͵�����
		//2,��������Զ����˷�����,������ʵ����û��ʹ��,��ôĬ��������Object���
		Order<Boolean> order = new Order<>();
		order.setT(true);
		System.out.println(order.getT());
		order.add();
		List<Boolean> list = order.list;//�������list����,����ָ�������ͽ��з���
		System.out.println(list);
		System.out.println("---------------");
		//��ͨ��������÷��ͷ���ʱ,ָ�����ͷ���������
		Integer i = order.getE(32);
		Double d = order.getE(3.2);
		System.out.println(i+"-----"+d);
	}
	/*
	 * ������̳еĹ�ϵ:
	 * ����A����B�����࣬��ôList<A>�Ͳ���List<B>���ӽӿ�
	 */
	@Test
	public void test5(){
		//�൱�ڶ�̬
		Object obj = null;
		String str = "AA";
		obj = str;  
		
		Object[] obj1 = null;
		String[] str1 = new String[]{"AA","BB","CC"};
		obj1 = str1;
		
		List<Object> list = null;
		List<String> list1 = new ArrayList<String>();
	//	lsit = list1;
	}
	/*
	 * ͨ��� ?
	 * List<A>��List<B>��������������List<?>������
	 * ? extends A :���Դ��A��������
	 * ? super A:���Դ��A���丸��
	 */
	@Test
	public void test6(){
		List<?> list = null;
		List<Object> list1 = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		list = list1;
		list = list2;
		
		show(list1);
		//show(list2);
		show(list1);
		show1(list2);
		
		//Integer��Number������
		List<? extends Number> list3 = null;
		List<Integer> list4 = null;
		list3 = list4;
//		list3 = list1;
		//Number�ĸ�����Object
		List<? super Number> list5 = null;
		list5 = list1;
  	}
	public void show(List<Object> list){
		
	}
	public void show1(List<?> list){
		
	}
	/*
	 * ͨ�����ʹ��
	 */
	@Test
	public void test7(){
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		List<?> list1 = list;
		//���Զ�ȡ����Ϊͨ����ļ��ϵĶ���
		Iterator<?> iterator =list1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//������������Ϊͨ����ļ�������д�����Ψһ�������null
//		list1.add("CC");
//		list1.add(123);
		list1.add(null);
	}
}
