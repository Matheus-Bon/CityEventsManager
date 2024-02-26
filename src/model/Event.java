package model;

import java.time.LocalDate;
import java.time.LocalTime;

import enums.Category;

public class Event {
    private int id;
    private char name;
    private String address;
    private LocalDate date;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private String description;
    private boolean free;
    private double price;
    private Category category;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public char getName() {
        return name;
    }
    public void setName(char name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getTimeStart() {
        return timeStart;
    }
    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }
    public LocalTime getTimeEnd() {
        return timeEnd;
    }
    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
 
}
