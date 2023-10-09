package application;
import dao.CurrencyDao;
import entity.Currency;
import java.util.List;
import application.CurrencyApp;

public class CurrencyConverter {

        private final CurrencyDao dao;

        public CurrencyConverter(CurrencyDao dao) {
            this.dao = dao;
        }

        public List<Currency> getAllCurrencies() {
            return dao.getAll();
        }

        public double convertCurrency(double startValue, String startCurrency, String endCurrency) {
            Currency start = dao.find(startCurrency);
            Currency end = dao.find(endCurrency);
            return startValue / start.getRate() * end.getRate();
        }

        public void addCurrency(String iso, String symbol, double rate) {
            dao.persist(new Currency(iso, symbol, rate));
        }
    }


