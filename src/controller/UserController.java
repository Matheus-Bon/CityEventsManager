package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

import model.User;

public class UserController {

    public static void handleUser() throws FileNotFoundException, IOException, ClassNotFoundException {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        ListIterator li = null;

        String pathName = "src/database/user.data";

        do {
            System.out.println();
            System.out.println("---- USER AREA ----");
            System.out.println("1. INSERT");
            System.out.println("2. DISPLAY");
            System.out.println("3. SEARCH");
            System.out.println("4. DELETE");
            System.out.println("5. UPDATE");
            System.out.println("6. SORT By ID");
            System.out.println("7. SORT By Name");
            System.out.println("0. EXIT");
            System.out.println();
            System.out.print("Enter your Choice: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 0:
                    scanner.close();
                    break;
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

                        User lastUser = null;
                        if (!users.isEmpty()) {
                            lastUser = users.get((users.size() - 1));
                        }
                        int userId = lastUser != null ? lastUser.getId() + 1 : 1;

                        users.add(new User(userId, name, lastName, email));
                    }

                    FileHandlerController.writeObject(pathName, users);

                    break;
                case 2:
                    if (Paths.get(pathName) != null) {
                        users = FileHandlerController.readObject(pathName);
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
                    if (Paths.get(pathName) != null) {
                        users = FileHandlerController.readObject(pathName);

                        boolean found = false;
                        System.out.print("Enter your search: ");
                        scanner.nextLine();
                        String search = scanner.nextLine();
                        System.out.println("");

                        System.out.println("---------------------------------------");
                        li = users.listIterator();
                        while (li.hasNext()) {
                            User user = (User) li.next();
                            if (user.getName().equals(search) ||
                                    user.getPhone().equals(search) ||
                                    user.getLastName().equals(search)) {
                                System.out.println(user);
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("User not found.");
                        }
                        System.out.println("---------------------------------------");
                    } else {
                        System.out.println("File not found.");
                    }

                    System.out.println();
                    break;

                case 4:
                    if (Paths.get(pathName) != null) {
                        users = FileHandlerController.readObject(pathName);

                        boolean found = false;
                        System.out.print("Enter ID to delete: ");
                        scanner.nextLine();
                        int id = scanner.nextInt();
                        System.out.println("");

                        System.out.println("---------------------------------------");
                        li = users.listIterator();
                        while (li.hasNext()) {
                            User user = (User) li.next();
                            if (user.getId() == id) {
                                li.remove();
                                found = true;
                            }
                        }

                        if (found) {
                            FileHandlerController.writeObject(pathName, users);
                            System.out.println("User deleted successfully");
                        } else
                            System.out.println("User not found");

                        System.out.println("---------------------------------------");
                    } else {
                        System.out.println("File not found");
                    }

                    System.out.println();
                    break;

                case 5:
                    if (Paths.get(pathName) != null) {
                        users = FileHandlerController.readObject(pathName);

                        boolean found = false;
                        System.out.print("Enter ID to update: ");
                        scanner.nextLine();
                        int id = scanner.nextInt();
                        System.out.println("");

                        System.out.println("---------------------------------------");
                        li = users.listIterator();
                        while (li.hasNext()) {
                            User user = (User) li.next();
                            if (user.getId() == id) {
                                System.out.print("New name: ");
                                scanner.nextLine();
                                String name = scanner.nextLine();

                                System.out.print("New last name: ");
                                String lastName = scanner.nextLine();

                                System.out.print("New e-mail: ");
                                String email = scanner.nextLine();
                                System.out.println();

                                li.set(new User(user.getId(), name, lastName, email));

                                found = true;
                            }
                        }

                        if (found) {
                            FileHandlerController.writeObject(pathName, users);
                            System.out.println("User updated successfully");
                        } else
                            System.out.println("User not found");

                        System.out.println("---------------------------------------");
                    } else {
                        System.out.println("File not found");
                    }

                    System.out.println();
                    break;
                case 6:
                    if (Paths.get(pathName) != null) {
                        users = FileHandlerController.readObject(pathName);

                        Collections.sort(users, new Comparator<User>() {
                            public int compare(User u1, User u2) {
                                return u1.getId() - u2.getId();
                            }
                        });

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
                case 7:
                    if (Paths.get(pathName) != null) {
                        users = FileHandlerController.readObject(pathName);

                        Collections.sort(users, new Comparator<User>() {
                            public int compare(User u1, User u2) {
                                return u1.getName().compareTo(u2.getName());
                            }
                        });

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
                default:
                    System.out.println("This number not found in Menu");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }

}
