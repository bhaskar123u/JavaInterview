import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamAPI5 {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("John", "Aane", "Jack", "Bill", "Mulie", "Jamie", "Jacky");

    // Parallel stream: processes elements concurrently, not guaranteed to preserve
    // order
    // names.parallelStream()
    //     .filter(name -> name.startsWith("J"))
    //     .forEach(System.out::println);
    // output
    /*
     * Jack
     * Jill
     * Jane
     * John
     */

    Optional<String> s = names.parallelStream()
        .filter(s1 -> s1.startsWith("J"))
        .findAny();
    if(s.isPresent())
      System.out.println(s.get());
  }
}
