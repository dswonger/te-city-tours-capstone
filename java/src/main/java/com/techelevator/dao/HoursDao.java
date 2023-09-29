package com.techelevator.dao;

import com.techelevator.model.Hours;

import java.util.List;

public interface HoursDao {

    public Hours getHoursByAttractionId (int id);

    public List<Hours> getAllMuseumHours ();

    public List <Hours> getAllMonumentHours();
}
