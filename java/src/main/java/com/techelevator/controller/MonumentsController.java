package com.techelevator.controller;

import com.techelevator.dao.MonumentsDao;
import com.techelevator.model.Monuments;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class MonumentsController {
    private MonumentsDao monumentsDao;
    public MonumentsController( MonumentsDao monumentsDao){
        this.monumentsDao = monumentsDao;

    }
    @RequestMapping(path ="/monuments")
    public List<Monuments> getAllMonuments(){
        return monumentsDao.listAll();
    }

}
