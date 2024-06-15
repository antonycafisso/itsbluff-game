package com.project.itsbluff.playerChoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/playerschoice")
public class PlayerChoiceResource {
    @Autowired
    private PlayerChoiceService playerChoiceService;

    @GetMapping
    public ResponseEntity<List<PlayerChoice>> findAll(){
        List<PlayerChoice> list = playerChoiceService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
