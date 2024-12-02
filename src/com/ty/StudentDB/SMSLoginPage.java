package com.ty.StudentDB;

import java.util.Scanner;

import com.ty.Exceptions.InvalidChoiceException;

public class SMSLoginPage {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to Student Management System");
		System.out.println("----------------------------------------");
		SMSFunctions sms = new SMSFunctionsImplementation();
		while (true) {
			System.out.println("Please select an option");
			System.out.println("1.AddStudent\n2.Display Student\n3.DisplayAllStudents");
			System.out.println("4.RemoveStudent\n5.RemoveAllStudents\n6.Update Student");
			System.out.println("7.CountStudents\n8.SortStudents\n9.GetStudenWithHighestMarks");
			System.out.println("10.GetStudenWithLowestMarks\n11.Exit\nEnter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudents();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudents();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("Thank You, Please do visit Again!!!");
				System.exit(0);
				break;
			default:
				try {
					String message = "Invalid choice!!Please try again";
					throw new InvalidChoiceException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
