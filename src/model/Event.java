package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import enums.Category;

public class Event implements Serializable {
    private int id;
    private String name;
    private String address;
    private LocalDate date;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private String description;
    private boolean free;
    private double price;
    private Category category;
    private String userIds;

    public Event(int id, String name, String address, LocalDate date, LocalTime timeStart, LocalTime timeEnd,
            String description, boolean free, double price, Category category, String userIds) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.description = description;
        this.free = free;
        this.price = price;
        this.category = category;
        this.userIds = userIds;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t\t" + address + "\t\t\t" + date + "\t" + timeStart + "\t" + timeEnd + "\t"
                + description + "\t" + free + "\t" + price + "\t" + category + "\t" + userIds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFree() {
        return free;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getUserIds() {
        return userIds;
    }

}
