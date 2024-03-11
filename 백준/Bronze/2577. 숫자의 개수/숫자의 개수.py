mul = 1

for i in range(3):
    num = int(input())
    mul *= num
    
for i in range(10):
    if str(i) in str(mul):
        print(str(mul).count(str(i)))
    elif str(i) not in str(mul):
        print(0)