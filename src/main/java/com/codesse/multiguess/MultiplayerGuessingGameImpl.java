package com.codesse.multiguess;

import com.codesse.multiguess.lettersAndWord.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplayerGuessingGameImpl implements MultiplayerGuessingGame {

    ArrayList<Word> guessingWords = new ArrayList<Word>(Arrays.asList(
            new Word("poker"),
            new Word("cover"),
            new Word("pesto")));
    VocabularyCheckerImpl vocabularyChecker = new VocabularyCheckerImpl();
    int wordLength = guessingWords.get(0).getWordLength();
    /**
     * Get the complete list of Strings to display to the players of the game.
     * Represent "hidden" characters with an asterisk *.
     * Completely solved / revealed words should also be included in the list.
     *
     * @return the list of Strings
     */
    public List<String> getGameStrings() {
        ArrayList<String> stringWords = new ArrayList<>();
        for (Word word : guessingWords) {
            stringWords.add(word.getHiddenWord());
        }
        return stringWords;
    }

    /**
     * Update the game based on a guess submitted by a player and return a score for the submission.
     *
     * @param playerName the name of the player. Player names can be considered as unique. There is no need to implement code to enforce uniqueness.
     * @param submission the word submitted by the player as a guess for partially hidden words in the game.
     * @return a score for the submission equivalent to the number of hidden characters that were caused to be revealed or 10 if the submitted word is an exact match for one of the words in the game. If the submission is invalid for any reason return a score of 0.
     */
    public int submitGuess(String playerName, String submission) {
        submission = submission.trim();
        if(!vocabularyChecker.exists(submission) || submission.length() != wordLength) {
            return 0;
        }
        for (Word guessWord : guessingWords) {
            if(submission.equals(guessWord.getFullWord())) {
                if(guessWord.isFullyReveald()) {
                    return 0;
                }
                guessWord.fullyRevealWord();
                return 10;
            }
        }

        boolean submissionValid = false;

        char[] submissionCharArr = submission.toCharArray();
        for (Word guessWord : guessingWords) {
            if (guessWord.isFullyReveald()) {
                continue;
            }
            boolean submissionValidForThisWord = true;
            char[] hiddenWordCharArr = guessWord.getHiddenWord().toCharArray();
            for (int i = 0; i < submissionCharArr.length; i++) {
                if(hiddenWordCharArr[i] == '*') {
                    continue;
                }
                if(hiddenWordCharArr[i] != submissionCharArr[i]) {
                    submissionValidForThisWord = false;
                    continue;
                }
            }
            if(submissionValidForThisWord == true) {
                submissionValid = true;
                break;
            }
        }

        if(!submissionValid) {
            return 0;
        }
        int points = 0;

        for (Word guessWord : guessingWords) {
            if (guessWord.isFullyReveald()) {
                continue;
            }
            for (int i = 0; i < submissionCharArr.length; i++) {
                if(guessWord.getLetterList().get(i).isReveald()) {
                    continue;
                }
                if(guessWord.getLetterList().get(i).getChar() == submissionCharArr[i]) {
                    guessWord.getLetterList().get(i).setReveald(true);
                    guessWord.recalculateHiddenWordString();
                    points ++;
                }
            }
        }

        return points;
    }

}
