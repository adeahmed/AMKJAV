package View;
import javafx.application.Application;
import Controller.DictionaryController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.scene.control.*;

public class DictionaryView extends Application {
    private DictionaryController controller;

    @Override
    public void start(Stage stage){

        stage.setTitle("Dictionary");

        FlowPane root = new FlowPane();

        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        Label addWordLabel = new Label("Add a word");
        root.getChildren().add(addWordLabel);

        TextField addWordInput = new TextField();
        addWordInput.setPromptText("Word to add");
        root.getChildren().add(addWordInput);

        TextField addMeaningInput = new TextField();
        addMeaningInput.setPromptText("Word meaning");
        root.getChildren().add(addMeaningInput);

        Button addButton = new Button("Add");
        root.getChildren().add(addButton);

        Label searchWord = new Label("Search for a word");
        root.getChildren().add(searchWord);

        TextField searchWordInput = new TextField();
        searchWordInput.setPromptText("Search for a word");
        root.getChildren().add(searchWordInput);

        Button searchButton = new Button("Search");
        root.getChildren().add(searchButton);

        TextArea meaningOutput = new TextArea();
        meaningOutput.setEditable(false);
        meaningOutput.setPrefWidth(490);
        root.getChildren().add(meaningOutput);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.addWord(addWordInput.getText(), addMeaningInput.getText());
                meaningOutput.setText(addWordInput.getText() + " has been added to dictionary");
            }
        });

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                meaningOutput.setText(controller.searchWord(searchWordInput.getText()));
            }
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void init(){
        controller = new DictionaryController(this);
    }
}
