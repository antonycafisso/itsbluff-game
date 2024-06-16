package com.project.itsbluff.playerChoice;

import java.io.Serializable;

import com.project.itsbluff.choice.Choice;
import com.project.itsbluff.player.Player;


public class PlayerChoice implements Serializable{
    private Player player;
    private Choice choice;

    public PlayerChoice(){

    }

    public PlayerChoice(Player player, Choice choice) {
        this.player = player;
        this.choice = choice;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }


    
}
