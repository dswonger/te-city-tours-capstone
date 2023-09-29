package com.techelevator.dao;

import com.techelevator.model.Attractions;

import java.util.List;

public interface AttractionsDao {

    public List<Attractions> getAllMuseums ();
    public List<Attractions> getAllMonuments ();

    public boolean addAttraction (Attractions newAttraction);
    public boolean updateAttraction(Attractions updatedAttraction);
    public int deleteAttraction(int id);

}
