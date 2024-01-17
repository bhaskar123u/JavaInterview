// Uncomment and guess the output
public class TestProgram15 {
    public void test(Integer i) {
        System.out.println("test() Integer method called");
    }
    public void test(String s) {
        System.out.println("test() String method called");
    }
    public void test(Object obj) {
        System.out.println("test() Object method called");
    }
    public static void main(String[] args) {
        TestProgram15 test = new TestProgram15();
        //test.test(null);
    }
}
