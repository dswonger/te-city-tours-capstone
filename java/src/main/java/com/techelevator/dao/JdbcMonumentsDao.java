package com.techelevator.dao;

import com.techelevator.model.Monuments;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcMonumentsDao implements MonumentsDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcMonumentsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Monuments> listAll() {
        List<Monuments> monuments = new ArrayList<>();
        String sql = "SELECT * from monuments";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Monuments monument = mapRowToMonument(results);
            monuments.add(monument);
        }

        return monuments;
    }

    @Override
    public Monuments getMonumentByName(String name) throws NameNotFoundException {
        if (name == null) throw new IllegalArgumentException("Username cannot be null");
        for ( Monuments monument : this.listAll()){
            if( monument.getName().equalsIgnoreCase(name)){
                return monument;
            }
        }
        throw new NameNotFoundException("Monument " + name + " was not found.");
    }

    @Override
    public Monuments getMonumentById(int id) {
        Monuments monument = null;
        String sql = "SELECT monuments WHERE monument_id = ?;";
        try {
            SqlRowSet res = jdbcTemplate.queryForRowSet(sql,id);
            if(res.next()){
               monument = mapRowToMonument(res);

            }
        }catch( CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server ordatabase", e);
        }
        return monument;
    }

    @Override
    public Monuments createMonument(Monuments monument) {
        Monuments newMonument = null;
        String sql = " INSERT INTO monuments (name,description, year_built,city) " +
                "VALUES(?,?,?) Returning monument_id;";
        try {
            Integer newMonumentId = jdbcTemplate.queryForObject(sql, Integer.class,monument.getYearBuilt(),monument.getName(),monument.getDescription());
            newMonument = getMonumentbyId(newMonumentId);
        }catch (CannotGetJdbcConnectionException e) {
        throw new DaoException("ERROR: Unable to connect to server or DB", e);
    }catch (DataIntegrityViolationException e){
        throw new DaoException("ERROR: Data Integrity Violation", e);
    }
        return newMonument;
    }
    @Override
    public Monuments updateMonument(Monuments monument) {
        Monuments updateMonument = null;
        String sql = " UPDATE monuments SET name = ?, description = ?, year_built = ? WHERE monument_di = ?;";
        try {
            int numberOfMonument = jdbcTemplate.update(sql,monument.getName(), monument.getDescription(),monument.getYearBuilt());
            if(numberOfMonument ==0){
                throw new DaoException("Zero row affected, expected at least one");
            }else{
                updateMonument =getMonumentbyId(monument.getId());
            }
        }catch(BadSqlGrammarException e){
            throw new DaoException("SQL syntax error",e);
        } catch( CannotGetJdbcConnectionException e){
            throw new DaoException("ERROR: Unable to connect to server or DB", e);
        }catch (DataIntegrityViolationException e){
            throw new DaoException("ERROR: Data Integrity Violation", e);
        }

        return updateMonument;
    }

    @Override
    public int deleteMonumentbyId(int id) {
        int numberOfRow = 0;
        String sql = "DELETE from monument WHERE monument_id = ?;";
        try{

            numberOfRow =jdbcTemplate.update(sql,id);
        }catch(BadSqlGrammarException e){
            throw new DaoException("SQL syntax error",e);
        } catch( CannotGetJdbcConnectionException e){
            throw new DaoException("ERROR: Unable to connect to server or DB", e);
        }catch (DataIntegrityViolationException e){
            throw new DaoException("ERROR: Data Integrity Violation", e);
        }
        return numberOfRow;

    }


    private Monuments mapRowToMonument(SqlRowSet rs) {
        Monuments monument = new Monuments();
        monument.setId(rs.getInt("monument_id"));
        monument.setName(rs.getString("name"));
        monument.setDescription(rs.getString("description"));
        monument.setAvailableDay(rs.getString("available_days"));
        monument.setAvailableHours(rs.getString("available_hours"));
        monument.setYearBuilt(rs.getString("year_built"));
        monument.setRate(rs.getDouble("rate"));
        monument.setReview(rs.getString("review"));

        return monument;
    }
}
