package com.project.itsbluff.move;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveService {

    public Move fromDTO(MovePlayerOptionDTO movePlayerOptionDTO){
        if(movePlayerOptionDTO == null){
            return null;
        }
        return new Move(movePlayerOptionDTO.getPlayerOption());
    }
 
}
