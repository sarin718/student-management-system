package com.ty.StudentDB;

import java.util.Comparator;

//import com.ty.StudentDB.Student;

public class SortByAge implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		return x.getAge() - y.getAge();
	}

}
