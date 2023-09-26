package com.techelevator.service;

import com.techelevator.dao.MuseumDao;
import com.techelevator.model.Museum;

import java.util.List;

public class MuseumService {
    private MuseumDao museumDao;

    public MuseumService (MuseumDao museumDao) {
        this.museumDao = museumDao;
    }


    public List<Museum> getAllMuseums ()
    {
       List<Museum>allMuseums = museumDao.allMuseumsList();
       return  allMuseums;
    }



}
