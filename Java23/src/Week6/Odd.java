package Week6;

public class Odd extends Thread {
    private int count = 0;

    public Odd(int count) {
        this.count = count;
    }

    public void run() {
        for(int i = 1; i <= count; i++) {
            if(i % 2 == 1) {
                System.out.println("Odd: " + i);
            }
        }
    }

    public void printOddNumbers() {
    }
}


