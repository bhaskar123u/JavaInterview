import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionalInterface2 {
    public static void main(String[] args) {
        // Supplier to generate random integers
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100); // Generates random numbers between 0 and 99

        // Use the supplier to create a stream of random numbers
        Stream<Integer> randomNumbers = Stream.generate(randomSupplier)
            .limit(5); // Limit to 5 random numbers

        // Print the random numbers
        System.out.println("Random Numbers:");
        randomNumbers.forEach(System.out::println);
        /*
        * Output: (5 random integers between 0 and 99)
        */
    }
}