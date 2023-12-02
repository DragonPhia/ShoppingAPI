package com.f23.shoppeasy.model.transaction;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JK
 */
@Repository
public class TransactionRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    public int save(long userId, double total) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", userId);
        paramMap.put("total", total);
        String query = "INSERT INTO transaction_entry(user_id, total) VALUES(:user_id, :total)";
        return template.update(query, paramMap);
    }
}
