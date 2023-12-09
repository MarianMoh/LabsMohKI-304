package KI304.Moh.Lab4;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Main class contains the main method to execute the Calculator application.
 *
 *  @author Marian Moh
 *  @version 1.0
 *  @since 2023-11-27
 */
public class Main {

    /**
     * The main method of the application that takes user input, performs calculations,
     * and saves the result to a file using the Calculator class.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        System.out.println("Formula is: y = sin(x) / tg(4x)");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter x: ");

            try {
                double x = scanner.nextDouble();
                Calculator.calculate(x);
                Calculator.saveResultToFile();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input miscast, please enter a double");
                scanner.next();
            } catch (ArithmeticException e) {
                System.out.println("Divide by 0!" + e.getMessage());
            } catch(FileNotFoundException e) {
                System.out.println("File not found... ");
                break;
            }
        }
    }
}
