package com.project.itsbluff.choice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "choice")
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LetterEnum letter;
    private SideEnum side;

    public Choice(){

    }

    public Choice(Long id, LetterEnum letter, SideEnum side) {
        this.id = id;
        this.letter = letter;
        this.side = side;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
