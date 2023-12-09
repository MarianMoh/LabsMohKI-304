package KI304.Moh.Lab6;

/**
 * The {@code DangerousTruck} class represents a specialized type of vehicle designed for transporting dangerous goods.
 * It implements the {@code Vehicle} interface and provides information about its carrying capacity and level of danger.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-27
 */
public class DangerousTruck implements Vehicle {

    /**
     * The carrying capacity of the dangerous goods truck.
     */
    private float carryingCapacity;

    /**
     * The level of danger associated with the transported goods.
     * Rating scale from 1 to 5.
     */
    private int levelOfDanger;

    /**
     * Constructs a new instance of the {@code DangerousTruck} class with the specified carrying capacity and level of danger.
     *
     * @param carryingCapacity The carrying capacity of the dangerous goods truck.
     * @param levelOfDanger    The level of danger associated with the transported goods.
     */
    public DangerousTruck(float carryingCapacity, int levelOfDanger) {
        this.carryingCapacity = carryingCapacity;
        this.levelOfDanger = levelOfDanger;
    }

    /**
     * Gets the carrying capacity of the dangerous goods truck.
     *
     * @return The carrying capacity of the dangerous goods truck.
     */
    @Override
    public float getCarryingCapacity() {
        return carryingCapacity;
    }

    /**
     * Prints information about the dangerous goods truck, including its type, carrying capacity, and level of danger.
     */
    @Override
    public void print() {
        System.out.println("Type: FoodTruck"
                + "\nCarrying capacity: " + carryingCapacity
                + "\nLevel of danger: " + levelOfDanger);
    }

    /**
     * Compares the carrying capacity of the dangerous goods truck with that of another vehicle.
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
