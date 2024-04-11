# 간단한 코드
def solution(my_string, n):
    return my_string[-n:]

# 내 코드
def solution(my_string, n):
    answer = ''
    
    length = len(my_string) - n
    answer += my_string[length:]
    
    return answer
