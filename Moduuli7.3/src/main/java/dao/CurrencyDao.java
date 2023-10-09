package dao;
import entity.Currency;
import java.util.List;
import datasource.MariaDbCurrencyDao;

import java.util.List;

public interface CurrencyDao {
    void persist(Currency currency);

    Currency find(String iso);

    void update(Currency currency);

    void delete(Currency currency);

    List<Currency> getAll();

    double getExchangeRate(String fromCurrency, String toCurrency);
}