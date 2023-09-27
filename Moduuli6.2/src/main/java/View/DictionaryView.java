package View;

import Controller.DictionaryController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DictionaryView extends Application {
    private final ToggleGroup startGroup = new ToggleGroup();
    private final ToggleGroup endGroup = new ToggleGroup();
    private final TextField startCurrencyTextField = new TextField();
    private final TextField endCurrencyTextField = new TextField();
    private final Label errorLabel = new Label();
    private final String[] currencies = {"USD", "EUR", "JPY", "GBP"};

    private DictionaryController controller;

    public void start(Stage stage) {
        stage.setTitle("Currency Converter");

        // Header
        Label titleLabel = new Label("Currency Converter");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setAlignment(Pos.CENTER);

        VBox startingCurrencyContainer = currencySettings(new VBox(), "Source Currency: ", startGroup);
        VBox endingCurrencyContainer = currencySettings(new VBox(), "Target Currency: ", endGroup);

        HBox currencyContainer = new HBox();
        currencyContainer.setAlignment(Pos.CENTER);
        currencyContainer.setSpacing(25);
        currencyContainer.getChildren().addAll(startingCurrencyContainer, endingCurrencyContainer);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(5);

        Label startCurrencyLabel = new Label("Amount in Starting Currency:");
        Label endCurrencyLabel = new Label("Converted Amount in Target Currency:");
        Button convertButton = new Button("Convert");

        gridPane.add(startCurrencyLabel, 0, 0);
        gridPane.add(startCurrencyTextField, 0, 1);
        gridPane.add(endCurrencyLabel, 2, 0);
        gridPane.add(endCurrencyTextField, 2, 1);
        gridPane.add(convertButton, 1, 1);

        convertButton.setOnAction(event -> {
            String startCurrency = startGroup.getSelectedToggle().getUserData().toString();
            String endCurrency = endGroup.getSelectedToggle().getUserData().toString();
            String startValue = startCurrencyTextField.getText();
            if (startValue.isEmpty()) {
                System.out.println("The input field is empty");
                errorLabel.setText("The input field is empty");
                return;
            }

            try {
                double startingValue = Double.parseDouble(startValue);
                controller.convert(startingValue, startCurrency, endCurrency);
                errorLabel.setText("");
            } catch (NumberFormatException e) {
                System.out.println("The input field is not a valid number");
                errorLabel.setText("The input field is not a valid number");
            }
        });

        VBox helpContainer = new VBox();
        helpContainer.setSpacing(5);
        helpContainer.paddingProperty().setValue(new Insets(16));
        Label helpHeader = new Label("How to Use the Currency Converter:");
        helpHeader.getStyleClass().add("help-header");
        helpContainer.setAlignment(Pos.CENTER);
        helpContainer.getChildren().addAll(
                helpHeader,
                new Label("1. Enter the amount you want to convert in the first field."),
                new Label("2. Select your source and target currencies using the radio buttons."),
                new Label("3. Click the \"Convert\" button to see the converted amount in the second field.")
        );

        VBox mainContainer = new VBox();
        mainContainer.setSpacing(25);
        mainContainer.paddingProperty().setValue(new Insets(16));
        mainContainer.getChildren().addAll(titleLabel, currencyContainer, errorLabel, gridPane, helpContainer);
        errorLabel.getStyleClass().add("error-label");

        Scene scene = new Scene(mainContainer, 500, 500);
        scene.getStylesheets().add("Styles.css"); // Lisää tyylitiedoston nimi tarvittaessa

        stage.setScene(scene);
        stage.show();
    }

    public void init() {
        controller = new DictionaryController(this);
    }

    public VBox currencySettings(VBox container, String header, ToggleGroup group) {
        container.getChildren().add(new Label(header));

        for (String currency : currencies) {
            RadioButton radioButton = new RadioButton(currency);
            radioButton.setUserData(currency);
            radioButton.setToggleGroup(group);
            radioButton.setSelected(true);
            container.getChildren().add(radioButton);
        }

        return container;
    }

    public void convertAnswer(String answer) {
        endCurrencyTextField.setText(answer);
    }


}
