public class TestProgram5 {
    public static void main(String[] args) {
        AmI objA = new AmI();
        //A.B objB = objA.new B(); // Object can only be created just outside the inner class declaration
        objA.fn();
    }
}
class AmI{
    int a;
    static double b;
    // Inner class
    class B{
        int c;
        //static int d; // In a inner class, which exist only on object of outer class, we cannot have static fields
        void print(){
            System.out.println("a "+a);
            System.out.println("b "+b);
            System.out.println("c "+c);
        }
    }
    B objB = new B();
    void fn(){
        objB.print();
    }
}
