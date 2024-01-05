package com.codesse.multiguess.lettersAndWord;

public class Letter {
    private char letterChar;
    private boolean reveald;

    public Letter(char letter) {
        this.letterChar = letter;
        this.reveald = false;
    }

    public boolean isReveald() {
        return reveald;
    }

    public void setReveald(boolean reveald) {
        this.reveald = reveald;
    }

    public char getChar() {
        return letterChar;
    }
}
