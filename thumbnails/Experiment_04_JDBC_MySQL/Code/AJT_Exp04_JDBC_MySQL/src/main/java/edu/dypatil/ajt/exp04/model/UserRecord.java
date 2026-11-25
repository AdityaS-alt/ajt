package edu.dypatil.ajt.exp04.model;

public class UserRecord {
    private final int id;
    private final String name;
    private final String email;

    public UserRecord(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

