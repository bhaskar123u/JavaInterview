public class TestProgram7 {
    public static void main(String[] args) {
        TestProgram7 obj = new TestProgram7();
        obj.start();
    }
    void start() {
        String s = "do";
        String s2 = method(s);
        System.out.print(": " + s + s2);
    }
    String method(String s) {
        s = s + "good";
        System.out.print(s);
        return "good";
    }
}

// output
// dogood: dogood