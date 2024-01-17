import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class TestProgram6 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Bhaskar Sharan", 27, 900000, "St. Albert's");
        String file = "/Users/bhaskarsharan/Desktop/testprogram6.txt";
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(teacher);
            fos.close();
            oos.close();
            System.out.println("Teacher object is serialized : " + teacher);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // During deserialization we cannot alter the class nature, it will throw exception  
            //Teacher2 tmp = (Teacher2) ois.readObject();
            Teacher tmp = (Teacher) ois.readObject();
            fis.close();
            ois.close();
            System.out.println("Teacher object is de-serialized : " + tmp);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
class Teacher implements Serializable{
    private static final long serialVersionUID = 21L;
    private String name;
    private int age;
    private int salary;
    private transient String schoolName; // transient variables are not converted in bytes
    public Teacher(String name, int age, int salary, String schoolName){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.schoolName = schoolName;
    }
    @Override
    public String toString() {
        return "Teacher [name=" + name + ", age=" + age + ", salary=" + salary + ", schoolName=" + schoolName + "]";
    }
}
class Teacher2 implements Serializable{
    private static final long serialVersionUID = 21L;
    private String name;
    private int age;
    private int salary;
    public Teacher2(String name, int age, int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Teacher2 [name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}
