package KI304.Moh.Lab6;

/**
 * The {@code Main} class demonstrates the usage of the {@code Truck}, {@code FoodTruck}, and {@code DangerousTruck} classes.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-27
 */
public class Main {

    /**
     * The main method demonstrates the creation and manipulation of FoodTruck and DangerousTruck instances using the Truck class.
     *
     * @param args The command line arguments (not used in this example).
     */
    public static void main(String[] args) {

        // Example with FoodTruck

        Truck<FoodTruck> foodTrucks = new Truck<>();
        foodTrucks.addVehicle(new FoodTruck(5, true));
        foodTrucks.addVehicle(new FoodTruck(10, false));
        foodTrucks.addVehicle(new FoodTruck(7, true));

        Vehicle maxVehicle = foodTrucks.findMaxCarryingCapacity();
        Vehicle minVehicle = foodTrucks.findMinCarryingCapacity();

        System.out.println("\n--FoodTruck with min carrying capacity--");
        maxVehicle.print();

        System.out.println("\n--FoodTruck with max carrying capacity--");
        minVehicle.print();

        // Example with DangerousTruck

        Truck<DangerousTruck> dangerousTrucks = new Truck<>();
        DangerousTruck deletedTruck = new DangerousTruck(9, 2);

        dangerousTrucks.addVehicle(new DangerousTruck(8, 5));
        dangerousTrucks.addVehicle(deletedTruck);
        dangerousTrucks.addVehicle(new DangerousTruck(5, 4));

        dangerousTrucks.removeVehicle(deletedTruck);

        Vehicle maxVehicle2 = dangerousTrucks.findMaxCarryingCapacity();
        Vehicle minVehicle2 = dangerousTrucks.findMinCarryingCapacity();

        System.out.println("\n\n--DangerousTruck with min carrying capacity--");
        maxVehicle2.print();

        System.out.println("\n--DangerousTruck with max carrying capacity--");
        minVehicle2.print();
    }
}
