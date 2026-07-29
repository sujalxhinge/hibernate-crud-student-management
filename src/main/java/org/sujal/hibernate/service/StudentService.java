package org.sujal.hibernate.service;

import org.sujal.hibernate.dao.StudentDAO;
import org.sujal.hibernate.entity.Student;

public class StudentService
{
    private StudentDAO studentDAO = new StudentDAO();
    public void saveStudent(Student student)
    {
        studentDAO.saveStudent(student);
    }
}
