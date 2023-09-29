package com.techelevator.controller;

import com.techelevator.dao.HoursDao;
import com.techelevator.model.Hours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HoursController {
    @Autowired
    HoursDao dao;

    @RequestMapping (path= "/getAllMuseumHours", method = RequestMethod.GET)
    public List<Hours> getAllMuseumHours () {
       return dao.getAllMuseumHours();
    }

    @RequestMapping (path = "/getAllMonumentHours", method = RequestMethod.GET)
    public List <Hours> getAllMonumentHours () {
        return dao.getAllMonumentHours();
    }
    @RequestMapping(path = "/hours/{id}", method = RequestMethod.GET)
    public Hours getHoursById (@PathVariable int id) {
        return dao.getHoursByAttractionId(id);
}
}
