import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI3 {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(12, 5, 8, 3, 20, 15, 6, 7, 1, 30);

    // Finding and printing the three smallest numbers
    List<Integer> threeSmallest = numbers.stream()
        .sorted() // Sort in ascending order
        .distinct() // Remove duplicates
        .limit(3) // Limit to the first three elements
        .collect(Collectors.toList()); // Collect to a list

    System.out.println("Three smallest numbers: " + threeSmallest);

    // Finding and printing the three largest numbers
    List<Integer> threeLargest = numbers.stream()
        .sorted((a, b) -> b.compareTo(a)) // Sort in descending order
        .distinct() // Remove duplicates
        .limit(3) // Limit to the first three elements
        .collect(Collectors.toList()); // Collect to a list

    System.out.println("Three largest numbers: " + threeLargest);
  }
}