# 간단한 풀이
def solution(arr):
    stk = []

    for i in range(len(arr)):
        while stk and stk[-1] >= arr[i]: # 스택이 비어있지 않고, 스택의 맨 위에 있는 값이 현재 숫자 arr[i]보다 크거나 같은 경우에는 반복
            stk.pop()
        stk.append(arr[i])
    return stk

# 내 풀이
def solution(arr):
    stk = []
    i = 0
    
    while i < len(arr): 
        if len(stk) == 0:
            stk.append(arr[i])
            i += 1
        elif len(stk) != 0:
            if stk[-1] < arr[i]:
                stk.append(arr[i])
                i += 1
            elif stk[-1] >= arr[i]:
                stk.pop()
        
    return stk
