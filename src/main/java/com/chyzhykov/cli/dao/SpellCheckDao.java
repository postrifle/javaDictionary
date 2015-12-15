package com.chyzhykov.cli.dao;

import com.chyzhykov.cli.model.CheckedWord;
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
 * Created by AChizhikov on 12/7/2015.
 */

@Repository
public class SpellCheckDao implements DAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Long insert(final Object entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into spellcheck (essentialword, dictionaryword) values (?, ?)", new String[]{"id"});
                ps.setString(1, ((CheckedWord)entity).getEssentialWord());
                ps.setString(2, ((CheckedWord)entity).getDictionaryWord());
                return ps;
            }
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from spellcheck where id = ?", id);
    }
}
