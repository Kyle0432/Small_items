package com.kyle.struts2.tags;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		 //按名字进行排序
		return o1.getName().compareTo(o2.getName());
	}

}
