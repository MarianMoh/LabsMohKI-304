package KI304.Moh.Lab3;

/**
 * The {@code Lab3} class serves as a demonstration of the functionality of the {@code Sea} class.
 * It creates a {@code Sea} object, performs various operations on it, and displays the results.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-25
 */
public class Lab3 {

    /**
     * The main method serves as the entry point of the program.
     * It creates a {@code Sea} object, performs various operations on it, and displays the results.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create object sea
        Sea sea = new Sea("Black Sea", 1000000, 15, 2500);

        // Add season
        sea.addSeason();
        // Next Season and show info
        sea.nextSeason();

        // Shark fishing, that reduces the number of sharks
        sea.fish();
        // Shark fishing is not allowed, because too few sharks
        sea.fish();
        // Feed our sharks and after this shark fishing is not allowed
        sea.feed();

        // Show the sea's fields
        sea.showInfo();

        // Dry up our sea
        sea.dry();
    }
}
