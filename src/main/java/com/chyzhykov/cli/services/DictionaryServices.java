package com.chyzhykov.cli.services;

import com.chyzhykov.cli.model.Word;
import com.chyzhykov.cli.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AChizhikov on 12/6/2015.
 */
@Service(value = "service")
public class DictionaryServices {

    @Autowired
    private DAO dictionaryDao;

    public void addWordsToDictionary(List<String> strings) {
        for (Word word : getWordFromString(strings)) {
            dictionaryDao.insert(word);
        }
    }

    private List<Word> getWordFromString(List<String> strings){
        List<Word> words = new ArrayList<Word>();
        for (String string : strings) {
            Word word = new Word();
            word.setWord(string);
            words.add(word);
        }
        return words;
    }
}
