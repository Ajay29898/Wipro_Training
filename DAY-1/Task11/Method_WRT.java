public class Method_WRT {

    // Method for addition
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // Method for subtraction
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    // Method for multiplication
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    // Method for division
    public double divide(int num1, int num2) {
        if (num2 != 0) {
            return (double) num1 / num2;  // Return double for precision
        } else {
            System.out.println("Error! Division by zero.");
            return 0; // Returning 0 in case of division by zero
        }
    }

    // Main method
    public static void main(String[] args) {
        Method_WRT calculator = new Method_WRT();

        int num1 = 20, num2 = 10;

        // Calling methods and printing the results
        System.out.println("Addition: " + calculator.add(num1, num2));
        System.out.println("Subtraction: " + calculator.subtract(num1, num2));
        System.out.println("Multiplication: " + calculator.multiply(num1, num2));
        System.out.println("Division: " + calculator.divide(num1, num2));
    }
}