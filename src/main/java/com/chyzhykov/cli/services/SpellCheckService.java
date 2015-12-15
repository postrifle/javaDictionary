package com.chyzhykov.cli.services;

import com.chyzhykov.cli.dao.DAO;
import com.chyzhykov.cli.model.CheckedWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AChizhikov on 12/7/2015.
 */
@Service
public class SpellCheckService {
    @Autowired
    DAO spellCheckDao;

    public void addCheckedWordsToBD(List<String> strings){
        for (CheckedWord checkedWord : getCheckedWordFromString(strings)) {
            spellCheckDao.insert(checkedWord);
        }

    }

    private List<CheckedWord> getCheckedWordFromString(List<String> strings){
        List<CheckedWord> checkedWords = new ArrayList<CheckedWord>();
        for (String string : strings) {
            CheckedWord checkedWord = new CheckedWord();
            checkedWord.setEssentialWord(string);
            checkedWord.setDictionaryWord(string + "ABC");
            checkedWords.add(checkedWord);
        }
        return checkedWords;
    }
}
