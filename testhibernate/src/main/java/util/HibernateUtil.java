package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    public static SessionFactory getSessionFactory(){
        try{
            if(sessionFactory == null)
                sessionFactory  = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        }
    }

