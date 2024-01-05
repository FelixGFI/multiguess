package com.codesse.multiguess;

import com.codesse.multiguess.lettersAndWord.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordTest {
    @Test
    void testWordSetters () {
        Word word = new Word("poker");
        Assertions.assertEquals(5, word.getWordLength());
        Assertions.assertEquals("poker", word.getFullWord());
    }
}
