package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.model.Gamer;

public interface GameHelperService {

    int createRandomNumber(int min, int max);
    boolean checkWin(int number);
    boolean checkCorrectness(int choose, int number);
    Gamer whoStart();
}
