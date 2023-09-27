package com.techelevator.model;

import java.util.List;

public class Itinerary {
    private int id;
    private int startingPoint;
    private List<Integer> locations;
    private String Date;
    private int userId;

    public Itinerary() {}

    public Itinerary(int id, int startingPoint, List<Integer> locations, String date, int userId) {
        this.id = id;
        this.startingPoint = startingPoint;
        this.locations = locations;
        Date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(int startingPoint) {
        this.startingPoint = startingPoint;
    }

    public List<Integer> getLocations() {
        return locations;
    }

    public void setLocations(List<Integer> locations) {
        this.locations = locations;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
