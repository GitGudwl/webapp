package com.ticketstore.webapp.Dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ticketstore.webapp.model.Concert;

@Repository
@Transactional
public class ConcertDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertConcert(String name, Date date, String venuename) {
        if (inputCheck(name, venuename)) {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("InsertConcert");
            SqlParameterSource in = new MapSqlParameterSource().addValue("NAMA", name)
                    .addValue("DATEE", date).addValue("VENNAME", venuename);
            jdbcCall.execute(in);
            return true;
        }
        return false;
    }

    public List<Concert> test() {
        String sql = "SELECT * FROM CONCERT";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Concert.class));
    }

    public boolean inputCheck(String name, String venuename) {
        if (name.equals("") || venuename.equals("")) {
            return false;
        }
        return true;
    }

    public String getVenueID(String venueName) {
        String sql = "SELECT ID FROM VENUE WHERE VENUE_NAME = ?";
        return jdbcTemplate.queryForObject(sql, String.class, venueName);
    }
}
