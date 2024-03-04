import java.util.Scanner;

import controller.EventController;
import controller.UserController;

public class App {
    public static void main(String[] args) throws Exception {
        int choice = -1;
        Scanner menuScanner = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("---- MENU ----");
            System.out.println("1. HANDLE USER");
            System.out.println("2. HANDLE EVENT");
            System.out.println("0. EXIT");
            System.out.println();
            System.out.print("Enter your Choice: ");
            choice = menuScanner.nextInt();
            System.out.println();

            switch (choice) {
                case 0:
                    menuScanner.close();
                    break;
                case 1:
                    UserController.handleUser();
                    break;
                case 2:
                    EventController.handleEvent();
                    break;

                default:
                    System.out.println("Item not found");
                    break;
            }
        } while (choice != 0);

    }
}
