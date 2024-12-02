package com.ty.StudentDB;

import java.util.Comparator;

//import com.ty.StudentDB.Student;

public class SortByName implements Comparator<Student> {
	
	@Override
	public int compare(Student x, Student y) {
		return x.getName().compareTo(y.getName());
	}

}
