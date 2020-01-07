package main.java.com.company;

import java.util.*;

public class Grade {

    public boolean compareScoreToPassMark(int score, int passMark)
    {
        if (score > passMark)
        {
            return true;
        }else
        {
            return false;
        }
    }

    // method which assists in determining the next multiple  of 5 for a score
    public int nearestMultipleOfFive(int score)
    {
        int rem = score % 5;
        int nearestMultiple = score + (5-rem);
        return nearestMultiple;
    }

    // method to do the actual rounding of based on the conditions
    // incase the number should not be rounded off we return 0
    public int roundOff(int score, int passMark)
    {   int newScore = 0;
        // ensure we do the rounding off only if above passmark
        if (compareScoreToPassMark(score, passMark))
        {
             int nearestScore = nearestMultipleOfFive(score);
             if (nearestScore - score < 3)
             {
                 newScore = nearestScore;

             }
        }
        return newScore;
    }

}

