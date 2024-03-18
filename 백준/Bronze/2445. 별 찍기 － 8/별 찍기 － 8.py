num = int(input())

for i in range(1, num+1):
    print("*" * i + " " * ((num * 2) - (i * 2)) + "*" * i)
for i in range(num-1, 0, -1): # 감소하는 for문을 작성할 때는 세 번째 매개변수 작성하는 것을 기억하기
    print("*" * i + " " * ((num * 2) - (i * 2)) + "*" * i)
