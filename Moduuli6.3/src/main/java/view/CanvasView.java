package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.PetController;
import model.PetImage;

public class CanvasView extends Application {
    private PetController controller;
    private GraphicsContext gc;


    @Override
    public void start(Stage stage) {
        stage.setTitle("Virtual Pet");

        Canvas canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();

        controller = new PetController(this);
        controller.initializePet("/RAT.png", 2, 3, 2.0);

        canvas.setOnMouseMoved(controller::handleMouseMoved);
        canvas.setOnMouseExited(event -> {
            controller.handleMouseExited();
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });

        VBox vBox = new VBox(canvas);
        stage.setScene(new Scene(vBox));
        stage.show();

        // Start animation loop
        animate();
    }

    private void animate() {
        new Thread(() -> {
            while (true) {
                if (controller.isPetMoving()) {
                    PetImage pet = controller.getPet();
                    gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
                    gc.drawImage(pet.getImage(), pet.getX(), pet.getY(), 40 , 40);
                }
                try {
                    Thread.sleep(16); // 60 FPS
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
