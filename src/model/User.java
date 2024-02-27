package model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String lastName;
    private String email;

    public User(int id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String toString() {
        return id + "\t" + name + "\t\t" + lastName + "\t\t" + email;
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

    public String getEmail() {
        return email;
    }

    
}
