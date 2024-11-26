public class DemoAbstractClass extends ParentAbstractClass {

  @Override
  int getA() {
    return a+1;
  }

  public static void main(String[] args) {
    DemoAbstractClass demoAbstractClass = new DemoAbstractClass();
    System.out.print(demoAbstractClass.getA());
  }

}

abstract class ParentAbstractClass {

  int a;

  // this will be called an we can use it to initialise ParentAbstractClass members
  ParentAbstractClass() {
    System.out.println("ParentAbstractClass constructor called()");
  }

  // ParentAbstractClass(int a) {
  //   this.a = a;
  // }

  abstract int getA();
}
