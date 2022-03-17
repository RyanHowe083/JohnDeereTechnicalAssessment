package com.example.john_deere_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.example.john_deere_demo.JohnDeereDemoApplication.displayTop50OccurringWords;

@SpringBootTest
class JohnDeereDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testDisplayTop50OccurringWords_AssertTrue() throws FileNotFoundException {
        File mobyDick = new File("MobyDick.txt");
        Scanner scanner = new Scanner(mobyDick);
        ParsingService parsingService = new ParsingService();
        HashMap<String, Integer> listOfWords = parsingService.getMapOfParsedWords(scanner);
        List<Map.Entry<String, Integer> > list = parsingService.getSortedListOfWord(listOfWords);
        displayTop50OccurringWords(list);
    }


}
