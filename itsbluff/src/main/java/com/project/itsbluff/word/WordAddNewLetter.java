package com.project.itsbluff.word;

import com.project.itsbluff.enums.Side;

public class WordAddNewLetter {
    private Word word;
    private String newLetter;
    private Side side;

    public WordAddNewLetter() {

    }

    public WordAddNewLetter(String newLetter, Word word) {
        this.newLetter = newLetter;
        this.word = word;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String getNewLetter() {
        return newLetter;
    }

    public void setNewLetter(String newLetter) {
        this.newLetter = newLetter;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

}
