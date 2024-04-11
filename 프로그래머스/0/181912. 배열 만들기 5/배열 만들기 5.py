def solution(intStrs, k, s, l):
    answer = []
    
    for idx in intStrs:
        cut = idx[s:s+l]
        
        if int(cut) > k:
            answer.append(int(cut))
        else:
            continue
    
    return answer