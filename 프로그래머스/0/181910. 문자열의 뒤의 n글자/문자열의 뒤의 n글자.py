def solution(my_string, n):
    answer = ''
    
    length = len(my_string) - n
    answer += my_string[length:]
    
    return answer