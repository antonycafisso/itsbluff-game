package com.project.itsbluff.word;

import org.springframework.stereotype.Service;

import com.project.itsbluff.choice.LetterEnum;

@Service
public class WordService {
    public Word getRandomInitialLetter(){
        LetterEnum letter = LetterEnum.getRandomLetter();
        return new Word(letter.toString());
    }
}
