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

import com.ticketstore.webapp.model.Customer;

@Repository
@Transactional
public class CustomerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer login(String username, String Password) {
        return null;
    }

    public List<Customer> test() {
        String sql = "SELECT * FROM CUSTOMER";
        List<Customer> listcustomer = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
        return listcustomer;
    }

    public boolean checkEmailandUsername(String email, String username) {
        List<Customer> listcustomer = test();
        for (Customer customer : listcustomer) {
            if (customer.getEmail().equals(email) || customer.getUser_name().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean signup(String name, String email, String username, String password) {
        if (checkEmailandUsername(email, username)) {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("INSERTCUSTOMERS");
            SqlParameterSource in = new MapSqlParameterSource().addValue("cust_customer_name", name)
                    .addValue("cust_email", email)
                    .addValue("cust_username", username).addValue("cust_password", password);
            jdbcCall.execute(in);
            return true;

        } else {
            return false;
        }
    }

}
