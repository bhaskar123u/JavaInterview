public class RuntimePolymorphism {
    public static void main(String[] args) {
        Child obj = new Child();
        System.out.println(obj.getNum());
        System.out.println(obj.getRandNum());
        Parent obj1 = new Child();
        System.out.println(obj1.getRandNum());
    }
}
class Parent{
    Integer getNum(){
        return 2;
    }
    static int getRandNum(){
        return 3;
    }
}
class Child extends Parent{
    // Java support covariant return type, meaning we can change return type of overriding function as long as it is child of parent's return type
    /*Number getNum(){
        return 3;
    }*/
    static int getRandNum(){
        return 5;
    }
}
