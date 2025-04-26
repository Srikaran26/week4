package ioStreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Good practice

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // To display employee information
    @Override
    public String toString() {
        return "Employee { " +
               "ID: " + id +
               ", Name: '" + name + '\'' +
               ", Department: '" + department + '\'' +
               ", Salary: " + salary +
               " }";
    }
}

public class EmployeeSerializationDemo {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        // Adding some employees
        employeeList.add(new Employee(101, "Alice", "IT", 75000));
        employeeList.add(new Employee(102, "Bob", "HR", 65000));
        employeeList.add(new Employee(103, "Charlie", "Finance", 80000));

        // Serialize the list
        serializeEmployees(employeeList);

        // Deserialize and display
        List<Employee> deserializedEmployees = deserializeEmployees();
        if (deserializedEmployees != null) {
            System.out.println("\nDeserialized Employee List:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        }
    }

    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully!");
        } catch (IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
    }

    private static List<Employee> deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            return employees;
        } catch (IOException e) {
            System.err.println("Deserialization I/O error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found error: " + e.getMessage());
        }
        return null;
    }
}

