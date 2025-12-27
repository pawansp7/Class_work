package doa;

import entity.Post;
import entity.Profile;
import entity.Role;
import entity.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCrypt;
import util.HibernateUtil;
import util.PasswordHashUtil;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.List;
import java.util.Scanner;

public class UserDAO {
    static Scanner sc = new Scanner(System.in);

    public static void addUser() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            System.out.println("Enter user name");
            String name = sc.nextLine();
            System.out.println("Enter email");
            String email = sc.nextLine();
//            sc.next();
            System.out.println("Enter password");
            String pass = sc.nextLine();

            User user = new User();
            user.setUserName(name);
            user.setEmail(email);
            user.setPassword(pass);

            Profile profile = new Profile();
            System.out.println("enter for profile name for user");
            String add = sc.nextLine();
            profile.setProfileName(add);

            user.setProfile(profile);

            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();

            System.out.println("User added Succesfully");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void viewUser() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            System.out.println("Enter user id");
            int id = sc.nextInt();
            User user = session.get(User.class, id);
            if (user != null)
                System.out.println(user.getUserName() + " " + user.getEmail() + " " + user.getPassword());
            if (user.getProfile() != null)
                System.out.println("Profile Name " + user.getProfile().getProfileName());
            else
                System.out.println("user not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean updateUser() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            System.out.println("Enter user id");
            int id = sc.nextInt();

            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user == null) {
                System.out.println("user not found");
                return false;
            }
            System.out.println(user.getUserName() + " / Enter new name:");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.println(user.getEmail() + " / Enter new email:");
            String email = sc.nextLine();

            System.out.println(user.getPassword() + " / Enter new password:");
            String pass = sc.nextLine();

            session.merge(user);
            transaction.commit();

            System.out.println("Record updated");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void deleteUser() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            System.out.println("Enter user id for delete user");
            int id = sc.nextInt();
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.remove(user);
                transaction.commit();
                System.out.println("user delete sucessfully");
            } else
                System.out.println("User not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewallUser() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {

            List<User> user = session.createQuery("from User", User.class).list();
            if (user.isEmpty()) {
                System.out.println("no users found");
                return;
            }
            System.out.println("--------------------");
            for (User e : user) {
                System.out.println("User ID " + e.getUserId());
                System.out.println("User name " + e.getUserName());
                System.out.println("User email " + e.getEmail());
                System.out.println("User password " + e.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addPost(int userId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            User user = session.get(User.class, userId);

            if (user == null) {
                System.out.println("user not found");
                return;
            }
            System.out.println("Enter post title");
            String title = sc.nextLine();

            Post post = new Post();
            post.setTittle(title);
            post.setUser(user);

            user.getPost().add(post);

            session.merge(user);
            Transaction transaction = session.beginTransaction();
            transaction.commit();

            System.out.println("post added succesfully");
        }
    }

    public static void addRole(int userId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, userId);

            if (user == null) {
                System.out.println("User not found");
                return;
            }
            System.out.println("Enter role name");
            String roleName = sc.nextLine();
            Role role = session.createQuery("FROM Role r WHERE r.roleName = :name", Role.class)
                    .setParameter("name", roleName)
                    .uniqueResult();

            if (role == null) {
                role = new Role();
                role.setRoleName(roleName);
                session.persist(role);
            }
            user.getRoles().add(role);
            role.getUsers().add(user);

            session.merge(user);
            transaction.commit();

            System.out.println("Role added...");
        }
    }

    public static void listallPostWithUser() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            List<Post> posts = session.createQuery(
                    "SELECT p FROM Post p LEFT JOIN FETCH p.user",
                    Post.class
            ).getResultList();

            for (Post p : posts) {
                System.out.println("Post ID: " + p.getPostId());
                System.out.println("Post Title: " + p.getTittle());

                if (p.getUser() != null) {
                    System.out.println("User ID: " + p.getUser().getUserId());
                    System.out.println("User Name: " + p.getUser().getUserName());
                } else {
                    System.out.println("No User Assigned");
                }

                System.out.println("----------------------------");
            }
        }
    }

    public static void listUsersByRole(String roleName) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {


            List<User> users = session.createQuery(
                            "SELECT u FROM User u JOIN u.roles r WHERE r.roleName = :roleName",
                            User.class
                    ).setParameter("roleName", roleName)
                    .getResultList();

            if (users.isEmpty()) {
                System.out.println("No users found with role: " + roleName);
                return;
            }

            System.out.println("Users with role: " + roleName);
            for (User u : users) {
                System.out.println("User ID: " + u.getUserId() + ", Name: " + u.getUserName() + ", Email: " + u.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean authenticate(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();){
            TypedQuery<User> query = session.createQuery("from User where email =:email",User.class);
            query.setParameter("email", user.getEmail());
            User dbUser =  query.getSingleResult();
            if(dbUser == null)
                return false;
            return PasswordHashUtil.checkPass(user.getPassword(), dbUser.getPassword());
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static boolean loginUser(String enteredEmail, String enteredPassword) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {


            Query<User> query = session.createQuery("from User where email = :email", User.class);
            query.setParameter("email", enteredEmail);

            User user = query.uniqueResult();

            if (user == null) {
                System.out.println("No user found with this email.");
                return false;
            }


            if (BCrypt.checkpw(enteredPassword, user.getPassword())) {
                System.out.println("Login successful! Welcome " + user.getUserName());
                return true;
            } else {
                System.out.println("Wrong password!");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}





