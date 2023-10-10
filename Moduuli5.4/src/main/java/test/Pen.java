package test;
public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }

    private Color currentColor;
    private boolean capOn;

    public Pen() {
        this.currentColor = Color.RED; // Oletusväri on punainen
        this.capOn = true; // Korkki on oletuksena kiinni
    }

    public Pen(Color initialColor) {
        this.currentColor = initialColor;
        this.capOn = true; // Korkki on oletuksena kiinni
    }

    public void capOff() {
        this.capOn = false;
    }

    public void capOn() {
        this.capOn = true;
    }

    public String draw() {
        if (capOn) {
            return ""; // Jos korkki on kiinni, ei voida piirtää
        } else {
            return "Drawing " + currentColor;
        }
    }

    public void changeColor(Color newColor) {
        if (capOn) {
            this.currentColor = newColor;
        }
    }
}

