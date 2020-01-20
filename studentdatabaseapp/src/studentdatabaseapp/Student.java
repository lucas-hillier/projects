package studentdatabaseapp;
import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int yearOfStudy;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int courseCost = 600;
	private static int id = 1000;
	
	// Constructor: prompt user to enter student's name and year 
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - First Year\n2 - Second Year\n3 - Third Year\n4 - Fourth Year\nEnter student class level: ");
		this.yearOfStudy = in.nextInt();
		
		setStudentID();		
		
	}
	
	// Generate an ID
	private void setStudentID() {
		// Grade Level + ID
		id++;
		this.studentID = yearOfStudy + "" + id;
	}
	
	// Enroll in courses
	public void enroll() {
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if(!course.equals("Q")) {
				courses = courses + "\n " + course;
				tuitionBalance += courseCost;
			}
			else {break;}
		} while (1 != 0);
	}
	
	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	// Pay Tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	// Show status
	public String showInfo() {
		return "Name: " + firstName + " " + lastName +
				"\nYear of Study:" + "" + yearOfStudy +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}
}
