package com.chyzhykov.cli.dictionary;

import com.chyzhykov.cli.AppConfig;
import com.chyzhykov.cli.ConsoleFileReader;
import com.chyzhykov.cli.model.Word;
import com.chyzhykov.cli.services.DictionaryServices;
import com.chyzhykov.cli.services.WordServiceUtilites;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class Dictionary {

    public static void main(String[] args) {
//        ConsoleFileReader consoleFileReader = new ConsoleFileReader();
//        List<String> list = consoleFileReader.getWordListFromFile();

//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        DictionaryServices jdbcDictionaryService = (DictionaryServices) context.getBean("service");
//        jdbcDictionaryService.addWordsToDictionary(list);

        System.out.println("Levenshtein distance between "+"\'table\'"+" and "+"\'table\'  : "+
                WordServiceUtilites.levenshteinDistance("tab", "tar"));
    }
}
