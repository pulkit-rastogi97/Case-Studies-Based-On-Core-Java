package com.psl.university.pl;

import java.util.ArrayList;
import java.util.Scanner;

import com.psl.university.dto.Student;
import com.psl.university.exception.UniversityException;
import com.psl.university.service.UniversityService;
import com.psl.university.service.UniversityServiceImpl;

public class MainUniversity {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ch = 0;
		UniversityService ref = new UniversityServiceImpl();
		Student stu;
		int stuId;
		String stuName, deptName;
		System.out.println("************************************************************");
		System.out.println("\t\t WELCOME TO UNIVERSITY MGMT SYSTEM ");
		System.out.println("************************************************************");
		do {
			System.out.println("What would you like to do ?");
			System.out.println("1. Insert Student Details ");
			System.out.println("2. Delete a student record ");
			System.out.println("3. Get Students enrolled for a particular course ");
			System.out.println("4. Exit");
			ch = sc.nextInt();
			try {

				switch (ch) {
				case 1:
					System.out.println("Enter the student Id :: ");
					stuId = sc.nextInt();
					System.out.println("Enter student name :: ");
					stuName = sc.next();
					System.out.println("Enter the department name :: ");
					deptName = sc.next();
					boolean isInserted = ref.createStudent(stuId, stuName, deptName);
					if (isInserted)
						System.out.println("Student record successfully inserted ");
					break;
				case 2:
					System.out.println("Enter the student id :: ");
					stuId = sc.nextInt();
					stu = ref.deleteStudent(stuId);
					System.out.println("Deleted Student Record " + stu);
					break;
				case 3:
					System.out.println("Enter the department name :: ");
					deptName = sc.next();
					ArrayList<Student> listStu = ref.getStudentByDepartment(deptName);
					System.out.println("Students enrolled in " + deptName + " are as follows :: ");
					for (Student stu1 : listStu) {
						System.out.println(stu1);
					}
					break;
				case 4: System.exit(0);
					break;
				default:
					System.out.println("Invalid choice");

				}

			} catch (UniversityException e) {
				System.out.println(e.getMessage());
			}
		} while (ch > 0 && ch <= 3);
		sc.close();
	}

}
