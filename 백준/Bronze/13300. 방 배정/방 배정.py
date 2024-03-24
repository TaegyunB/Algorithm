import sys
input = sys.stdin.readline

# 2차원 배열
room = [[0]*2 for _ in range(6)] # [[0,0], [0,0], [0,0], [0,0], [0,0], [0,0]]
room_num = 0

n, k = map(int, input().split())

for i in range(n):
    s, g = map(int, input().split())
    
    room[g-1][s-1] += 1 # [남학생, 여학생(0-1은 -1이 되니깐 [-1]에 +1을 함)]
    
for i in range(6): # 학년
    for j in range(2): # 성별
        if room[i][j] % k == 0:
            room_num += room[i][j] // k
        else:
            room_num += room[i][j] // k + 1
            
print(room_num)
