package datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import entity.Currency;
import database.MariaDbJpaConnection;


import java.util.List;

public class MariaDbCurrencyDao implements CurrencyDao {
    @Override
    public void persist(Currency currency) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }

    @Override
    public Currency find(String iso) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        Currency currency = em.find(Currency.class, iso);
        return currency;
    }

    @Override
    public void update(Currency currency) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.merge(currency);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Currency currency) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.remove(currency);
        em.getTransaction().commit();
    }

    @Override
    public List<Currency> getAll() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c", Currency.class);
        List<Currency> currencies = query.getResultList();
        return currencies;
    }
}
