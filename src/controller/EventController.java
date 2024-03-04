package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import enums.Category;
import model.Event;
import model.User;

public class EventController {

    public static void handleEvent() throws FileNotFoundException, IOException, ClassNotFoundException {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Event> events = new ArrayList<Event>();
        ListIterator li = null;

        String pathName = "src/database/event.data";

        do {
            System.out.println();
            System.out.println("---- EVENT AREA ----");
            System.out.println("1. INSERT");
            System.out.println("2. DISPLAY");
            System.out.println("3. SEARCH By Name or Address");
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
                    System.out.print("How many events you want: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Address: ");
                        String address = scanner.nextLine();

                        System.out.print("Date (yyyy-MM-dd): ");
                        String dateString = scanner.nextLine();

                        System.out.print("Time start (HH:mm:ss): ");
                        String timeStartString = scanner.nextLine();

                        System.out.print("Time end (HH:mm:ss): ");
                        String timeEndString = scanner.nextLine();

                        System.out.print("Description: ");
                        String description = scanner.nextLine();

                        System.out.print("Free [Y/N]: ");
                        String freeString = scanner.nextLine();

                        System.out.print("Price: ");
                        Double price = scanner.nextDouble();

                        System.out.print("Category (FESTAS[F], EVENTOS_ESPORTIVOS[E], SHOWS)[S]: ");
                        String categoryString = scanner.nextLine();
                        scanner.nextLine();

                        System.out.print("ID of users who will participate in the event (separated by commas): ");
                        String userIds = scanner.nextLine();
                        System.out.println();

                        Event lastEvent = null;
                        if (!events.isEmpty()) {
                            lastEvent = events.get((events.size() - 1));
                        }
                        int eventId = lastEvent != null ? lastEvent.getId() + 1 : 1;

                        boolean free = false;
                        if (freeString.toLowerCase() == "y") {
                            price = 0.0;
                            free = true;
                        }

                        Category category = null;
                        switch (categoryString.toLowerCase()) {
                            case "f":
                                category = Category.FESTAS;
                                break;
                            case "e":
                                category = Category.EVENTOS_ESPORTIVOS;
                                break;
                            case "s":
                                category = Category.SHOWS;
                                break;
                            default:
                                category = Category.FESTAS;
                                break;
                        }

                        LocalDate date = null;
                        if (dateString != null) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            date = LocalDate.parse(dateString, formatter);
                        }

                        LocalTime timeStart = null;
                        if (timeStartString != null) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            timeStart = LocalTime.parse(timeStartString, formatter);
                        }

                        LocalTime timeEnd = null;
                        if (timeEndString != null) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            timeEnd = LocalTime.parse(timeEndString, formatter);
                        }

                        events.add(new Event(eventId, name, address, date, timeStart, timeEnd, description, free,
                                price, category, userIds));

                    }

                    FileHandlerController.writeObject(pathName, events);

                    break;

                case 2:
                    if (Paths.get(pathName) != null) {
                        events = FileHandlerController.readObject(pathName);
                        System.out.println();
                        System.out.println("------------- Event LIST -------------");

                        li = events.listIterator();
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
                        events = FileHandlerController.readObject(pathName);

                        boolean found = false;
                        System.out.print("Enter your search: ");
                        scanner.nextLine();
                        String search = scanner.nextLine();
                        System.out.println("");

                        System.out.println("---------------------------------------");
                        li = events.listIterator();
                        while (li.hasNext()) {
                            Event event = (Event) li.next();
                            if (
                                event.getName().equalsIgnoreCase(search) ||
                                event.getAddress().equalsIgnoreCase(search)
                            ) {
                                System.out.println(event);
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

                default:
                    System.out.println("This number not found in Menu");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
}
