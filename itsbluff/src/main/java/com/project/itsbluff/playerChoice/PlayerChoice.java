package com.project.itsbluff.playerChoice;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.itsbluff.choice.Choice;
import com.project.itsbluff.player.Player;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_choice")
public class PlayerChoice implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Player player;
    @ManyToOne
    @Enumerated(EnumType.STRING)
    private Choice choice;

    public PlayerChoice() {
    }

    public PlayerChoice(Choice choice, Long id, Player player) {
        this.choice = choice;
        this.id = id;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlayerChoice other = (PlayerChoice) obj;
        return Objects.equals(this.id, other.id);
    }

}
