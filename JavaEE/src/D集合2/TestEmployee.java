package D集合2;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/*
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
分别按以下两种方式对集合中的元素进行排序，并遍历输出：

1). 使Employee 实现 Comparable 接口，并按 name 排序
2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。

提示：Employee类是否需要重写equals()方法？MyDate类呢？

 */
public class TestEmployee {
	//自然排序： 使Employee 实现 Comparable 接口，并按 name 排序
    @Test
    public void test1(){
    	Employee e1 = new Employee("张三",19,new MyDate(9,9,1999));
    	Employee e2 = new Employee("李四",20,new MyDate(8,4,1998));
    	Employee e3 = new Employee("王五",21,new MyDate(7,3,1996));
    	Employee e4 = new Employee("赵六",22,new MyDate(6,7,1994));
    	Employee e5 = new Employee("田七",23,new MyDate(5,9,1998));
    	TreeSet set = new TreeSet();
    	set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		Iterator i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
    }
}
