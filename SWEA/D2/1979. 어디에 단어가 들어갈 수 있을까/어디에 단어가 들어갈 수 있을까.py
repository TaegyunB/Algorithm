T = int(input())

for tc in range(1, T+1):
    N, K = map(int, input().split())

    arr = [list(map(int, input().split())) for _ in range(N)]
    result_cnt = 0

    # 가로 탐색
    for i in range(N):
        cnt = 0
        for j in range(N):
            if arr[i][j] == 1:
                cnt += 1

            if arr[i][j] == 0 or j == N-1:  # 0 이거나 끝에 도달했을 때
                if cnt == K:
                    result_cnt += 1
                cnt = 0

    # 세로 탐색
    for j in range(N):
        cnt = 0
        for i in range(N):
            if arr[i][j] == 1:
                cnt += 1

            if arr[i][j] == 0 or i == N-1:  # 0 이거나 끝에 도달했을 때
                if cnt == K:
                    result_cnt += 1
                cnt = 0

    print(f'#{tc} {result_cnt}')