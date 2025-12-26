package org.example;

import java.util.Scanner;

import static dao.CurdOperation.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            try{
                Scanner sc = new Scanner(System.in);
                while (true){
                    System.out.println("Press 1 for user registration..");
                    System.out.println("Press 2 for fetch user by id");
                    System.out.println("Press 3 for update user");
                    System.out.println("Press 4 for delete user");
                    System.out.println("Press 0 for exit");
                    System.out.println("Enter your choice");
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1: registerUser();
                        break;
                        case 2: getUserById();
                        break;
                        case 3: updateUser();
                        break;
                        case 4: deleteUser();
                        break;
                        case 0: System.exit(0);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

                  }
    }
