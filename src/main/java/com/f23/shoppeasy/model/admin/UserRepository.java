package com.f23.shoppeasy.model.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author drago
 */
@Repository
public class UserRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    public List<User> findAll() {

        String query = "select id, firstname, lastname, email, role,password from user";
        return template.query(query,
                (result, rowNum)
                    -> new User(result.getLong("id"), 
                        result.getString("firstname"), 
                            result.getString("lastname"), 
                            result.getString("email"),                             
                            result.getString("role"), 
                            result.getString("password")));
    }

    public User getUserById(long id) {
        String query = "select * from user where id=:id ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(User.class));
    }

    public void deleteUserById(long id) {
        String query = "delete from user where id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        template.update(query, namedParameters);
    }
}
