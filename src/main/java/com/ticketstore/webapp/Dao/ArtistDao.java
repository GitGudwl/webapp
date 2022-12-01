package com.ticketstore.webapp.Dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.ticketstore.webapp.model.Artist;
import com.ticketstore.webapp.model.Genre;
import com.ticketstore.webapp.Dao.GenreDao;

@Repository
@Transactional
public class ArtistDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    GenreDao genreDao = new GenreDao();

    

    public void insertArtist(String artistName, String genre) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("INSERTARTIST");
        SqlParameterSource in = new MapSqlParameterSource().addValue("ART_ARTIST_NAME", artistName)
                .addValue("ART_GENRE_NAME", genre);
        jdbcCall.execute(in);

    }
}
