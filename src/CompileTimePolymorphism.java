public class CompileTimePolymorphism {
    public static void main(String[] args) {
        CTP obj = new CTP();
        obj.print();
        System.out.println(obj.print(2));
        try {
            System.out.println(obj.print("Calling method"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// as long as they have same name and different arguments
// they may or maynot
// have different access specifier
// have different return types
// throw different checked and unchecked exceptions
class CTP{
    public void print(){
        System.out.println("void print() called");
    }
    protected int print(int a) throws RuntimeException{
        System.out.println("int print() called");
        return 1;
    }
    String print(String a) throws Exception{
        System.out.println("String print() called");
        return "Hello";
    }
}
