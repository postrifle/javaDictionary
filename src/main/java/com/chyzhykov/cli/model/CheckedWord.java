package com.chyzhykov.cli.model;

/**
 * Created by AChizhikov on 12/7/2015.
 */
public class CheckedWord {
    Long id;
    String essentialWord;
    String dictionaryWord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEssentialWord() {
        return essentialWord;
    }

    public void setEssentialWord(String essentialWord) {
        this.essentialWord = essentialWord;
    }

    public String getDictionaryWord() {
        return dictionaryWord;
    }

    public void setDictionaryWord(String dictionaryWord) {
        this.dictionaryWord = dictionaryWord;
    }
}
