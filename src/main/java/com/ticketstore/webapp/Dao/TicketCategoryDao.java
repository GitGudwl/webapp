package com.ticketstore.webapp.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TicketCategoryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertTicketCategory(String Description, Number price, String concertId, Number stock) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("INSERTTICKETCATEGORY");
        SqlParameterSource in = new MapSqlParameterSource().addValue("DESCRIP", Description)
                .addValue("PRICEE", price)
                .addValue("CONCID", concertId).addValue("stck", stock);
        jdbcCall.execute(in);
    }


}
