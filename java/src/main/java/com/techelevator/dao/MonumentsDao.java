package com.techelevator.dao;

import com.techelevator.model.Monuments;

import javax.naming.NameNotFoundException;
import java.util.List;

public interface MonumentsDao {
    List<Monuments> listAll();
    Monuments getMonumentByName(String name) throws NameNotFoundException;


}
