package KI304.Moh.Lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Truck} class represents a truck that can carry vehicles.
 * It is parameterized with a type {@code T} that extends the {@code Vehicle} interface,
 * indicating the type of vehicles that can be carried by the truck.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-27
 *
 * @param <T> The type of vehicles that can be carried by the truck, must extend the {@code Vehicle} interface.
 */
public class Truck<T extends Vehicle> {

    /**
     * The list of vehicles carried by the truck.
     */
    private List<T> arr;

    /**
     * Constructs a new instance of the {@code Truck} class with an empty list of vehicles.
     */
    public Truck() {
        this.arr = new ArrayList<>();
    }

    /**
     * Adds a vehicle to the list of vehicles carried by the truck.
     *
     * @param vehicle The vehicle to be added to the truck.
     */
    public void addVehicle(T vehicle) {
        arr.add(vehicle);
    }

    /**
     * Removes a vehicle from the list of vehicles carried by the truck.
     *
     * @param vehicle The vehicle to be removed from the truck.
     */
    public void removeVehicle(T vehicle) {
        arr.remove(vehicle);
    }

    /**
     * Finds and returns the vehicle with the minimum carrying capacity among the vehicles carried by the truck.
     *
     * @return The vehicle with the minimum carrying capacity, or {@code null} if the list is empty.
     */
    public T findMinCarryingCapacity() {
        if(arr != null) {
            T min = arr.get(0);
            for(int i = 1; i < arr.size(); i++) {
                if(min.compareTo(arr.get(i)) > 0){
                    min = arr.get(i);
                }
            }
            return min;
        } else {
            return null;
        }
    }

    /**
     * Finds and returns the vehicle with the maximum carrying capacity among the vehicles carried by the truck.
     *
     * @return The vehicle with the maximum carrying capacity, or {@code null} if the list is empty.
     */
    public T findMaxCarryingCapacity() {
        if(arr != null) {
            T max = arr.get(0);
            for(int i = 1; i < arr.size(); i++) {
                if(max.compareTo(arr.get(i)) < 0){
                    max = arr.get(i);
                }
            }
            return max;
        } else {
            return null;
        }
    }
}
