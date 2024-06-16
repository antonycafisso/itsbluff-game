package com.project.itsbluff.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.itsbluff.choice.Choice;
import com.project.itsbluff.choice.LetterEnum;
import com.project.itsbluff.choice.SideEnum;
import com.project.itsbluff.player.Player;
import com.project.itsbluff.player.PlayerRepository;
import com.project.itsbluff.playerChoice.PlayerChoice;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PlayerRepository playerRepository;

    public void run(String... args) throws Exception {

        Player p1 = new Player(null, "Player 01", true, 5);
        Player p2 = new Player(null, "Player 02", false, 5);
        playerRepository.saveAll(Arrays.asList(p1,p2));
    }
}
