
package com.comparevalues.www;

import java.util.Comparator;

public class SortByNameUSingComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getsName().compareTo(o2.getsName());
	}
	
	
	

}
