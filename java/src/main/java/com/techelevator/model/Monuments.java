package com.techelevator.model;

public class Monuments extends Attractions {
    private String yearBuilt;


    public Monuments(int id,String name, String description, String availableDay, String availableHours, double rate, String review) {
        super(id, name, description, availableDay, availableHours, rate, review);
    }
    public Monuments(){
        super(0, "", "","","",0.0,
                "");
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
}
