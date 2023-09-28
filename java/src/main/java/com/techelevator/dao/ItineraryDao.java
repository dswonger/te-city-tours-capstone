package com.techelevator.dao;

import com.techelevator.model.Attractions;
import com.techelevator.model.Itinerary;

import java.util.List;

public interface ItineraryDao {

    public List<Itinerary> getAllItineraries ();
    public Itinerary getItineraryById ( int id);
    public Itinerary createItinerary ( Itinerary itinerary);
    public Itinerary updateItinerary ( Itinerary itinerary);
    public int deleteItinerary ( int id );


}
