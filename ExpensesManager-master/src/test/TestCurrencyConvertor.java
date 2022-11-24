import java.beans.Transient;
import java.util.Currency;

public class TestCurrencyConvertor {
    //BLACK BOX TESTING
    
    procedure convertCurrency() {
        //list of currencies 
        List<Currency> currencies = new ArrayList<Currency>();
        currencies.add(Currency.getInstance("USD"));
        currencies.add(Currency.getInstance("CAD"));
        currencies.add(Currency.getInstance("GBP"));
        currencies.add(Currency.getInstance("EUR"));
        currencies.add(Currency.getInstance("CHF"));
        currencies.add(Currency.getInstance("INR"));
        currencies.add(Currency.getInstance("AUD"));

        List<Int> amounts = new ArrayList<Int>();
        for (int i = 0; i = 10000; i++) {
            amounts.add(i);
        }

        //test all possible combinations of currencies and amounts
        for (Currency currency : currencies) {
            for (Int amount : amounts) {
                //test convertCurrency method
                convertCurrency(currency, amount);
            }
        }

        //in case of invalid currency or amount, throw exception
        try {
            convertCurrency(Currency.getInstance("ABC"), 100);
        } catch (Exception e) {
            //expected exception
        }
    }
}
