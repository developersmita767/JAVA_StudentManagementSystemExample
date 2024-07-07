//package com.example.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
	//create a list of students
	 List<Student> students = new ArrayList<>();
	 
    class Student{
        int rollNo;
        String name;
        int mark;
    }

	public static void main(String[] args) {
		//
		System.out.println("Please enter Student data");
		StudentManagementSystem system=new StudentManagementSystem();
		system.addStudent();
		system.searchStudentByName();
		system.sortStudentByMarks();
		system.sortStudentByName();
		system.calculateTotalMarksAndPercentage();

	}
	public void addStudent() {
		//Enter your code and store all the student data in a list of student
		String hasMore="Yes";
		Scanner sc=new Scanner(System.in);
		while("Yes".equalsIgnoreCase(hasMore)) {
			// Create new Student
            Student student = new Student();
            // Enter individual student data
            System.out.println("Please enter Student name:");
            student.name = sc.next();
            System.out.println("Please enter Student rollNum:");
            student.rollNo = sc.nextInt();
            System.out.println("Please enter Student mark:");
            student.mark = sc.nextInt();
            // Add the student to list
            students.add(student);
            System.out.println("Do you want to add more students? (Yes/No):");
            hasMore = sc.next();
			
			hasMore=sc.next();
		}
	}
	public void searchStudentByName() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Student name:");
        String searchName = sc.next();
        boolean found = false;
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(searchName)) {
                System.out.println("Student found:");
                System.out.println("Roll Number: " + student.rollNo + ", Name: " + student.name + ", Mark: " + student.mark);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No data found for the given name.");
		}
	}
	public void sortStudentByName() {
		//sort the students by name
		 students.sort(Comparator.comparing(s -> s.name));
        System.out.println("Students sorted by name:");
        for (Student student : students) {
            System.out.println("Roll Number: " + student.rollNo + ", Name: " + student.name + ", Mark: " + student.mark);
        }
	}
	public void sortStudentByMarks() {
		//sort the students by marks
		students.sort(Comparator.comparingInt(s -> s.mark));
        System.out.println("Students sorted by marks:");
        for (Student student : students) {
            System.out.println("Roll Number: " + student.rollNo + ", Name: " + student.name + ", Mark: " + student.mark);
        }
	}
	public void calculateTotalMarksAndPercentage() {
		//calculate total marks and percentage of each student and print
		int totalMarks = 0;
        for (Student student : students) {
            totalMarks += student.mark;
        }
        double averageMarks = (double) totalMarks / students.size();
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + averageMarks);
    
	}
	
}
