package E泛型;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * 泛型的使用
 * 1.在集合中使用泛型(掌握)
 * 2.自定义泛型类、泛型接口、泛型方法（理解 --->使用）
 * 3.泛型与继承的关系
 * 4.通配符
 */
public class TestGeneric {
	//1.在集合中没有使用泛型的情况下
	@Test
	public void test1(){
		List list = new ArrayList();
		list.add(89);
		list.add(99);
		list.add(78);
		//1,没有使用泛型,任何Object及其子类的对象可以添加进来
		list.add(new String("AA"));
		for(int i = 0 ;i<list.size();i++){
		//2,强制转换为int类型,可能报ClassCastException的异常
			int score =(Integer)list.get(i);
			System.out.println(i);
		}
	}
	//2.在集合中使用泛型
	@Test
	public void test2(){
		List<Integer> list = new ArrayList<>();
		list.add(99);
		list.add(88);
		list.add(79);
		//list.add(new String("BB"));
		/*方式一:
		for(int i = 0 ;i < list.size();i++){
			int score = list.get(i);
		  System.out.println(score);
		}*/
		//方式二:
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		/*方式三:
		for(int i:list){
			System.out.println(i);
		}*/
	}
	//Map集合中使用泛型
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
	//自定义泛型类的使用
	@Test
	public void test4(){
		//1,当实例化泛型类的对象时,指明泛型的类型
		//指明以后,对应的类中所有使用泛型的位置,都变为实例化中指定的泛型的类型
		//2,如果我们自定义了泛型类,但是在实例化没有使用,那么默认类型是Object类的
		Order<Boolean> order = new Order<>();
		order.setT(true);
		System.out.println(order.getT());
		order.add();
		List<Boolean> list = order.list;//对象调用list集合,并用指定的类型进行返回
		System.out.println(list);
		System.out.println("---------------");
		//当通过对象调用泛型方法时,指明泛型方法的类型
		Integer i = order.getE(32);
		Double d = order.getE(3.2);
		System.out.println(i+"-----"+d);
	}
	/*
	 * 泛型与继承的关系:
	 * 若类A是类B的子类，那么List<A>就不是List<B>的子接口
	 */
	@Test
	public void test5(){
		//相当于多态
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
	 * 通配符 ?
	 * List<A>、List<B>、。。。。都是List<?>的子类
	 * ? extends A :可以存放A及其子类
	 * ? super A:可以存放A及其父类
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
		
		//Integer是Number的子类
		List<? extends Number> list3 = null;
		List<Integer> list4 = null;
		list3 = list4;
//		list3 = list1;
		//Number的父类是Object
		List<? super Number> list5 = null;
		list5 = list1;
  	}
	public void show(List<Object> list){
		
	}
	public void show1(List<?> list){
		
	}
	/*
	 * 通配符的使用
	 */
	@Test
	public void test7(){
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		List<?> list1 = list;
		//可以读取声明为通配符的集合的对象
		Iterator<?> iterator =list1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//不允许向声明为通配符的集合类中写入对象。唯一例外的是null
//		list1.add("CC");
//		list1.add(123);
		list1.add(null);
	}
}
