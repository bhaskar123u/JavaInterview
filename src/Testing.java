import java.util.ArrayList;
import java.util.Scanner;

/**
 * Testing
 */
public class Testing {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // String name1;
    // int id1, age1;
    
    // I can input name if input is before all integers
    
    /*System.out.println("Enter id");
    id1 = in.nextInt();
    
    System.out.println("Enter name"); // Problem here, name input gets skipped
    name1 = in.nextLine();
    
    System.out.println("Enter age");
    age1 = in.nextInt();
    
    int a;
    int b;
    int c;
    String s;
    
    a = sc.nextInt();
    b = sc.nextInt();
    sc.nextLine();
    s = sc.nextLine();
    c = sc.nextInt();
    
    System.out.println(a + " " + b + " " + c + " " + s);
    
    System.out.println("Enter");*/
    
    int a = sc.nextInt();
    sc.nextLine();
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < a; i++) {
      list.add(sc.nextLine());
    }
    
    list.forEach(i -> System.out.println(i + " "));
    
    sc.close();


  }
}

// notes
/*
 * https://stackoverflow.com/questions/26626106/why-string-inputs-after-integer-input-gets-skipped-in-java
 * https://dev.to/sbu_05/reading-an-string-after-an-integer-4jbp
 */
