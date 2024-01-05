package com.codesse.multiguess.lettersAndWord;

import java.util.ArrayList;

public class Word {
    private String hiddenWord = "";
    private String fullWord;
    private int wordLength;
    private ArrayList<Letter> letterList = new ArrayList<Letter>();
    private boolean fullyReveald;


    public Word(String fullWord) {
        this.fullWord = fullWord;
        this.wordLength = fullWord.length();
        char[] charList = fullWord.toCharArray();
        for (char character : charList) {
            letterList.add(new Letter(character));
        }
        this.fullyReveald = fullyReveald = false;
        generateHiddenString(fullWord);

    }

    private void generateHiddenString(String fullWord) {
        int revealdCharIndex = (int) (Math.random()*(this.wordLength));
        this.letterList.get(revealdCharIndex).setReveald(true);
        recalculateHiddenWordString();
    }

    public void recalculateHiddenWordString() {
        hiddenWord = "";
        for (Letter letter : this.letterList) {
            if(letter.isReveald()) {
                this.hiddenWord = this.hiddenWord + letter.getChar();
            } else {
                this.hiddenWord = this.hiddenWord + '*';
            }
        }
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getFullWord() {
        return fullWord;
    }

    public int getWordLength() {
        return wordLength;
    }

    public ArrayList<Letter> getLetterList() {
        return letterList;
    }

    public boolean isFullyReveald() {
        return fullyReveald;
    }

    public void fullyRevealWord() {
        this.fullyReveald = true;
        for (Letter lettter : letterList) {
            lettter.setReveald(true);
            this.recalculateHiddenWordString();
        }
    }

}
