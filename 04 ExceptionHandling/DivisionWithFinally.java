package ExceptionHandling;

import java.util.Scanner;

public class DivisionWithFinally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking two integers from the user
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            // Performing division
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handling divide by zero error
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            // This block will always be executed
            System.out.println("Operation completed.");
        }

        scanner.close();
    }
}

