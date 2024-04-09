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