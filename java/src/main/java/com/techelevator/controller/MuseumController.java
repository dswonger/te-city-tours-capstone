package com.techelevator.controller;

import com.techelevator.dao.MuseumDao;
import com.techelevator.model.Museum;
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

}
