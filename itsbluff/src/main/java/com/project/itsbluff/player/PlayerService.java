package com.project.itsbluff.player;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.itsbluff.exceptions.ResourceNotFoundException;
import com.project.itsbluff.move.Move;

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

    private Player swapPlayer01Turn(List<Player> players){
        players.get(0).setTurn(false);
        players.get(1).setTurn(true);
        playerRepository.saveAll(players);
        return players.get(1);
    }

    private Player swapPlayer02Turn(List<Player> players){
        players.get(0).setTurn(true);
        players.get(1).setTurn(false);
        playerRepository.saveAll(players);
        return players.get(0);
    }

    public Player verifyPlayerTurn(Player player){
        List<Player> players = playerRepository.findAll();
        if(player.getId()==1 && player.isTurn()==true){
            return swapPlayer01Turn(players);
        }
        return swapPlayer02Turn(players);
    }

    public void deductPoints(Player player, int points){
        player.setPoints(player.getPoints() - points);
        playerRepository.save(player);
    }

    public void deductPointsFromOpponent(Player player, int points){
        List<Player> players = playerRepository.findAll();
        if(player.getId()==1){
            deductPoints(players.get(1), points);
            return;
        }
        deductPoints(players.get(0), points);
    }

    public Move handledChallengeBluff(Move move, boolean wordExists){
        if(wordExists){
            deductPointsFromOpponent(move.getPlayerOption().getPlayer(), 1);
            return move;
        }
        deductPoints(move.getPlayerOption().getPlayer(), 2);
        return move;
    }
}
