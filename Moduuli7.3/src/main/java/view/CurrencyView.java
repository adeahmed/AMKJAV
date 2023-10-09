package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dao.CurrencyDao;
import datasource.MariaDbCurrencyDao;
import entity.Currency;
import application.CurrencyConverter;
import datasource.MariaDbCurrencyDao;

public class CurrencyView extends Application {
    private final ToggleGroup startGroup = new ToggleGroup();
    private final ToggleGroup endGroup = new ToggleGroup();
    private final TextField startCurrencyTextField = new TextField();
    private final TextField endCurrencyTextField = new TextField();
    private final Label errorLabel = new Label();
    private final String[] currencies = {"USD", "EUR", "JPY", "GBP"};

    private CurrencyConverter converter;

    public void start(Stage stage) {
        stage.setTitle("Currency Converter.");
        CurrencyDao dao = (CurrencyDao) new MariaDbCurrencyDao();
        converter = new CurrencyConverter(dao);

        VBox startingCurrencyContainer = currencySettings(new VBox(), "Choose a source currency: ", startGroup);
        VBox endingCurrencyContainer = currencySettings(new VBox(), "Choose a target currency: ", endGroup);

        HBox currencyContainer = new HBox();
        currencyContainer.setAlignment(Pos.CENTER);
        currencyContainer.setSpacing(25);
        currencyContainer.getChildren().addAll(startingCurrencyContainer, endingCurrencyContainer);

        GridPane gridPane = createGridPane();

        Button convertButton = new Button("Convert");
        configureConvertButton(convertButton);

        Button addNewCurrencyButton = new Button("Add new currency");
        configureAddCurrencyButton(addNewCurrencyButton);

        VBox mainContainer = new VBox();
        mainContainer.setSpacing(25);
        mainContainer.setPadding(new Insets(16));
        mainContainer.getChildren().addAll(currencyContainer, addNewCurrencyButton, errorLabel, gridPane);
        errorLabel.getStyleClass().add("error-label");

        Scene scene = new Scene(mainContainer, 800, 600); // Set your preferred window size
        scene.getStylesheets().add("week6/chapter-2.css");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(5);

        Label startCurrencyLabel = new Label("Starting currency: ");
        Label endCurrencyLabel = new Label("Conversion currency: ");

        gridPane.add(startCurrencyLabel, 0, 0);
        gridPane.add(startCurrencyTextField, 0, 1);
        gridPane.add(endCurrencyLabel, 2, 0);
        gridPane.add(endCurrencyTextField, 2, 1);

        return gridPane;
    }

    private void configureConvertButton(Button convertButton) {
        convertButton.setOnAction(event -> {
            String startCurrency = startGroup.getSelectedToggle().getUserData().toString();
            String endCurrency = endGroup.getSelectedToggle().getUserData().toString();
            String startValue = startCurrencyTextField.getText();
            if (startValue.isEmpty()) {
                showError("The search field is empty");
                return;
            }

            try {
                double startingValue = Double.parseDouble(startValue);
                double result = converter.convertCurrency(startingValue, startCurrency, endCurrency);
                endCurrencyTextField.setText(String.format("%s %.2f", endCurrency, result));
                errorLabel.setText("");
            } catch (NumberFormatException e) {
                showError("The search field is not a number");
            }
        });
    }

    private void configureAddCurrencyButton(Button addNewCurrencyButton) {
        addNewCurrencyButton.setOnAction(event -> {
            Stage popupStage = new Stage();
            // Code for adding a new currency goes here
            // ...
        });
    }

    private void showError(String message) {
        System.out.println(message);
        errorLabel.setText(message);
    }

    public VBox currencySettings(VBox container, String header, ToggleGroup group) {
        // Code for configuring currency settings goes here
        // ...
        return container;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
