package frs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReading {

    String line = "";
    String splitBy = ",";

    public boolean readLogin(String filename, String username, String password) {

        boolean authentication = false;
        if (filename.equals("admin_login.txt")) {
            Passenger p1 = new Passenger();
            try {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                while ((line = br.readLine()) != null) {
                    String[] credentials = line.split(splitBy);
                    if (credentials[0].equals(username) && credentials[1].equals(password)) {
                        p1.login_username = credentials[0];
                        p1.password = credentials[1];
                        authentication = true;  
                        return authentication;
                    }
                }
                throw new UserNotFoundException("User not Found!");
            } catch (IOException e) {
                return false;
            }
        } else if (filename.equals("passenger_login.txt")) {
            Admin a1 = new Admin();
            try {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                while ((line = br.readLine()) != null) {
                    String[] credentials = line.split(splitBy);
                    if (credentials[0].equals(username) && credentials[1].equals(password)) {
                        a1.login_username = credentials[0];
                        a1.password = credentials[1];
                        authentication = true;
                        return authentication;
                    }

                }
                throw new UserNotFoundException("User not Found!");
            } catch (IOException e) {
                return false;
            }
        }
        return authentication;
    }

    public List<ArrayList<String>> search_flight(String departure_location, String destination_location, String date) {
        List<ArrayList<String>> s = new ArrayList<>();

        // Vector v2 = new Vector<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("flights.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);
                if (credentials[1].equals(departure_location) && credentials[3].equals(destination_location)
                        && credentials[4].equals(date)) {

                    ArrayList<String> data = new ArrayList<String>();
                    data.add(credentials[0]);
                    data.add(credentials[1]);
                    data.add(credentials[2]);
                    data.add(credentials[3]);
                    data.add(credentials[4]);
                    data.add(credentials[5]);
                    data.add(credentials[6]);
                    s.add(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public List<ArrayList<String>> search_flight_direct(String departure_location, String destination_location,
            String date) {
        List<ArrayList<String>> s = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("flights.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);
                if (credentials[1].equals(departure_location) && credentials[3].equals(destination_location)
                        && credentials[4].equals(date) && credentials[2].equals("Direct")) {
                        
                    ArrayList<String> data = new ArrayList<String>();

                    data.add(credentials[0]);
                    data.add(credentials[1]);
                    data.add(credentials[2]);
                    data.add(credentials[3]);
                    data.add(credentials[4]);
                    data.add(credentials[5]);
                    data.add(credentials[6]);

                    s.add(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public List<ArrayList<String>> search_flight_indirect(String departure_location, String destination_location,
            String date) {
        List<ArrayList<String>> s = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("flights.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);
                if (credentials[1].equals(departure_location) && credentials[3].equals(destination_location)
                        && credentials[4].equals(date) && !credentials[2].equals("Direct")) {

                    ArrayList<String> data = new ArrayList<String>();
                    data.add(credentials[0]);
                    data.add(credentials[1]);
                    data.add(credentials[2]);
                    data.add(credentials[3]);
                    data.add(credentials[4]);
                    data.add(credentials[5]);
                    data.add(credentials[6]);

                    s.add(data);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public ArrayList<String> seat_search(String plane) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            String filename = plane + ".txt";
            System.out.println(filename);
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);
                if (credentials[1].equals("notbooked")) {

                    data.add(credentials[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void search_reservation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input CNIC: ");
        String cnic = input.nextLine();
        String check = "false";
        try {
            BufferedReader br = new BufferedReader(new FileReader("reservation.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);
                if (credentials[3].equals(cnic)) {

                    System.out.println("Name\tCNIC\tCell Number\tDeparture\tDestination\tDate\tSeat\tFare");
                    System.out.println(credentials[0] + "\t" + credentials[3] + "\t" + credentials[5] + "\t"
                            + credentials[8] + "\t" + credentials[10] + "\t" + credentials[11] + "\t" + credentials[13]
                            + "\t" + credentials[12]);
                    check = "true";

                }

            }

            if (check.equals("false")) {
                System.out.println("No reservation found! Presss any key");
                input.nextLine();
                Dashboard d1 = new Dashboard();
                d1.Passenger_menu();
            }
            System.out.println("Presss any key");
            input.nextLine();
            Dashboard d1 = new Dashboard();
            d1.Passenger_menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
