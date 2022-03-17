package com.example.john_deere_demo;

import java.util.*;

public class ParsingService {

    public HashMap<String, Integer> getMapOfParsedWords(Scanner scanner) {
        HashMap<String, Integer> mapOfParsedWords = new HashMap<>();
        while (scanner.hasNext()) {
            String nextWord = scanner.next().toLowerCase();
            mapOfParsedWords = appendMap(mapOfParsedWords, nextWord.toLowerCase());
        }
        return mapOfParsedWords;
    }

    public HashMap<String, Integer> appendMap(HashMap<String, Integer> mapOfParsedWords, String currentWord) {
        if (!Literals.unwantedWords.contains(currentWord.toLowerCase())) {
            return putCurrentWordInMap(mapOfParsedWords, currentWord.toLowerCase());
        }
        return mapOfParsedWords;
    }

    public HashMap<String, Integer> increaseCountOfWord(HashMap<String, Integer> mapOfParsedWords, String nextWord) {
        int count = mapOfParsedWords.get(nextWord);
        count++;
        mapOfParsedWords.replace(nextWord, count);
        return mapOfParsedWords;
    }

    private HashMap<String, Integer> putCurrentWordInMap(HashMap<String, Integer> mapOfParsedWords, String currentWord) {
        if(mapOfParsedWords.containsKey(currentWord.toLowerCase())){
            return increaseCountOfWord(mapOfParsedWords,currentWord.toLowerCase());
        }
        return addNewWordToMap(mapOfParsedWords,currentWord.toLowerCase());
    }

    private HashMap<String, Integer> addNewWordToMap(HashMap<String, Integer> mapOfParsedWords, String currentWord) {
        mapOfParsedWords.put(currentWord.toLowerCase(),1);
        return mapOfParsedWords;
    }

    public List<Map.Entry<String, Integer>> getSortedListOfWord(HashMap<String, Integer> mapOfParsedWords) {
        List<Map.Entry<String, Integer> > sortedListOfWords =
                new LinkedList<>(mapOfParsedWords.entrySet());

        sortedListOfWords.sort(Map.Entry.comparingByValue());
        return sortedListOfWords;
    }
}
