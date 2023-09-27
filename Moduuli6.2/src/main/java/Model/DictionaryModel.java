package Model;
import java.util.HashMap;
import java.util.Map;

public class DictionaryModel {
    private Map<String, Double> currencies = new HashMap<>();

    public DictionaryModel() {
        currencies.put("USD", 1.0);
        currencies.put("EUR", 0.94);
        currencies.put("JPY", 148.79);
        currencies.put("GBP", 0.82);
    }

    public double convert(double amount, String from, String to) {
        return amount / currencies.get(from) * currencies.get(to);
    }

    public String format(double amount, String to) {
        return switch (to) {
            case "JPY" -> String.format("%s %,.0f", "¥", amount);
            case "GBP" -> String.format("%s %,.2f", "£", amount);
            case "EUR" -> String.format("%s %,.2f", "€", amount);
            case "USD" -> String.format("%s %,.2f", "$", amount);
            default -> String.format("%,.2f", amount);
        };
    }
}
