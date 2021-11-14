package frs;

import java.util.Scanner;

public class Login {
    public void menu() {
        // Clearing Terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner input = new Scanner(System.in);

        System.out.println("..........:::::::::: FLIGHT RESERVATION SYSTEM :::::::::..........");
        System.out.println("------------------------------------------------------------------");
        System.out.println("1. Admin Login");
        System.out.println("2. Customer Login");
        System.out.println("3. Exit");
        System.out.print("Input option: ");
        String option = input.nextLine();

        if (option.equals("1")) {
            Login_admin la1 = new Login_admin();
            la1.menu();
        } else if (option.equals("2")) {
            Login_customer lc1 = new Login_customer();
            lc1.menu();
        } else if (option.equals("3")) {
            System.exit(0);
        }
    }
}
