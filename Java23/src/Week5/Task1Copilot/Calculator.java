package Week5.Task1Copilot;
// In a new project, write a `Calculator` class that has the ability to sum positive integers. A negative integer should throw an exception.

// The class acts as the model in the MVC pattern. It should have the following methods:
// - A method that resets the calculator to zero.
// - A method that adds an integer to the calculator.
// - A method that returns the current value of the calculator.

// In addition, write a temporary main method that creates an instance of the `Calculator` class and uses it to calculate the sum of a few integers.

// Explore various way in which you can use GitHub Copilot to write the sum method. For example, try the following:

// - Write the method signature and let GitHub Copilot write the method body.
// - Write the method signature and the first line of the method body, and let GitHub Copilot write the rest. Then, modify the code to use a different loop structure (while instead of for, or vice versa) in the body.
// - Write a comment where you describe the method in English, letting GitHub Copilot write the method body based on the comment.

public class Calculator{
    private int sum;

    public static void main(String[] args) {
        Calculator  calculator = new Calculator();

        // Test the methods
        System.out.println(calculator.getSum());
        calculator.add(1);
        System.out.println(calculator.getSum());
        calculator.add(2);
        System.out.println(calculator.getSum());
        calculator.add(3);
        System.out.println(calculator.getSum());
        calculator.add(4);
        System.out.println(calculator.getSum());
        calculator.add(5);
        System.out.println(calculator.getSum());
        calculator.reset();
        System.out.println(calculator.getSum());
    }

    public Calculator() {
        this.sum = 0;
    }

    public void reset() {
        this.sum = 0;
    }

    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("The number must be positive.");
        }

        this.sum += number;
    }

    public int getSum() {
        return this.sum;
    }
}