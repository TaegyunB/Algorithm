num = int(input())
time = list(map(int, input().split()))
y = 0
m = 0

for i in time:
    y += (i // 30 + 1) * 10 # 30초 이상 넘으면 통화료가 오르기 때문에 +1
    m += (i // 60 + 1) * 15 # 60초 이상 넘으면 통화료가 오르기 때문에 +1
    
if y < m:
    print("Y" , y)
elif m < y:
    print("M", m)
elif m == y:
    print("Y M", y)