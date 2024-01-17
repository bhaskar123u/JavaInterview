import java.util.ArrayList;
import java.util.List;
public class Generics {
    public static void main(String[] args) {
        List<? extends Animal> list = new ArrayList();
        // Error WHY?
        // list.add(new Dog());
        List<Animal> list1 = new ArrayList<>();
        list1.add(new Fish());
        list1.add(new Dog());
        for(Object obj : list1)
            System.out.println(obj.getClass());
    }
}
abstract class Animal{
    public abstract void whoAmI();
}
abstract class LandAnimal extends Animal{
}
abstract class WaterAnimal extends Animal{
}
class Dog extends LandAnimal{
    @Override
    public void whoAmI() {
        System.out.println("I am a dog");
    }
}
class Fish extends WaterAnimal{
    @Override
    public void whoAmI() {
        System.out.println("I am a fish");
    }
}
