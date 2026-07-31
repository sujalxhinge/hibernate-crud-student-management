package org.sujal.hibernate;

import org.sujal.hibernate.entity.Student;
import org.sujal.hibernate.service.StudentService;

import java.util.List;
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
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                student = studentService.getStudentById(id);

                if (student != null) {

                    System.out.println("\n===== Student Details =====");
                    System.out.println("ID         : " + student.getId());
                    System.out.println("First Name : " + student.getFirstName());
                    System.out.println("Last Name  : " + student.getLastName());
                    System.out.println("Email      : " + student.getEmail());
                    System.out.println("Age        : " + student.getAge());
                    System.out.println("Course     : " + student.getCourse());

                } else {

                    System.out.println("Student not found!");

                }

                break;

            case 3:

                List<Student> students = studentService.getAllStudents();

                if(students.isEmpty()) {
                    System.out.println("No students found");
                }
                else {

                    for(Student s : students){
                        System.out.println(s);
                    }

                }

                break;
            case 4:
                System.out.print("Enter Student ID to update: ");
                id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Age: ");
                age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Course: ");
                course = sc.nextLine();


                Student stud = new Student();


                studentService.updateStudent(stud);


                System.out.println("Student Updated Successfully! ");

                break;

            case 5:
                System.out.println("Enter student id to delete: ");
                Long id_num = sc.nextLong();
                studentService.deleteStudent(id_num);
                break;

            case 6:
                System.out.println("Thank you! ");
                break;

            default:
                System.out.println("Invalid Choice! ");
        }

        sc.close();
    }
}