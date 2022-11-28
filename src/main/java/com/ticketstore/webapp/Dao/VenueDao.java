package com.ticketstore.webapp.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ticketstore.webapp.model.Venue;

@Repository
@Transactional
public class VenueDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Venue> List() {
        String sql = "SELECT * FROM VENUE";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Venue.class));
    }

    public boolean checkVenue(String name, String location) {
        List<Venue> listvenue = List();
        for (Venue venue : listvenue) {
            if (venue.getVenue_name().equals(name) || venue.getLocation().equals(location)) {
                return false;
            }
        }
        return true;
    }

    public boolean insertVenue(String name, String Location, String Type, Number Capacity) {
        if (checkVenue(name, Location)) {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("INSERTVENUE");
            SqlParameterSource in = new MapSqlParameterSource().addValue("ven_venue_name", name)
                    .addValue("ven_location", Location)
                    .addValue("ven_type", Type)
                    .addValue("ven_capacity", Capacity);
            jdbcCall.execute(in);
            return true;

        } else {
            return false;
        }
    }

}
