package main;

import com.company.DistributeMoney;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistributeMoneyTest {

    @Test
    public void testDistributeMoneyToEmployees()
    {
         DistributeMoney distributeObj = new DistributeMoney(4000);
         assertEquals(distributeObj.distributeMoneyToEmployees().toString(),"[34, 154.79020988783805]");
    }

    @Test
    public void testDistributeMoneyToEmployeesWithIncorrectExpectedResultsFails()
    {
        DistributeMoney distributeObj = new DistributeMoney(4000);
        assertNotEquals(distributeObj.distributeMoneyToEmployees().toString(),"[3, 154.79020988783805]");
    }

    @Test
    public void testDistributeMoneyToEmployeesWith10ShillingsPass()
    {
        DistributeMoney distributeObj = new DistributeMoney(10);
        assertEquals(distributeObj.distributeMoneyToEmployees().toString(),"[1, 0.0]");
    }
    @Test
    public void testDistributeMoneyToEmployeesWithLessThan10ThrowsAnException()
    {
        DistributeMoney distributeObj = new DistributeMoney(9);
        assertEquals(distributeObj.distributeMoneyToEmployees().toString(),"[Amount must be 10 and above:-)]");
    }


}