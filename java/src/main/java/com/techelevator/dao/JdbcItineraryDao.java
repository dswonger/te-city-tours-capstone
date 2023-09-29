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
    public List<Itinerary> getAllItineraries( int id) {
        String sql = "SELECT * FROM itinerary WHERE user_id = ?;";
        SqlRowSet res = template.queryForRowSet(sql,id);
        List <Itinerary> allItineraries = new ArrayList<>();
        while (res.next()){
            Itinerary itinerary = mapToRowsetItinerary(res);
            // get list of attractions with itinerary Id
            itinerary.setLocations(getAttractions(itinerary.getId()));

            allItineraries.add(itinerary);
        }

        return allItineraries;
    }

    @Override
    public Itinerary getItineraryById(int id) {
        Itinerary itinerary = null;
        String sql = "SELECT * FROM itinerary WHERE user_id = ?;";
        SqlRowSet res = template.queryForRowSet(sql, id);
        if(res.next()){
           itinerary = mapToRowsetItinerary(res);
           // get list of attractions with itinerary Id
           itinerary.setLocations(getAttractions(itinerary.getId()));
        }
        return itinerary;
    }

    // Get list of attractions' id associates with target itinerary
    private List<Attractions> getAttractions(int itineraryId) {
        String sql = "SELECT * FROM attractions a JOIN itinerary_attraction b ON a.id = b.attraction_id  WHERE b.itinerary_id = ?";
        SqlRowSet res = template.queryForRowSet(sql, itineraryId);

        List<Attractions> attractionList = new ArrayList<>();
        while (res.next()) {
            attractionList.add(mapToRowsetAttractions(res));
        }

        return attractionList;
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
    public Itinerary updateItinerary(Itinerary itinerary, int userId) {
        Itinerary target = getItineraryById(itinerary.getId());

        if (userId == target.getUserId()) {
            Itinerary editItinerary = null;
            String sql = "UPDATE itinerary SET location_id = ?, Starting_point = ?, Date_of_itinerary = ? " +
                    "WHERE itinerary_id =?;";

            int numberOfRow = template.update(sql, itinerary.getLocations(),
                    itinerary.getStartingPoint(), itinerary.getDate(), itinerary.getId());
            if (numberOfRow == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            }else{
                editItinerary = getItineraryById(itinerary.getId());
            }
            return editItinerary;
        } else {
            throw new DaoException("Unauthorized to edit this object");
        }
    }

    @Override
    public int deleteItinerary(int id, int userId) {
        Itinerary target = getItineraryById(id);

        if (userId == target.getUserId()) {
            String sql = "DELETE FROM itinerary WHERE id = ?;";
            int numberOfRows= template.update(sql,id);
            return numberOfRows;
        } else {
            throw new DaoException("Unauthorized to edit this object");
        }
    }

    private Itinerary mapToRowsetItinerary(SqlRowSet res) {
        Itinerary itinerary = new Itinerary();
        itinerary.setId(res.getInt("id"));
        itinerary.setStartingPoint(res.getInt("starting_point"));
        itinerary.setDate(res.getString("data"));
        itinerary.setUserId(res.getInt("user_id"));

        return itinerary;
    }

    private Attractions mapToRowsetAttractions(SqlRowSet res) {
        Attractions att = new Attractions();

        att.setAddress(res.getString("address"));
        att.setDescription(res.getString("description"));
        att.setId(res.getInt("id"));
        att.setImage(res.getString("image"));
        att.setName(res.getString("name"));
        att.setRate(res.getInt("rate"));
        att.setType(res.getString("type"));

        return att;
    }

    @Override
    public void addAttraction (int itineraryId, int attractionId){
        String sql = "INSERT INTO itinerary_attraction (attraction_id,  itinerary_id) VALUES (?,?);";
        SqlRowSet res = template.queryForRowSet(sql,attractionId, itineraryId);

        if (!res.next()) {
            throw new DaoException("Failed to add Attraction to Itinerary");
        }
    };

    @Override
    public void removeAttraction (int itineraryId, int attractionId){
        String sql = "DELETE FROM itinerary_attraction WHERE attraction_id = ? AND itinerary_id =?;";
        SqlRowSet res = template.queryForRowSet(sql,attractionId, itineraryId);

        if (!res.next()) {
            throw new DaoException("Failed to add Attraction to Itinerary");
        }
    };
}
