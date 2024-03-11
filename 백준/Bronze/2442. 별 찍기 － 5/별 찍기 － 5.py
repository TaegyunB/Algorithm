num = int(input())

for i in range(1, num+1):
    for j in range(num-i, 0, -1):
        print("", end=" ")
    print("*" * (2 * i - 1))