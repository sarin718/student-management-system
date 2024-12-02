package com.ty.StudentDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ty.Exceptions.InvalidChoiceException;
import com.ty.Exceptions.StudentNotFoundException;

import java.util.Scanner;

public class SMSFunctionsImplementation implements SMSFunctions {
	Scanner s = new Scanner(System.in);
	Map<String, Student> db = new LinkedHashMap<String, Student>();

	@Override
	public void displayStudent() {
		System.out.println("Enter the id of student to be displayed");
		String id = s.next().toUpperCase();
		System.out.println("The student details are:");
		if (db.containsKey(id)) {
			System.out.println(db.get(id));
		} else {
			try {
				String message = "Student with Id:" + id + " not found";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudent() {
		if (db.size() != 0) {
			Set<String> studentId = db.keySet();
			System.out.println("Student details are as follows:");
			for (String s : studentId) {
				System.out.println(db.get(s));
			}
		} else {
			try {
				String message = "Student DataBase is empty:Nothing to display";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void addStudent() {
		System.out.println("Enter Student Name");
		String name = s.next();
		System.out.println("Enter Student Age");
		s.nextLine();
		int age = s.nextInt();
		System.out.println("Enter Student Marks");
		int marks = s.nextInt();
		Student student = new Student(name, age, marks);
		db.put(student.getId(), student);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student id is " + student.getId());
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter student id to be deleted");
		String id = s.next().toUpperCase();
		if (db.containsKey(id)) {
			System.out.println("Student Record Found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student Record Removed Successfully");
			Student.count--;
		} else {
			try {
				String message = "Student with ID:" + id + "is not present in DataBase";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllStudents() {
		if (db.size() != 0) {
			System.out.println("Available student records " + db.size());
			db.clear();
			System.out.println("All Student Records Removed Successfully");
			System.out.println("Available student records " + db.size());
			Student.count = 101;
		} else {
			try {
				String message = "Student DataBase is empty:Nothing to delete";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void countStudent() {
		System.out.println("There are " + db.size() + " students");

	}

	@Override
	public void getStudentWithHighestMarks() {
		List<Student> list = new ArrayList<Student>();
		Set<String> keys = db.keySet();
		for (String key : keys) {
			list.add(db.get(key));
		}
		Collections.sort(list, new SortByMarks());
		System.out.println(list.get(list.size() - 1));
	}

	@Override
	public void getStudentWithLowestMarks() {
		List<Student> list = new ArrayList<Student>();
		Set<String> keys = db.keySet();
		for (String key : keys) {
			list.add(db.get(key));
		}
		Collections.sort(list, new SortByMarks());
		System.out.println(list.get(0));
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter student id");
		String id = s.next().toUpperCase();
		if (db.containsKey(id)) {
			Student std = db.get(id);
			System.out.println("1.Update Name\n2.Update Age\n3.Update marks\nEnter your choice");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Student name");
				String name = s.nextLine();
				std.setName(name);
				break;
			case 2:
				System.out.println("Enter Student age");
				int age = s.nextInt();
				std.setAge(age);
				break;
			case 3:
				System.out.println("Enter Student marks");
				int marks = s.nextInt();
				std.setMarks(marks);
				break;
			default:
				String message = "Invalid choice!Please try again";
				try {
					throw new InvalidChoiceException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			try {
				String message = "Student with Id:" + id + " not found";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void sortStudents() {
		Set<String> keys = db.keySet();
		List<Student> list = new ArrayList<Student>();
		for (String key : keys) {
			list.add(db.get(key));
		}
		System.out.println("1.SortByName\n2.SortById\n3.SortByAge\n4.SortByMarks\nEnter your choice");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			Collections.sort(list, new SortByName());
			display(list);
			break;
		case 2:
			Collections.sort(list, new SortById());
			display(list);
			break;
		case 3:
			Collections.sort(list, new SortByAge());
			display(list);
			break;
		case 4:
			Collections.sort(list, new SortByMarks());
			display(list);
			break;
		default:
			String message = "Invalid choice!Please try again";
			try {
				throw new InvalidChoiceException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public static void display(List<Student> list) {
		for (Student student : list) {
			System.out.println(student);
		}
	}

}
