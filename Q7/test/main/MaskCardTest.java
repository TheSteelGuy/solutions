package main;

import com.company.MaskCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MaskCardTest {

    @Test
    public void testMaskCard() {
        //test with all integers and dashes
        String raw = "1234-1234-1234-1234";
        String expResult = "1234-####-####-1234";
        String result = MaskCard.mask(raw);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testMixedDashedInput(){
        //testing integers mixed with non integers
        String raw = "4556-3646-K079-356J";
        String expResult = "4556-####-K###-356J";
        String result = MaskCard.mask(raw);
        assertEquals(expResult, result);

    }

    @Test
    public void testNonDashedInput(){
        //testing integers without dashes
        String raw = "4556364607935616";
        String expResult = "4556########5616";
        String result = MaskCard.mask(raw);
        assertEquals(expResult, result);
    }

    @Test
    public void testNonIntegers(){
        //testing all non integer input
        String raw = "ABCD-EFGH-IJKLM-NOPQ";
        String expResult = "ABCD-EFGH-IJKLM-NOPQ";
        String result = MaskCard.mask(raw);
        assertEquals(expResult, result);
    }

    @Test
    public void testMixedInput(){
        //testing all mixed input
        String raw = "A1234567BCDEFG89HI";
        String expResult = "A123####BCDEFG89HI";
        String result = MaskCard.mask(raw);
        assertEquals(expResult, result);
    }

    @Test
    public void testEmpty(){
        //testing empty input
        String raw = "";
        String expResult = "";
        String result = MaskCard.mask(raw);
        assertEquals(expResult, result);
    }
    
}
