package org.example.entity;

public class Park extends BaseEntity {

    private String name;

    public String getParkName() {
        return name;
    }

    public void setParkName(String name) {
        this.name = name;
    }
}