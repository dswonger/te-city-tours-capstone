package com.techelevator.dao;

import java.util.List;

public interface MuseumDao {

    List<Museum> allMuseumsList ();

    Museum addNewMuseum (Museum newMuseum);

    boolean updateMuseum (Museum updatedMuseum);

    boolean deleteMuseum (int museumId);

}
