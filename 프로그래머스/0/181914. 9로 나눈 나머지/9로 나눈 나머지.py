def solution(number):
    answer = 0
    
    number_int = int(number)
    answer += number_int % 9
    
    return answer