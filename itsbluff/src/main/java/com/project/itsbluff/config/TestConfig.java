package com.project.itsbluff.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.itsbluff.choice.Choice;
import com.project.itsbluff.choice.ChoiceRepository;
import com.project.itsbluff.choice.LetterEnum;
import com.project.itsbluff.choice.SideEnum;
import com.project.itsbluff.player.Player;
import com.project.itsbluff.player.PlayerRepository;
import com.project.itsbluff.playerChoice.PlayerChoice;
import com.project.itsbluff.playerChoice.PlayerChoiceRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerChoiceRepository playerChoiceRepository;
    
    @Autowired
    private ChoiceRepository choiceRepository;

    public void run(String... args) throws Exception {

        Player p1 = new Player(null, "Player 01", true, 5);
        Player p2 = new Player(null, "Player 02", false, 5);
        playerRepository.saveAll(Arrays.asList(p1,p2));

        Choice c1 = new Choice(null, LetterEnum.A, SideEnum.RIGHT);
        Choice c2 = new Choice(null, LetterEnum.B, SideEnum.LEFT);
        choiceRepository.saveAll(Arrays.asList(c1 ,c2));

        PlayerChoice pc1 = new PlayerChoice(c1, null, p1);
        PlayerChoice pc2 = new PlayerChoice(c2, null, p2);
        playerChoiceRepository.saveAll(Arrays.asList(pc1, pc2));
    }
}
