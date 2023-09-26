package com.techelevator.model;

public class Museum extends Attractions{

    private String museumType;

    public Museum(int id, String name, String description, String availableDay, String availableHours, double rate, String review) {
        super(id, name, description, availableDay, availableHours, rate, review);
    }

    public Museum () {
        super();

    }

    public String getMuseumType() {
        return museumType;
    }

    public void setMuseumType(String museumType) {
        this.museumType = museumType;
    }
}
