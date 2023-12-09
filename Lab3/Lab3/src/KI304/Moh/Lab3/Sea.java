package KI304.Moh.Lab3;

/**
 * The {@code Sea} class represents a sea, extending the {@code Reservoir} class
 * and implementing the {@code Fishing} interface. It includes additional properties
 * specific to a sea, such as the number of sharks and fishing allowances.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-25
 */
public class Sea extends Reservoir implements Fishing {

    /** The number of sharks in the sea. */
    public int numberOfSharks;

    /** Flag indicating whether shark fishing is allowed in the sea. */
    public boolean sharkFishingIsAllowed;

    /**
     * Default constructor for the {@code Sea} class.
     */
    public Sea() {
    }

    /**
     * Parameterized constructor for the {@code Sea} class.
     * Initializes the sea with specified properties and checks fishing allowances.
     *
     * @param name            The name of the sea.
     * @param amountOfWater   The amount of water in the sea.
     * @param waterTemperature The temperature of the water in the sea.
     * @param numberOfSharks  The initial number of sharks in the sea.
     */
    public Sea(String name, int amountOfWater, int waterTemperature, int numberOfSharks) {
        super(name, amountOfWater, waterTemperature);
        this.numberOfSharks = numberOfSharks;
        isFishingAllowed();
    }

    /**
     * Displays information about the sea, including its name, amount of water,
     * water temperature, number of sharks, current season, and fishing allowances.
     */
    @Override
    public void showInfo() {
        log("\nName: " + super.getName());
        log("Amount of water: " + super.getAmountOfWater());
        log("Water temperature: " + super.getWaterTemperature());
        log("Number of sharks: " + numberOfSharks);

        if(!seasonIsUnknown()) {
            log("Season is: " + super.getSeason());
        }

        if(!sharkFishingIsAllowed) {
            log("- Shark fishing is not allowed!!!");
        } else {
            log("Shark fishing is allowed");
        }
    }

    /**
     * Sets the properties of the sea for the winter.
     * Logs the change and displays information about the sea.
     */
    @Override
    public void winterIsComing() {
        setSeason(Season.WINTER);
        setWaterTemperature(5);
        showInfo();
    }

    /**
     * Sets the properties of the sea for the spring.
     * Logs the change, adjusts the amount of water, and displays information about the sea.
     */
    @Override
    public void springIsComing() {
        setSeason(Season.SPRING);
        setWaterTemperature(14);
        setAmountOfWater((int) (getAmountOfWater() * 1.2));
        showInfo();
    }

    /**
     * Sets the properties of the sea for the summer.
     * Logs the change, adjusts the amount of water, and displays information about the sea.
     * If the amount of water is less than 500000, the sea dries up.
     */
    @Override
    public void summerIsComing() {
        setSeason(Season.SUMMER);
        setWaterTemperature(19);
        setAmountOfWater((int) (getAmountOfWater() * 0.8));
        if(getAmountOfWater() < 500000) {
            dry();
        }
        showInfo();
    }

    /**
     * Sets the properties of the sea for the autumn.
     * Logs the change and displays information about the sea.
     */
    @Override
    public void autumnIsComing() {
        setSeason(Season.AUTUMN);
        setWaterTemperature(16);
        showInfo();
    }

    /**
     * Performs the action of fishing in the sea.
     * If shark fishing is allowed, reduces the number of sharks,
     * checks if further fishing is allowed, and logs the result.
     */
    @Override
    public void fish() {
        if(sharkFishingIsAllowed) {
            numberOfSharks = (int) (numberOfSharks * 0.75);
            isFishingAllowed();
            log("\nAfter fishing the number of sharks is: " + numberOfSharks);
        } else {
            log("\n- Shark fishing is not allowed! Too few sharks!!!");
        }
    }

    /**
     * Performs the action of feeding in the sea.
     * Increases the number of sharks, checks if fishing is allowed,
     * and logs the result.
     */
    @Override
    public void feed() {
        numberOfSharks = (int) (numberOfSharks * 1.1);
        isFishingAllowed();
        log("\nAfter feeding the number of sharks is: " + numberOfSharks);
    }

    /**
     * Checks whether fishing is currently allowed in the sea.
     * Updates the fishing allowance flag based on the number of sharks.
     */
    @Override
    public void isFishingAllowed() {
        sharkFishingIsAllowed = numberOfSharks > 2000;
    }
}
