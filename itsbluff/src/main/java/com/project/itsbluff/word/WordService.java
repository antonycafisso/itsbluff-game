package com.project.itsbluff.word;

import org.springframework.stereotype.Service;

import com.project.itsbluff.enums.Letter;
import com.project.itsbluff.enums.Side;
import com.project.itsbluff.move.Move;
import com.project.itsbluff.playerOption.PlayerOption;

@Service
public class WordService {
    public Word getRandomInitialLetter() {
        Letter letter = Letter.getRandomLetter();
        return new Word(letter.toString());
    }

    public Word addNewLetter(Move move) {
        Word word = new Word();
        if (move.getPlayerOption().getSide().equals(Side.RIGHT)) {
            word.setContent(move.getWord() + move.getPlayerOption().getLetter());
            return word;
        }
        word.setContent(move.getPlayerOption().getLetter() + move.getWord());
        return word;
    }

    public WordAddNewLetter fromDto(PlayerOption playerOption, Word word) {
        WordAddNewLetter wordAddNewLetter = new WordAddNewLetter(playerOption.getLetter(), word);
        return wordAddNewLetter;
    }
}
