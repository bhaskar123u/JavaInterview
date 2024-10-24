import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Singleton {
    public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException, IOException, ClassNotFoundException{
        SingletonImpl obj1 = SingletonImpl.getInstance();
        SingletonImpl obj2 = SingletonImpl.getInstance();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        // Trying to create instance using clone
        SingletonImpl instance1 = SingletonImpl.getInstance();
        SingletonImpl instance2 = (SingletonImpl) instance1.clone();
        System.out.println("Instance 1 hashCode (cloning): " + instance1.hashCode());
        System.out.println("Instance 2 hashCode (cloning): " + instance2.hashCode());

        // Serialize the singleton instance
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            oos.writeObject(obj1);
        }

        // Deserialize the singleton instance
        SingletonImpl deserializedInstance;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
            deserializedInstance = (SingletonImpl) ois.readObject();
        }

        System.out.println("Deserialized Instance hashCode: " + deserializedInstance.hashCode());
        System.out.println("Are both instances equal? " + (obj1 == deserializedInstance));

        // Attempt to create an object using reflection
        try {
            Constructor<SingletonImpl> constructor = SingletonImpl.class.getDeclaredConstructor();
            constructor.setAccessible(true);  // Bypass the private constructor access
            SingletonImpl reflectionInstance = constructor.newInstance();  // Create new instance
            System.out.println("Reflection instance hashCode: " + reflectionInstance.hashCode());
        } catch (Exception e) {
            System.out.println("Reflection failed: " + e.getMessage());
        }
    }
}

class SingletonImpl implements Cloneable, Serializable {
    //private static final long serialVersionUID = 1L;
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
            // It may happen that 2 threads reaches here, and one of them gains entry @33(let's say t1)
            // Now when t2 get's access, it assumes that the object @29 is null hence it will again create object
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
