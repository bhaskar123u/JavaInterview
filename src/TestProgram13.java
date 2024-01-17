import java.util.List;
public class TestProgram13 {
    public static void main(String[] args) {
        //ArrayList<Integer> list = (ArrayList)List.of(1,2,3);
        // List.of returns a immutable list which can't be casted to ArrayList
        /*
        Exception in thread "main" java.lang.ClassCastException: class java.util.ImmutableCollections$ListN cannot be cast to class java.util.ArrayList (javautil.ImmutableCollections$ListN and java.util.ArrayList are in module java.base of loader 'bootstrap')
        at TestProgram13.main(TestProgram13.java:6)
        */
        List<Integer> list = List.of(1,2,3);
        list.forEach(item -> System.out.println(item));
    }
}
