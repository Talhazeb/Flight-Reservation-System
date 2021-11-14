package frs;

public class App {

    public static void main(String[] args) {
        // Clearing Terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Starting System
        Login l1 = new Login();
        l1.menu();
    }
}
