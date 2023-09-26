package com.techelevator.controller;

import com.techelevator.dao.MonumentsDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated()")
public class MonumentsController {
    private MonumentsDao monumentsDao;
    public MonumentsController( MonumentsDao monumentsDao){
        this.monumentsDao = monumentsDao;

    }

}
