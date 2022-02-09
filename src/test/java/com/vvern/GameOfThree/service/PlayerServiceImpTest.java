package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.model.Player;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlayerServiceImpTest {

    @Autowired
    private PlayerService playerService;

    @MockBean
    private CrudRepository playerRepository;

    @Test
    void save() {
        Player player = new Player();
        player.setName("Test");
        player.setId(1L);
        Assert.assertNotNull(playerService.save(player));
    }

    @Test
    void findByName() {
        Player player = new Player();
        player.setName("Test");
        player.setId(1L);
        playerService.save(player);
        Assert.assertNotNull(playerService.findByName("Test"));
    }
}