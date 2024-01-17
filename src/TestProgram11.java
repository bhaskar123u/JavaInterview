public class TestProgram11 {
    public static void main(String[] args) {
        Mobikwik1 mob = new Mobikwik1();
        System.out.println(mob.getA());
    }
}
// If the static variable declared as final, then we have to perform initialization explicitly whether we are using it or not and JVM won’t provide any default value for the final static variable.
// For final static variable, it is compulsory that we should perform initialization before class loading completion. We can initialize a final static variable at the time of declaration.
// We can also initialize a final static variable inside a static block because we should initialize a final static variable before class and we know that static block is executed before main() method.
class Mobikwik1{
    final static int a = 5; // CORRECT WAY 1
    //final static int a;
    // CORRECT WAY 2
    /*static{
        a = 5;
    }*/
    Mobikwik1(){
    }
    int getA(){
        return a;
    }
}
