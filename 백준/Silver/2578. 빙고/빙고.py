def check_bingo():
    bingo_cnt = 0

    # 가로
    for i in range(5):
        cnt = 0
        for j in range(5):
            if bingo[i][j] == 0:
                cnt += 1

        if cnt == 5:
            bingo_cnt += 1

    # 세로
    for j in range(5):
        cnt = 0
        for i in range(5):
            if bingo[i][j] == 0:
                cnt += 1

        if cnt == 5:
            bingo_cnt += 1

    # 대각선 -> 왼쪽에서 시작
    cnt = 0
    for i in range(5):
        if bingo[i][i] == 0:
            cnt += 1

    if cnt == 5:
        bingo_cnt += 1

    # 대각선 -> 오른쪽에서 시작
    cnt = 0
    for i in range(5):
        if bingo[i][4-i] == 0:
            cnt += 1

    if cnt == 5:
        bingo_cnt += 1

    return bingo_cnt


bingo = [list(map(int, input().split())) for _ in range(5)]
ref = []

for i in range(5):  # 한 줄 씩 추가 -> 한 줄로 만들기 위함
    ref += list(map(int, input().split()))

for i in range(25):  # 사회자가 부르는 숫자
    for x in range(5):
        for y in range(5):
            if ref[i] == bingo[x][y]:
                bingo[x][y] = 0
                break  # 1부터 25까지의 수가 한 번씩만 사용되니깐 찾으면 break

    result = check_bingo()

    if result >= 3:
        print(i + 1)  # 사회자가 부른 횟수
        break
