package KI304.Moh.Lab3;

/**
 * The {@code Fishing} interface represents the actions related to fishing.
 * Implementing classes should provide concrete implementations for the fishing and feeding methods,
 * and a method to check whether fishing is allowed.
 */
public interface Fishing {

    /**
     * Performs the action of fishing.
     * Implementations should define the specific behavior of fishing.
     */
    void fish();

    /**
     * Performs the action of feeding.
     * Implementations should define the specific behavior of feeding.
     */
    void feed();

    /**
     * Checks whether fishing is currently allowed.
     */
    void isFishingAllowed();
}
