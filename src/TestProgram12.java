// Can abstract class be created without abstract method?
public abstract class TestProgram12 {
    public void function1(){
        System.out.println("abstract class's concrete method");
    }
}
class TestProgram12Impl extends TestProgram12{
    public static void main(String[] args) {
        TestProgram12 obj = new TestProgram12Impl();
            obj.function1();
    }
}

// output
// abstract class's concrete method