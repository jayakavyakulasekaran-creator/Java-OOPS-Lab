import java.util.ArrayList;
import java.util.Scanner;

// ==========================================
// 1. ABSTRACTION: Abstract Base Class
// ==========================================
abstract class Person {
    // ENCAPSULATION: Private variables, hidden from direct outside access
    private String name;
    private int age;

    // Constructor to initialize common attributes
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ENCAPSULATION: Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Abstract method: Implementation detail is hidden, to be defined by subclasses
    public abstract void displayDetails();
}

// ==========================================
// 2. INHERITANCE: Subclass inheriting from Person
// ==========================================
class Student extends Person {
    private String studentId;
    private String course;
    private double gpa;

    // Constructor calling the parent (super) constructor
    public Student(String name, int age, String studentId, String course, double gpa) {
        super(name, age); // Inherited attributes
        this.studentId = studentId;
        this.course = course;
        this.gpa = gpa;
    }

    // Student-specific Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    // ==========================================
    // 3. POLYMORPHISM: Overriding the abstract method
    // ==========================================
    @Override
    public void displayDetails() {
        System.out.println("---------------------------------------------");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Course: " + course);
        System.out.println("GPA: " + gpa);
        System.out.println("---------------------------------------------");
    }
}

// ==========================================
// 4. MANAGEMENT ENGINE (Application Controller)
// ==========================================
public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] []args) {
        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: 
                    System.out.println("Exiting application. Goodbye!");
                    System.exit(0);
                default: 
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();
        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();

        // Instantiating a new Student object
        Student student = new Student(name, age, id, course, gpa);
        studentList.add(student);
        System.out.println("🎉 Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("❌ No student records found.");
            return;
        }
        System.out.println("\n--- Student Database ---");
        for (Student s : studentList) {
            // Polymorphic method call
            s.displayDetails();
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("🔍 Student Found:");
                s.displayDetails();
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                studentList.remove(s);
                System.out.println("🗑️ Student record deleted successfully.");
                return;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
    }
}
