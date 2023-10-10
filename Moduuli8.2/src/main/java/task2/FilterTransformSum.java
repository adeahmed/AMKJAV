package task2;

import java.util.Arrays;
import java.util.List;

public class FilterTransformSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * 2)
                .sum();

        System.out.println("Sum of doubled even numbers: " + sum);
    }
}
