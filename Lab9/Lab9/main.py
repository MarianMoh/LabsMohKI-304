from sea import Sea

if __name__ == "__main__":
    # Create a sea object with initial attributes
    sea = Sea("Sea", 1000000, 15, 2500)

    # Rename the sea and display its information
    sea.rename("Black sea")
    sea.showInfo()

    # Add a season to the sea and display updated information
    sea.addSeason()
    sea.showInfo()

    # Test method fish in a normal and error way
    sea.fish()
    sea.fish()

    # Test method feed, after which we can use fish again
    sea.feed()
    sea.fish()

    # Simulate the drying up of the sea
    sea.dry()
