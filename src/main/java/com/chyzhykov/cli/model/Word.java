package com.chyzhykov.cli.model;

/**
 * Created by AChizhikov on 11/29/2015.
 */
public class Word {
    private Long id;

    private String word;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word1 = (Word) o;

        return getWord().equals(word1.getWord());

    }

    @Override
    public int hashCode() {
        return getWord().hashCode();
    }
}
