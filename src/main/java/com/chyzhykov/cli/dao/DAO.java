package com.chyzhykov.cli.dao;

import com.chyzhykov.cli.model.Word;

/**
 * Created by AChizhikov on 12/5/2015.
 */
public interface DAO {
    Long insert(Object entity);
    void delete(Long id);


}
