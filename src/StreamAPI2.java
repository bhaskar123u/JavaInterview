import java.util.*;
import java.util.stream.Collectors;

// use of custom collectors
public class StreamAPI2 {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(12, 5, 8, 3, 20, 15, 6, 7, 1, 30);

    // Collecting three smallest numbers
    List<Integer> threeSmallest = numbers.stream()
        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.naturalOrder())))
        .stream()
        .limit(3)
        .collect(Collectors.toList());

    System.out.println("Three smallest numbers: " + threeSmallest);

    // Collecting three largest numbers
    List<Integer> threeLargest = numbers.stream()
        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.reverseOrder())))
        .stream()
        .limit(3)
        .collect(Collectors.toList());

    System.out.println("Three largest numbers: " + threeLargest);
  }
}