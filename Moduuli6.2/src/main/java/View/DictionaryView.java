package View;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DictionaryView {
    private Stage primaryStage;
    private TextField amountField;
    private ComboBox<String> sourceCurrencyBox;
    private ComboBox<String> targetCurrencyBox;
    private TextField resultField;
    private Button convertButton;

    public DictionaryView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Currency Converter");
        createUI();
    }

    private void createUI() {
        String cssFile = getClass().getResource("/Main.css").toExternalForm();
        scene.getStylesheets().add(cssFile);
        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
    }

    public void show() {
        primaryStage.show();
    }



    // Lisää tarvittavat getterit komponenteille, jotta voit niihin viitata muissa luokissa

    public TextField getAmountField() {
        return amountField;
    }

    public ComboBox<String> getSourceCurrencyBox() {
        return sourceCurrencyBox;
    }

    public ComboBox<String> getTargetCurrencyBox() {
        return targetCurrencyBox;
    }

    public TextField getResultField() {
        return resultField;
    }

    public Button getConvertButton() {
        return convertButton;
    }

    public void setAmountField(TextField amountField) {
        this.amountField = amountField;
    }


    public void setSourceCurrencyBox(ComboBox<String> sourceCurrencyBox) {
        this.sourceCurrencyBox = sourceCurrencyBox;
    }

    public void setTargetCurrencyBox(ComboBox<String> targetCurrencyBox) {
        this.targetCurrencyBox = targetCurrencyBox;
    }


    public void setResultField(TextField resultField) {
        this.resultField = resultField;
    }


    public void setConvertButton(Button convertButton) {
        this.convertButton = convertButton;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    
}
