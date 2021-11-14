package frs;

import java.util.Scanner;

public class Login_admin {
    public boolean validate(String username, String password) {
        FileReading fr1 = new FileReading();
        boolean val = fr1.readLogin("admin_login.txt", username, password);
        return val;
    }

    public void menu() {
        // Clearing Terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner input = new Scanner(System.in);
        
        String username;
        String password;

        boolean check_info = false;
        while (check_info == false) {
            try {

                System.out.println();
                System.out.println("\n\n...::: ADMIN DASHBOARD :::...");
                System.out.print("Input Username: ");
                username = input.nextLine();
                System.out.print("Input Password: ");
                password = input.nextLine();
                check_info = validate(username, password);
            } catch (UserNotFoundException error) {
                System.out.println(error);
            }
        }

        Dashboard d1 = new Dashboard();
        d1.Admin_menu();

        if (check_info == true) {
            System.out.println("\n----------------------");
            System.out.println("Credentials are Valid!");
            System.out.println("----------------------\n");

            //Dashboard d1 = new Dashboard();
            d1.Admin_menu();
        } else if (check_info == false) {
            throw new UserNotFoundException("User not found!");

            //Login_admin la1 = new Login_admin();
            //la1.menu();
        }
    }

}
