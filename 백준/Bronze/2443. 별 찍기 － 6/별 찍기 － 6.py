num = int(input())

for i in range(num, 0, -1):
    for j in range(0, num-i):
        print("", end=" ")
    print("*" * (2 * i - 1))