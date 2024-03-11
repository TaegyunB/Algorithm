import sys

num_list = [0] # 인덱스를 편하게 구하기 위해 0을 추가

for i in range(1, 21):
    num_list.append(i)

for i in range(10):
    a, b = map(int, sys.stdin.readline().split())
    num_list_ = num_list[:a] + num_list[b:a-1:-1] + num_list[b+1:] # 슬라이싱 후 연결
    num_list = num_list_

num_list.pop(0)
print(*num_list)