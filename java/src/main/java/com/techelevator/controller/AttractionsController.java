package com.techelevator.controller;

import com.techelevator.dao.AttractionsDao;
import com.techelevator.model.Attractions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

@RequestMapping (path = "/addAttraction", method = RequestMethod.POST)
  public boolean addAttraction (@RequestBody Attractions attraction) {
   return dao.addAttraction(attraction);
}

@RequestMapping (path = "/editAttraction", method = RequestMethod.PUT)
  public boolean editAttraction (@RequestBody Attractions attraction) {

    return dao.updateAttraction(attraction); }

  @RequestMapping (path = "/puppy/{id}", method = RequestMethod.DELETE)
  public int deleteAttraction (@PathVariable int id) {
    return dao.deleteAttraction(id);
  }

}
