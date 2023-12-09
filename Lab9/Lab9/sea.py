
from reservoir import Reservoir

class Sea(Reservoir):
    # Initialize the Sea object, inheriting from Reservoir.
    def __init__(self, name, amountOfWater, waterTemperature, numberOfSharks):
        super().__init__(name, amountOfWater, waterTemperature)
        self.__numberOfSharks = numberOfSharks
        self.__sharkFishingIsAllowed = numberOfSharks > 2000

    # Display information about the sea, including inherited reservoir information and
    # specific sea attributes such as the number of sharks and shark fishing allowance.
    def showInfo(self):
        super().showInfo()
        print("Number of sharks: ", self.__numberOfSharks)

        if self.__sharkFishingIsAllowed:
            print("Shark fishing is allowed!")
        else:
            print("- Shark fishing is not allowed!!!")

    # Perform fishing in the sea, reducing the number of sharks and updating fishing allowance.
    def fish(self):
        if self.__sharkFishingIsAllowed:
            self.__numberOfSharks = int(self.__numberOfSharks * 0.75)
            self.isFishingAllowed()
            print(f"\nAfter fishing there are {self.__numberOfSharks} sharks")
        else:
            print(f"\n- Shark fishing is not allowed! Only {self.__numberOfSharks} sharks!!!")

    # Feed the sharks in the sea, increasing the number of sharks and updating fishing allowance.
    def feed(self):
        self.__numberOfSharks = int(self.__numberOfSharks * 1.1)
        self.isFishingAllowed()
        print(f"\nAfter feeding there are {self.__numberOfSharks} sharks")

    # Check whether shark fishing is allowed based on the updated number of sharks.
    def isFishingAllowed(self):
        self.__sharkFishingIsAllowed = self.__numberOfSharks > 2000
