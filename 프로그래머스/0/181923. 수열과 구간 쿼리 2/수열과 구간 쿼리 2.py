# 간단한 코드
def solution(arr, queries):
    answer = []

    for s, e, k in queries:
        tmp = []

        for x in arr[s:e+1]:
            if x > k:
                tmp.append(x)
        answer.append(-1 if not tmp else min(tmp)) 
        # 리스트 tmp가 비어있지 않은 경우에는 tmp 리스트 안의 최솟값을 answer 리스트에 추가하고, 비어있는 경우에는 -1을 추가합니다.
        # 'not tmp': 리스트 'tmp'가 비어있지 않으면 'True', 비어있으면 'False'
    
    return answer

# 내 코드
def solution(arr, queries):
    answer = []
    
    for a, b, c in queries:
        result = []
        
        for i in range(a, b+1):
            if arr[i] < c:
                continue
            elif arr[i] > c:
                result.append(arr[i])
            
        if len(result) == 0:
            answer.append(-1)
        else:
            answer.append(min(result))
    
    return answer
