package frs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWriting {

    List<ArrayList<String>> modify = new ArrayList<>();
    List<ArrayList<String>> modify_s = new ArrayList<>();

    public void reservation(Passenger p1, List<ArrayList<String>> s, int flight, int seat) {
        Path path = Paths.get("reservation.txt");
        String s_seat = String.valueOf(seat);
        if (Files.exists(path)) {
            try {
                FileWriter fw = new FileWriter("reservation.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(p1.name + "," + p1.address + "," + p1.age + "," + p1.cnic + "," + p1.gender + ","
                        + p1.phone_number + "," + p1.passport_number + "," + s.get(flight - 1).get(0) + ","
                        + s.get(flight - 1).get(1) + "," + s.get(flight - 1).get(2) + "," + s.get(flight - 1).get(3)
                        + "," + s.get(flight - 1).get(4) + "," + s.get(flight - 1).get(5) + "," + s_seat + "\n");
                bw.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }

        if (Files.notExists(path)) {
            try {
                BufferedWriter bw1 = new BufferedWriter(new FileWriter("reservation.txt"));
                bw1.write(p1.name + "," + p1.address + "," + p1.age + "," + p1.cnic + "," + p1.gender + ","
                        + p1.phone_number + "," + p1.passport_number + "," + s.get(flight - 1).get(0) + ","
                        + s.get(flight - 1).get(1) + "," + s.get(flight - 1).get(2) + "," + s.get(flight - 1).get(3)
                        + "," + s.get(flight - 1).get(4) + "," + s.get(flight - 1).get(5) + ","
                        + s.get(flight - 1).get(6) + "\n");
                bw1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void update_flight(String plane) {
        String line = "";
        String splitBy = ",";

        // Vector v2 = new Vector<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("flights.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                if (credentials[0].equals(plane)) {
                    int temp_int = Integer.parseInt(credentials[6]);
                    --temp_int;
                    String temp_string = String.valueOf(temp_int);
                    credentials[6] = temp_string;
                }
                ArrayList<String> data = new ArrayList<String>();
                data.add(credentials[0]);
                data.add(credentials[1]);
                data.add(credentials[2]);
                data.add(credentials[3]);
                data.add(credentials[4]);
                data.add(credentials[5]);
                data.add(credentials[6]);

                modify.add(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("flights.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < modify.size(); i++) {
                for (int j = 0; j < modify.get(i).size(); j++) {
                    if (j == 6)
                        bw.write(modify.get(i).get(j));
                    else
                        bw.write(modify.get(i).get(j) + ",");
                }
                bw.write("\n");
            }
            bw.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void update_seat(String plane, int seat_no) {
        String line = "";
        String splitBy = ",";

        String seat = String.valueOf(seat_no);
        // Vector v2 = new Vector<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(plane + ".txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                if (credentials[0].equals(seat)) {
                    credentials[1] = "booked";
                }
                ArrayList<String> data = new ArrayList<String>();
                data.add(credentials[0]);
                data.add(credentials[1]);

                modify_s.add(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(plane + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < modify_s.size(); i++) {
                for (int j = 0; j < modify_s.get(i).size(); j++) {
                    if (j == 1)
                        bw.write(modify_s.get(i).get(j));
                    else
                        bw.write(modify_s.get(i).get(j) + ",");
                }
                bw.write("\n");
            }
            bw.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void cancel_reservation() {
        String line = "";
        String splitBy = ",";
        Scanner input = new Scanner(System.in);
        System.out.print("Input CNIC: ");
        String cnic = input.nextLine();
        String check = "false";
        String plane = "";
        String seat = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("reservation.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                if (!credentials[3].equals(cnic)) {
                    ArrayList<String> data = new ArrayList<String>();
                    data.add(credentials[0]);
                    data.add(credentials[1]);
                    data.add(credentials[2]);
                    data.add(credentials[3]);
                    data.add(credentials[4]);
                    data.add(credentials[5]);
                    data.add(credentials[6]);
                    data.add(credentials[7]);
                    data.add(credentials[8]);
                    data.add(credentials[9]);
                    data.add(credentials[10]);
                    data.add(credentials[11]);
                    data.add(credentials[12]);
                    data.add(credentials[13]);

                    modify.add(data);
                } else {
                    check = "true";
                    plane = credentials[7];
                    seat = credentials[13];

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("reservation.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < modify.size(); i++) {
                for (int j = 0; j < modify.get(i).size(); j++) {
                    if (j == 13)
                        bw.write(modify.get(i).get(j));
                    else
                        bw.write(modify.get(i).get(j) + ",");
                }
                bw.write("\n");
            }
            bw.close();

        } catch (IOException io) {
            io.printStackTrace();
        }
        if (check.equals("false")) {
            System.out.println("No reservation found! Presss any key");
            input.nextLine();
            Dashboard d1 = new Dashboard();
            d1.Passenger_menu();
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(plane + ".txt"));
                while ((line = br.readLine()) != null) {
                    String[] credentials = line.split(splitBy);

                    if (credentials[0].equals(seat)) {

                        credentials[1] = "notbooked";
                    }
                    ArrayList<String> data = new ArrayList<String>();
                    data.add(credentials[0]);
                    data.add(credentials[1]);

                    modify.add(data);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileWriter fw = new FileWriter(plane+".txt");
                BufferedWriter bw = new BufferedWriter(fw);
    
                for (int i = 0; i < modify.size(); i++) {
                    for (int j = 0; j < modify.get(i).size(); j++) {
                        if (j == 1)
                            bw.write(modify.get(i).get(j));
                        else
                            bw.write(modify.get(i).get(j) + ",");
                    }
                    bw.write("\n");
                }
                bw.close();
    
            } catch (IOException io) {
                io.printStackTrace();
            }

            System.out.println("Reservation Cancelled Successfully, Press any key to continue");
            input.nextLine();
            Dashboard d1 = new Dashboard();
            d1.Passenger_menu();
        }
    }
}
