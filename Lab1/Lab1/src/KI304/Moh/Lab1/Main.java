package KI304.Moh.Lab1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The Main class prompts the user for inputs, including the size of the square matrix
 * and a character to fill it. It then generates a jagged square matrix based on the
 * provided parameters, displays the matrix, and saves it to a text file.
 *
 * @author Marian Moh
 * @version 1.0
 * @since version 1.0
 *
 */

public class Main {

    /**
     * File name for saving the generated jagged matrix.
     */
    private static final String FILE_NAME = "MyFile.txt";

    /**
     * The static main method is the entry point to the program. It calls other methods to perform
     *    matrix generation, display, and file saving.
     *
     * @param args The command-line arguments passed to the program.
     *
     */
    public static void main(String[] args) {
        int size = inputSize();
        char filler = inputFiller();

        char[][] juggedArr = generateJaggedArr(size, filler);

        showJuggedArr(juggedArr);
        saveJuggedArrToFile(juggedArr);
    }

    /**
     * Reads and validates the size of the square matrix from the user.
     *    It handles input exceptions and keeps prompting until a valid size is provided.
     *
     * @return int size of matrix
     */
    public static int inputSize() {
        Scanner scanner = new Scanner(System.in);
        int size;

        while(true){
            try {
                System.out.print("Enter size of square matrix: ");
                size = scanner.nextInt();
                break;
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + ". Please enter a number");
                scanner.next();
            }
        }
        return size;
    }

    /**
     * Reads and validates the character to fill the matrix from the user.
     *     It handles input exceptions and keeps prompting until a valid character is provided.
     *
     * @return The character symbol provided by the user.
     */
    public static char inputFiller() {
        Scanner scanner = new Scanner(System.in);
        char filler;

        while (true) {
            System.out.print("Enter character to fill matrix: ");
            String str = scanner.nextLine().trim();

            if (!str.isEmpty()) {
                filler = str.charAt(0);
                break;
            } else {
                System.out.println("Please enter a non-empty character");
            }
        }
        return filler;
    }

    /**
     * Generates a jagged square matrix
     *    of the specified size and fills it with the provided character.
     *
     * @param size    The size of the square matrix to be generated.
     * @param filler  The character to fill the matrix with.
     * @return        The generated jagged square matrix as a 2D character array.
     */
    public static char[][] generateJaggedArr(int size, char filler) {
        char[][] juggedArr = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(((i < size / 2) && (j < size / 2))
                        || ((i >= size / 2) && (j >= size / 2))) {
                    juggedArr[i][j] = filler;
                } else {
                    juggedArr[i][j] = ' ';
                }
            }
        }
        return juggedArr;
    }

    /**
     * Displays the generated jagged square matrix
     *    in the console.
     *
     * @param juggedArr  The jagged square matrix to be displayed.
     */
    public static void showJuggedArr(char[][] juggedArr) {
        for (char[] charArr : juggedArr) {
            for (char ch : charArr) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    /**
     * Saves the generated jagged square matrix
     *    to a text file named "lab2/MyFile.txt".
     *
     * @param juggedArr  The jagged square matrix to be saved to the txt file.
     */
    public static void saveJuggedArrToFile(char[][] juggedArr) {
        try (PrintWriter writer = new PrintWriter(FILE_NAME)) {
            for (char[] charArr : juggedArr) {
                for (char ch : charArr) {
                    writer.print(ch + " ");
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
