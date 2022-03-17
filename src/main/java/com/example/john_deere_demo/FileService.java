package com.example.john_deere_demo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FileService {

    public void writeFile(String fileName, String urlName) {
        try {
            FileWriter file = new FileWriter(fileName);
            URL url = new URL(urlName);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                line = removeUnwantedCharacters(line);
                file.write(line);
            }
            in.close();
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

    public static String removeUnwantedCharacters(String line) {
        line = line.replace(".","")
                .replace(",","")
                .replace(";","")
                .replace("-"," ")
                .replace("_","")
                .replace("(","")
                .replace(")","")
                .replace(":","")
                .replace("?","")
                .replace("!","")
                .replace("'","") +"\n";
        return line;
    }
}
