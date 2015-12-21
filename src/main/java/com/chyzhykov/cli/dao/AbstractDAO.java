package com.chyzhykov.cli.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by User on 12/17/15.
 */
abstract class AbstractDAO<T> implements DAO<T> {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void delete(String tableName, Long id) {
        jdbcTemplate.update("delete from "+tableName+" where id = ?", id);
    }
}
