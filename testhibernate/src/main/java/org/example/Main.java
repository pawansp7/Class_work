package org.example;

import java.util.Scanner;
import doa.UserDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        try{
            while (true){
                System.out.println("Press 1 for register user");
                System.out.println("Press 2 for fetch user by id");
                System.out.println("Press 3 for update user");
                System.out.println("Prss 4 for Delte user");
                System.out.println("Press 5 for view all users");
                System.out.println("Press 6 for add post");
                System.out.println("Press 7 for add Role");
                System.out.println("Press 8 for all user with post");
                System.out.println("Press 9 for user whose work on role");
                System.out.println("Press 10 for login");
                System.out.println("Press 0 for exit");
                System.out.println("Enter user choice");
                int choice = sc.nextInt();

                switch (choice){
                    case 0 : System.exit(0);
                    case 1: UserDAO.addUser(); break;
                    case 2: UserDAO.viewUser(); break;
                    case 3: UserDAO.updateUser(); break;
                    case 4: UserDAO.deleteUser(); break;
                    case 5: UserDAO.viewallUser(); break;
                    case 6:
                        System.out.println("Enter User id when you add post");
                        int id = sc.nextInt();
                        UserDAO.addPost(id); break;
                    case 7:
                        System.out.println("Enter User id when you add role");
                        int uid = sc.nextInt();
                        UserDAO.addRole(uid);
                        break;
                    case 8: UserDAO.listallPostWithUser();
                    break;

                    case 9:
                        System.out.println("Enter role name jiske user chaiye");
                        sc.nextLine();
                        String role = sc.nextLine();
                        UserDAO.listUsersByRole(role);

                    case 10:
                        System.out.println("Enter email");
                        sc.nextLine();
                        String email = sc.nextLine();
                        System.out.println("Enter password");
                        String pass = sc.nextLine();
                        UserDAO.loginUser(email, pass);
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
