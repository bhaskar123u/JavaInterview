// https://medium.com/javarevisited/21-lambda-and-stream-interview-questions-for-java-programmers-38d7e83b5cac
/*
 * 
Lazy execution in Java Streams refers to the behavior where operations on a stream (particularly non-terminal or intermediate operations) are not executed immediately but are deferred until a terminal operation is invoked. This mechanism allows for optimization and efficient processing of data.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
public class StreamAPI {
    static List<Employee2> employeeList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();
        // Count of total employees
        System.out.println("Total employees count : " +
            employeeList.stream()
            .count()
        );
        // List all distinct project in non-ascending order
        List<String> allProjects = employeeList.stream() // employee stream
        .flatMap(employee -> employee.getProjects().stream()) // project stream
        .map(project -> project.getName()) // project
        .distinct() // string
        .sorted(Collections.reverseOrder())
        .collect(Collectors.toList());
        System.out.println("Distinct project in non-ascending order : " + allProjects);
        
        // Print full name of any employee whose firstName starts with 'A'
        System.out.println("Employee with firstName starting with A : " +
            employeeList.stream()
            .filter(employee -> employee.getFirstName().startsWith("A"))
            .map(employee -> employee.getFirstName()+" "+employee.getLastName())
            .findFirst()
            .orElse("No Such Employee")
        );

        // Print full name of all employee whose firstName starts with 'A'
        System.out.print("all employees with firstName starting with A : ");
        List<String> list =  employeeList.stream()
            .filter(employee -> employee.getFirstName().startsWith("A"))
            .map(employee -> employee.getFirstName() + " " + employee.getLastName())
            .collect(Collectors.toList());
            list.forEach(i -> System.out.println(i + " "));

        // List of all employee who joined in year 2023
        System.out.println("List of all employee who joined in year 2023 : " +
            employeeList.stream()
            .filter(employee -> employee.getId().substring(0, 4).equals("2023"))
            .map(employee -> employee.getFirstName()+" "+employee.getLastName())
            .collect(Collectors.toList())
        );
        // Print all emplyee name with 3rd highest salary
        // Check NthHighestSalaryDemo.java
        
        // Print min salary
        Optional<Integer> minSalary = employeeList.stream()
            .min(Comparator.comparing(employee -> employee.getSalary()))
            .map(employee -> employee.getSalary());
        System.out.println("Minimum Salary : " + minSalary);
        
        // Print list of all employee with min salary
        System.out.println("List of all employee with minimum salary : " +
            employeeList.stream()
            .filter(employee -> employee.getSalary() == minSalary.get())
            .map(employee -> employee.getFirstName() + " " + employee.getLastName())
            .collect(Collectors.toList())
        );
        
        // List of people working on more than 2 projects
        System.out.println("List of all employee with more than 2 projects : " +
            employeeList.stream()
            .filter(employee -> employee.getProjects().size() > 2)
            .map(employee -> employee.getFirstName() + " " + employee.getLastName())
            .collect(Collectors.toList())
        );
        
        // Count of total laptops assigned to the employees
        System.out.println("Total laptops assigned to all employees : " +
            employeeList.stream()
            .mapToInt(employee -> employee.getTotalLaptopsAssigned())
            .sum()
        );
        // Count of all projects with Robert as PM
        System.out.println("Number of projects headed by Robert as PM : " +
            employeeList.stream()
            .flatMap(employee -> employee.getProjects().stream())
            .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
            .distinct()
            .count()
        );
        // List of all projects with Robert as PM
        List<String> robertProjects = new ArrayList<String>();
            robertProjects = employeeList.stream()
            .flatMap(employee -> employee.getProjects().stream())
            .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
            .map(project -> project.getName())
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("List of all projects headed by Robert as PM : " + robertProjects);
        // List of all people working with Robert
        System.out.println("List of all employee working with Robert as PM : " +
            employeeList.stream()
            .filter(employee -> employee.getProjects().stream().anyMatch(s -> s.getProjectManager().equals("Robert Downey Jr")))
            .map(employee -> employee.getFirstName() + " " + employee.getLastName())
            .collect(Collectors.toList())
        );
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        // Map<yearOfJoining, Employee fullName>, here we will get Exception in thread "main" java.lang.IllegalStateException: Duplicate key 2017 (attempted merging values Priti Kabir and Chris Martin)
        // Map<String, String> map = employeeList.stream()
        //                             .collect(Collectors.toMap(employee -> employee.getId().substring(0,4), employee -> employee.getFirstName() + " " + employee.getLastName()));
        // System.out.println("Map<yearOfJoining, Employee fullName> : " + map);
        // Map of all employees joining in a particular year
        // Map<String, List<Employee>> map1 = employeeList.stream()
        //                                 .collect(Collectors.groupingBy(employee -> employee.getId().substring(0,4)));
        // System.out.println("Map of all employees joining in a particular year : " + map1);
        // Map<yearOfJoining, countOfEmployees>
        Map<String, Long> map3 = employeeList.stream()
                                    .collect(Collectors.groupingBy(employee -> employee.getId().substring(0,4), Collectors.counting()));
        System.out.println("Map<yearOfJoining, countOfEmployees> : " + map3);
        // Map<yearOfJoining, averageSalaryOfPeopleJoiningAYear>
        // Map<String, Long> map4 = employeeList.stream()
        //                             .collect(Collectors.groupingBy(employee -> employee.getId().substring(0,4), Collectors.averagingDouble(employee -> employee.getSalary())));
        // System.out.println("Map<yearOfJoining, averageSalaryOfPeopleJoiningAYear> : " + map4);
    }
}