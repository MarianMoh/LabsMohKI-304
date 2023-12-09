package KI304.Moh.Lab2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The {@code Reservoir} class represents a reservoir with various properties
 * such as name, amount of water, water temperature, and current season.
 * It provides methods to perform operations on the reservoir.
 *
 * @author Marian Moh
 * @version 1.0
 * @since 2023-11-25
 */

public class Reservoir {

    /** The name of the reservoir. */
    private String name;

    /** The current season of the reservoir. */
    private Season season;

    /** The amount of water in the reservoir. */
    private int amountOfWater;

    /** The temperature of the water in the reservoir. */
    private int waterTemperature;

    /** Flag indicating whether the water in the reservoir is frozen. */
    private boolean waterIsFrozen;

    /** The FileWriter used to log information to a file. */
    private FileWriter fileWriter;

    /** The constant file name for logging. */
    private static final String FILE_NAME = "MyFile.txt";

    /**
     * Default constructor for the {@code Reservoir} class.
     * Initializes the reservoir and creates a log file.
     */
    public Reservoir() {
        createFile();
        season = Season.UNKNOWN;
        waterIsFrozen = waterTemperature < 0;
    }

    /**
     * Parameterized constructor for the {@code Reservoir} class.
     * Initializes the reservoir with specified properties and creates a log file.
     *
     * @param name            The name of the reservoir.
     * @param amountOfWater   The amount of water in the reservoir.
     * @param waterTemperature The temperature of the water in the reservoir.
     */
    public Reservoir(String name, int amountOfWater, int waterTemperature) {
        this();
        this.name = name;
        this.amountOfWater = amountOfWater;
        this.waterTemperature = waterTemperature;
    }

    /**
     * Creates a log file for the reservoir.
     * If the file does not exist, it will be created.
     */
    private void createFile() {
        File file = new File(FILE_NAME);
        try {
            if (!file.exists() && file.createNewFile()) {
                System.out.println("File created: " + FILE_NAME + "\n");
            }
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logs a message to the file associated with the reservoir.
     *
     * @param message The message to be logged.
     */
    public void log(String message) {
        try {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the file associated with the reservoir.
     * If the file is not null, it will be closed.
     */
    public void closeFile() {
        try {
            if (fileWriter != null) {
                fileWriter.close();
                System.out.println("\nFile closed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays information about the reservoir, including its name, amount of water,
     * water temperature, current season, and whether the water is frozen.
     */
    public void showInfo() {
        log("\nName: " + name);
        log("Amount of water: " + amountOfWater);
        log("Water temperature: " + waterTemperature);

        if(!seasonIsUnknown()) {
            log("Season is: " + season);
        }
        if(waterIsFrozen){
            log("Water is frozen");
        }
    }

    /**
     * Renames the reservoir with a new name, if the provided name is valid.
     *
     * @param newName The new name for the reservoir.
     */
    public void rename(String newName) {
        if (newName.matches("^[a-zA-Z ]{3,}$")) {
            name = newName;
            log("\nNew name: " + newName);
        } else {
            log("\n- Error! New name \"" + newName + "\" is incorrect :(");
        }
    }

    /**
     * Drains the reservoir, setting its properties to default values,
     * logs a message, closes the log file, and exits the program.
     */
    public void dry() {
        name = "Unknown";
        amountOfWater = 0;
        waterTemperature = 0;

        log("\n-_- The reservoir has dried up...");
        closeFile();
        System.exit(0);
    }

    /**
     * Adds a new season to the reservoir, if the current season is unknown.
     * Prompts the user to enter a season and logs the new season.
     */
    public void addSeason() {
        if(seasonIsUnknown()) {
            Scanner scanner = new Scanner(System.in);
            String strOfSeason = null;

            while (true) {
                try {
                    System.out.print("Enter a season: ");
                    strOfSeason = scanner.nextLine().toUpperCase();
                    season = Season.valueOf(strOfSeason);

                    log("\nNew season is: " + season);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid season. Please enter a valid season.\n");
                    log("\nError! Invalid season: " + strOfSeason);
                }
            }
            showInfo();
        } else {
            log("\n- Error! You already have the season: " + season);
        }
    }

    /**
     * Deletes the current season of the reservoir and logs the action.
     */
    public void deleteSeason() {
        season = Season.UNKNOWN;
        log("\nSeason was deleted");
    }

    /**
     * Changes the current season of the reservoir based on the current season.
     * Logs the change and provides information about the new season.
     */
    public void nextSeason() {
        if(!seasonIsUnknown()) {
            log("\nSeason was changed");
            switch (season) {
                case WINTER -> springIsComing();
                case SPRING -> summerIsComing();
                case SUMMER -> autumnIsComing();
                case AUTUMN -> winterIsComing();
            }
        } else {
            log("\n- Error! You don't have a season to change it");
        }
    }

    /**
     * Checks if the current season of the reservoir is unknown.
     *
     * @return {@code true} if the season is unknown, {@code false} otherwise.
     */
    public boolean seasonIsUnknown() {
        return season.equals(Season.UNKNOWN);
    }

    /**
     * Sets the properties of the reservoir for the winter season.
     * Logs the change and displays information about the reservoir.
     */
    private void winterIsComing() {
        season = Season.WINTER;
        waterTemperature = 0;
        waterIsFrozen = true;
        showInfo();
    }

    /**
     * Sets the properties of the reservoir for the spring season.
     * Logs the change, adjusts the amount of water, and displays information about the reservoir.
     */
    private void springIsComing() {
        season = Season.SPRING;
        waterTemperature = 14;
        waterIsFrozen = false;
        amountOfWater = (int) (amountOfWater * 1.2);
        showInfo();
    }

    /**
     * Sets the properties of the reservoir for the summer season.
     * Logs the change, adjusts the amount of water, and displays information about the reservoir.
     * If the amount of water is less than 5000, the reservoir dries up.
     */
    private void summerIsComing() {
        season = Season.SUMMER;
        waterTemperature = 20;
        waterIsFrozen = false;
        amountOfWater = (int) (amountOfWater * 0.8);

        if(amountOfWater < 5000) {
            dry();
        }
        showInfo();
    }

    /**
     * Sets the properties of the reservoir for the autumn season.
     * Logs the change and displays information about the reservoir.
     */
    private void autumnIsComing() {
        season = Season.AUTUMN;
        waterTemperature = 10;
        waterIsFrozen = false;
        showInfo();
    }
}
