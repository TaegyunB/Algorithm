num = int(input())

for i in range(1, num+1):
    for j in range(num-i, 0, -1):
        print("", end=" ")
    print("*" * (2 * i - 1))
    
for i in range(num-1, 0, -1):
    for j in range(0, num-i):
        print("", end=" ")
    print("*" * (2 * i - 1))