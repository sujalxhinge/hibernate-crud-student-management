package org.sujal.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.sujal.hibernate.entity.Student;
import org.sujal.hibernate.util.HibernateUtil;

import java.util.List;

public class StudentDAO {
    public void saveStudent(Student student){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            System.out.println("Student saved successfully!");
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
    }
    public Student getStudentById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Student student = null;

        try {

            student = session.find(Student.class, id);

        } finally {

            session.close();

        }

        return student;
    }
    public List<Student> getAllStudents() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Student> students = session
                .createQuery("FROM Student", Student.class)
                .getResultList();

        session.close();

        return students;
    }
    public void updateStudent(Student student){

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(student);

        transaction.commit();

        session.close();

    }
    public void deleteStudent(Long id){
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.find(Student.class, id);
        if (student !=null){
            session.remove(student);
            System.out.println("Student delted succefully");
        }
        else{
            System.out.println("Student not found !");
        }
        transaction.commit();
        session.close();
    }

}
