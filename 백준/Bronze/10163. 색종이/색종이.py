arr = [[1002] * 1001 for _ in range(1001)]

paper_num = int(input())

for i in range(paper_num):
    x1, y1, width, height = map(int, input().split())
    x2 = x1 + width
    y2 = y1 + height

    for x in range(x1, x2):
        for y in range(y1, y2):
            arr[x][y] = i

for i in range(paper_num):
    cnt = 0
    for x in range(1001):
        for y in range(1001):
            if arr[x][y] == i:
                cnt += 1

    print(cnt)

