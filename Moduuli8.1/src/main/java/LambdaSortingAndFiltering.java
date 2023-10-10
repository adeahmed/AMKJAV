import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaSortingAndFiltering {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, "New York"));
        people.add(new Person("Bob", 25, "Los Angeles"));
        people.add(new Person("Charlie", 35, "New York"));
        people.add(new Person("David", 28, "Chicago"));
        people.add(new Person("Eva", 22, "Chicago"));


        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());

        System.out.println("Sorted by Age:");
        sortedByAge.forEach(System.out::println);


        List<Person> newYorkResidents = people.stream()
                .filter(person -> "New York".equals(person.getCity()))
                .collect(Collectors.toList());

        System.out.println("\nNew York Residents:");
        newYorkResidents.forEach(System.out::println);
    }
}

