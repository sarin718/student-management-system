package com.ty.StudentDB;

public class Student {
	private String name;
	private String id;
	private int age;
	private int marks;
	static int count = 101;

	public Student(String name, int age, int marks) {
		this.id = "JSP" + count;
		this.name = name;
		this.age = age;
		this.marks = marks;
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + ", marks=" + marks + "]";
	}

}
