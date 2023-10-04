package application;
import dao.CurrencyDao;

public class CurrencyApp {
    private CurrencyDao dao;

    public CurrencyApp(CurrencyDao dao) {
        this.dao = dao;
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double exchangeRate = dao.getExchangeRate(fromCurrency, toCurrency);
        return amount * exchangeRate;
    }
}
