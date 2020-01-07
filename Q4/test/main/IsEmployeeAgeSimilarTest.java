package main;

import main.java.com.company.IsEmployeeAgeSimilar;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class IsEmployeeAgeSimilarTest {
    @Test
    public void testEmployeeAgeSimilarReturnsCorrectValue()
    {
        IsEmployeeAgeSimilar employee = new IsEmployeeAgeSimilar();
        Set<Integer> sharedAges = new HashSet<>();
        sharedAges.add(17);
        sharedAges.add(22);
        sharedAges.add(59);
        sharedAges.add(45);
        assertEquals(sharedAges, employee.isAgeSimilar());
    }

    @Test
    public void testEmployeeAgeSimilarFailsIfIncorrectSetPassed()
    {
        IsEmployeeAgeSimilar employee = new IsEmployeeAgeSimilar();
        Set<Integer> sharedAges = new HashSet<>();
        sharedAges.add(17);
        sharedAges.add(45);
        assertNotEquals(sharedAges, employee.isAgeSimilar());
    }

}