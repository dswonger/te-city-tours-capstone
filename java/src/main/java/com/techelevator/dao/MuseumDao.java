package com.techelevator.dao;

import com.techelevator.model.Museum;

import java.util.List;

public interface MuseumDao {

    List<Museum> allMuseumsList ();

    Museum addNewMuseum (Museum newMuseum);
}
