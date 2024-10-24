import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterface1 {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Predicate to filter even numbers
    Predicate<Integer> isEven = number -> number % 2 == 0;

    // Function to square a number
    Function<Integer, Integer> square = number -> number * number;

    // Use both predicate and function in a stream
    List<Integer> squaredEvenNumbers = numbers.stream()
        .filter(isEven) // Filtering even numbers
        .map(square) // Squaring the filtered numbers
        .toList(); // Collect results into a List

    System.out.println("Squared Even Numbers: " + squaredEvenNumbers); // Output: Squared Even Numbers: [4, 16, 36, 64,
                                                                       // 100]
  }
}
