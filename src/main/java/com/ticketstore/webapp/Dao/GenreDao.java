package com.ticketstore.webapp.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ticketstore.webapp.model.Genre;

@Repository
@Transactional
public class GenreDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Genre> list() {
        String sql = "SELECT * FROM GENRE";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Genre.class));
    }

    public void insertGenre(String genre_name) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("INSERTGENRE");
        jdbcCall.execute(genre_name);
    }

}
