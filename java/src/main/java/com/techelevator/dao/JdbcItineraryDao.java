package com.techelevator.dao;

import com.techelevator.model.Attractions;
import com.techelevator.model.Itinerary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class JdbcItineraryDao implements ItineraryDao {
    private JdbcTemplate template;

    public JdbcItineraryDao (DataSource source) {
        template = new JdbcTemplate(source);
    }

    @Override
    public List<Itinerary> getAllItineraries() {
        String sql = "SELECT * FROM itinerary;";
        SqlRowSet res = template.queryForRowSet(sql);
        List <Itinerary> allItineraries = new ArrayList<>();
        while (res.next()){
            Itinerary itinerary = mapToRowsetItinerary(res);

            allItineraries.add(itinerary);
        }

        return allItineraries;
    }

    @Override
    public Itinerary getItineraryById(int id) {
        Itinerary itinerary = null;
        String sql = "SELECT * FROM itinerary WHERE itinerary = ?;";
        SqlRowSet res = template.queryForRowSet(sql, id);
        if(res.next()){
           itinerary = mapToRowsetItinerary(res);

        }
        return itinerary;
    }

    @Override
    public Itinerary createItinerary(Itinerary itinerary) {
        Itinerary newItinerary =null;
        String sql = "INSERT INTO itinerary (location_id,starting_point,date_of_itinerary,user_id) " +
                "VALUES ( ?,?,?,?) RETURNING itinerary_id;";

            Integer newItineraryId = template.queryForObject(sql, Integer.class,
                    itinerary.getLocations(), itinerary.getStartingPoint(),
                    itinerary.getDate(), itinerary.getUserId());
            newItinerary = getItineraryById(newItineraryId);

        return newItinerary;
    }

    @Override
    public Itinerary updateItinerary(Itinerary itinerary) {
        Itinerary editItinerary = null;
        String sql = "UPDATE itinerary SET location_id = ?, Starting_point = ?, Date_of_itinerary = ?, user_id = ? " +
                "WHERE itinerary_id =?;";

        int numberOfRow = template.update(sql, itinerary.getLocations(),
                itinerary.getStartingPoint(), itinerary.getDate(), itinerary.getUserId(), itinerary.getId());
        if (numberOfRow == 0) {
            throw new DaoException("Zero rows affected, expected at least one");
        }else{
            editItinerary = getItineraryById(itinerary.getId());
        }
        return editItinerary;
    }

    @Override
    public int deleteItinerary(int id) {
        String sql = "DELETE FROM itinerary WHERE id = ?;";
        int numberOfRows= template.update(sql,id);
        return numberOfRows;
    }

    private Itinerary mapToRowsetItinerary(SqlRowSet res) {
        Itinerary itinerary = new Itinerary();
        itinerary.setId(res.getInt("id"));
        itinerary.setStartingPoint(res.getInt("starting_point"));
        itinerary.setDate(res.getString("data"));
        itinerary.setUserId(res.getInt("user_id"));

        List<Integer> locationIds = new ArrayList<>();
        while (res.next()) {
            int locationId = res.getInt("location_id"); // Retrieve location_id from ResultSet
            locationIds.add(locationId);
        }
        itinerary.setLocations(locationIds);

        return itinerary;
    }
}
