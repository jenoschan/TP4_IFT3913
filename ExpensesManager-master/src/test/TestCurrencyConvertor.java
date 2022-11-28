import java.beans.Transient;
import java.util.Currency;

public class TestCurrencyConvertor {
    //------------------------BLACK BOX TESTING-----------------------//
    //see report for more details on the coverage
   @Test 
   // test if amount entered is between 0 and 10000
    public void testAmount() {
         CurrencyConvertor convertor = new CurrencyConvertor();
         double amount = 1000;
         String from = "USD";
         String to = "CAD";
         CurrencyConversion conversion = new CurrencyConversion();
         conversion.getRates().put("USD", 1.0);
         conversion.getRates().put("CAD", 0.74);
         double result = convertor.convert(amount, from, to, conversion);
         assertEquals(740.0, result, 0.0);
        //test if amount entered is less than 0
         amount = -1;
         result = convertor.convert(amount, from, to, conversion);
         assertEquals(0.0, result, 0.0);
        //test if amount entered is greater than 10000
        amount = 20000;
        result = convertor.convert(amount, from, to, conversion);
        assertEquals(0.0, result, 0.0);
    }

    @Test
    //test if currency entered is valid
    public void testCurrency() {
        CurrencyConvertor convertor = new CurrencyConvertor();
        double amount = 1000;
        String from = "USD";
        String to = "CAD";
        CurrencyConversion conversion = new CurrencyConversion();
        conversion.getRates().put("USD", 1.0);
        conversion.getRates().put("CAD", 0.74);
        double result = convertor.convert(amount, from, to, conversion);
        assertEquals(740.0, result, 0.0);
        //test if currency entered is invalid
        from = "KYD";
        to = "CAD";
        result = convertor.convert(amount, from, to, conversion);
        assertEquals(0.0, result, 0.0);
        from = "USD";
        to = "KYD";
        result = convertor.convert(amount, from, to, conversion);
        assertEquals(0.0, result, 0.0);
    }
    //------------------------BLACK BOX TESTING-----------------------//
} 
