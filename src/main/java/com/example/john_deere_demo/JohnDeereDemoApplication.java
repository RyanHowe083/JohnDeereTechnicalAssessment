package com.example.john_deere_demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class JohnDeereDemoApplication {
    private static final String fileName = "MobyDick.txt";
    private static final String urlName = "https://www.gutenberg.org/files/2701/2701-0.txt";
    private static final FileService fileService = new FileService();
    private static final ParsingService parsingService = new ParsingService();


    public static void main(String[] args) throws FileNotFoundException {
        fileService.writeFile(fileName,urlName);

        File mobyDick = new File(fileName);
        Scanner scanner = new Scanner(mobyDick);
        HashMap<String, Integer> mapOfParsedWords = parsingService.getMapOfParsedWords(scanner);
        List<Map.Entry<String, Integer> > sortedListOfWord = parsingService.getSortedListOfWord(mapOfParsedWords);
        displayTop50OccurringWords(sortedListOfWord);
    }

    public static void displayTop50OccurringWords(List<Map.Entry<String, Integer>> list) {
        int count = 1;
        for(int i = list.size()-1; i > list.size()-51;i--){
            System.out.println(count + ") "+list.get(i).getKey().replace("="," ") + ": " + list.get(i).getValue());
            count++;
        }
    }

}
