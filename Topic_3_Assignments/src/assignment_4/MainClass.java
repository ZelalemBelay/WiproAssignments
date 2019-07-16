package assignment_4;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainClass {

	public static void main(String args[]) {
		System.out.println("CURRENCY CODE" + "  |  " + "CURRENCY SYMBOL");
        Map<Currency, Locale> map = getCurrencyLocaleMap();

		String [] countries = { "US", "CA", "MX", "GB", "DE", "PL", "RU", "JP", "CN" };

        for (String countryCode : countries) {
           Locale locale = new Locale("EN",countryCode);
           Currency currency = Currency.getInstance(locale);
           String symbol = currency.getSymbol(map.get(currency));
           System.out.println(currency.getCurrencyCode() + "          |           " + symbol);
        }
        
        //with default locale ISO 4217
		Currency.getAvailableCurrencies().forEach(curr -> {
			System.out.println(curr.getCurrencyCode() + "          |           " + curr.getSymbol());
		});

	}
	
    public static Map<Currency, Locale> getCurrencyLocaleMap() {
        Map<Currency, Locale> map = new HashMap<>();
         for (Locale locale : Locale.getAvailableLocales()) {
            try {
              Currency currency = Currency.getInstance(locale);
              map.put(currency, locale);
            }
            catch (Exception e){ 
              // skip strange locale 
            }
         }
         return map;
     }
}
