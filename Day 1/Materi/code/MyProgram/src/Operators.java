public class Operators {
    public static void main(String[] args) {

        // Arithmetic Operators
        int resultAdd = 5 + 3; // Addition
        int resultSub = 7 - 2; // Subtraction
        int resultMul = 4 * 6; // Multiplication
        int resultDiv = 8 / 2; // Division
        int resultMod = 9 % 4; // Modulus

        // Comparison Operators
        boolean isEqual = resultAdd == resultSub;
        boolean isNotEqual = resultMul != resultDiv;
        boolean isGreaterThan = resultAdd > resultSub;
        boolean isLessThan = resultDiv < resultMod;

        // Logical Operators
        boolean condition1 = true;
        boolean condition2 = false;
        boolean logicalAnd = condition1 && condition2; // Logical AND
        boolean logicalOr = condition1 || condition2; // Logical OR
        boolean logicalNot = !condition1; // Logical NOT

        // Assignment Operators
        int number = 42;
        number += 10; // Compound Assignment

        // Increment and Decrement Operators
        int count = 5;
        count++; // Increment by 1
        count--; // Decrement by 1

        // Conditional (Ternary) Operator
        int age = 20;
        String canVote = (age >= 18) ? "Yes" : "No";

        // Expressions
        int expressionResult = resultAdd + resultSub;

        // Output Results
        System.out.println("Arithmetic Operators:");
        System.out.println("Addition: " + resultAdd);
        System.out.println("Subtraction: " + resultSub);
        System.out.println("Multiplication: " + resultMul);
        System.out.println("Division: " + resultDiv);
        System.out.println("Modulus: " + resultMod);
        System.out.println("\nComparison Operators:");
        System.out.println("Equal: " + isEqual);
        System.out.println("Not Equal: " + isNotEqual);
        System.out.println("Greater Than: " + isGreaterThan);
        System.out.println("Less Than: " + isLessThan);
        System.out.println("\nLogical Operators:");
        System.out.println("Logical AND: " + logicalAnd);
        System.out.println("Logical OR: " + logicalOr);
        System.out.println("Logical NOT: " + logicalNot);
        System.out.println("\nAssignment Operators:");
        System.out.println("Number: " + number);
        System.out.println("\nIncrement and Decrement Operators:");
        System.out.println("Count: " + count);
        System.out.println("\nConditional (Ternary) Operator:");
        System.out.println("Can Vote? " + canVote);
        System.out.println("\nExpressions:");
        System.out.println("Expression Result: " + expressionResult);
    }
}
