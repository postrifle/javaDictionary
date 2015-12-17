package com.chyzhykov.cli.mains;

import com.chyzhykov.cli.conf.AppConfig;
import com.chyzhykov.cli.services.ConsoleFileReader;
import com.chyzhykov.cli.model.CheckedWord;
import com.chyzhykov.cli.services.SpellCheckService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by AChizhikov on 12/7/2015.
 */
public class SpellChecker {
    public static void main(String[] args) {
        System.out.println("SPELLCHECKER");
        ConsoleFileReader consoleFileReader = new ConsoleFileReader();
        List<CheckedWord> checkedWords = consoleFileReader.getCheckedWordsFromFile();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpellCheckService service = context.getBean(SpellCheckService.class);
        service.addCheckedWordsToBD(checkedWords);

    }
}
