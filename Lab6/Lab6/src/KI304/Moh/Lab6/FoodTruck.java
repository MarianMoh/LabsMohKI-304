package KI304.Moh.Lab6;

/**
 * The {@code FoodTruck} class represents a specialized type of vehicle designed for transporting food.
 * It implements the {@code Vehicle} interface and provides information about its carrying capacity and temperature mode.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-27
 */
public class FoodTruck implements Vehicle {

    /**
     * The carrying capacity of the food truck.
     */
    private float carryingCapacity;

    /**
     * A flag indicating whether the food truck is equipped with a temperature control system.
     */
    private boolean isTemperatureMode;

    /**
     * Constructs a new instance of the {@code FoodTruck} class with the specified carrying capacity and temperature mode.
     *
     * @param carryingCapacity The carrying capacity of the food truck.
     * @param isTemperatureMode {@code true} if the food truck has temperature control, {@code false} otherwise.
     */
    public FoodTruck(float carryingCapacity, boolean isTemperatureMode) {
        this.carryingCapacity = carryingCapacity;
        this.isTemperatureMode = isTemperatureMode;
    }

    /**
     * Gets the carrying capacity of the food truck.
     *
     * @return The carrying capacity of the food truck.
     */
    @Override
    public float getCarryingCapacity() {
        return carryingCapacity;
    }

    /**
     * Prints information about the food truck, including its type, carrying capacity, and temperature mode.
     */
    @Override
    public void print() {
        System.out.println("Type: FoodTruck"
                + "\nCarrying capacity: " + carryingCapacity
                + "\nIs temperature mode: " + isTemperatureMode);
    }

    /**
     * Compares the carrying capacity of the food truck with that of another vehicle.
     *
     * @param vehicle Another vehicle to compare carrying capacities.
     * @return A negative integer, zero, or a positive integer if the carrying capacity of this truck
     *         is less than, equal to, or greater than the carrying capacity of the specified vehicle.
     */
    @Override
    public int compareTo(Vehicle vehicle) {
        Float d = carryingCapacity;
        return d.compareTo(vehicle.getCarryingCapacity());
    }
}
