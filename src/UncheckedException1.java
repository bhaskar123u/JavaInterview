import java.io.IOException;

public class UncheckedException1 {
  public static void main(String[] args) throws IOException {
    divide();
  }
  
  // you have to explicitly define checked exception for propogation just writing
  // public static int divide() won't compile, on the other hand unchecked exception propogation happens automatically
  public static int divide() throws IOException {
    throw new IOException();
  }
}
