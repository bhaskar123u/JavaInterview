public class Base62 {
  public static void main(String[] args) {
    System.out.println(Base62Impl.encode(100000000000L)); // 10^11
  }
}

class Base62Impl {
  static String s = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
  public static String encode(long num) {
    StringBuilder result = new StringBuilder();

    while (num > 0) {
      int index = (int)num % 62;
      result.append(s.charAt(index));
      num = num / 62;
    }

    return result.toString();
  }
}
