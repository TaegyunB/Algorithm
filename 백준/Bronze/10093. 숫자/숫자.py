a, b = map(int, input().split())
n1 = min(a, b)
n2 = max(a, b)
n = n2 - n1 - 1 # 두 숫자 사이의 수 개수를 구하기 위함

# n1과 n2의 차이가 1이라면 두 숫자 사이에 해당하는 숫자가 없다라는 점을 제시
if n2 - n1 <= 1:
    n = 0
    
print(n)

arr = [i for i in range(n1+1, n2)]
print(*arr)
