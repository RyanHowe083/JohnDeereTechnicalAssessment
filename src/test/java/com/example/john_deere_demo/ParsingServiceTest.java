package com.example.john_deere_demo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ParsingServiceTest {

    ParsingService parsingService = new ParsingService();


    @Test
    void testIncreaseCountOfWord_WhenWordFoundIncreaseCount(){
        //Arrange
        String firstWord = "firstWord";
        HashMap<String, Integer> listOfWords  = new HashMap<>();
        listOfWords.put(firstWord.toLowerCase(),1);
        listOfWords = parsingService.appendMap(listOfWords,firstWord.toLowerCase());


        //Act
        int expectedCount = 2;
        int actualCount = listOfWords.get(firstWord.toLowerCase());

        //Assert
        assertEquals(expectedCount,actualCount);
    }

    @Test
    void testAppendMap_WhenWordNotFoundPutInMap(){
        //Arrange
        String firstWord = "firstWord";
        String secondWord = "secondWord";
        HashMap<String, Integer> listOfWords  = new HashMap<>();
        listOfWords.put(firstWord.toLowerCase(),1);
        listOfWords = parsingService.appendMap(listOfWords,secondWord.toLowerCase());


        //Act
        int expectedCount = 1;
        int actualCount = listOfWords.get(secondWord.toLowerCase());

        //Assert
        assertEquals(expectedCount,actualCount);
    }

    @Test
    void testAppendMap_WhenParsingMapNeverGetsUnwantedWords(){
        //Arrange
        HashMap<String, Integer> listOfWords  = new HashMap<>();
        for(String currentWord: Literals.mixOfWantedAndWantedWords){
            listOfWords = parsingService.appendMap(listOfWords,currentWord.toLowerCase());
        }


        //Act
        boolean hasUnwantedWords = false;
        for(String unwanted:Literals.unwantedWords){
            if (listOfWords.containsKey(unwanted.toLowerCase())) {
                hasUnwantedWords = true;
                break;
            }
        }

        //Assert
        assertFalse(hasUnwantedWords);
    }

    @Test
    void testGetSortedListOfWords_AssertNextWordEqualOrGreater() throws FileNotFoundException {
        //Arrange
        File mobyDick = new File("MobyDick.txt");
        Scanner scanner = new Scanner(mobyDick);
        HashMap<String, Integer> listOfWords = parsingService.getMapOfParsedWords(scanner);
        List<Map.Entry<String, Integer> > list = parsingService.getSortedListOfWord(listOfWords);


        //Act
        boolean actual = true;
        for(int i = 0; i < list.size();i++){
            if(i < list.size()-1){
                if(list.get(i).getValue() > list.get(i+1).getValue()){
                    actual = false;
                }
            }
        }

        //Assert
        assertTrue(actual);
    }
}