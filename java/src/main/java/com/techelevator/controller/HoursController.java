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

    @RequestMapping(path = "/{id}/hours", method = RequestMethod.GET)
    public Hours getHoursById (@PathVariable int id) {
        return dao.getHoursByAttractionId(id);
    }


}
