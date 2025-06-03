T = int(input())

for tc in range(1, T+1):
    N = int(input())

    distance = 0
    speed = 0
    for n in range(N):
        c = list(map(int, input().split()))

        if c[0] == 1:  # 가속
            speed += c[1]

        elif c[0] == 2:  # 감속
            speed -= c[1]
            if speed < 0:
                speed = 0

        distance += speed

    print(f'#{tc} {distance}')
