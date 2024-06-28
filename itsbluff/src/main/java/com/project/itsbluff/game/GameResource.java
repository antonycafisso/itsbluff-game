package com.project.itsbluff.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.itsbluff.move.Move;
import com.project.itsbluff.move.MovePlayerOptionDTO;
import com.project.itsbluff.move.MoveService;
import com.project.itsbluff.player.PlayerService;
import com.project.itsbluff.word.WordService;

@RestController
@RequestMapping("/game")
public class GameResource {
    @Autowired
    private WordService wordService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MoveService moveService;

    @PostMapping(value = "/addNewLetter")
    public ResponseEntity<Move> addNewLetter(@RequestBody Move move) {
        // change the word, adding new letter
        move.getWord().setContent(wordService.addNewLetter(move).toString());
        // verify player turn
        move.getPlayerOption().setPlayer(playerService.verifyPlayerTurn(move.getPlayerOption().getPlayer()));
        // verify word on dictionary api
        move.setWord(wordService.wordExistsAddNewLetter(move));

        return ResponseEntity.ok().body(move);
    }

    @PostMapping(value = "/challenge")
    public ResponseEntity<Move> challengeBluff(@RequestBody Move move) {
        move.setWord(wordService.wordExistsChallengeBluff(move));
        move.getPlayerOption().setPlayer(playerService.verifyPlayerTurn(move.getPlayerOption().getPlayer()));
        return ResponseEntity.ok().body(move);
    }

    @PostMapping(value = "/giveup")
    public ResponseEntity<Move> playerGiveUp(@RequestBody MovePlayerOptionDTO movePlayerOptionDTO){
        Move move = moveService.fromDTO(movePlayerOptionDTO);
        playerService.deductPoints(movePlayerOptionDTO.getPlayerOption().getPlayer(), 1);
        move.getPlayerOption().setPlayer(playerService.verifyPlayerTurn(movePlayerOptionDTO.getPlayerOption().getPlayer()));
        return ResponseEntity.ok().body(move);
    }
}
