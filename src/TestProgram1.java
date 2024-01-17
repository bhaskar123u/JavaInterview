import java.util.Comparator;

public class TestProgram1{
    public static void main(String[] args) {
    StringBuilder s1 = new StringBuilder("tony");
    StringBuilder s2 = new StringBuilder("tony");
    System.out.println(s1.equals(s2));
    System.out.println(s1.hashCode());
    System.out.println(s2.hashCode());
    String s3 = new String("stark");
    String s4 = new String("stark");
    System.out.println(s3.equals(s4));
    System.out.println(s3.hashCode());
    System.out.println(s4.hashCode());
    }
}
class MyComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getRoll() - o2.getRoll();
        // return o1.getName().compareTo(o2.getName());
    }
}
