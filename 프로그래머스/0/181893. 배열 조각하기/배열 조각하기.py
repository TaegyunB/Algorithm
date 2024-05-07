def solution(arr, query):
    answer = arr
    
    for i in range(len(query)):
        if i % 2 == 0:
            del arr[query[i]+1:]
            answer = arr
        else:
            del arr[:query[i]]
            answer = arr
    
    return answer