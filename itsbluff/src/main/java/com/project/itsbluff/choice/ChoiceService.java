package com.project.itsbluff.choice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceService {
    @Autowired
    private ChoiceRepository choiceRepository;

    public List<Choice> findAll(){
        return choiceRepository.findAll();
    }

}
