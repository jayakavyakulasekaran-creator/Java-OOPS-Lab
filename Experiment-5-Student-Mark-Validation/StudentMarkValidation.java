import java.util.Scanner;

public class InvalidMarkException extends Exception {

    // Constructor for our exception message configuration
    public InvalidMarkException(String message) {
        super(message);
    }

    // Validation utility method inside the main class block
    public static void validateMark(int mark) throws InvalidMarkException {
        if (mark < 0 || mark > 100) {
            throw new InvalidMarkException("Invalid mark! mark must be between 0 and 100.");
        }
    }

    // The main execution method placed directly at the top level of this class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Output :");
        System.out.println();

        // --- FIRST INPUT RUN (Valid Scenario) ---
        try {
            System.out.print("Enter Student Name : ");
            String name1 = scanner.nextLine();
            
            System.out.print("Enter Student Mark : ");
            int mark1 = scanner.nextInt();
            scanner.nextLine(); // Clear scanner buffer
            System.out.println();

            validateMark(mark1);
            
            // Output if valid
            System.out.println("Student Name : " + name1);
            System.out.println("Mark : " + mark1);
            System.out.println("The Mark is valid.");
            
        } catch (InvalidMarkException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            System.out.println("Mark validation process completed.");
            System.out.println();
        }

        // --- SECOND INPUT RUN (Exception Scenario) ---
        try {
            System.out.print("Enter Student Name : ");
            String name2 = scanner.nextLine();
            
            System.out.print("Enter Student Mark : ");
            int mark2 = scanner.nextInt();
            System.out.println();

            validateMark(mark2);
            
            // This section won't execute if an exception is thrown
            System.out.println("Student Name : " + name2);
            System.out.println("Mark : " + mark2);
            System.out.println("The Mark is valid.");
            
        } catch (InvalidMarkException e) {
            // Output if invalid
            System.out.println("Exception : " + e.getMessage());
        } finally {
            System.out.println("Mark validation process completed.");
        }

        scanner.close();
    }
}
