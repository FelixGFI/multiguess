package com.codesse.multiguess;

import com.codesse.multiguess.lettersAndWord.Word;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World");
        VocabularyCheckerImpl vc = new VocabularyCheckerImpl();
        System.out.println(vc.exists("apple"));
        vc.exists("cat");
        Word word = new Word("poker");

        MultiplayerGuessingGameImpl mggi = new MultiplayerGuessingGameImpl();
        System.out.println(mggi.getGameStrings());
        System.out.println(mggi.submitGuess("non", "boxer"));
        System.out.println(mggi.getGameStrings());
        //System.out.println(mggi.submitGuess("non", "grove"));
        //System.out.println(mggi.submitGuess("non", "cover"));
        System.out.println(mggi.submitGuess("non", "lotto"));
        System.out.println(mggi.getGameStrings());
        System.out.println(mggi.submitGuess("non", "peaky"));
        System.out.println(mggi.getGameStrings());

    }
}
