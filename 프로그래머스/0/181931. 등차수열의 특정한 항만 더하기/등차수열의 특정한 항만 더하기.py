def solution(a, d, included):
    answer = [a]
    sum = 0
    
    for i in range(len(included)-1):
        a += d
        answer.append(a)

    for i in range(0, len(included)):
        if included[i] == True:
            sum += answer[i]
        elif included[i] == False:
            continue
    
    return sum