package D����2;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/*
 * ��������� 5 �����󣬲�����Щ������� TreeSet �����У���һ�£�TreeSet ��ʹ�÷��������壩
�ֱ��������ַ�ʽ�Լ����е�Ԫ�ؽ������򣬲����������

1). ʹEmployee ʵ�� Comparable �ӿڣ����� name ����
2). ���� TreeSet ʱ���� Comparator���󣬰��������ڵ��Ⱥ�����

��ʾ��Employee���Ƿ���Ҫ��дequals()������MyDate���أ�

 */
public class TestEmployee {
	//��Ȼ���� ʹEmployee ʵ�� Comparable �ӿڣ����� name ����
    @Test
    public void test1(){
    	Employee e1 = new Employee("����",19,new MyDate(9,9,1999));
    	Employee e2 = new Employee("����",20,new MyDate(8,4,1998));
    	Employee e3 = new Employee("����",21,new MyDate(7,3,1996));
    	Employee e4 = new Employee("����",22,new MyDate(6,7,1994));
    	Employee e5 = new Employee("����",23,new MyDate(5,9,1998));
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
