import sys
input = sys.stdin.readline

num = int(input())
num_list = sorted(list(map(int, input().split())))
answer = int(input())

left = 0
right = num - 1
count = 0

while left < right:
    if num_list[left] + num_list[right] > answer:
        right -= 1
    elif num_list[left] + num_list[right] < answer:
        left += 1
    else:
        count += 1
        left += 1 # left 하나 올려주는 것 중요
        
print(count)


