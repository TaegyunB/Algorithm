import sys

N = int(sys.stdin.readline())
bar_arr = [0] * N

for i in range(N):
    bar_arr[i] = int(sys.stdin.readline())

bar_cnt = 1
largest_bar = bar_arr[-1]
for i in range(N-2, -1, -1):
    if bar_arr[i] > largest_bar:
        largest_bar = bar_arr[i]
        bar_cnt += 1

print(bar_cnt)