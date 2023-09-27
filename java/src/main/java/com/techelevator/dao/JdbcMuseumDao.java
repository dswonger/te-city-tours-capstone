package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component


public class JdbcMuseumDao implements MuseumDao{

    private JdbcTemplate template;

    public JdbcMuseumDao (DataSource source) {
        template = new JdbcTemplate(source);
    }
    @Override
    public List<Museum> allMuseumsList () {

        String sql = "SELECT * FROM MUSEUMS;";
        SqlRowSet museumSqlResults = this.template.queryForRowSet(sql);

        List <Museum> allMuseums = new ArrayList<>();
        while (museumSqlResults.next()) {
            Museum eachMuseum = mapRowToMuseum(museumSqlResults);

            allMuseums.add(eachMuseum);
        }

        return allMuseums;

    }

    @Override
    public Museum addNewMuseum(Museum newMuseum) {
        String sql = "INSERT INTO museums (museum_name, museum_description, museum_type, clicked)" +
                " VALUES (?, ?, ?, ?) RETURNING museum_id";
        Integer newMuseumId = this.template.queryForObject(sql,Integer.class, newMuseum.getName(), newMuseum.getDescription(),
                newMuseum.getMuseumType(), false);
        newMuseum.setId(newMuseumId);
        return newMuseum;
    }

    @Override
    public boolean updateMuseum(Museum updatedMuseum) {
        String sql = "UPDATE museum SET museum_name = ?, museum_description = ?, museum_type = ? WHERE museum_id = ?" ;
        int numberOfRows = template.update(sql, Integer.class, updatedMuseum.getName(), updatedMuseum.getDescription(), updatedMuseum.getMuseumType(), updatedMuseum.getId());
        if (numberOfRows == 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean deleteMuseum(int museumId) {

        String sql ="DELETE FROM museums WHERE museum_id = ?;";
        int numberOfRows = template.update(sql, Integer.class, museumId);

        if (numberOfRows == 1 ) {
            return true;
        } else {
            return false;
        }
    }

    private Museum mapRowToMuseum (SqlRowSet results) {
        Museum museum = new Museum();
        museum.setId(results.getInt("museum_id"));
        museum.setName(results.getString("museum_name"));
        museum.setMuseumType(results.getString("museum_type"));
        return museum;

    }
}
