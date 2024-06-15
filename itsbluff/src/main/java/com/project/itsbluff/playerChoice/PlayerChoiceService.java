package com.project.itsbluff.playerChoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerChoiceService {
    @Autowired
    private PlayerChoiceRepository playerChoiceRepository;

    public List<PlayerChoice> findAll (){
        return playerChoiceRepository.findAll();
    }

}
