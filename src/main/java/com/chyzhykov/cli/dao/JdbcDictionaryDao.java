package com.chyzhykov.cli.dao;

import com.chyzhykov.cli.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by AChizhikov on 12/5/2015.
 */
@Repository(value = "dictionaryDao")
public class JdbcDictionaryDao implements DAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long insert(final Object entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement("insert into dictionary (word) values (?)", new String[]{"id"});
                        ps.setString(1, ((Word) entity).getWord());
                        return ps;
                    }
                }, keyHolder);
        ((Word)entity).setId(keyHolder.getKey().longValue());
        return keyHolder.getKey().longValue();
    }

    public void delete(Long id){
        jdbcTemplate.update("delete from dictionary where id = ?", id);
        }
        }
