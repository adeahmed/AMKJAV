package controller;

import javafx.scene.input.MouseEvent;
import view.CanvasView;
import model.PetImage;

public class PetController {
    private PetImage pet;
    private CanvasView view;
    private boolean isMoving;

    public PetController(CanvasView view) {
        this.view = view;
    }



    public void initializePet(String imgPath, double x, double y, double speed) {
        pet = new PetImage(imgPath, x, y, speed);
        isMoving = false;
    }

    public void handleMouseMoved(MouseEvent event) {
        if (pet != null) {
            pet.moveTo(event.getX(), event.getY());
            isMoving = true;
        }
    }

    public void handleMouseExited() {
        isMoving = false;
    }

    public boolean isPetMoving() {
        return isMoving;
    }

    public PetImage getPet() {
        return pet;
    }
    public static void main(String[] args) {
        CanvasView.launch(CanvasView.class);
    }

}
