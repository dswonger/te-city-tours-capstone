package com.techelevator.dao;


import com.techelevator.model.Hours;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcHoursDao implements HoursDao {

    private JdbcTemplate template;

    public JdbcHoursDao (JdbcTemplate template) {
        this.template = template;
    }
    @Override
    public Hours getHoursByAttractionId(int id) {
        Hours attractionHours = new Hours();

        String sql = "SELECT attractions.name, attraction_id, mon_open, tues_open, wed_open, thurs_open, fri_open, sat_open, sun_open, " +
                " mon_close, tues_close, wed_close, thurs_close, fri_close, sat_close, sun_close FROM hour_day JOIN attractions ON attractions.id = hour_day.attraction_id " +
                "WHERE attraction_id = ? ";

        SqlRowSet results = template.queryForRowSet(sql,id);

        if (results.next()) {
            attractionHours = mapRowToHours(results);
        }

        return attractionHours;

    }



    @Override
    public boolean addHours(Hours addHours) {
        return false;
    }

    @Override
    public boolean updateHours(String day, Hours newHours) {
        return false;
    }

    @Override
    public int deleteHours(int id) {
        return 0;
    }


    public Hours mapRowToHours (SqlRowSet results) {
        Hours attractionHours = new Hours();
        attractionHours.setAttractionName(results.getString("name"));
        attractionHours.setAttractionId(results.getInt("attraction_id"));
        attractionHours.setMondayOpen(results.getString("mon_open"));
        attractionHours.setMondayClose(results.getString("mon_close"));
        attractionHours.setTuesdayOpen(results.getString("tues_open"));
        attractionHours.setTuesdayClose(results.getString("tues_close"));
        attractionHours.setWednesdayOpen(results.getString("wed_open"));
        attractionHours.setWednesdayClose(results.getString("wed_close"));
        attractionHours.setThursdayOpen(results.getString("thurs_open"));
        attractionHours.setThursdayClose(results.getString("thurs_close"));
        attractionHours.setFridayOpen(results.getString("fri_open"));
        attractionHours.setFridayClose(results.getString("fri_close"));
        attractionHours.setSaturdayOpen(results.getString("sat_open"));
        attractionHours.setSaturdayClose(results.getString("sat_close"));
        attractionHours.setSundayOpen(results.getString("sun_open"));
        attractionHours.setSundayClose(results.getString("sun_close"));

     return attractionHours;
    }

}
