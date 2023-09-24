package Week6.task1;

public class Even extends Thread {
    private int count = 0;

    public Even(int count) {
        this.count = count;
    }

    public void run() {
        for(int i = 1; i <= count; i++) {
            if(i % 2 == 0) {
                System.out.println("Even: " + i);
            }
        }
    }

    public void printEvenNumbers() {
    }
}

