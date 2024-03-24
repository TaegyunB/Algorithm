def solution(a, b):
    answer = 0
    
    str_ab = str(a) + str(b)
    str_ba = str(b) + str(a)
    
    ab = 2 * a * b
    
    
    if int(str_ab) > ab:
        answer = int(str_ab)
    elif int(str_ab) < ab:
        answer = ab
    elif int(str_ba) > ab:
        answer = int(str_ba)
    elif int(str_ba) < ab:
        answer = ab
    
    return answer