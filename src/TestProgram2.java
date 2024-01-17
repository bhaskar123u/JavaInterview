import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestProgram2 {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Saket Kumar", 37));
        studentList.add(new Student("Madan Kumar", 34));
        Collections.sort(studentList, new MyComparator());
        for(Student s : studentList)
            System.out.println(s.getName() + " " + s.getRoll());
        System.out.println("---------------------");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Bhaskar Sharan", 38));
        employeeList.add(new Employee("Saket Kumar", 37));
        employeeList.add(new Employee("Saket Kumar", 34));
        Collections.sort(employeeList);
        for(Employee e : employeeList)
            System.out.println(e.getName() + " " + e.getId());
    }
}

// output
/*
 * Madan Kumar 34
 * Saket Kumar 37
 * ---------------------
 * Bhaskar Sharan 38
 * Saket Kumar 34
 * Saket Kumar 37
 */