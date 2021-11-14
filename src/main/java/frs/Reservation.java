package frs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class Reservation {
    Scanner input_string = new Scanner(System.in);
    Scanner input_int = new Scanner(System.in);
    Scanner input_char = new Scanner(System.in);
    Passenger p1 = new Passenger();
    Flight f1 = new Flight();
    FileReading fr1 = new FileReading();
    FileWriting fw = new FileWriting();
    List<ArrayList<String>> s;
    ArrayList<String> seatd;
    Dashboard d1 = new Dashboard();

    int count = 1;
    int count_seat = 1;
    int option;
    int select_flight;
    int select_seat;

    public void input_detail() {
        System.out.println("\nKindly fill remaining details.\n");
        System.out.print("Input Name: ");
        p1.name = input_string.nextLine();
        System.out.print("Input CNIC: ");
        p1.cnic = input_string.nextLine();
        System.out.print("Input Phone Number: ");
        p1.phone_number = input_string.nextLine();
        System.out.print("Input Address: ");
        p1.address = input_string.nextLine();
        System.out.print("Input Gender(M/F): ");
        p1.gender = input_char.next().charAt(0);
        System.out.print("Input Age: ");
        p1.age = input_int.nextInt();
        System.out.print("Input Passport Number: ");
        p1.passport_number = input_string.nextLine();
    }

    public void choose_seat(String plane) {
        seatd = fr1.seat_search(plane);

        if (s.size() == 0) {
            System.out.println("\n----------------------");
            System.out.println("Sorry all seats are booked!");
            System.out.println("----------------------\n");

        } else {
            System.out.println("\nSr.\tSeat No.");
            // System.out.println(s);
            for (int i = 0; i < seatd.size(); i++) {
                System.out.println(count_seat + "\t" + seatd.get(i));
                count_seat++;
            }

            System.out.print("\nInput Seat No. to select: ");
            select_seat = input_int.nextInt();

        }

    }

    public void advance_search(String departure_location, String destination_location, String date) {
        System.out.println("\n\n...::: Personlized Flights Search :::...");
        System.out.println("1. Search Direct Flights");
        System.out.println("2. Search InDirect Flights");
        System.out.println("3. Search by Lowest Fare");
        String sopt = input_string.nextLine();

        if (sopt.equals("1")) {

            s = fr1.search_flight_direct(departure_location, destination_location, date);
            System.out.println(s.get(0).get(0)+ s.get(0).get(1));
            if (s.size() == 0) {
                System.out.println("\n----------------------");
                System.out.println("Sorry no flights available!");
                System.out.println("----------------------\n");

                d1.Passenger_menu();
            } else {
                System.out.println("\nSr.\tPlane\tDep_Loc\t\tCon_loc\tDest_Loc\tDate\tFare\tSeats_Available");
                for (int i = 0; i < s.size(); i++) {
                    System.out.print(count + "\t");
                    for (int j = 0; j < s.get(i).size(); j++) {
                        System.out.print(s.get(i).get(j) + "\t");
                    }
                    System.out.println();
                    count++;
                }
                do {
                    System.out.print("Input flight serial to select: ");
                    select_flight = input_int.nextInt();
                } while (select_flight <= 0 || select_flight > count);

            }
        } else if (sopt.equals("2")) {
            s = fr1.search_flight_indirect(departure_location, destination_location, date);

            if (s.size() == 0) {
                System.out.println("\n----------------------");
                System.out.println("Sorry no flights available!");
                System.out.println("----------------------\n");

                d1.Passenger_menu();
            } else {
                System.out.println("\nSr.\tPlane\tDep_Loc\t\tCon_loc\tDest_Loc\tDate\tFare\tSeats_Available");
                for (int i = 0; i < s.size(); i++) {
                    System.out.print(count + "\t");
                    for (int j = 0; j < s.get(i).size(); j++) {
                        System.out.print(s.get(i).get(j) + "\t");
                    }
                    System.out.println();
                    System.out.println();
                    count++;
                }
                do {
                    System.out.print("Input flight serial to select: ");
                    select_flight = input_int.nextInt();
                } while (select_flight <= 0 || select_flight > count);

            }
        } else if (sopt.equals("3")) {
            s = fr1.search_flight(departure_location, destination_location, date);

            if (s.size() == 0) {
                System.out.println("\n----------------------");
                System.out.println("Sorry no flights available!");
                System.out.println("----------------------\n");

                d1.Passenger_menu();
            } else {

                long n1, n2;

                for (int i = 0; i < s.size(); i++) {

                    for (int j = 0; j < s.size() - i - 1; j++) {
                        int fj1 = j;
                        int fj2 = j + 1;
                        n1 = Long.parseLong(s.get(fj1).get(5));
                        n2 = Long.parseLong(s.get(fj2).get(5));

                        if (n1 > n2) {
                            /*
                             * String temp_plane = s.get(fj1).get(0); String temp_dep = s.get(fj1).get(1);
                             * String temp_con = s.get(fj1).get(2); String temp_dest = s.get(fj1).get(3);
                             * String temp_date = s.get(fj1).get(4); String temp_fare = s.get(fj1).get(5);
                             * String temp_seats = s.get(fj1).get(6);
                             * 
                             * s.get(fj1).set(0, s.get(fj2).get(0)); s.get(fj1).set(1, s.get(fj2).get(1));
                             * s.get(fj1).set(2, s.get(fj2).get(2)); s.get(fj1).set(3, s.get(fj2).get(3));
                             * s.get(fj1).set(4, s.get(fj2).get(4)); s.get(fj1).set(5, s.get(fj2).get(5));
                             * s.get(fj1).set(6, s.get(fj2).get(6));
                             * 
                             * s.get(fj2).set(0, temp_plane); s.get(fj2).set(1, temp_dep); s.get(fj2).set(2,
                             * temp_con); s.get(fj2).set(3, temp_dest); s.get(fj2).set(4, temp_date);
                             * s.get(fj2).set(5, temp_fare); s.get(fj2).set(6, temp_seats);
                             */

                            Collections.swap(s, fj1, fj2);
                        }
                    }
                }

                System.out.println("\nSr.\tPlane\tDep_Loc\t\tCon_Loc\tDest_Loc\tDate\tFare\tSeats_Available");
                for (int i = 0; i < s.size(); i++) {
                    System.out.print(count + "\t");
                    for (int j = 0; j < s.get(i).size(); j++) {
                        System.out.print(s.get(i).get(j) + "\t");
                    }
                    System.out.println();
                    System.out.println();
                    count++;
                }
                do {
                    System.out.print("Input flight serial to select: ");
                    select_flight = input_int.nextInt();
                } while (select_flight <= 0 || select_flight > count);

            }
        }
    }

    public void search_flight(String departure_location, String destination_location, String date) {

        //try
        //{
            s = fr1.search_flight(departure_location, destination_location, date);
        //}
        //catch()
        //{

        //}


        if (s.size() == 0) {
            System.out.println("\n----------------------");
            System.out.println("Sorry no flights available!");
            System.out.println("----------------------\n");

            d1.Passenger_menu();
        } else {
            System.out.println("\nSr.\tPlane\tDep_Loc\t\tCon_Loc\tDest_Loc\tDate\tFare\tSeats_Available");
            for (int i = 0; i < s.size(); i++) {
                System.out.print(count + "\t");
                for (int j = 0; j < s.get(i).size(); j++) {
                    System.out.print(s.get(i).get(j) + "\t");
                }
                System.out.println();
                System.out.println();
                count++;
            }
        }
    }

    public void initiate() {

        System.out.print("\nInput Flight Departure Location: ");
        f1.departure_location = input_string.nextLine();
        System.out.print("Input Flight Destination Location: ");
        f1.destination_location = input_string.nextLine();
        System.out.print("Input Flight Date(DD/MM/YYYY): ");
        f1.date = input_string.nextLine();

        advance_search(f1.departure_location, f1.destination_location, f1.date);

        input_detail();

        choose_seat(s.get(select_flight - 1).get(0));

        fw.update_flight(s.get(select_flight - 1).get(0));

        fw.update_seat(s.get(select_flight - 1).get(0), select_seat);

        fw.reservation(p1, s, select_flight, select_seat);

        System.out.println("Reservation successfully completed!\nPress any key to continue!");
        input_string.nextLine();
        d1.Passenger_menu();

    }
}
