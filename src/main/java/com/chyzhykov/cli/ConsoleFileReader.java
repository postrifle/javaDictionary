package com.chyzhykov.cli;

import com.chyzhykov.cli.model.Word;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by AChizhikov on 12/6/2015.
 */
public class ConsoleFileReader {

    private String getFilePathFromConsole() {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        return c.readLine("Enter path to dictionary file: ");
    }

    public List<String> getWordListFromFile(){
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

}
