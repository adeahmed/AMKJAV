package entity;
import jakarta.persistence.*;
@Entity
@Table(name = "currencies")
public class Currency {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String iso;
        private String symbol;
        private double rate;

        // Constructors, getters, and setters

        public Currency() {
        }

        public Currency(String iso, String symbol, double rate) {
            this.iso = iso;
            this.symbol = symbol;
            this.rate = rate;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getIso() {
            return iso;
        }

        public void setIso(String iso) {
            this.iso = iso;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public double getRate() {
            return rate;
        }


        public void setRate(double rate) {
            this.rate = rate;
        }

        @Override

        public String toString() {
            return "Currency{" +
                    "id=" + id +
                    ", iso='" + iso + '\'' +
                    ", symbol='" + symbol + '\'' +
                    ", rate=" + rate +
                    '}';
        }

    }

