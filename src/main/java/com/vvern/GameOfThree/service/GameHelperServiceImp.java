package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.model.Gamer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameHelperServiceImp implements GameHelperService {

    private static final Logger logger = LoggerFactory.getLogger(GameHelperServiceImp.class);

    @Override
    public int createRandomNumber(int min, int max) {
        return (int)(Math.random()*(max-min+1)+min);
    }

    @Override
    public boolean checkWin(int number) {
        if (number == 1) {
            logger.info("End of the game");
            return true;
        }
        return false;
    }

    @Override
    public boolean checkCorrectness(int choose, int number) {
        if ((number + choose) % 3 == 0) {
            logger.info("Selected number " + choose + " is correct");
            return true;
        }
        logger.info("Selected number " + choose + " is incorrect");
        return false;
    }

    @Override
    public Gamer whoStart() {
        if (createRandomNumber(1, 2) == 1) {
            logger.info("HUMAN starts first");
            return Gamer.HUMAN;
        }
        logger.info("COMPUTER starts first");
        return Gamer.ROBOT;
    }
}
