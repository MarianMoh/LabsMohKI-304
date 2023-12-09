import re
import sys
import time

from season import Season

class Reservoir:
    # Initialize the Reservoir object with a name, amount of water, and water temperature.
    def __init__(self, name, amountOfWater, waterTemperature):
        self.__name = name
        self.__amountOfWater = amountOfWater
        self.__waterTemperature = waterTemperature
        self.__season = None

    # Display information about the reservoir, including name, amount of water, water temperature,
    # and the season (if available).
    def showInfo(self):
        print("\nName: ", self.__name)
        print("Amount of water: ", self.__amountOfWater)
        print("Water temperature: ", self.__waterTemperature)

        if self.__season is not None:
            print("Season: ", self.__season.name)

    # Rename the reservoir if the provided new name is valid (matches the specified pattern).
    def rename(self, newName):
        if re.match("^[a-zA-Z ]{3,}$", newName):
            self.__name = newName
            print("\nNew name:", newName)
        else:
            print(f"\n- Error! New name \"{newName}\" is incorrect :(")

    # Add a season to the reservoir if it doesn't already have one. Validate user input.
    def addSeason(self):
        if self.__season is None:
            while True:
                try:
                    inputSeason = input("\nEnter a season: ")
                    season = Season[inputSeason.upper()]
                    break
                except KeyError:
                    print(f"\n- Error! Wrong input \"{inputSeason}\"...")

            self.__season = season
        else:
            print("\n- Error! You already have a season: ", self.__season.name)

    # Simulate the drying up of the reservoir with a short delay and exit the program.
    def dry(self):
        time.sleep(0.5)
        sys.exit(f"\nThe {self.__name} dried up...")
