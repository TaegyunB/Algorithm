arr = [[0] * 100 for _ in range(100)]

paper_num = int(input())

for _ in range(paper_num):
    x1, y1 = map(int, input().split())
    x2 = x1 + 10
    y2 = y1 + 10

    for i in range(x1, x2):
        for j in range(y1, y2):
            arr[i][j] = 1

cnt = 0
for i in range(100):
    for j in range(100):
        if arr[i][j] == 1:
            cnt += 1

print(cnt)
