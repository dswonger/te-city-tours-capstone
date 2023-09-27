package com.techelevator.dao;

import com.techelevator.model.Attractions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcAttractionsDao implements AttractionsDao{

    private JdbcTemplate template;

    public JdbcAttractionsDao (DataSource source) {
        template = new JdbcTemplate(source);
    }


    @Override
    public List<Attractions> getAllMuseums() {
        String sql = "SELECT * FROM attractions WHERE type = Museum;";
        SqlRowSet results = template.queryForRowSet(sql);
        List <Attractions> allMuseums = new ArrayList<>();
        while (results.next()){
            Attractions museum = mapRowToAttractions(results);

            allMuseums.add(museum);
        }

    return allMuseums;
    }

    @Override
    public List<Attractions> getAllMonuments() {
        String sql = "SELECT * FROM attractions WHERE type = Monument;";
        SqlRowSet results = template.queryForRowSet(sql);
        List <Attractions> allMonuments = new ArrayList<>();
        while (results.next()){
            Attractions monument = mapRowToAttractions(results);

            allMonuments.add(monument);
        }

        return allMonuments;

    }

    @Override
    public Attractions addAttraction() {
        return null;
    }

    @Override
    public Attractions updateAttraction() {
        return null;
    }

    @Override
    public int deleteAttraction(int id) {
        String sql = "DELETE FROM attractions WHERE id = ?;";
        int numberOfRows= template.update(sql,id);
        return numberOfRows;
    }

    public Attractions mapRowToAttractions (SqlRowSet results) {
        Attractions attraction = new Attractions();
        attraction.setAddress(results.getString("address"));
        attraction.setDescription(results.getString("description"));
        attraction.setImage(results.getString("image"));
        attraction.setName(results.getString("name"));
        attraction.setType(results.getString("type"));
        attraction.setId(results.getInt("id"));

        return attraction;
    }
}
