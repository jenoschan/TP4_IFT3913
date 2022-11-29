package ua.karatnyk;
import static org.junit.Assert.*;
import java.text.ParseException;
import org.junit.Test;

import junit.framework.Assert;
import ua.karatnyk.impl.CurrencyConversion;
import ua.karatnyk.impl.CurrencyConvertor;

public class TestCurrencyConvertor {
    //------------------------BLACK BOX TESTING-----------------------//
    //see report for more details on the coverage
   @Test 
   // test if amount entered is between 0 and 10000
    public void testAmount() throws ParseException {
         double amount = 1000;
         String from = "USD";
         String to = "CAD";
         CurrencyConversion conversion = new CurrencyConversion();
         conversion.getRates().put("USD", 1.0);
         conversion.getRates().put("CAD", 0.74);
         double result = CurrencyConvertor.convert(amount, from, to, conversion);
         assertEquals(740.0, result, 0.0);
        //test if amount entered is less than 0 or more than 10000
        // amount = -1;
        // result = CurrencyConvertor.convert(amount, from, to, conversion);
        // assertEquals(0.0, result, 0.0);
        // amount = 20000;
        // result = CurrencyConvertor.convert(amount, from, to, conversion);
        // assertEquals(0.0, result, 0.0);
    }

    @Test
    //test if currency entered is valid
    public void testCurrency() throws ParseException {
        double amount = 1000;
        String from = "USD";
        String to = "CAD";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        double result = CurrencyConvertor.convert(amount, from, to, conversion);
        assertEquals(740.0, result, 0.0);
        //test if currency entered is invalid
        try {
        from = "KYD";
        to = "CAD";
        result = CurrencyConvertor.convert(amount, from, to, conversion);
        }
        catch (ParseException e) {
            assertEquals("Not correct format currency", e.getMessage());
        }
        try{
            from = "USD";
            to = "KYD";
            result = CurrencyConvertor.convert(amount, from, to, conversion);
        } catch (ParseException e) {
            assertEquals("Not correct format currency", e.getMessage());
        }
    }
    //------------------------BLACK BOX TESTING-----------------------//

    //------------------------WHITE BOX TESTING-----------------------//

    // test if the instructions going through the if when the from currency is wrong
    // execute properly
    @Test
    public void testWrongCurrency1() throws ParseException{
        try {
        double amount = 1000;
        String from = "AAA";
        String to = "CAD";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        double result = CurrencyConvertor.convert(amount, from, to, conversion);
        assertEquals(740.0, result, 0.0);
        } catch (ParseException e) {
            assertEquals("Not correct format currency", e.getMessage());
        }	
    }

    // test if the instructions going through the if when the to currency is wrong
    // execute properly
    @Test
    public void testWrongCurrency2() throws ParseException{
        try {
        double amount = 1000;
        String from = "USD";
        String to = "AAA";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        double result = CurrencyConvertor.convert(amount, from, to, conversion);
        assertEquals(740.0, result, 0.0);
        } catch (ParseException e) {
            assertEquals("Not correct format currency", e.getMessage());
        }
    }

    // test if both currencies are wrong
    @Test
    public void testBothWrongCurrency() throws ParseException{
        try {
        double amount = 1000;
        String from = "BBB";
        String to = "AAA";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        double result = CurrencyConvertor.convert(amount, from, to, conversion);
        assertEquals(740.0, result, 0.0);
        } catch (ParseException e) {
            assertEquals("Not correct format currency", e.getMessage());
        }
    }

    @Test
    public void testBothRightCurrency() throws ParseException{
        try {
        double amount = 0;
        String from = "USD";
        String to = "CAD";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        double result = CurrencyConvertor.convert(amount, from, to, conversion);
        assertEquals(0.0, result, 0.0);
        } catch (ParseException e) {
            assertEquals("Not correct format currency", e.getMessage());
        }
    }

} 
