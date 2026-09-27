import java.util.Arrays;

public class EmployeeRecord {
    int id;
    String name;
    double salary;

    // Constructor inside the same class
    public EmployeeRecord(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // The main execution method placed directly at the top level of this class
    public static void main(String[] args) {
        // Creating the array of 5 employees matching your notebook data figures
        EmployeeRecord[] employees = {
            new EmployeeRecord(101, "Kiran", 35000.0),
            new EmployeeRecord(102, "Priya", 65000.0),
            new EmployeeRecord(103, "Vijay", 45000.0),
            new EmployeeRecord(104, "Sneha", 80000.0),
            new EmployeeRecord(105, "Anand", 55000.0)
        };

        System.out.println("Output :");
        
        // 1. Filter: Employees with salary above 60000.0
        System.out.println("Employees with salary above 60000.0");
        for (EmployeeRecord e : employees) {
            if (e.salary > 60000.0) {
                System.out.println("       " + e.id + "    " + e.name + "    " + e.salary);
            }
        }
        System.out.println();

        // Extracting salaries into an array for sorting operations
        double[] salaries = new double[employees.length];
        double totalSalary = 0;
        
        for (int i = 0; i < employees.length; i++) {
            salaries[i] = employees[i].salary;
            totalSalary += employees[i].salary;
        }

        // 2. Sorting in Ascending Order
        Arrays.sort(salaries);
        System.out.println("Salaries in ascending order");
        for (double s : salaries) {
            System.out.println("       " + s);
        }
        System.out.println();

        // 3. Sorting in Descending Order
        System.out.println("Salaries in descending order");
        for (int i = salaries.length - 1; i >= 0; i--) {
            System.out.println("       " + salaries[i]);
        }
        System.out.println();

        // 4. Calculations Summary Metrics
        int totalEmployees = employees.length;
        int averageSalary = (int) (totalSalary / totalEmployees);
        double highestSalary = salaries[salaries.length - 1];

        System.out.println("Total Employees : " + totalEmployees);
        System.out.println("Total Salary : " + totalSalary);
        System.out.println("Average Salary : " + averageSalary);
        System.out.println("Highest Salary : " + highestSalary);
    }
}
