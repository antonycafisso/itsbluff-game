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

    public Player verifyPlayerTurn(Player player){
        List<Player> players = playerRepository.findAll();
        if(player.getId()==1 && player.isTurn()==true){
            players.get(0).setTurn(true);
            players.get(1).setTurn(false);
            System.out.println(players.get(1));
            playerRepository.saveAll(players);
            return players.get(1);
        }
        players.get(0).setTurn(true);
        players.get(1).setTurn(false);
        playerRepository.saveAll(players);
        return players.get(0);
    }

}
