import java.util.ArrayList;
import java.util.List;
public class Generics2 {
    public static void main(String[] args) throws Exception {
        Student2 student = new Student2();
        EnggStudent enggStudent = new EnggStudent();
        System.out.println(student.whoAmI());
        System.out.println(enggStudent.whoAmI());
        student = enggStudent;
        System.out.println(student.whoAmI());
        System.out.println(enggStudent.whoAmI());
        // List<Student> studentsList = new ArrayList<>(); // this will lead to error
        List<? extends Student2> studentsList = new ArrayList<>();
        List<EnggStudent> enggStudentsList = new ArrayList<>();
        studentsList = enggStudentsList;
    }
}
class EnggStudent extends Student2{
    public String whoAmI(){
        return "I'm a engg student";
    }
}
class Student2 {
    
    public String whoAmI(){
        return "I'm a student";
    }
}
