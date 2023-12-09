package KI304.Moh.Lab5;

import java.io.*;

/**
 *  The FileTool class provides utility methods for saving and retrieving calculation results to and from files.
 *
 *  @author Marian Moh
 *  @version 1.0
 *  @since 2023-11-27
 */
public class FileTool {
    /**
     * The name of the file used to save the calculation results.
     */
    private static final String FILE_NAME = "result.txt";

    /**
     * The name of the binary file used to save the calculation results.
     */
    private static final String BIN_FILE_NAME = "binResult.bin";

    /**
     * Saves the result of the calculation to a file.
     *
     * @throws FileNotFoundException If the specified file for result storage is not found.
     */
    public static void saveResultToFile(double result) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(FILE_NAME)) {
            printWriter.println("Result y=sin(x)/tg(4x): " + result);
        }
    }

    /**
     * Retrieves the result of the calculation from the text file.
     *
     * @return The result as a string read from the text file.
     * @throws IOException If an I/O error occurs while reading from the file.
     */
    public static String getResultFromFile() throws IOException {
        String line;
        String text = "";
        try(FileReader fileReader = new FileReader(FILE_NAME);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                text += line;
            }
        }
        return text;
    }

    /**
     * Saves the result of the calculation to a binary file.
     *
     * @param result The result to be saved.
     * @throws IOException If an I/O error occurs while writing to the binary file.
     */
    public static void saveResultToBinFile(double result) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(BIN_FILE_NAME));
        out.writeDouble(result);
    }

    /**
     * Retrieves the result of the calculation from the binary file.
     *
     * @return The result read from the binary file.
     * @throws IOException If an I/O error occurs while reading from the binary file.
     */
    public static double getResultFromBinFile() throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(BIN_FILE_NAME));
        return in.readDouble();
    }
}
