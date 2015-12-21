package com.chyzhykov.cli.services;

import com.chyzhykov.cli.dao.DAO;
import com.chyzhykov.cli.dao.JdbcDictionaryDao;
import com.chyzhykov.cli.model.CheckedWord;
import com.chyzhykov.cli.model.Word;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    JdbcDictionaryDao jdbcDictionaryDao;

    public void addCheckedWordsToBD(List<CheckedWord> checkedWords) {
        List<Word> dictionaryWords = jdbcDictionaryDao.getAll();
        for (CheckedWord checkedWord : grammarCheck(checkedWords, dictionaryWords)) {
            spellCheckDao.insert(checkedWord);
        }
    }

    private List<CheckedWord> getCheckedWordFromString(List<String> strings) {
        List<CheckedWord> checkedWords = new ArrayList<CheckedWord>();
        for (String string : strings) {
            CheckedWord checkedWord = new CheckedWord();
            checkedWord.setEssentialWord(string);
            checkedWord.setDictionaryWord(string + "ABC");
            checkedWords.add(checkedWord);
        }
        return checkedWords;
    }

    private List<CheckedWord> grammarCheck(List<CheckedWord> checkedWords, List<Word> dictionaryWords) {

        for (CheckedWord checkedWord : checkedWords) {
            int closestDistance = checkedWord.getEssentialWord().length();
            String closestWord = null;
            for (Word dictionaryWord : dictionaryWords) {
                int levenshteinDist = StringUtils.getLevenshteinDistance(checkedWord.getEssentialWord(), dictionaryWord.getWord());
                closestDistance = levenshteinDist < closestDistance ? levenshteinDist : closestDistance;
                closestWord = levenshteinDist < closestDistance ? dictionaryWord.getWord() : closestWord;
                if (levenshteinDist == 0) break;
            }
            checkedWord.setDictionaryWord(closestWord);
        }
        return checkedWords;
    }
}
