T = int(input())

for tc in range(1, T+1):
    N, M = map(int, input().split())  # M x M 크기의 파리채

    arr = [list(map(int, input().split())) for _ in range(N)]

    max_sum = 0

    for i in range(N-M+1):
        for j in range(N-M+1):
            catch_fly = 0
            for k in range(i, i+M):
                for l in range(j, j+M):
                    catch_fly += arr[k][l]

            if catch_fly > max_sum:
                max_sum = catch_fly

    print(f'#{tc} {max_sum}')

