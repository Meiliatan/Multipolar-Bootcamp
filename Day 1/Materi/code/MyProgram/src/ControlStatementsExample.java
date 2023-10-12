public class ControlStatementsExample {
    public static void main(String[] args) {

        // Conditional Statements
        int score = 85;
        if (score >= 90) {
            System.out.println("Excellent");
        } else if (score >= 80) {
            System.out.println("Good");
        } else {
            System.out.println("Average");
        }

        // Loop Statements
        System.out.println("Loop with for:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i);
        }
        System.out.println("\nLoop with while:");
        int j = 1;
        while (j <= 5) {
            System.out.println("Iteration " + j);
            j++;
        }
        System.out.println("\nLoop with do-while:");
        int k = 1;
        do {
            System.out.println("Iteration " + k);
            k++;
        } while (k <= 5);

        // Switch Statement
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other day");
        }

        // Break and Continue Statements
        System.out.println("Break and Continue:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Skip iteration 3
            }
            System.out.println("Iteration " + i);
            if (i == 4) {
                break; // Exit the loop at iteration 4
            }
        }

        // Return Statement
        int sum = add(5, 3);
        System.out.println("Sum: " + sum);
    }
    public static int add(int a, int b) {
        return a + b;
    }
}
