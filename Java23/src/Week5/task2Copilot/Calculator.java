package Week5.task2Copilot;

public class Calculator {
    public static void main(String[] args) {


        Calculator calculator = new Calculator();
        
        // Test the methods
        System.out.println(calculator.add(1, 2, 3, 4, 5));
        System.out.println(calculator.subtract(1, 2, 3, 4, 5));
        System.out.println(calculator.multiply(1, 2, 3, 4, 5));
        System.out.println(calculator.divide(1, 2, 3, 4, 5));
    }

    /**
     * Returns the sum of all the numbers.
     * @param numbers The numbers to add.
     * @return The sum of all the numbers.
     */

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    /**
     * Returns the difference of all the numbers.
     *
     * @param numbers The numbers to subtract.
     * @return The difference of all the numbers.
     */

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int subtract(int... numbers) {
        int difference = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            difference -= numbers[i];
        }

        return difference;
    }

    /** Multiplies all of the numbers in the list together.
     * @param numbers The numbers to be multiplied together.
     * @return The result of multiplying all of the numbers together.
     */

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int multiply(int... numbers) {
        int product = 1;
        for (int number : numbers) {
            product *= number;
        }

        return product;
    }


    /**
     * Divides all the given numbers from each other.
     * @param numbers the numbers to divide
     * @return the quotient of the division
     */

    public static int divide(int a, int b) {
        return a / b;
    }

    public static int divide(int... numbers) {
        int quotient = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            quotient /= numbers[i];
        }

        return quotient;
    }
}