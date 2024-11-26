public class DiamondProblemInterfaceImple implements DiamondProblemInterface1, DiamondProblemInterface2{
  @Override
  public void fn() {
    // we can call parent iterface methods as
    DiamondProblemInterface1.super.fn();
  }
  // comment above function to see error
}
