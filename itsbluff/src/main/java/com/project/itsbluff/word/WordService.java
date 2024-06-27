package com.project.itsbluff.word;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.project.itsbluff.enums.Letter;
import com.project.itsbluff.enums.Side;
import com.project.itsbluff.exceptions.DictionaryApiException;
import com.project.itsbluff.move.Move;
import com.project.itsbluff.player.PlayerService;
import com.project.itsbluff.playerOption.PlayerOption;

@Service
public class WordService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PlayerService playerService;

    @Value("${api.ninjas.dictionary.url}")
    private String apiUrl;

    @Value("${api.ninjas.api.key}")
    private String apiKey;

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

    private WordMeaningDTO verifyWordAPI(String word) {
        String url = apiUrl + "?word=" + word;
        try {
            RequestEntity<Void> request = RequestEntity
                    .get(URI.create(url))
                    .header("X-Api-Key", apiKey)
                    .build();

            ResponseEntity<WordMeaningDTO> response = restTemplate.exchange(request, WordMeaningDTO.class);
            if (response != null && response.getBody() != null) {
                return response.getBody();
            } else {
                return null;
            }
        } catch (RestClientException e) {
            throw new DictionaryApiException(e.getMessage());
        }
    }

    public Word mapToWord(WordMeaningDTO wordMeaningDTO) {
        if (wordMeaningDTO == null) {
            return null;
        }

        Word word = new Word();
        word.setContent(wordMeaningDTO.getWord());
        word.setExits(wordMeaningDTO.isValid());
        word.setMeaning(wordMeaningDTO.getDefinition());
        return word;
    }

    public Word wordExistsAddNewLetter(Move move) {
        if (verifyWordAPI(move.getWord().getContent()).isValid()) {
            WordMeaningDTO wordMeaningDTO = verifyWordAPI(move.getWord().getContent());
            playerService.deductPoints(move.getPlayerOption().getPlayer(), 1);
            return mapToWord(wordMeaningDTO);
        }
        return move.getWord();
    }

    public Word wordExistsChallengeBluff(Move move) {
        if (verifyWordAPI(move.getWord().getContent()).isValid()) {
            WordMeaningDTO wordMeaningDTO = verifyWordAPI(move.getWord().getContent());
            playerService.deductPointsFromOpponent(move.getPlayerOption().getPlayer(), 1);
            return mapToWord(wordMeaningDTO);
        }
        return null;
    }

    public boolean ChallengeWordExists(Move move) {
        if (verifyWordAPI(move.getWord().getContent()).isValid()) {
            return true;
        }
        return false;
    }
}
