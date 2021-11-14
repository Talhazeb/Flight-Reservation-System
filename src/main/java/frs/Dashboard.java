package frs;

import java.util.Scanner;

public class Dashboard {
    public void Admin_menu() {
        // Clearing Terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner input = new Scanner(System.in);

        System.out.println(".....::::: ADMIN DASHBOARD :::::.....");
        System.out.println("1. Search Flights");
        System.out.println("2. Search Reservation");
        System.out.println("3. Edit Reservation");
        System.out.println("4. Log out");
        System.out.print("Input option: ");
        String option = input.nextLine();

        System.out.println(".:.:.:.:.: STILL IN DEVELOPMENT :) :.:.:.:.:.");
        System.out.println("Press any key to go back :>");
        input.nextLine();
        Login la1 = new Login();
        la1.menu();
    }

    public void Passenger_menu() {
        // Clearing Terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner input = new Scanner(System.in);

        System.out.println(".....::::: PASSENGER DASHBOARD :::::.....");
        System.out.println("1. Book a Flight");
        System.out.println("2. View Reservations");
        System.out.println("3. Modify Reservation");
        System.out.println("4. Cancel Reservation");
        System.out.println("5. Log out");
        System.out.print("Input option: ");
        String option = input.nextLine();

        if (option.equals("1")) {
            Reservation r1 = new Reservation();
            r1.initiate();
        } else if (option.equals("2")) {
            FileReading fr1 = new FileReading();
            fr1.search_reservation();

        } else if (option.equals("3")) {
            System.out.println(".:.:.:.:.: STILL IN DEVELOPMENT :) :.:.:.:.:.");
            System.out.println("Press any key to go back :>");
            input.nextLine();
            Dashboard d1 = new Dashboard();
            d1.Passenger_menu();
        } else if (option.equals("4")) {
            FileWriting fw1 = new FileWriting();
            fw1.cancel_reservation();

        } else if (option.equals("5")) {
            Login la1 = new Login();
            la1.menu();

        }

    }

}
