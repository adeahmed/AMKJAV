package Week6.Synchronization.task1;

import Week6.Synchronization.task1.Even;

public class Main {
    public static void main(String[] args) {
        try {
            Even even = new Even(5);
            Odd odd = new Odd(5);

            even.start();
            odd.start();

            System.out.println("Even numbers:");
            even.printEvenNumbers();

            System.out.println("Odd numbers:");
            odd.printOddNumbers();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
