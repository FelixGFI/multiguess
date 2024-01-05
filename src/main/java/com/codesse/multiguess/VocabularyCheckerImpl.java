package com.codesse.multiguess;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class VocabularyCheckerImpl implements VocabularyChecker {

    List<String> validWords = new ArrayList<>();

    /*
    Instead of reading the whole file it might be smarter to only read in the needed words needed
    for example if the game only contains words of a specific length that need to be checked, reading in
    words of all length that will never be used seems unreasonable. the begining letter of the word might
    also be a factor to consider. it might be possible to only read in the sections of the file that
    are relevent for the search.
     */
    public VocabularyCheckerImpl() {
        try {

            InputStream inputStream = this.getClass().getResourceAsStream("/wordlist.txt");
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                validWords.add(inputLine);
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(String word) {
        return validWords.contains(word);
    }

}

