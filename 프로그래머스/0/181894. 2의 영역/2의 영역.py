def solution(arr):
    answer = []
    num_idx = []
    
    for i in range(len(arr)):
        if arr[i] == 2:
            num_idx.append(i)
            
    if len(num_idx) == 0:
        answer.append(-1)
    else:
        answer = arr[num_idx[0]:num_idx[-1]+1]    
            
    
    return answer