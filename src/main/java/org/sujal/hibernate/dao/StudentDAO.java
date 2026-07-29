package org.sujal.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.sujal.hibernate.entity.Student;
import org.sujal.hibernate.util.HibernateUtil;

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

}
