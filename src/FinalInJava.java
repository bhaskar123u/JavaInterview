public class FinalInJava {
    public static void main(String[] args) {
        
    }
}
final class FinalDemo{
}
/*class FinalDemo1 extends FinalDemo{
    Error
}*/
class FinalDemo2{
    private final int a;
    FinalDemo2(int a){
        this.a = a;
    }
    public int getA() {
        return a;
    }
    final void print(){
        System.out.println("Hello");
    }
    public void setA(int a){
        //this.a = a; // Error
    }
}
class FinalDemo3 extends FinalDemo2{
    FinalDemo3(int a) {
        super(a);
    }
    /*@Override
    final void print(){
        Error
    }*/
}
