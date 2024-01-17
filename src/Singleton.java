public class Singleton {
    public static void main(String[] args) throws CloneNotSupportedException{
        /*SingletonImpl obj1 = SingletonImpl.getInstance();
        SingletonImpl obj2 = SingletonImpl.getInstance();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());*/


        /*SingletonImpl instance1 = SingletonImpl.getInstance();
        SingletonImpl instance2 = (SingletonImpl) instance1.clone();
        System.out.println("instance1 hashCode:- "+ instance1.hashCode());
        System.out.println("instance2 hashCode:- "+ instance2.hashCode());*/

        
    }
}
class SingletonImpl implements Cloneable{
    private static volatile SingletonImpl obj  = null;

    private SingletonImpl() {
        // this will handle the reflection
        if (obj != null) {
            throw new InstantiationError("Error creating class");
        }
    }
 
    public static SingletonImpl getInstance()
    {
        if (obj == null) {
            // It may happen that 2 threads reaches here, and one of them gains entry @21(let's say t1)
            // Now when t2 get's access, it assumes that the object @17 is null hence it will again create object
            // To make thread safe
            synchronized (SingletonImpl.class) {
                // check again as multiple threads
                // can reach above step
                if (obj == null)
                    obj = new SingletonImpl();
            }
        }
        return obj;
    }
    
    // when we serialise and deserialise an object, a new object gets created, we would want to stop that
    // implement readResolve method
    protected Object readResolve() {
        return obj;
    }

    public Object clone() throws CloneNotSupportedException {
        // return super.clone();
        return obj;
        //throw new CloneNotSupportedException();
    }
}
