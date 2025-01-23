public class Method_WORT
{
    // Method for addition
    public void add(int num1, int num2) {
        System.out.println("Addition: " + (num1 + num2));
    }

    // Method for subtraction
    public void subtract(int num1, int num2) {
        System.out.println("Subtraction: " + (num1 - num2));
    }

    // Method for multiplication
    public void multiply(int num1, int num2) {
        System.out.println("Multiplication: " + (num1 * num2));
    }

    // Method for division
    public void divide(int num1, int num2) {
        if (num2 != 0) {
            System.out.println("Division: " + ((double) num1 / num2));  // Handle division and return double
        } else {
            System.out.println("Error! Division by zero.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Method_WORT calculator = new Method_WORT();

        int num1 = 20, num2 = 10;

        // Calling methods
        calculator.add(num1, num2);
        calculator.subtract(num1, num2);
        calculator.multiply(num1, num2);
        calculator.divide(num1, num2);
    }
}
