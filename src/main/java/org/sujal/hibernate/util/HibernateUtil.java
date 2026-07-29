package org.sujal.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sessionFactory;
    static {
        try{
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
