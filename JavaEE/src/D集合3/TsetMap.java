package D����3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import D����1.Person;

/*
 * Collection�ӿ�
 * 
 * Map�ӿ�
 * 		|-----HashMap:Map����Ҫʵ����
 * 		|-----LinkedHashMap:ʹ������ά����ӽ�Map�е�˳�򡣹ʱ���Mapʱ���ǰ���ӵ�˳������ġ�
 * 		|-----TreeMap:������ӽ�Map�е�Ԫ�ص�key��ָ�����Խ�������Ҫ��key������ͬһ����Ķ���
 * 				���key����Ȼ����   vs ��������
 * 		|-----Hashtable:���ϵ�ʵ���࣬�̰߳�ȫ��������ʹ�á�
 * 			|----Properties:���������������ļ�������ֵ��ΪString���͵�
 */
public class TsetMap {
	/*
	 * put(Object key,Object value):��Map�����һ��Ԫ�� Object 
	 * remove(Object key):����ָ����keyɾ����key-value
	 * putAll(Map t) 
       clear():��� Object
	 * get(Object key)����ȡָ��key��valueֵ�����޴�key���򷵻�null 
       containsKey(Object key) 
	 * containsValue(Object value) 
	 * int size():���ؼ��ϵĳ��� 
	 * isEmpty() 
       equals(Object obj)
	 * 
	 * HashMap�� 1.key����Set����ŵģ������ظ���value����Collection����ŵģ����ظ�
	 * һ��key-value�ԣ���һ��Entry�����е�Entry����Set��ŵģ�Ҳ�ǲ����ظ��ġ�
	 * 2.��HashMap�����Ԫ��ʱ�������key�������equals()�������ж�����key�Ƿ���ͬ������ͬ ��ֻ����ӽ�����ӵ��Ǹ�Ԫ�ء�
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
	 * ��α���Map  Set--->keySet() Collection--->values() Set--->entrySet()
	 */
	@Test
	public void test2(){
		Map map = new HashMap();
		map.put("AA", 45);
		map.put("BB", 123);
		map.put("CC",123);
		map.put(null, null);
		map.put(new Person("DD", 23), 89);
		//1,����Key��
		Set set = map.keySet();
		for(Object obj:set){
			System.out.println(obj);
		}
		System.out.println("---------");
		//2,����Value��
		Collection coll = map.values();
		for(Object obj:coll){
			System.out.println(obj);
		}
		System.out.println("---------");
		//3������Key-Value��
		Set set1 = map.keySet();
		for(Object obj1:set1){             //��ȡkey��Ӧ��value
			System.out.println(obj1+"---->"+map.get(obj1));
		}
	}
}