package com.project.itsbluff.move;

import com.project.itsbluff.playerOption.PlayerOption;
import com.project.itsbluff.word.Word;

public class Move {
    private PlayerOption playerOption;
    private Word word;

   public Move(){

   }

    public Move(PlayerOption playerOption, Word word) {
        this.playerOption = playerOption;
        this.word = word;
    }

    public PlayerOption getPlayerOption() {
        return playerOption;
    }

    public void setPlayerOption(PlayerOption playerOption) {
        this.playerOption = playerOption;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

   

}
