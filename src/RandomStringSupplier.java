import java.util.Random;
import java.util.function.Supplier;

public class RandomStringSupplier {
  public static void main(String[] args) {
    // Supplier for generating random strings
    Supplier<String> randomStringSupplier = () -> {
      String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
      Random random = new Random();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 10; i++) {
        int index = random.nextInt(characters.length());
        sb.append(characters.charAt(index));
      }
      return sb.toString();
    };

    // Generate and print random strings
    for (int i = 0; i < 5; i++) {
      System.out.println(randomStringSupplier.get()); // Output: Random strings of 10 characters each
    }
  }
}