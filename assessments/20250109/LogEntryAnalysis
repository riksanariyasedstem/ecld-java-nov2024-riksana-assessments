import java.util.*;
import java.util.stream.*;

public class Main {


    static class Employee {
        private String name;
        private String department;
        private double salary;
        private List<String> skills;


        public Employee(String name, String department, double salary, List<String> skills) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.skills = skills;
        }


        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public List<String> getSkills() {
            return skills;
        }
    }


    static class DepartmentStats {
        private double averageSalary;
        private long employeeCount;
        private Set<String> uniqueSkills;


        public DepartmentStats(double averageSalary, long employeeCount, Set<String> uniqueSkills) {
            this.averageSalary = averageSalary;
            this.employeeCount = employeeCount;
            this.uniqueSkills = uniqueSkills;
        }

        @Override
        public String toString() {
            return "DepartmentStats{" +
                    "averageSalary=" + averageSalary +
                    ", employeeCount=" + employeeCount +
                    ", uniqueSkills=" + uniqueSkills +
                    '}';
        }
    }

    public static Map<String, DepartmentStats> analyzeDepartments(List<Employee> employees) {
        return employees.stream()

                .collect(Collectors.groupingBy(
                        employee -> employee.getDepartment(),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                employeeList -> {

                                    double averageSalary = employeeList.stream()
                                            .mapToDouble(employee -> employee.getSalary())  // Replaced method reference with lambda
                                            .average()
                                            .orElse(0.0);


                                    long employeeCount = employeeList.size();


                                    Set<String> uniqueSkills = employeeList.stream()
                                            .flatMap(employee -> employee.getSkills().stream())  // Replaced method reference with lambda
                                            .collect(Collectors.toSet());

                                    return new DepartmentStats(averageSalary, employeeCount, uniqueSkills);
                                }
                        )
                ))

                .entrySet().stream()
                .filter(entry -> entry.getValue().employeeCount > 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 75000, Arrays.asList("Java", "SQL")),
                new Employee("Alice", "IT", 82000, Arrays.asList("Python", "Java")),
                new Employee("Bob", "HR", 65000, Arrays.asList("Communication")),
                new Employee("Charlie", "IT", 78000, Arrays.asList("Java", "AWS"))
        );

        Map<String, DepartmentStats> departmentStats = analyzeDepartments(employees);
        System.out.println(departmentStats);
    }
}
