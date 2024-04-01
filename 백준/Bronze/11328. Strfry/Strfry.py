num = int(input())

for i in range(num):
    a, b = input().split()
    a = sorted(a)
    b = sorted(b)

    if a == b:
        print("Possible")
    else:
        print("Impossible")