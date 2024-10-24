import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI4 {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(12, 5, 8, 3, 20, 15, 6, 7, 1, 30, 2, 10, 3, 4, 5);

    // Extracting the 3rd, 4th, and 5th smallest elements
    List<Integer> smallestElements = numbers.stream()
        .distinct() // Remove duplicates
        .sorted() // Sort in ascending order
        .skip(2) // Skip the first two elements
        .limit(3) // Limit to the next three elements (3rd, 4th, 5th)
        .collect(Collectors.toList()); // Collect to a list

    System.out.println("3rd, 4th, and 5th smallest elements: " + smallestElements);
  }
}