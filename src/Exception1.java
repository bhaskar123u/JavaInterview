public class Exception1 {
    public static void main(String[] args) {
        ChildException obj = new ChildException();
        obj.hello();
    }
}
class Exceptionex{
    public void hello() throws ArithmeticException{
        System.out.println("Inside Exceptionex");
    }
}
class ChildException extends Exceptionex{
    public void hello() throws NullPointerException{
        System.out.println("Inside ChildException");
    }
}

// output
// Inside ChildException