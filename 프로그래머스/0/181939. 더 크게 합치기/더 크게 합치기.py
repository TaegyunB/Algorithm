def solution(a, b):
    answer = 0
    
    str_ab = str(a) + str(b)
    str_ba = str(b) + str(a)
    
    if int(str_ab) > int(str_ba):
        answer = int(str_ab)
    else:
        answer = int(str_ba)
              
    return answer