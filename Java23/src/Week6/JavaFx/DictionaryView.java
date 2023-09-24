// package Week6.JavaFx;

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.FlowPane;
// import javafx.stage.Stage;

// public class DictionaryView extends Application {
//     private DictionaryController controller;

//     public DictionaryView() {
//         // Initialize the controller and dictionary here
//         Dictionary dictionary = new Dictionary();
//         controller = new DictionaryController(dictionary);
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Virtual Dictionary");

//         FlowPane root = new FlowPane();

//         TextField searchField = new TextField();
//         Button searchButton = new Button("Search");
//         Label meaningLabel = new Label();

//         searchButton.setOnAction(e -> {
//             String word = searchField.getText();
//             String meaning = controller.searchWord(word);
//             meaningLabel.setText(meaning);
//         });

//         root.getChildren().addAll(searchField, searchButton, meaningLabel);

//         Scene scene = new Scene(root, 300, 150);
//         primaryStage.setScene(scene);

//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

