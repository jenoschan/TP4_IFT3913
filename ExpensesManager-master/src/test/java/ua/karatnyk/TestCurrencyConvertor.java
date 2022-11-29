package ua.karatnyk;
import static org.junit.Assert.*;
import java.text.ParseException;
import org.junit.Test;

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
        // from = "KYD";
        // to = "CAD";
        // result = CurrencyConvertor.convert(amount, from, to, conversion);
        // assertEquals(0.0, result, 0.0);
        // from = "USD";
        // to = "KYD";
        // result = CurrencyConvertor.convert(amount, from, to, conversion);
        // assertEquals(0.0, result, 0.0);
    }
    //------------------------BLACK BOX TESTING-----------------------//

    //------------------------WHITE BOX TESTING-----------------------//

    // test if the instructions going through the if when the from currency is wrong
    // execute properly
    @Test
    public void testWrongCurrency1() throws ParseException{
        double amount = 1000;
        String from = "AAA";
        String to = "CAD";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        double result = CurrencyConvertor.convert(amount, from, to, conversion);
        assertEquals(0.0, result, 0.0);

    }

    // test if the instructions going through the if when the to currency is wrong
    // execute properly
    @Test
    public void testWrongCurrency2() throws ParseException{
        double amount = 1000;
        String from = "USD";
        String to = "AAA";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        double result = CurrencyConvertor.convert(amount, from, to, conversion);
        assertEquals(0.0, result, 0.0);
    }

    // test if both currencies are wrong
    @Test
    public void testBothWrongCurrency() throws ParseException{
        double amount = 1000;
        String from = "BBB";
        String to = "AAA";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        assertThrow(ParseException.class,
        () -> {
            CurrencyConvertor.convert(amount, from, to, conversion);
        });
    }

    @Test
    public void testBothRightCurrency() throws ParseException{
        double amount = 0;
        String from = "USD";
        String to = "CAD";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        double result = CurrencyConvertor.convert(amount, from, to, conversion);
        assertEquals(0.0, result, 0.0);
    }

} 
