package main;

import main.java.com.company.Grade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeTest {
    Grade grade = new Grade();
    @Test
    public void tesCompareScoreToPassMarkReturnsBoolean()
    {
        boolean value = grade.compareScoreToPassMark(27, 38);
        assertNotEquals(value,true);
        assertEquals(grade.compareScoreToPassMark(63, 38),true);
    }
    @Test
    public void testNearestMultipleOfFiveWorksCorrectly()
    {
        assertEquals(grade.nearestMultipleOfFive(53), 55);
        assertEquals(grade.nearestMultipleOfFive(71), 75);
        assertNotEquals(grade.nearestMultipleOfFive(53), 60);
    }

    @Test
    public void testRoundOffWorksCorrectly()
            // this
    {
        assertEquals(grade.roundOff(53, 38),55);
        assertEquals(grade.roundOff(71, 38),0);
        assertEquals(grade.roundOff(27,38), 0);
    }
}