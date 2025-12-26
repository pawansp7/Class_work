package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
    private static SessionFactory sessionFactory = null;

        static {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Session factory creation failed");
                throw new RuntimeException(e);
            }
        }
    public static SessionFactory getFactory() {
            return sessionFactory;
    }
}

