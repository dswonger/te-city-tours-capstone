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
  @PreAuthorize("hasRole('USER', 'ADMIN')")
  @RequestMapping (path="/allMuseums", method = RequestMethod.GET)
    public List<Attractions> getAllMuseums () {
      return dao.getAllMuseums();
  }
  @PreAuthorize("hasRole('USER', 'ADMIN')")
  @RequestMapping (path="/allMonuments", method = RequestMethod.GET)
  public List<Attractions> getAllMonuments () {
    return dao.getAllMonuments();
  }
  @PreAuthorize("hasRole('USER', 'ADMIN')")
  @RequestMapping (path = "/addAttraction", method = RequestMethod.POST)
  public boolean addAttraction (@RequestBody Attractions attraction) {
   return dao.addAttraction(attraction);
}
  @PreAuthorize("hasRole('ADMIN')")
  @RequestMapping (path = "/editAttraction", method = RequestMethod.PUT)
  public boolean editAttraction (@RequestBody Attractions attraction) {

    return dao.updateAttraction(attraction); }
  @PreAuthorize("hasRole('ADMIN')")
  @RequestMapping (path = "/attractions/{id}", method = RequestMethod.DELETE)
  public int deleteAttraction (@PathVariable int id) {
    return dao.deleteAttraction(id);
  }

}
