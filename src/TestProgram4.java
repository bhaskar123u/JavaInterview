public class TestProgram4 {
    public static void main(String[] args) {
        A.C obj = new A.C();
        System.out.println(A.C.x);
        obj.print();
    }
}
class A{
    int a;
    static int b;
    // Static inner class
    static class C{
        int m = 10;
        static double x;
        static{
            x = 1.0;
        }
        
        void print(){
            //System.out.println("a "+a); // Static inner class can't access non-static outer class variables
            System.out.println("b : "+b);
            System.out.println("x : "+x);
            System.out.println("m : "+m);
        }
    }
}

// output
/*
 * 1.0
 * b : 0
 * x : 1.0
 * m : 10
 */