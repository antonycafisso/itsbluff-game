package com.project.itsbluff.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/word")
public class WordResource {
    @Autowired
    private WordService wordService;

    @GetMapping(value = "/initialLetter")
    public ResponseEntity<String> getRandomInitialLetter(){
        Word letter = wordService.getRandomInitialLetter();
        return ResponseEntity.ok().body(letter.content);
    }

    @PostMapping(value = "/addNewLetter")
    public ResponseEntity<String> addNewLetter(@RequestBody String initialLetter, @RequestBody String newLetter){
        String word = initialLetter + newLetter;
        return ResponseEntity.ok().body(word);
    }
}
