package model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String lastName;
    private String phone;

    public User(int id, String name, String lastName, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t\t" + lastName + "\t\t" + phone;
    }
 
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    
}
