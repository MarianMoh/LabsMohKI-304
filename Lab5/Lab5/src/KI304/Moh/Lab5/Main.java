package KI304.Moh.Lab5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Main class serves as the entry point for the program, showcasing the interaction
 * between mathematical calculations, file operations, and user input/output.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-27
 */
public class Main {

    /**
     * The main method serves as the entry point for the program. It orchestrates user input,
     * mathematical calculations, file operations, and exception handling.
     *
     * @param args The command-line arguments (unused).
     */
    public static void main(String[] args) {
        System.out.println("Formula is: y = sin(x) / tg(4x)");
        Scanner scanner = new Scanner(System.in);
        double result;

        while (true) {
            System.out.print("\nEnter x: ");
            try {
                double x = scanner.nextDouble();
                result = Calculator.calculate(x);

                // Test methods of working with a regular file
                FileTool.saveResultToFile(result);
                String text = FileTool.getResultFromFile();
                System.out.println("\n-- Text from file --\n" + text);

                // Test methods of working with a binary file
                FileTool.saveResultToBinFile(result);
                result = FileTool.getResultFromBinFile();
                System.out.println("\n-- Text from bin file --\n" + result);

                break;
            } catch (InputMismatchException e) {
                System.out.println("Input miscast, please enter a double");
                scanner.next();
            } catch (ArithmeticException e) {
                System.out.println("Divide by 0!" + e.getMessage());
            } catch(FileNotFoundException e) {
                System.out.println("File not found... ");
                break;
            } catch (IOException e) {
                System.out.println("Input/Output exception... ");
                break;
            }
        }
    }
}
