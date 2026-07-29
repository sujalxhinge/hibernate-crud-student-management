package org.sujal.hibernate;

import org.sujal.hibernate.entity.Student;
import org.sujal.hibernate.service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();

        System.out.println("=================================");
        System.out.println(" Student Management System");
        System.out.println("=================================");
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. View All Students");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");

        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        // Switch statement starts here
        switch (choice) {

            case 1:
                System.out.print("Enter First Name: ");
                String firstName = sc.next();

                System.out.print("Enter Last Name: ");
                String lastName = sc.next();

                System.out.print("Enter Email: ");
                String email = sc.next();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                System.out.print("Enter Course: ");
                sc.nextLine(); // consume leftover newline
                String course = sc.nextLine();

                Student student = new Student(firstName, lastName, email, age, course);

                studentService.saveStudent(student);

                break;

            case 2:
                System.out.println("View Student Selected");
                break;

            case 3:
                System.out.println("View All Students Selected");
                break;

            case 4:
                System.out.println("Update Student Selected");
                break;

            case 5:
                System.out.println("Delete Student Selected");
                break;

            case 6:
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("Invalid Choice!");
        }

        sc.close();
    }
}