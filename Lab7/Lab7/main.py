import sys

# Create variables and check for Exception
try:
    size = int(input("Enter size of square matrix: "))
    filler = input("Enter character to fill matrix: ")
except ValueError as e:
    print(f"\nWrong value type... \nError: {e}")
    exit(1)

# Check filler and size
if size <= 0:
    sys.exit("\nError: Too few size...")
elif len(filler) > 1:
    sys.exit("\nError: Too big filler...")
elif len(filler) == 0:
    sys.exit("\nError: Empty filler...")

# Create juggedArr with our size
juggedArr = [[' ' for _ in range(size)] for _ in range(size)]

# Fill juggedArr
for i in range(size):
    for j in range(size):
        if(i < size // 2 and j < size // 2) or (i >= size // 2 and j >= size // 2):
            juggedArr[i][j] = filler
        else:
            juggedArr[i][j] = " "

# Print juggedArr
for row in juggedArr:
   print(' '.join(row))
