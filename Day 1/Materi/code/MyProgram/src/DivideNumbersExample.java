import java.util.Scanner;
public class DivideNumbersExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Prompt the user to enter the first number
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            // Prompt the user to enter the second number
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();
            // Perform division and display the result
            double result = num1 / num2;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.err.println("Error: Division by zero is not allowed.");
        } catch (java.util.InputMismatchException e) {
            // Handle invalid input (non-numeric input)
            System.err.println("Error: Invalid input. Please enter numeric values.");
        } finally {
            // Close the Scanner to release resources
            scanner.close();
        }
    }
}