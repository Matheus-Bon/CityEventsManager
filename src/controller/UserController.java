package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import model.User;

public class UserController {

    public static void handleUser() throws FileNotFoundException, IOException, ClassNotFoundException {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        File directory = new File("src/database");
        File file = new File(directory, "user.txt");
        ObjectOutputStream objectOut = null;
        ObjectInput objectIn = null;
        ListIterator li = null;

        if (!directory.exists()) {
            directory.mkdirs();
        }

        if (file.isFile()) {
            objectIn = new ObjectInputStream(new FileInputStream(file));
            users = (ArrayList<User>) objectIn.readObject();
            objectIn.close();
        }

        do {
            System.out.println();
            System.out.println("---- USER AREA ----");
            System.out.println("1. INSERT");
            System.out.println("2. DISPLAY");
            System.out.println("3. SEARCH");
            System.out.println("0. EXIT");
            System.out.println();
            System.out.print("Enter your Choice: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("How many users you want: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Last name: ");
                        String lastName = scanner.nextLine();

                        System.out.print("E-mail: ");
                        String email = scanner.nextLine();
                        System.out.println();

                        int userId = users.size() + 1;

                        users.add(new User(userId, name, lastName, email));
                    }

                    objectOut = new ObjectOutputStream(new FileOutputStream(file));
                    objectOut.writeObject(users);
                    objectOut.close();

                    break;
                case 2:
                    if (file.isFile()) {
                        objectIn = new ObjectInputStream(new FileInputStream(file));
                        users = (ArrayList<User>) objectIn.readObject();
                        objectIn.close();
                        System.out.println();
                        System.out.println("------------- USER LIST -------------");
                        System.out.println();
                        System.out.println("ID\tNAME\t\tLAST NAME\tE-MAIL");
                        System.out.println();

                        li = users.listIterator();
                        while (li.hasNext()) {
                            System.out.println(li.next());
                        }
                    } else {
                        System.out.println("File not found.");
                    }

                    System.out.println();
                    break;

                case 3:
                    if (file.isFile()) {
                        objectIn = new ObjectInputStream(new FileInputStream(file));
                        users = (ArrayList<User>) objectIn.readObject();
                        objectIn.close();

                        boolean found = false;
                        System.out.print("Enter your search: ");
                        scanner.nextLine();
                        String search = scanner.nextLine();
                        System.out.println("");

                        li = users.listIterator();
                        while (li.hasNext()) {
                            User user = (User) li.next();
                            if (user.getName().equals(search) ||
                             user.getEmail().equals(search) || 
                             user.getLastName().equals(search)) {
                                System.out.println("---------------------------------------");
                                System.out.println(user);
                                System.out.println("---------------------------------------");
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("User not found.");
                        }
                    } else {
                        System.out.println("File not found.");
                    }

                    System.out.println();
                    break;

                default:
                    break;
            }

        } while (choice != 0);
    }

}
