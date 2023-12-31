package com.jspiders.jdbc.operation;

import java.util.List;
import java.util.Scanner;

public class StudentMain {
	
	public static void main(String[] args) {

		StudentJDBC jdbc = new StudentJDBC();
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.println(
					"\nEnter 1 to add student."
					+ "\nEnter 2 to get all students."
					+ "\nEnter 3 to get student by id."
					+ "\nEnter 4 to delete student."
					+ "\nEnter 5 to update student."
					+ "\nEnter 6 to Exit.");
			System.out.print("\n\nEnter your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Student student = new Student();
				System.out.println("\nEnter student id.");
				student.setId(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter student name.");
				student.setName(scanner.nextLine());
				System.out.println("Enter student email.");
				student.setEmail(scanner.nextLine());
				System.out.println("Enter student age.");
				student.setAge(scanner.nextInt());
				System.out.println("Enter student fees.");
				student.setFees(scanner.nextDouble());
				jdbc.addStudent(student);
				break;
			case 2:
				
				List<Student> students = jdbc.getAllStudents();
				for (Student s : students) {
					System.out.println(s);
				}
				break;
			case 3:
				System.out.println("Enter student id.");
				Student s = jdbc.getStudentById(scanner.nextInt());
				System.out.println(s);
				break;
			case 4:
				System.out.println("Enter student id.");
				jdbc.deleteStudent(scanner.nextInt());
				break;
			case 5:
				System.out.println("\nEnter student id.");
				jdbc.updateStudent(scanner.nextInt(), scanner);
				break;
			case 6:
				System.out.println("\nThank you!");
				flag = false;
				break;
			default:
				System.out.println("\nInvalid choice!!!!");
			}
		}
		scanner.close();
	}

}
