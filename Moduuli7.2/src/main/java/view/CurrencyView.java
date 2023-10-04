package view;

import application.CurrencyApp;
import dao.CurrencyDao;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class CurrencyView extends Application {
    private CurrencyDao dao;
    private CurrencyApp application;
    private ComboBox<String> fromCurrencyComboBox;
    private ComboBox<String> toCurrencyComboBox;
    private TextField amountTextField;
    private Label resultLabel;
    private Label errorLabel;

    public void start(Stage stage) {
        stage.setTitle("Currency Converter");

        dao = new CurrencyDao();
        application = new CurrencyApp(dao);

        ObservableList<String> currencies = FXCollections.observableArrayList(dao.getCurrencies());

        VBox currencySelectionBox = createCurrencySelectionBox(currencies);
        GridPane conversionGrid = createConversionGrid();
        HBox buttonBox = createButtonBox();

        VBox mainContainer = new VBox(20);
        mainContainer.setPadding(new Insets(20));
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getChildren().addAll(currencySelectionBox, conversionGrid, buttonBox, errorLabel);

        Scene scene = new Scene(mainContainer, 400, 300);
        stage.setScene(scene);

        stage.show();
    }

    private VBox createCurrencySelectionBox(ObservableList<String> currencies) {
        fromCurrencyComboBox = new ComboBox<>(currencies);
        toCurrencyComboBox = new ComboBox<>(currencies);
        fromCurrencyComboBox.setValue("USD");
        toCurrencyComboBox.setValue("EUR");

        VBox currencySelectionBox = new VBox(10);
        currencySelectionBox.setAlignment(Pos.CENTER);
        currencySelectionBox.getChildren().addAll(
                new Label("From Currency:"),
                fromCurrencyComboBox,
                new Label("To Currency:"),
                toCurrencyComboBox
        );

        return currencySelectionBox;
    }

    private GridPane createConversionGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        amountTextField = new TextField();
        resultLabel = new Label();
        resultLabel.setStyle("-fx-font-weight: bold;");

        grid.add(new Label("Amount:"), 0, 0);
        grid.add(amountTextField, 1, 0);
        grid.add(new Label("Result:"), 0, 1);
        grid.add(resultLabel, 1, 1);

        return grid;
    }

    private HBox createButtonBox() {
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(event -> convertCurrency());

        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(convertButton);

        return buttonBox;
    }

    private void convertCurrency() {
        String fromCurrency = fromCurrencyComboBox.getValue();
        String toCurrency = toCurrencyComboBox.getValue();
        String amountStr = amountTextField.getText();

        try {
            double amount = Double.parseDouble(amountStr);
            double result = application.convertCurrency(amount, fromCurrency, toCurrency);
            resultLabel.setText(String.format("%.2f %s", result, toCurrency));
            errorLabel.setText("");
        } catch (NumberFormatException e) {
            resultLabel.setText("");
            errorLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
