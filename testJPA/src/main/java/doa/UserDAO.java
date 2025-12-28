package doa;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Transaction;
import util.JPAUtil;

import java.util.Scanner;

public class UserDAO {
    public static void addUser(){
        EntityManagerFactory entityManagerFactory = JPAUtil.getFactory();
        try(EntityManager entityManager = entityManagerFactory.createEntityManager();){
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user name");
//            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Enter User Age");
            int age = sc.nextInt();

            User user = new User();
            user.setName(name);
            user.setAge(age);

            entityManager.persist(user);
            entityTransaction.commit();
            System.out.println("User added succesfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
