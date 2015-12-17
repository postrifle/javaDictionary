package com.chyzhykov.cli.model;

/**
 * Created by AChizhikov on 12/7/2015.
 */
public class CheckedWord {
    Long id;
    String essentialWord;
    String dictionaryWord;
    Integer firstSymbolIndex;
    Integer wrongSymbolIndex;
    Integer lineNumer;

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

    public Integer getFirstSymbolIndex() {
        return firstSymbolIndex;
    }

    public void setFirstSymbolIndex(Integer firstSymbolIndex) {
        this.firstSymbolIndex = firstSymbolIndex;
    }

    public Integer getWrongSymbolIndex() {
        return wrongSymbolIndex;
    }

    public void setWrongSymbolIndex(Integer wrongSymbolIndex) {
        this.wrongSymbolIndex = wrongSymbolIndex;
    }

    public Integer getLineNumer() {
        return lineNumer;
    }

    public void setLineNumer(Integer lineNumer) {
        this.lineNumer = lineNumer;
    }
}
