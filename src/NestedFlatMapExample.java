import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NestedFlatMapExample {
  public static void main(String[] args) {
    // Creating a 3-level nested structure (List of List of List of Integers)
    List<List<List<Integer>>> nestedList = Arrays.asList(
        Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6)),
        Arrays.asList(
            Arrays.asList(7, 8),
            Arrays.asList(9, 10)));

    // Using flatMap at multiple levels to flatten the structure
    List<Integer> flatList = nestedList.stream()
        .flatMap(listOfLists -> listOfLists.stream()) // Flattening first level (List<List<Integer>>)
        .flatMap(list -> list.stream()) // Flattening second level (List<Integer>)
        .collect(Collectors.toList()); // Collecting final flat list

    // Printing the flattened list
    System.out.println(flatList);
  }
}
