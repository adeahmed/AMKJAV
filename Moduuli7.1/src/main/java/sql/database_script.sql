
DROP DATABASE IF EXISTS currency_converter_db;

CREATE DATABASE currency_converter_db;

USE currency_converter_db;

CREATE TABLE currencies (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            abbreviation VARCHAR(3) NOT NULL,
                            name VARCHAR(255) NOT NULL,
                            conversion_rate DECIMAL(10, 4) NOT NULL
);

INSERT INTO currencies (abbreviation, name, conversion_rate) VALUES
                                                                 ('USD', 'United States Dollar', 1.0000),
                                                                 ('EUR', 'Euro', 0.8500),
                                                                 ('GBP', 'British Pound Sterling', 0.7345),
                                                                 ('JPY', 'Japanese Yen', 110.4800),
                                                                 ('AUD', 'Australian Dollar', 1.2947),
                                                                 ('CAD', 'Canadian Dollar', 1.2534),
                                                                 ('CHF', 'Swiss Franc', 0.9201),
                                                                 ('CNY', 'Chinese Yuan', 6.4545);

DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password123';
GRANT SELECT ON currency_converter_db.currencies TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
