# 간단한 풀이
def solution(arr, queries):
    for a, b in queries:
        arr[a], arr[b] = arr[b], arr[a]

    return arr


# 내 풀이
def solution(arr, queries):
    
    for i in range(len(queries)):
        
        m = queries[i][0]
        n = queries[i][1]
        
        k = arr[m]
        arr[m] = arr[n]
        arr[n] = k
    
    return arr
