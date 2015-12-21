package com.chyzhykov.cli.dao;

import com.chyzhykov.cli.model.Word;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by AChizhikov on 12/5/2015.
 */
@Repository(value = "dictionaryDao")
public class JdbcDictionaryDao extends AbstractDAO<Word> {

    public Long insert(final Word word) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement("insert into dictionary (word) values (?)", new String[]{"id"});
                        ps.setString(1, word.getWord());
                        return ps;
                    }
                }, keyHolder);
        word.setId(keyHolder.getKey().longValue());
        return keyHolder.getKey().longValue();
    }

    public List<Word> getAll() {
        List<Word> words = this.jdbcTemplate.query(
                "select id, word from dictionary",
                new RowMapper<Word>() {
                    public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Word word = new Word();
                        word.setId(rs.getLong("id"));
                        word.setWord(rs.getString("word"));
                        return word;
                    }
                });
        return words;
    }
}


