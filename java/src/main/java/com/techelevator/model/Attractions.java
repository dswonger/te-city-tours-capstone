package com.techelevator.model;

public class Attractions {

    private String name;
    private int id;
    private String description;



    public Attractions(int id, String name, String description) {
        this.name = name;
        this.id =id;
        this.description = description;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
