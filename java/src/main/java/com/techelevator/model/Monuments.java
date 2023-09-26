package com.techelevator.model;

public class Monuments extends Attractions {
    private String yearBuilt;


    public Monuments(int id,String name, String description, String city) {
        super(id, name, description, city);
    }
    public Monuments(){
        super(0, "", "", "");
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
}
