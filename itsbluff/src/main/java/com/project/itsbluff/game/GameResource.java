package com.project.itsbluff.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.itsbluff.move.Move;
import com.project.itsbluff.player.PlayerService;
import com.project.itsbluff.word.WordService;

@RestController
@RequestMapping("/game")
public class GameResource {
    @Autowired
    private WordService wordService;

    @Autowired
    private PlayerService playerService;

    @PostMapping(value = "/addNewLetter")
    public ResponseEntity<Move> addNewLetter(@RequestBody Move move) {
        //verify player turn
        move.getPlayerOption().setPlayer(playerService.verifyPlayerTurn(move.getPlayerOption().getPlayer()));
        //change the word, adding new letter
        move.getWord().setContent(wordService.addNewLetter(move).toString());
        //verify word on dictionary api
        move.setWord(wordService.wordExists(move.getWord()));

        return ResponseEntity.ok().body(move);
    }
}
