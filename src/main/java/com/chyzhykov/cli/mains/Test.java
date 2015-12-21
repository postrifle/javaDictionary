package com.chyzhykov.cli.mains;

import com.chyzhykov.cli.model.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/17/15.
 */
public class Test {

    public void listWork(List<Word> list) {

        for (Word word : anotherJob(list)) {
            System.out.println("WORD   :" + word.getWord());
            System.out.println(("ID     :" + word.getId()));
        }

    }

    private List<Word> anotherJob(List<Word> list) {
        for (Word word : list) {
            word.setId(1l);
        }
        return list;
    }

    public static void main(String[] args) {

        Test test = new Test();
        List<Word> list = new ArrayList<Word>();
        Word word1 = new Word();
        word1.setWord("word1");
        Word word2 = new Word();
        word2.setWord("word2");
        list.add(word1);
        list.add(word2);
        test.listWork(list);


    }
}
