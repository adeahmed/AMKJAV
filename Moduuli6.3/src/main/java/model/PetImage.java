package model;

import javafx.scene.image.Image;

public class PetImage {
    private Image image;
    private double x, y; // Pet's current position
    private double speed; // Pet's movement speed in pixels per frame

    public PetImage(String imgPath, double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.image = new Image(imgPath);
    }

    public Image getImage() {
        return image;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveTo(double targetX, double targetY) {
        double deltaX = targetX - x;
        double deltaY = targetY - y;
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        if (distance > 0) {
            // Calculate normalized direction vector
            double directionX = deltaX / distance;
            double directionY = deltaY / distance;

            // Move the pet towards the target
            x += directionX * speed;
            y += directionY * speed;
        }
    }
}
