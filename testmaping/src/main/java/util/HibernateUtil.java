package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        try{
            if(sessionFactory == null){
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return sessionFactory;
    }

    }


