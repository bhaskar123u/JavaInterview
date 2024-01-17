// all non static methods have access to 'this'
public class TestProgram3 {
    public static void main(String[] args) {
        TestProgram3 obj = new TestProgram3();
        System.out.println(obj + " created in main()");
        obj.hello();
    }
    public void hello(){
        System.out.println(this + " can be accessed in hello()");
        this.helloAgain();
    }
    public void helloAgain(){
        System.out.println("hello again()");
    }
}
