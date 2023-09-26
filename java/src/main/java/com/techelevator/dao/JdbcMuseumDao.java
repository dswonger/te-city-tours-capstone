package com.techelevator.dao;

import com.techelevator.model.Museum;
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

    public List<Museum> allMuseumsList () {
        List <Museum> allMuseums = new ArrayList<>();
        String sql = "SELECT * FROM MUSEUMS;";
        SqlRowSet museumSqlResults = this.template.queryForRowSet(sql);
        while (museumSqlResults.next()) {
            Museum eachMuseum = mapRowToMuseum(museumSqlResults);

            allMuseums.add(eachMuseum);
        }

        return allMuseums;

    }

    private Museum mapRowToMuseum (SqlRowSet results) {
        Museum museum = new Museum();
        museum.setId(results.getInt("museum_id"));
        museum.setName(results.getString("museum_name"));
        museum.setMuseumType(results.getString("museum_type"));
        return museum;

    }
}
