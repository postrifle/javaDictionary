package com.chyzhykov.cli.mains;

import com.chyzhykov.cli.conf.AppConfig;
import com.chyzhykov.cli.services.ConsoleFileReader;
import com.chyzhykov.cli.services.DictionaryServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class Dictionary {

    public static void main(String[] args) {
        ConsoleFileReader consoleFileReader = new ConsoleFileReader();
        List<String> list = consoleFileReader.getWordListFromFile();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DictionaryServices jdbcDictionaryService = (DictionaryServices) context.getBean("service");
        jdbcDictionaryService.addWordsToDictionary(list);
    }
}
