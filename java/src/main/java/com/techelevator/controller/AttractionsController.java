package com.techelevator.controller;

import com.techelevator.dao.AttractionsDao;
import com.techelevator.model.Attractions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AttractionsController {
  @Autowired
  AttractionsDao dao;
  @RequestMapping (path="/allMuseums", method = RequestMethod.GET)
    public List<Attractions> getAllMuseums () {
      return dao.getAllMuseums();
  }
  @RequestMapping (path="/allMonuments", method = RequestMethod.GET)
  public List<Attractions> getAllMonuments () {
    return dao.getAllMonuments();
  }


}
