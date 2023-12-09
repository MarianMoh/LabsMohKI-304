import math
import os.path
import struct
import sys

# Writes the result to a text file
def writeResTxt(fName, res):
    with open(fName, 'w') as f:
        f.write(str(res))

# Reads the result from a text file
def readResTxt(fName):
    res = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                res = f.read()
        else:
            raise FileNotFoundError(f"\nError: File {fName} not found")
    except FileNotFoundError as e:
        print(e)
    return res

# Writes the result to a binary file
def writeResBin(fName, result):
    with open(fName, 'wb') as f:
        f.write(struct.pack('f', result))

# Reads the result from a binary file
def readResBin(fName):
    res = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                res = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"\nError: File {fName} not found")
    except FileNotFoundError as e:
        print(e)
    return res

# Get correct float from user
def getInput():
    try:
        x = float(input("Enter x: "))
    except ValueError as e:
        print(f"\nError: Wrong input... \n{e}")
        sys.exit("Exiting due to error.")
    return x


# Calculates the result using the formula: y = sin(x) / tg(4x)
def calculate(x):
    try:
        res = math.sin(x) / math.tan(4 * x)
    except ZeroDivisionError:
        print("\nError: You can't divide by 0")
        res = 0
    return res


if __name__ == "__main__":
    # Get x and res
    x = getInput()
    res = calculate(x)

    # Writing the result to a text file and reading it again
    writeResTxt("result.txt", res)
    resFromTxtFile = readResTxt("result.txt")
    print("Result from txt file: ", resFromTxtFile)

    # Writing the result to a binary file and reading it again
    writeResBin("result.bin", res)
    resFromBinFile = readResBin("result.bin")
    print("Result from bin file: ", resFromBinFile)