import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Student {
    int studentId;
    String studentName;
    String department;
    int marks;

    Student(int studentId, String studentName, String department, int marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.marks = marks;
    }

    String getDetails() {
        return "Student ID: " + studentId +
               "\nStudent Name: " + studentName +
               "\nDepartment: " + department +
               "\nMarks: " + marks + "\n";
    }
}

class CollegeStudent extends Student {

    CollegeStudent(int studentId, String studentName,
                   String department, int marks) {
        super(studentId, studentName, department, marks);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            CollegeStudent student =
                new CollegeStudent(id, name, dept, marks);

            // Write data to file
            FileWriter fw = new FileWriter("StudentRecords.txt");
            fw.write(student.getDetails());
            fw.close();

            System.out.println("\nStudent record stored successfully.");

            // Read data from file
            FileReader fr = new FileReader("StudentRecords.txt");

            System.out.println("\n--- Student Record ---");

            int ch;

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }

        sc.close();
    }
}
