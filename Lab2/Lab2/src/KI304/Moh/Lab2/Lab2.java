package KI304.Moh.Lab2;

/**
 * The {@code Lab2} class serves as a demonstration of the functionality of the {@code Reservoir} class.
 * It creates a {@code Reservoir} object, performs various operations on it, and displays the results.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-26
 */
public class Lab2 {

    /**
     * The main method serves as the entry point of the program.
     * It creates a {@code Reservoir} object, performs various operations on it, and displays the results.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Create object reservoir
        Reservoir reservoir = new Reservoir("lake",50000, 15);
        // Show info about this object
        reservoir.showInfo();

        // Error in rename method, because the name is invalid
        reservoir.rename("123");
        // Good example of rename
        reservoir.rename("White lake");

        // Add season
        reservoir.addSeason();
        // Next Season and show info
        reservoir.nextSeason();

        // Error in addSeason, because the season is already exists
        reservoir.addSeason();
        // Next season
        reservoir.nextSeason();

        // Delete season
        reservoir.deleteSeason();
        // Error in nextSeason, because season was deleted
        reservoir.nextSeason();

        // Dry up our reservoir
        reservoir.dry();
        // Program already finished, we won't see this message
        System.out.println("Program is dead!");
    }
}
