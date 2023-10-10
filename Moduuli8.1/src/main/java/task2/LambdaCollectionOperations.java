package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaCollectionOperations {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);


        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even Numbers:");
        evenNumbers.forEach(System.out::println);


        List<Integer> doubledOddNumbers = numbers.stream()
                .map(number -> number % 2 == 1 ? number * 2 : number)
                .collect(Collectors.toList());

        System.out.println("\nDoubled Odd Numbers:");
        doubledOddNumbers.forEach(System.out::println);

       
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("\nSum of All Numbers: " + sum);
    }
}
