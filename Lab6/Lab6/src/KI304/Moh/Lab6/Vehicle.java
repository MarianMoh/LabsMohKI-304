package KI304.Moh.Lab6;

/**
 * The {@code Vehicle} interface represents a generic vehicle that can be used for transportation.
 * It extends the {@code Comparable} interface to enable comparison between vehicles based on their carrying capacity.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-27
 */
public interface Vehicle extends Comparable<Vehicle> {

    /**
     * Gets the carrying capacity of the vehicle.
     *
     * @return The carrying capacity of the vehicle.
     */
    float getCarryingCapacity();

    /**
     * Prints information about the vehicle.
     * The specific details of the printed information depend on the implementation of this method in concrete classes.
     */
    void print();
}
