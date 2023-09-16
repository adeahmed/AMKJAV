Assignment 2: Using GitHub Copilot to explain code

With GitHub Copilot, you can also write comments and explanations of code. In this assignment, you will write a textual explanation of the Calculator class and its methods. Use GitHub Copilot to write the explanations. Then, modify the explanations to make them more readable and understandable.

Proceed as follows:

    Create a Markdown file in your project. Name it README.md. If you are not familiar with Markdown, you can read about it here: https://www.markdownguide.org/basic-syntax/
    Write a short description of the idea of the program in the beginning of the file. You can edit the md document in IntelliJ Idea.
    Copy the code of the Calculator class to the md file. Be sure to mark the code as code by using three backticks before and after the code block:
    Below the code, explain how the class works. Use GitHub Copilot to write the explanation. Then, modify the explanation to make it more readable and understandable.

Documentation

How the calculator is supposed to work:

    A method that resets the calculator to zero.
    A method that adds an integer to the calculator.
    A method that returns the current value of the calculator.

package object_oriented_programming.week_04.chapter_02.task_01;

// This class is a simple calculator that can add positive numbers.
// It can also reset its sum to zero.
public class Calculator {
    private int sum;

    public static void main(String[] args) {
        // Create a calculator
        Calculator calculator = new Calculator();

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

    // The constructor creates a new calculator with a sum of zero
    public Calculator() {
        this.sum = 0;
    }

    // This method resets the sum to zero
    public void reset() {
        this.sum = 0;
    }

    // This method adds a number to the sum
    public void add(int number) {
        // Make sure the number is positive
        if (number < 0) {
            throw new IllegalArgumentException("The number must be positive.");
        }

        // Add the number to the sum
        this.sum += number;
    }

    // This method returns the sum
    public int getSum() {
        return this.sum;
    }
}

Explanation

    main() method creates a new calculator and tests the methods
    Calculator() constructor creates a new calculator with a sum of zero
    reset() method resets the sum to zero
    add() method adds a number to the sum
    getSum() method returns the sum
