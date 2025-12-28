package org.example;

import doa.UserDAO;
import util.JPAUtil;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        try{
            while (true){
                System.out.println("Enter 1 for add users");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();

                switch (choice){
                    case 1:
                        UserDAO.addUser();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
