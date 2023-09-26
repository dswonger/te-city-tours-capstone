package com.techelevator.dao;

import com.techelevator.model.Monuments;
import com.techelevator.model.User;
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
        String sql = "select * from monuments";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Monuments monument = mapRowToUser(results);
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


    private Monuments mapRowToUser(SqlRowSet rs) {
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
