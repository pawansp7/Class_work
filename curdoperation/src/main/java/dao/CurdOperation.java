package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateConnection;

import java.util.List;
import java.util.Scanner;

public class CurdOperation {
    public static void registerUser() {
        Transaction transaction = null;
        try (SessionFactory sessionFactory = HibernateConnection.getFactory();
             Session session = sessionFactory.openSession();) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name");
            String name = sc.next();
            System.out.println("Enter email id");
            String email = sc.next();
            System.out.println("Enter password");
            String password = sc.next();
            User user = new User(name, email, password);
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            System.out.println("Registration sucess.....");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void getUserById(){
        try(SessionFactory sessionFactory = HibernateConnection.getFactory();
        Session session = sessionFactory.openSession();){
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter id");
            int id = sc.nextInt();
            User user =  session.get(User.class, id);
            if(user!=null)
                System.out.println(user.getId()+" "+user.getName()+" "+user.getEmail()+" "+user.getPassword());
            else
                System.out.println("User not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public List<User> getAllUser(){
//        try(Session session = HibernateConnection.getFactory().openSession()){
//           User UserAll =  session.createQuery("from user", User.class).list();
//        }
//    }

    public static void updateUser(){
        try(SessionFactory sessionFactory = HibernateConnection.getFactory();
        Session session = sessionFactory.openSession();){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user id");
            int id = sc.nextInt();

            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if(user == null){
                System.out.println("user not found");
                return;
            }
            System.out.println(user.getName()+" Enter update name :");
            String name = sc.next();

            System.out.println(user.getEmail()+" Enter new email :");
            String email = sc.next();

            System.out.println(user.getPassword()+" Enter new password :");
            String password = sc.next();

            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            session.persist(user);
            transaction.commit();
            System.out.println("Record updated....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(){
        try(SessionFactory sessionFactory = HibernateConnection.getFactory();
        Session session = sessionFactory.openSession();){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter id");
            int id = sc.nextInt();

            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class,id);
            if(user!=null){
                session.remove(user);
                transaction.commit();
                System.out.println("User removed...");
            }
            else
                System.out.println("User not found...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
