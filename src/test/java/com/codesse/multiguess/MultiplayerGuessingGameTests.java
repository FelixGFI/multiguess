package com.codesse.multiguess;

import com.codesse.multiguess.lettersAndWord.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplayerGuessingGameTests {

    @Test
    void submitGuessTest() {
        MultiplayerGuessingGameImpl mpgg = new MultiplayerGuessingGameImpl();

        Assertions.assertEquals(0, mpgg.submitGuess("non", "factory"));
        Assertions.assertEquals(0, mpgg.submitGuess("non", "the"));
        Assertions.assertEquals(0, mpgg.submitGuess("non", "catwalk"));
        Assertions.assertEquals(0, mpgg.submitGuess("non", "factorsdfy"));
        Assertions.assertEquals(0, mpgg.submitGuess("non", "asfjklhjl"));
        Assertions.assertEquals(0, mpgg.submitGuess("non", "f45asd//#"));

        Assertions.assertEquals(10, mpgg.submitGuess("non", "poker"));
        Assertions.assertEquals(0, mpgg.submitGuess("non", "poker"));

    }

    // write tests here
    // or add other test suites

}