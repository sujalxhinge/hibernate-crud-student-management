package org.sujal.hibernate.service;

import org.sujal.hibernate.dao.StudentDAO;
import org.sujal.hibernate.entity.Student;

import java.util.List;

public class StudentService
{
    private StudentDAO studentDAO = new StudentDAO();

    public void saveStudent(Student student)
    {
        studentDAO.saveStudent(student);
    }
    public Student getStudentById(int id){
        return studentDAO.getStudentById(id);
    }
    public List<Student> getAllStudents() {

        return studentDAO.getAllStudents();

    }
    public void updateStudent(Student student){

        studentDAO.updateStudent(student);

    }
    public void deleteStudent(Long id){
        studentDAO.deleteStudent(id);
    }
}
