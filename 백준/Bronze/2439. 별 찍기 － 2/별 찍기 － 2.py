num = int(input())

for i in range(1, num+1):
    for j in range(num-i, 0, -1): # j를 num-i부터 1까지 -1씩 감소하며 반복
        print("", end=" ") # 줄바꿈을 하지 않음
    print("*" * i)