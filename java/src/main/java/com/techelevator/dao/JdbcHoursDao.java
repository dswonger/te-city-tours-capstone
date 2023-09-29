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

        String sql = "SELECT attraction_id, mon_open, tues_open, wed_open, thurs_open, fri_open, sat_open, sun_open, " +
                "mon_close, tues_close, wed_close, thurs_close, fri_close, sat_close, sun_close FROM hour_day " +
                "WHERE attraction_id = ?;";

        SqlRowSet results = template.queryForRowSet(sql,id);

        if (results.next()) {
            attractionHours = mapRowToHours(results);
        }

        return attractionHours;

    }

    @Override
    public List<Hours> getAllMuseumHours() {
        List <Hours> allMuseumHours = new ArrayList<>();

      try {
          String sql = "SELECT attraction_id, mon_open, tues_open, wed_open, thurs_open, fri_open, sat_open, sun_open, " +
                  "mon_close, tues_close, wed_close, thurs_close, fri_close, sat_close, sun_close FROM hour_day JOIN attractions ON attractions.id = hour_day.attraction_id " +
                  "WHERE type = 'Museum';";

          SqlRowSet results = template.queryForRowSet(sql);

          while (results.next()) {
              Hours eachAttractionHours = mapRowToHours(results);

              allMuseumHours.add(eachAttractionHours);
          }

      }catch (CannotGetJdbcConnectionException e) {

          throw new DaoException("Cannot connect to server or database", e);

      }

        return allMuseumHours;
    }

    @Override
    public List<Hours> getAllMonumentHours() {
        List <Hours> allMonumentHours = new ArrayList<>();

        try {
            String sql = "SELECT attraction_id, mon_open, tues_open, wed_open, thurs_open, fri_open, sat_open, sun_open, " +
                    "mon_close, tues_close, wed_close, thurs_close, fri_close, sat_close, sun_close FROM hour_day JOIN attractions ON attractions.id = hour_day.attraction_id " +
                    "WHERE type = 'Monument';";

            SqlRowSet results = template.queryForRowSet(sql);

            while (results.next()) {
                Hours eachAttractionHours = mapRowToHours(results);

                allMonumentHours.add(eachAttractionHours);
            }

        }catch (CannotGetJdbcConnectionException e) {

            throw new DaoException("Cannot connect to server or database", e);

        }

        return allMonumentHours;
    }


    public Hours mapRowToHours (SqlRowSet results) {
        Hours attractionHours = new Hours();
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
