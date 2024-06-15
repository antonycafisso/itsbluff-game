package com.project.itsbluff.player;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itsbluff.exceptions.ResourceNotFoundException;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public Player findById(Long id){
        Optional<Player> player = playerRepository.findById(id);
        return player.orElseThrow(()->new ResourceNotFoundException(id));
    }    

}
