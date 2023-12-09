package KI304.Moh.Lab5;

/**
 * The Calculator class provides methods for mathematical calculations and result storage.
 * The results can be calculated using the formula y = sin(x) / tan(4x) and saved to a file.
 *
 *  @author Marian Moh
 *  @version 1.0
 *  @since 2023-11-27
 */
public class Calculator {
    /**
     * Holds the calculated result of the mathematical expression y = sin(x) / tan(4x).
     */
    private static double result;

    /**
     * Calculates the result of the mathematical expression y = sin(x) / tan(4x).
     *
     * @param x The input value for the calculation.
     * @return The result of the mathematical expression.
     * @throws ArithmeticException If the denominator (Math.tan(4 * x)) is 0, indicating division by zero.
     */
    public static double calculate(double x) {
        if(Math.tan(4 * x) == 0.0) {
            throw new ArithmeticException("Math.tan(4 * " + x + ") is 0, and we can't divide by it!");
        }
        result = Math.sin(x) / Math.tan(4 * x);
        System.out.println("Result: " + result);
        return result;
    }
}
