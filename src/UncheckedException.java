public class UncheckedException {
  public static void main(String[] args) throws ArithmeticException,NullPointerException{
    //System.out.println(divide(9, 3, null));
    System.out.println(divide(9, 0, null));
  }

  public static int divide(int a, int b, Mobile mobile) {
    // throwing checked exception
    if (b == 0)
      throw new ArithmeticException();

    // throwing unchecked exception
    if (mobile == null)
      throw new NullPointerException();

    return a / b;
  }
}

class Mobile {
}
