package dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyDao {
    private Map<String, Double> exchangeRates;
    private List<String> currencies;

    public CurrencyDao() {
        // Initialize exchange rates and currencies here from your database or API
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.75);

        currencies = List.of("USD", "EUR", "JPY", "GBP"); // Example currencies
    }

    public double getExchangeRate(String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return toRate / fromRate;
    }

    public List<String> getCurrencies() {
        return currencies;
    }


}
