package com.techelevator.controller;

import com.techelevator.dao.MuseumDao;
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
public class MuseumController {
@Autowired
MuseumDao dao;

  @RequestMapping (path="/allMuseums", method = RequestMethod.GET)
    public List<Museum> getAllMuseums () {
      return dao.allMuseumsList();
  }

  @RequestMapping (path="/addMuseums", method = RequestMethod.POST)
  public Museum addMuseum (Museum newMuseum) {

    return dao.addNewMuseum(newMuseum);
  }
@RequestMapping (path = "/updateById", method = RequestMethod.PUT)
  public boolean updateMuseumById (Museum newMuseum) {
    return dao.updateMuseum(newMuseum);
}
@RequestMapping (path = "/deleteMuseumById", method = RequestMethod.DELETE)
  public boolean deleteMuseumById (int museumId) {
    return dao.deleteMuseum(museumId);
}
}
