package com.chyzhykov.cli.services;

import com.chyzhykov.cli.model.CheckedWord;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by AChizhikov on 12/6/2015.
 */
public class ConsoleFileReader {
    static int row = 0;

    private String getFilePathFromConsole() {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        return c.readLine("Enter path to dictionary file: ");
    }

    public List<String> getWordListFromFile() {
        List<String> strings = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(getFilePathFromConsole())));
            while (sc.hasNext()) {
                strings.add(sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public List<CheckedWord> getCheckedWordsFromFile() {
        List<CheckedWord> checkedWords = new ArrayList<CheckedWord>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(getFilePathFromConsole())));
            while (sc.hasNextLine()) {
                getCheckWordsFromLine(sc.nextLine(), checkedWords);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        row = 0;
        return checkedWords;
    }

    private List<CheckedWord> getCheckWordsFromLine(String line, List<CheckedWord> checkedWords) {
        String[] strings = line.split("\\s+");
        List<String> list = Arrays.asList(strings);
        for (String s : list) {
            int firstLetterIndex = line.indexOf(s);
            CheckedWord checkedWord = new CheckedWord();
            checkedWord.setEssentialWord(s);
            checkedWord.setFirstSymbolIndex(firstLetterIndex);
            checkedWord.setLineNumer(row);
            checkedWords.add(checkedWord);
        }
        row++;
        return checkedWords;
    }
}
