package D集合3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import D集合1.Person;

/*
 * Collection接口
 * 
 * Map接口
 * 		|-----HashMap:Map的主要实现类
 * 		|-----LinkedHashMap:使用链表维护添加进Map中的顺序。故遍历Map时，是按添加的顺序遍历的。
 * 		|-----TreeMap:按照添加进Map中的元素的key的指定属性进行排序。要求：key必须是同一个类的对象！
 * 				针对key：自然排序   vs 定制排序
 * 		|-----Hashtable:古老的实现类，线程安全，不建议使用。
 * 			|----Properties:常用来处理属性文件。键和值都为String类型的
 */
public class TsetMap {
	/*
	 * put(Object key,Object value):向Map中添加一个元素 Object 
	 * remove(Object key):按照指定的key删除此key-value
	 * putAll(Map t) 
       clear():清空 Object
	 * get(Object key)：获取指定key的value值。若无此key，则返回null 
       containsKey(Object key) 
	 * containsValue(Object value) 
	 * int size():返回集合的长度 
	 * isEmpty() 
       equals(Object obj)
	 * 
	 * HashMap： 1.key是用Set来存放的，不可重复。value是用Collection来存放的，可重复
	 * 一个key-value对，是一个Entry。所有的Entry是用Set存放的，也是不可重复的。
	 * 2.向HashMap中添加元素时，会调用key所在类的equals()方法，判断两个key是否相同。若相同 则只能添加进后添加的那个元素。
	 */
	@Test
	public void test1(){
		Map map = new HashMap();
		map.put("AA", 213);
		map.put("BB", 456);
		map.put("BB", 377);
		map.put(null, null);
		map.put(123, "CC");
		map.put(new Person("DD",23), 89);
		map.put(new Person("DD",23), 88);
		System.out.println(map.size());
		System.out.println(map);
		map.remove("BB");
		System.out.println(map);
		Object value = map.get(123);
		System.out.println(value);
	}
	/*
	 * 如何遍历Map  Set--->keySet() Collection--->values() Set--->entrySet()
	 */
	@Test
	public void test2(){
		Map map = new HashMap();
		map.put("AA", 45);
		map.put("BB", 123);
		map.put("CC",123);
		map.put(null, null);
		map.put(new Person("DD", 23), 89);
		//1,遍历Key集
		Set set = map.keySet();
		for(Object obj:set){
			System.out.println(obj);
		}
		System.out.println("---------");
		//2,遍历Value集
		Collection coll = map.values();
		for(Object obj:coll){
			System.out.println(obj);
		}
		System.out.println("---------");
		//3，遍历Key-Value对
		Set set1 = map.keySet();
		for(Object obj1:set1){             //获取key对应的value
			System.out.println(obj1+"---->"+map.get(obj1));
		}
	}
}