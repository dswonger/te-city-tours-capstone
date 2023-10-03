package com.techelevator.model.ItineraryDto;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class CreateItineraryDto {
    private Date date;
    @NotEmpty
    private String name;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
