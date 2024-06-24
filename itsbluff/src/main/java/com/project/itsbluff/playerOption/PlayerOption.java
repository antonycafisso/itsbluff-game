package com.project.itsbluff.playerOption;

import com.project.itsbluff.enums.Options;
import com.project.itsbluff.enums.Side;
import com.project.itsbluff.player.Player;

public class PlayerOption {
    private Player player;
    private String letter;
    private Side side;
    private Options option;

    public PlayerOption(String letter, Options option, Player player, Side side) {
        this.letter = letter;
        this.option = option;
        this.player = player;
        this.side = side;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }


  
}
