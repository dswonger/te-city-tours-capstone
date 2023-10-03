package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Attractions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcAttractionsDaoTests extends BaseDaoTests {

    protected static final Attractions ATTRACTION_1 = new Attractions (1, "National Gallery of Art", "Constitution Ave. NW, Washington, DC 20565",
            "The National Gallery of Art, and its attached Sculpture Garden, is a national art museum in Washington, D.C., United States, located on the National Mall, between 3rd and 9th Streets, at Constitution Avenue NW.",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQEzfvN0a5h2kRsyhpJSIw9eSqB13fYogK3dBN0hZNikc17k-1q", "Museum");

    protected static final Attractions ATTRACTION_2 = new Attractions (2,"Smithsonian National Museum of Natural History", "10th St. & Constitution Ave. NW, Washington, DC 20560", "The National Museum of Natural History is a natural history museum administered by the Smithsonian Institution, located on the National Mall in Washington, D.C., United States. It has free admission and is open 364 days a year. In 2022, with 3.9 million visitors, it was the most-visited museum in the United States.",
            "https://t1.gstatic.com/images?q=tbn:ANd9GcRc1umdEPTXUzw3bKF4m4ZJgLmxGC7zKz__UcPtKBdM1uebBj0i", "Museum");

    protected static final Attractions ATTRACTION_3 = new Attractions (3, "National Air and Space Museum", "600 Independence Ave SW, Washington, DC 20560", "The National Air and Space Museum of the Smithsonian Institution, is a museum in Washington, D.C., in the United States dedicated to human flight and space exploration. Established in 1946 as the National Air Museum, its main building opened on the National Mall near L'Enfant Plaza in 1976.",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRM7rHKDn4KhbnAfv2otT-knCvYfzqfSA8GdO5eWkSMHRbdWS0z", "Museum");

    protected static final Attractions ATTRACTION_4 = new Attractions (4,"United States Holocaust Memorial Museum", "100 Raoul Wallenberg Pl SW, Washington, DC 20024", "The United States Holocaust Memorial Museum is the United States'' official memorial to the Holocaust. Adjacent to the National Mall in Washington, D.C., the USHMM provides for the documentation, study, and interpretation of Holocaust history.",
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTYd6QSJ3mz8QUely6JXDS1FJEHHsPlW0oYxYqGne2BJ6tQMmY2", "Museum");

    JdbcAttractionsDao sut;

    @Before
    public void setup () {
     sut =   new JdbcAttractionsDao(dataSource);
    }

    @Test
    public void findAttractionsById (){

        Attractions inDB = sut.getAttractionById(1);
        AssertAttractionsMatch(ATTRACTION_1, inDB);


    }

    @Test
    public void getAllMuseums() {
        List<Attractions> museums = sut.getAllMuseums();
        AssertAttractionsMatch(ATTRACTION_1,museums.get(0));
        AssertAttractionsMatch(ATTRACTION_2, museums.get(1));
        AssertAttractionsMatch(ATTRACTION_3, museums.get(2));
    }
    @Test
    public void addAttraction () {
        Attractions newAttraction  = new Attractions("Random name", "Random address", "Random description", "Random type");
        Attractions inDb = sut.addAttraction(newAttraction);
        AssertInsertWorks(newAttraction, inDb);

    }


    public void AssertAttractionsMatch (Attractions expected, Attractions result) {
        Assert.assertEquals(expected.getId(),result.getId());
        Assert.assertEquals(expected.getName(), result.getName());
        Assert.assertEquals(expected.getAddress(), result.getAddress());
        Assert.assertEquals(expected.getDescription(), result.getDescription());
        Assert.assertEquals(expected.getImage(), result.getImage());
        Assert.assertEquals(expected.getType(),result.getType());

    }

    public void AssertInsertWorks (Attractions expect, Attractions res) {
        Assert.assertEquals(expect.getName(), res.getName());
        Assert.assertEquals(expect.getDescription(), res.getDescription());
        Assert.assertEquals(expect.getAddress(), res.getAddress());
        Assert.assertEquals(expect.getType(), res.getType());
    }
}
