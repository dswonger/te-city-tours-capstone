package com.techelevator.model;

public class Attractions {

    private String name;
    private int id;
    private String description;
    private String availableDay;
    private String availableHours;
    private double rate;
    private String review;

    public Attractions(int id, String name, String description, String availableDay, String availableHours, double rate, String review) {
        this.name = name;
        this.id =id;
        this.description = description;
        this.availableDay = availableDay;
        this.availableHours = availableHours;
        this.rate = rate;
        this.review = review;
    }

    public Attractions () {

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

    public String getAvailableDay() {
        return availableDay;
    }

    public void setAvailableDay(String availableDay) {
        this.availableDay = availableDay;
    }

    public String getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(String availableHours) {
        this.availableHours = availableHours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
