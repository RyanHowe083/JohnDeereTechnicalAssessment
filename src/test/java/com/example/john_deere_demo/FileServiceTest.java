package com.example.john_deere_demo;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.example.john_deere_demo.FileService.removeUnwantedCharacters;
import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {
    FileService fileService = new FileService();

    @Test
    void testWriteFile() {
        //Arrange
        fileService.writeFile("testFile.txt","www.test.com");

        //Act
        File file = new File("testFile.txt");

        //Assert
        assertNotNull(file);
    }

    @Test
    void testRemoveUnwantedCharacters_WhenInputHasUnwantedCharsReturnNewString(){
        //Arrange
        String line = "Hello there, here is some bad characters , . ?";


        //Act
        String lineWithRemovedCharacters = removeUnwantedCharacters(line);


        //Assert
        assertFalse(lineWithRemovedCharacters.contains(","));
        assertFalse(lineWithRemovedCharacters.contains("."));
        assertFalse(lineWithRemovedCharacters.contains("?"));
    }
}