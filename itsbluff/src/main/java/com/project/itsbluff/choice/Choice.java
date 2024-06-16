package com.project.itsbluff.choice;

import java.io.Serializable;


public class Choice implements Serializable{
    private LetterEnum letter;
    private SideEnum side;
    private OptionsEnum option;

    public Choice(){

    }

    public Choice(LetterEnum letter, SideEnum side, OptionsEnum option) {
        this.letter = letter;
        this.side = side;
        this.option = option;
    }

    public Choice(OptionsEnum optionsEnum){
        this.option = optionsEnum;
    }

    public LetterEnum getLetter() {
        return letter;
    }

    public void setLetter(LetterEnum letter) {
        this.letter = letter;
    }

    public SideEnum getSide() {
        return side;
    }

    public void setSide(SideEnum side) {
        this.side = side;
    }

    public OptionsEnum getOption() {
        return option;
    }

    public void setOption(OptionsEnum option) {
        this.option = option;
    }

    

}
