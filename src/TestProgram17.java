// !!!!! IMPROVE THIS CODE !!!!!

import java.io.IOException;

public class TestProgram17 {
  public static void main(String[] args){
    fn();
    System.out.println("after fn()");
  }
  
  public static void fn(){
    try {
      System.out.println("Try");
      int result = 10 / 0;
      throw new ClassNotFoundException("");
    } catch (ClassNotFoundException e) {
      System.out.println("Catch 1");
      throw new RuntimeException("Runtime Exception");
    } catch (ArithmeticException e) {
      System.out.println("Arithmetic Exception");
      throw new IOException("IO Exception");
    } catch (IOException e) {
      System.out.println("IO Exception");
    } catch (Exception e) {
      System.out.println("Exception");
    } finally {
      System.out.println("finally");
    }
  }
}
