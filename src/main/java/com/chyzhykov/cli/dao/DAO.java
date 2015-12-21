package com.chyzhykov.cli.dao;

import com.chyzhykov.cli.model.Word;

import java.util.List;

/**
 * Created by AChizhikov on 12/5/2015.
 */
public interface DAO<T> {
    Long insert(T entity);
    void delete(String tableName, Long id);
    List<T> getAll();
}
